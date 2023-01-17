package pageObjects.Alibuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TipsPage {
    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[5]//a[@href='https://ali-buy.com/tips/aliexpress-tips/']")
    public WebElement AETips;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[5]//a[@href='https://ali-buy.com/tips/amazon-tips/']")
    public WebElement amazonTips;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[5]//a[@href='https://ali-buy.com/tips/general/']")
    public WebElement generalTips;
}
