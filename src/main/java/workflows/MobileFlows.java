package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;


public class MobileFlows extends CommonOps {
    @Step("Business flow: fill and calculate mortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileActions.updateText(mortgageMain.txtAmount, amount);
        MobileActions.updateText(mortgageMain.txtTerm, term);
        MobileActions.updateText(mortgageMain.txtRate, rate);
        MobileActions.tap(mortgageMain.btnCalc);
    }
}
