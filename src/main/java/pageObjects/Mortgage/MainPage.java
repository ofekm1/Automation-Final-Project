package pageObjects.Mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class MainPage {
    private final AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(id = "etAmount")
    public AndroidElement txtAmount;

    @AndroidFindBy(id = "etTerm")
    public AndroidElement txtTerm;

    @AndroidFindBy(id = "etRate")
    public AndroidElement txtRate;

    @AndroidFindBy(id = "btnCalculate")
    public AndroidElement btnCalc;

    @AndroidFindBy(id = "tvRepayment")
    public MobileElement txtRepayment;

}
