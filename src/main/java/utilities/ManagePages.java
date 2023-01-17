package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.Alibuy.*;

public class ManagePages extends Base {
    public static void initAliBuy() {
        alibuyLogin = PageFactory.initElements(driver, LoginPage.class);
        alibuyMain = PageFactory.initElements(driver, MainPage.class);
        alibuyTips = PageFactory.initElements(driver, TipsPage.class);
        alibuyTopMenu = PageFactory.initElements(driver, TopMenu.class);
        alibuyRegister = PageFactory.initElements(driver, RegisterPage.class);
    }

    public static void initMortgage() {
        mortgageMain = new pageObjects.Mortgage.MainPage(mobileDriver);
    }

    public static void initTodo() {
        todoMain = PageFactory.initElements(driver, pageObjects.Todo.MainPage.class);
    }

    public static void initCalc() {
        calcMain = PageFactory.initElements(driver, pageObjects.Calculator.MainPage.class);
    }
}
