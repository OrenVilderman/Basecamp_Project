package PageObjects.BasecampWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewProjectFlow {

    @FindBy(how = How.ID, using = "project_name")
    public WebElement nameThisProject_field;

    @FindBy(how = How.ID, using = "project_description")
    public WebElement addDescription_box;

    @FindBy(how = How.XPATH, using = "//input[@name='commit']")
    public WebElement createThisProject_btn;

}
