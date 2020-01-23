package PageObjects.Basecamp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemoveAProjectFlow {

    @FindBy(how = How.LINK_TEXT, using = "Delete this project")
    public WebElement menuDeleteThisProject_btn;

    @FindBy(how = How.XPATH, using = "//a[@rel='nofollow']")
    public WebElement redDeleteThisProject_btn;
}
