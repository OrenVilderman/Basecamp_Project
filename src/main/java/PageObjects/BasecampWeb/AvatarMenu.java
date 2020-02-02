package PageObjects.BasecampWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AvatarMenu {

    @FindBy(how = How.LINK_TEXT, using = "My profile (avatar, title, password, etc)")
    public WebElement myProfile_btn;

    @FindBy(how = How.LINK_TEXT, using = "Log out")
    public WebElement logOut_btn;

}
