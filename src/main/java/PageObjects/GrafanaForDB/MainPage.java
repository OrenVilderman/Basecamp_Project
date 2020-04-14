package PageObjects.GrafanaForDB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.XPATH, using = "//span/img")
    public WebElement avatar_img;

    @FindBy(how = How.XPATH, using = "//div[3]/div[1]/ul/li[2]/a")
    public WebElement logOut_btn;

    @FindBy(how = How.XPATH, using = "//li[3]/span")
    public WebElement userName;


}
