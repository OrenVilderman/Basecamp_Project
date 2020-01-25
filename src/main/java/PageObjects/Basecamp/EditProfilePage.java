package PageObjects.Basecamp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditProfilePage {

    @FindBy(how = How.XPATH, using = "//p/button")
    public WebElement uploadAPhoto_btn;

    @FindBy(how = How.XPATH, using = "//input[@type='file']")
    public WebElement sendImageElement;
}
