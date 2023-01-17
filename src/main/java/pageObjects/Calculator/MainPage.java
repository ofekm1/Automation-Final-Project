package pageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(name = "אפס")
    public WebElement btnZero;

    @FindBy(name = "אחת")
    public WebElement btnOne;

    @FindBy(name = "שתיים")
    public WebElement btnTwo;

    @FindBy(name = "שלוש")
    public WebElement btnThree;

    @FindBy(name = "ארבע")
    public WebElement btnFour;

    @FindBy(name = "חמש")
    public WebElement btnFive;

    @FindBy(name = "שש")
    public WebElement btnSix;

    @FindBy(name = "שבע")
    public WebElement btnSeven;

    @FindBy(name = "שמונה")
    public WebElement btnEight;

    @FindBy(name = "תשע")
    public WebElement btnNine;

    @FindBy(name = "ועוד")
    public WebElement btnPlus;

    @FindBy(name = "פחות")
    public WebElement btnMinus;

    @FindBy(xpath = "//*[@AutomationId='multiplyButton']")
    public WebElement btnMultiply;

    @FindBy(xpath = "//*[@AutomationId='divideButton']")
    public WebElement btnDivide;

    @FindBy(xpath = "//*[@AutomationId='equalButton']")
    public WebElement btnEquals;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement calcResult;

    @FindBy(xpath = "//*[@AutomationId='clearButton']")
    public WebElement btnClear;

}
