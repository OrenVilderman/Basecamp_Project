package PageObjects.BasecampMobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyStuffPage {

    @CacheLookup
    @FindBy(how = How.ID, using = "settings_logout_email")
    public WebElement logout_btn;

    @CacheLookup
    @FindBy(how = How.ID, using = "button1")
    public WebElement logoutOk_btn;
}
