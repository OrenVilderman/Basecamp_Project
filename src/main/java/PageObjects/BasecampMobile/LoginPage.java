package PageObjects.BasecampMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    /*@AndroidFindBy(id = "login_next")
    public WebElement loginToBasecamp_btn;

    @AndroidFindBy(id = "start_trial")
    public WebElement tryBasecampFree_btn;

    @AndroidFindBy(xpath = "//*[@id='login_email']")
    public WebElement loginEmail_field;

    @AndroidFindBy(id = "login_next")
    public WebElement next1_btn;

    @AndroidFindBy(xpath = "//*[@id='login_password']")
    public WebElement password_field;

    @AndroidFindBy(id = "login_password_next")
    public WebElement next2_btn;*/

    @CacheLookup
    @FindBy(how = How.ID, using = "login_next")
    public WebElement loginToBasecamp_btn;

    @CacheLookup
    @FindBy(how = How.ID, using = "start_trial")
    public WebElement tryBasecampFree_btn;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//*[@id='login_email']")
    public WebElement loginEmail_field;

    @CacheLookup
    @FindBy(how = How.ID, using = "login_next")
    public WebElement next1_btn;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//*[@id='login_password']")
    public WebElement password_field;

    @CacheLookup
    @FindBy(how = How.ID, using = "login_password_next")
    public WebElement next2_btn;

}
