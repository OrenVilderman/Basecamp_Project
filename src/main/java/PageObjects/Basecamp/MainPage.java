package PageObjects.Basecamp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.XPATH, using = "//header/h1")
    public WebElement pageTitle_txt;

    @FindBy(how = How.XPATH, using = "*//a[@href='/4392455/']")
    public WebElement homePage_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__add-project")
    public WebElement addAnotherProject_btn;

    @FindBy(how = How.CLASS_NAME, using = "card__title flush")
    public WebElement existingProject_btn;

    @FindBy(how = How.XPATH, using = "//a[@title='Edit project name or description…']")
    public WebElement projectEditDetails_btn;

    @FindBy(how = How.XPATH, using = "//button[@name='button']")
    public WebElement help_btn;

    @FindBy(how = How.XPATH, using = "//main/div/a[@href='/4392455/account']")
    public WebElement adminland_btn;

    @FindBy(how = How.XPATH, using = "//div[2]/a")
    public WebElement needMoreProjectUpgrade_btn;

    @FindBy(how = How.XPATH, using = "//div/article[@id]")
    public List<WebElement> projects_list;


}
