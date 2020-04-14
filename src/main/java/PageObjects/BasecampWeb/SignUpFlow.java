package PageObjects.BasecampWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpFlow {

    @FindBy(how = How.XPATH, using = "//a[@class='button button--primary button--stacked']")
    public WebElement startFreeTrial_btn;

    @FindBy(how = How.ID, using = "signup_full_name")
    public WebElement name_Field;

    @FindBy(how = How.ID, using = "signup_email_address")
    public WebElement email_Field;

    @FindBy(how = How.XPATH, using = "//section[1]/input")
    public WebElement nextButtonFirst_btn;                                          //After inserting name and email

    @FindBy(how = How.ID, using = "signup_password")
    public WebElement password_Field;

    @FindBy(how = How.XPATH, using = "//section[2]/input")
    public WebElement createMyAccount_btn;

    @FindBy(how = How.ID, using = "setup_company_name")
    public WebElement companyName_Field;

    @FindBy(how = How.XPATH, using = "//article[1]/button")
    public WebElement nextButtonSecond_btn;                                         //After entering company name

    @FindBy(how = How.XPATH, using = "//article[2]/button")
    public WebElement nextButtonThird_btn;                                          //After entering company teams

    @FindBy(how = How.XPATH, using = "//article[3]/button")
    public WebElement nextButtonForth_btn;                                          //After entering company projects

    @FindBy(how = How.XPATH, using = "//article[4]/input")
    public WebElement allDone_btn;

    @FindBy(how = How.XPATH, using = "//div[1]/header/h3")
    public WebElement finishAccountCreationWindowTitle_txt;                         //Title assertion for successful account creation
                                                                                    //"Your account’s ready to go! 👍"
    @FindBy(how = How.XPATH, using = "//article/div[1]/button")
    public WebElement noThanks_btn;                                                 //In order to close popup window

    @FindBy(how = How.XPATH, using = "//section[1]/header/h3/span")
    public WebElement userNameTitle_txt;                                            //For assertion

    @FindBy(how = How.XPATH, using = "//section[3]/header/aside[1]/span/button")
    public WebElement newInitialProject_btn;

    @FindBy(how = How.ID, using = "project_name")
    public WebElement nameThisInitialNewProject_field;

    @FindBy(how = How.XPATH, using = "//*[@value = 'Save']")
    public WebElement SaveInitialNewProject_btn;

}
