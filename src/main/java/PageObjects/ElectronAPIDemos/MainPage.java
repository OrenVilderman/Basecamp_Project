package PageObjects.ElectronAPIDemos;

import Utilities.CommonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends CommonOps {
    @FindBy(how = How.ID, using = "button-windows")
    public WebElement windows_createAndManage_btn;

    @FindBy(how = How.ID, using = "button-crash-hang")
    public WebElement windows_handlingWindow_btn;

    @FindBy(how = How.ID, using = "button-app-sys-information")
    public WebElement system_systemInfo_btn;

    @FindBy(how = How.ID, using = "screen-info-demo-toggle")
    public WebElement getScreenInfo_btn;

    @FindBy(how = How.ID, using = "screen-info")
    public WebElement viewDemo_btn;

    @FindBy(how = How.ID, using = "got-screen-info")
    public WebElement screenInfo_txt;
}
