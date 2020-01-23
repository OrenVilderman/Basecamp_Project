package PageObjects.Basecamp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage {
    @FindBy(how = How.CLASS_NAME, using = "input--text")
    public WebElement userIdentifierInput_Field;

    @FindBy(how = How.XPATH, using = "*//button[@data-role='next_button']")
    public WebElement next_btn;

    @FindBy(how = How.XPATH, using = "*//input[@type='password']")
    public WebElement userPasswordInput_Field;

    @FindBy(how = How.XPATH, using = "*//input[@type='submit']")
    public WebElement login_btn;
}
