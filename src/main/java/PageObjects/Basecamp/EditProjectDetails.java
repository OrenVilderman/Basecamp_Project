package PageObjects.Basecamp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditProjectDetails {
    @FindBy(how = How.CLASS_NAME, using = "perma__title")
    public WebElement EditProjectDetailsTitle;

    @FindBy(how = How.ID, using = "project_name")
    public WebElement name_field;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    public WebElement saveChanges_btn;
}
