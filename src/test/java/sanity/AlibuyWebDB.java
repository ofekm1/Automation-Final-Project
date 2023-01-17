package sanity;

import extensions.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class AlibuyWebDB extends CommonOps {
    @Test(description = "Test01 - verify login to alibuy with DB credentials")
    @Description("This test login to alibuy with DB credentials, and verify user menu")
    public void test01_verifyLoginWithDB() {
        WebFlows.loginWithDB();
        Verification.verifyLogin(alibuyMain.userDropdown);
    }
}
