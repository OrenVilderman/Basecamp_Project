package PageObjects.BasecampMobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.List;

public class LoginPage {

    @AndroidFindBy(id = "login_next")
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
    public WebElement next2_btn;



}
