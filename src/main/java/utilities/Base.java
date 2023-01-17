package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.Alibuy.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver<?> mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jsonPath;

    //DataBase
    protected static Connection connection;
    protected static Statement statement;
    protected static ResultSet resultSet;

    //Page objects - Web
    protected static LoginPage alibuyLogin;
    protected static MainPage alibuyMain;
    protected static TipsPage alibuyTips;
    protected static TopMenu alibuyTopMenu;
    protected static RegisterPage alibuyRegister;
    protected static String platform;

    //Page objects - Mobile
    protected static pageObjects.Mortgage.MainPage mortgageMain;

    //Page objects - Electron
    protected static pageObjects.Todo.MainPage todoMain;

    //Page objects - Desktop
    protected static pageObjects.Calculator.MainPage calcMain;
}
