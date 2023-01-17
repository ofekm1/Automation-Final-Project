package sanity;

import extensions.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {
    @Test(description = "Test01 verify calculator addition command")
    @Description("This test verify calculator addition command")
    public void test01_verifyAddition() {
        DesktopFlows.calcAddition();
        Verification.verifyElemText(calcMain.calcResult, "התצוגה היא 9");
    }
}
