package Desktop;

import Extensions.Web.Verifications;
import PageObjects.Calculator.MainPage;
import Utilities.CommonOps;
import WorkFlows.CalculatorFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class CalculatorSanity extends CommonOps {
    @Test(description = "Simple Addition Action")
    @Description("Test Simple addition action in calculator")
    public void calculatorSanityPlus(){
        CalculatorFlow.addNumbers();
        Verifications.verifyTextInElement(calculatorMainPage.results_field, "6");
    }
}
