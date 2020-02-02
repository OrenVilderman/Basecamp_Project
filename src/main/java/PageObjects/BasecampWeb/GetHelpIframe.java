package PageObjects.BasecampWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GetHelpIframe {
    @FindBy(how = How.XPATH, using = "//iframe[@title='Help Scout Beacon']")
    public WebElement helpIframeMain_ifrm;

    @FindBy(how = How.XPATH, using = "//a[1]/div[2]/span/span/span")
    public WebElement gettingStartedWithBasecamp_btn;

    @FindBy(how = How.XPATH, using = "//div/div/span/span[1]/span")
    public WebElement masterTheBasecampBasics_btn;

    @FindBy(how = How.XPATH, using = "//a[3]/div[2]/span")
    public WebElement introToTheProjectTools_btn;

    @FindBy(how = How.XPATH, using = "//a[4]/div[2]/span/span/span")
    public WebElement howWeWork_btn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"Input1\"]")
    public WebElement searchTheBasecampHelpGuides_Field;

    @FindBy(how = How.XPATH, using = "//*[@id=\"beacon-container\"]/div/div[2]/button/span[1]/span")
    public WebElement closeHelp_btn;

    @FindBy(how = How.XPATH, using = "//div[2]/a/div/div[2]/span")
    public WebElement ask_btn;

    @FindBy(how = How.XPATH, using = "//div[1]/a/div/div[2]/span")
    public WebElement answers_btn;

}
