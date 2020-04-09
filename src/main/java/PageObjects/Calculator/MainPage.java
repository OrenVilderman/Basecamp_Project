package PageObjects.Calculator;

import Utilities.CommonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends CommonOps {

    @FindBy(how = How.NAME, using = "Clear")
    public WebElement clear_btn;

    @FindBy(how = How.NAME, using = "One")
    public WebElement one_btn;

    @FindBy(how = How.NAME, using = "Plus")
    public WebElement plus_btn;

    @FindBy(how = How.NAME, using = "Five")
    public WebElement five_btn;

    @FindBy(how = How.NAME, using = "Equals")
    public WebElement equals_btn;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement results_field;
}
