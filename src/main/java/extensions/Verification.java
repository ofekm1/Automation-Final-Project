package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.List;

public class Verification extends CommonOps {
    @Step("Verify text in element")
    public static void verifyElemText(WebElement elem, String expectedResult) {
        Assert.assertEquals(elem.getText(), expectedResult);
    }

    @Step("Verify Login")
    public static void verifyLogin(List<WebElement> elems) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elems));
        Assert.assertEquals(elems.size(), 1);
    }

    @Step("Verify Logout")
    public static void verifyLogout(List<WebElement> elems) {
        WebFlows.logout();
        wait.until(ExpectedConditions.visibilityOfAllElements(elems));
        Assert.assertEquals(elems.size(), 0);

    }

    @Step("Verify Registration")
    public static void verifyRegistration(List<WebElement> elems) {
        if (elems.size() >= 1) {
            throw new RuntimeException(elems.get(0).getText());
        } else {
            wait.until(ExpectedConditions.visibilityOf(alibuyRegister.regSuccess));
            Assert.assertTrue(alibuyRegister.regSuccess.isDisplayed(), alibuyRegister.regSuccess.getText());
        }
    }

    @Step("Verify top menu enabled")
    public static void verifyTopMenu(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        Assert.assertEquals(elems.size(), expected);
    }

    @Step("Verify top menu is enabled")
    public static void verifyTopMenuEnabled(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isEnabled());
        }
    }

    @Step("Verify visual element")
    public static void verifyVisualElement(String expectedImage) throws FindFailed {
        screen.find(getData("ImageRepo") + expectedImage + ".png");
    }

    @Step("Verify search result is not empty")
    public static void searchResultFound(List<WebElement> elements) {
        Assert.assertTrue(elements.size() > 0);
    }

    @Step("Verify search result is  empty")
    public static void searchResultNotFound(List<WebElement> elements) {
        Assert.assertFalse(elements.size() == 0);
    }

    @Step("Verify text")
    public static void verifyText(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Verify number")
    public static void verifyNumber(int actual, int expected) {
        Assert.assertEquals(actual, expected);
    }
}
