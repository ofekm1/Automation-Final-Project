package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("C:\\Automation\\FinalProject\\Configuration\\DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("edge"))
            driver = initEdgeDriver();
        else
            throw new RuntimeException("Unsupported browser type");
        driver.get(getData("URL"));
        ManagePages.initAliBuy();
        driver.manage().window().maximize();
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (MalformedURLException e) {
            System.out.println("Cannot connect to appium server. See details: " + e);
        }
        ManagePages.initMortgage();
    }

    public void initAPI() {
        RestAssured.baseURI = getData("RestAPIURL");
        httpRequest = RestAssured.given();
    }

    public void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
    }

    public void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver<>(new URL(getData("AppiumServerDesktop")), dc);
        } catch (MalformedURLException e) {
            System.out.println("Cannot find Appium Server, see details: " + e);
        }
        ManagePages.initCalc();
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        switch (platform.toLowerCase()) {
            case ("web"):
                initBrowser(getData("BrowserName"));
                break;

            case ("mobile"):
                initMobile();
                break;

            case ("api"):
                initAPI();
                break;

            case ("electron"):
                initElectron();
                break;

            case ("desktop"):
                initDesktop();
                break;

            default:
                throw new RuntimeException("Invalid platform name");
        }
        switch (platform.toLowerCase()) {
            case ("web"):
            case ("mobile"):
            case ("electron"):
                action = new Actions(driver);
                break;
        }
        switch (platform.toLowerCase()) {
            case ("web"):
            case ("electron"):
            case ("desktop"): {
                driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
                wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
                break;
            }
            case ("mobile"): {
                mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
                wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
                break;
            }
        }
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBusername"), getData("DBpassword"));
    }

    @AfterClass
    public void endSession() {
        switch (platform.toLowerCase()) {
            case ("web"):
            case ("electron"):
            case ("desktop"):
                driver.quit();
                break;
            case ("mobile"):
                mobileDriver.quit();
                break;
        }
        try {
            ManageDB.closeConnection();
        } catch (SQLException e) {
            System.out.println("Unable to disconnect from DB. see details:" + e);
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) throws Exception {
        if (!platform.equalsIgnoreCase("api"))
            MonteScreenRecorder.startRecord(method.getName());
    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web")) {
            driver.get(getData("MainPage"));
        } else if (platform.equalsIgnoreCase("electron")) {
            ElectronFlows.clearList();
        }
    }
}

