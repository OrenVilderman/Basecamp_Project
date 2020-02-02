package PageObjects.BasecampWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpperMenuBar {
    @FindBy(how = How.LINK_TEXT, using = "Home")
    public WebElement home_btn;

    @FindBy(how = How.XPATH, using = "//ul[2]/li[2]")
    public WebElement pings_btn;

    @FindBy(how = How.XPATH, using = "//ul[2]/li[3]")
    public WebElement hey_btn;

    @FindBy(how = How.XPATH, using = "//ul[2]/li[4]")
    public WebElement activity_btn;

    @FindBy(how = How.XPATH, using = "//ul[2]/li[5]")
    public WebElement myStuff_btn;

    @FindBy(how = How.XPATH, using = "//ul[2]/li[6]")
    public WebElement find_btn;
}
