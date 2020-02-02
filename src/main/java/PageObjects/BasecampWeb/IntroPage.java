package PageObjects.BasecampWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IntroPage {
    @FindBy(how = How.XPATH, using="//*[@id=\"top\"]/ul/li[6]/a")
    public WebElement signIn_btn;

    @FindBy(how = How.XPATH, using="//*[@id=\"top\"]/ul/li[7]/a")
    public WebElement tryItFree_btn;

}
