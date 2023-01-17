package sanity;

import extensions.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {
    @Test(description = "Test01 fill and calculate mortgage")
    @Description("This test fill the form and calculate repayment")
    public void test01_calPayment() {
        MobileFlows.calculateMortgage("1000", "3", "5");
        Verification.verifyElemText(mortgageMain.txtRepayment, "£30.60");
    }
}
