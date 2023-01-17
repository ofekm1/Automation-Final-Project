package sanity;

import extensions.Verification;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class AlibuyWeb extends CommonOps {
    @Test(description = "Test01 - verify login")
    @Description("This test login to alibuy with username and password, and verify user menu")
    public void test01_verifyLogin() {
        WebFlows.login(getData("username"),getData("password"));
        Verification.verifyLogin(alibuyMain.userDropdown);
    }

    @Test(description = "Test02 - verify the top menu")
    @Description("This test verify the top menu has eight sections")
    public void test02_verifyTopMenu() {
        Verification.verifyTopMenu(alibuyTopMenu.topMenuList, 8);
    }

    @Test(description = "Test03 - verify logout")
    @Description("This test verify logout")
    public void test03_verifyLogout() {
        Verification.verifyLogout(alibuyMain.userDropdown);
    }

    @Test(description = "Test04 - verify registration")
    @Description("This test verify user registration")
    public void test04_verifyRegistration() {
        WebFlows.register("ofekmo12333dd323", "aaa@bbbbbbbbbbbb.com", "123456", "123456", "ofekmo");

        Verification.verifyRegistration(alibuyRegister.listError);
    }

    @Test(description = "Test05 - verify top menu enabled")
    @Description("This test verify top menu is enabled")
    public void test05_verifyTopMenuEnabled() {
        Verification.verifyTopMenuEnabled(alibuyTopMenu.topMenuList);
    }

    @Test(description = "test06 - verify main logo")
    @Description("This test verify main logo using sikuli tool")
    public void test06_verifyMainLogo() throws FindFailed {
        Verification.verifyVisualElement("alibuyLogo");
    }

    @Test(description = "Test07 - verify search is not empty",
            dataProvider = "data-provider-searches", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verify search result list usint DDT")
    public void test07_verifySearchList(String searchValue, String shouldFound) {
        WebFlows.search(searchValue, shouldFound);
        Verification.searchResultFound(alibuyMain.searchResultList);
    }
}
