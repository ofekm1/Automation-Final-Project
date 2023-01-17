package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {
    @Step("Calculate addition - 1+8")
    public static void calcAddition() {
        UIActions.click(calcMain.btnClear);
        UIActions.click(calcMain.btnOne);
        UIActions.click(calcMain.btnPlus);
        UIActions.click(calcMain.btnEight);
        UIActions.click(calcMain.btnEquals);
    }
}
