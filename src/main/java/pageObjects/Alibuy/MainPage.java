package pageObjects.Alibuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//div[@class='position-relative user-dropdown-intop']")
    public List<WebElement> userDropdown;

    @FindBy(xpath = "//div[@class='userblockintop']//li[4]")
    public WebElement btnLogout;

    @FindBy(xpath = "//span[@class='act-rehub-login-popup']")
    public WebElement btnLogReg;

    @FindBy(xpath = "//div[@class='pm-content']//span")
    public WebElement register;

    @FindBy(xpath = "//*[@id=\"main_header\"]/div/div[2]/div/div/div[2]/form/input[1]")
    public WebElement txtSearch;

    @FindBy(xpath = "//div[@class='re-search-result-div']")
    public List<WebElement> searchResultList;
}
