package PageObjects.Basecamp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UpperMenuFindWindow {
    @FindBy(how = How.XPATH, using = "//input[@autocomplete='chrome-is-buggy']")
    public WebElement searchBar_Field;

    @FindBy(how = How.ID, using = "search_type")
    public List<WebElement> searchItemType_select;

    @FindBy(how = How.ID, using = "search_creator_id")
    public List<WebElement> searchByWho_select;

    @FindBy(how = How.XPATH, using = "//select[3]")
    public List<WebElement> searchWhere_select;
}
