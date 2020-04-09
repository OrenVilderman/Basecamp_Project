package WorkFlows;

import Extensions.Web.UiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class CalculatorFlow extends CommonOps {
    @Step("Check Simple Plus Action")
    public static void addNumbers() {
        UiActions.click(calculatorMainPage.clear_btn);
        UiActions.click(calculatorMainPage.one_btn);
        UiActions.click(calculatorMainPage.plus_btn);
        UiActions.click(calculatorMainPage.five_btn);
        UiActions.click(calculatorMainPage.equals_btn);
    }

}
