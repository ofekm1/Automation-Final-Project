package pageObjects.Alibuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopMenu {

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[1]")
    public WebElement btnHomepage;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[2]")
    public WebElement btnCategories ;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[3]")
    public WebElement btnTopSites ;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[4]")
    public WebElement btnWebOnly;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[5]")
    public WebElement btnTips ;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[6]")
    public WebElement btnCard ;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[7]")
    public WebElement btnFlashDeals;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li[8]")
    public WebElement btnContact;

    @FindBy(xpath = "//nav[@class='top_menu']/ul/li")
    public List<WebElement> topMenuList;


}
