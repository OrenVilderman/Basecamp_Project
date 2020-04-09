package WorkFlows;

import Extensions.Web.UiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class CalculatorFlow extends CommonOps {
    @Step("Check Simple Plus Action")
    public static void addNumbers(WebElement elem1) {
        UiActions.click(elem1);
    }

}
