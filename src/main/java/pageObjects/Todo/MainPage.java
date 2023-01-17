package pageObjects.Todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(xpath = "//input[@placeholder='Create a task']")
    public WebElement txtCreate;

    @FindBy (xpath = "//div[@class='view_2Ow90']")
    public List<WebElement> listTasks;

    @FindBy (className = "destroy_19w1q")
    public WebElement btnDelete;

}
