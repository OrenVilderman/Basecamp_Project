package PageObjects.BasecampMobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BottomMenu {
    @AndroidFindBy(id = "tab_bar_home")
    public WebElement homeMenu_btn;

    @AndroidFindBy(id = "tab_bar_inbox_container")
    public WebElement HeyMenu_btn;

    @AndroidFindBy(id = "tab_bar_activity")
    public WebElement activityMenu_btn;

    @AndroidFindBy(id = "tab_bar_me_container")
    public WebElement myStuffMenu_btn;
}
