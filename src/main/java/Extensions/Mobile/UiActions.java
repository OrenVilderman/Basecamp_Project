package Extensions.Mobile;

import Utilities.CommonOps;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class UiActions extends CommonOps {

    public static void click(WebElement elem) {
        elem.click();
    }

    public static void insertKeysAndClick(WebElement elem, String info, WebElement elem2) {
        elem.sendKeys(info);
        elem2.click();
    }

    /*public static void scrollToBottom()*/


}
