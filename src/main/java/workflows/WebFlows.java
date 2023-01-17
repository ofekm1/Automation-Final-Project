package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {
    @Step("Business flow: Login to AliBuy using username and password")
    public static void login(String user, String pass) {
        UIActions.click(alibuyMain.btnLogReg);
        UIActions.updateText(alibuyLogin.txt_userName, user);
        UIActions.updateText(alibuyLogin.txt_password, pass);
        UIActions.click(alibuyLogin.btn_submit);
//        wait.until(ExpectedConditions.visibilityOfAllElements(alibuyMain.userDropdown));
        if (alibuyMain.userDropdown.size() == 1) {
            System.out.println("Logged in successfully");
        } else if (alibuyLogin.loginError.isEnabled())
            throw new RuntimeException(alibuyLogin.loginError.getText());
    }

    @Step("Business flow: Business flow: Login to AliBuy using Database credentials")
    public static void loginWithDB() {
        List<String> cred = DBActions.getCredentials("SELECT username, password FROM Users WHERE id='1'");
        UIActions.click(alibuyMain.btnLogReg);
        UIActions.updateText(alibuyLogin.txt_userName, cred.get(0));
        UIActions.updateText(alibuyLogin.txt_password, cred.get(1));
        UIActions.click(alibuyLogin.btn_submit);
//        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfAllElements(alibuyMain.userDropdown));
        if (alibuyMain.userDropdown.size() == 1) {
            System.out.println("Logged in successfully");
        } else if (alibuyLogin.loginError.isEnabled())
            throw new RuntimeException(alibuyLogin.loginError.getText());
    }

    @Step("Business flow: logout")
    public static void logout() {
        if (alibuyMain.userDropdown.size() == 1) {
            UIActions.click(alibuyMain.btnLogReg);
            UIActions.click(alibuyMain.btnLogout);
        } else
            throw new RuntimeException("You are not  logged in");
    }

    @Step("Business flow: register")
    public static void register(String username, String email, String pass, String confirmPass, String name) {
        if (alibuyMain.userDropdown.size() == 1) {
            UIActions.click(alibuyMain.btnLogReg);
            UIActions.click(alibuyMain.btnLogout);
        } else {
            UIActions.click(alibuyMain.btnLogReg);
            UIActions.click(alibuyMain.register);
            UIActions.updateText(alibuyRegister.username, username);
            UIActions.updateText(alibuyRegister.email, email);
            UIActions.updateText(alibuyRegister.pass, pass);
            UIActions.updateText(alibuyRegister.confirmPass, confirmPass);
            UIActions.updateText(alibuyRegister.name, name);
            UIActions.click(alibuyRegister.btnSubmit);
        }
    }

    @Step("Business flow: search")
    public static void search(String searchValue, String shouldFound) {
        UIActions.updateTextHuman(alibuyMain.txtSearch, searchValue);
        Verification.searchResultFound(alibuyMain.searchResultList);
        if (shouldFound.equalsIgnoreCase("true")) {
            Verification.searchResultFound(alibuyMain.searchResultList);
        } else if (shouldFound.equalsIgnoreCase("false")) {
            Verification.searchResultNotFound(alibuyMain.searchResultList);
        }
    }
}
