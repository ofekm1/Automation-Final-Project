package pageObjects.Alibuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage {

    @FindBy(xpath = "//input[@id='signup_username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='signup_email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='signup_password']")
    public WebElement pass;

    @FindBy(xpath = "//input[@id='signup_password_confirm']")
    public WebElement confirmPass;

    @FindBy(xpath = "//input[@id='field_1']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='signup_submit']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//div[@class='error']")
    public List<WebElement> listError;

    @FindBy(xpath = "//div[@id='template-notices']")
    public WebElement regSuccess;
}
