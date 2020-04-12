package PageObjects.GrafanaForDB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginFlow {
    @FindBy(how = How.NAME, using = "user")
    public WebElement userName_field;

    @FindBy(how = How.NAME, using = "password")
    public WebElement password_field;

    @FindBy(how = How.XPATH, using = "//button")
    public WebElement logIn_btn;

    @FindBy(how = How.XPATH, using = "//form/div[3]/a")
    public WebElement skip_btn;

}
