package PageObjects.BasecampMobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MyStuffPage {

    @AndroidFindBy(id = "settings_logout_email")
    public WebElement logout_btn;

    @AndroidFindBy(id = "button1")
    public WebElement logoutOk_btn;
}
