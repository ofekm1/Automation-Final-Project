package pageObjects.Alibuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//div[@class='pm-content']//input[@name='rehub_user_login']")
    public WebElement txt_userName;
    @FindBy(xpath = "//div[@class='pm-content']//input[@name='rehub_user_pass']")
    public WebElement txt_password;
    @FindBy(xpath = "//div[@class='pm-content']//button[@class='wpsm-button rehub_main_btn']")
    public WebElement btn_submit;
    @FindBy(xpath = "//div[@class='pm-content']//div[@class='wpsm_box warning_type mb30']")
    public WebElement loginError;
}
