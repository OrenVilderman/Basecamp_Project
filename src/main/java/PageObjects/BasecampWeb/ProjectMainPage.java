package PageObjects.BasecampWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProjectMainPage {
    @FindBy(how = How.CLASS_NAME, using = "project-header__name--overview")
    public WebElement projectTitle_txt;

    @FindBy(how = How.CLASS_NAME, using = "project-header__description normal")
    public WebElement projectDescription_txt;

    @FindBy(how = How.CLASS_NAME, using = "project-avatars__edit-text--full")
    public WebElement invitePeople_btn;

    @FindBy(how = How.XPATH, using = "//div[2]/div/img")
    public WebElement ownerAvatar_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__icon card__icon--messages")
    public WebElement messageBoard_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__icon card__icon--todos")
    public WebElement toDos_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__icon card__icon--document")
    public WebElement docsAndFiles_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__icon card__icon--campfire")
    public WebElement campfire_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__icon card__icon--schedule")
    public WebElement schedule_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__icon card__icon--checkins")
    public WebElement automaticCheckIns_btn;

    @FindBy(how = How.TAG_NAME, using = "article")
    public List<WebElement> toolsDisplayed_list;

    @FindBy(how = How.CLASS_NAME, using = "decorated decorated--matched")
    public WebElement changeToolSet_btn;

    @FindBy(how = How.XPATH, using = "//button[@title='Show options…']")
    public WebElement optionsMenu_btn;

}
