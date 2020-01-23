package Extensions;     //Actions we commonly do on UI objects will be wrapped here with our methods in order to simplify
                        //the process. Inherits from CommonOps.

import Utilities.CommonOps;
import Utilities.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Utilities.HelperMethods;

public class UiActions extends CommonOps {

    public static void click (WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    public static void insertKeys (WebElement elem, String info){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
        elem.sendKeys(info);
    }

    public static void mouseHover (WebElement elem1, WebElement elem2){
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    public static void selectFromDropDownList (WebElement elem, String selection){
        Select DropDown = new Select(elem);
        DropDown.selectByVisibleText(selection);
    }

    public static void dragAndDrop (WebElement elem1, WebElement elem2){
        action.dragAndDrop(elem1, elem2);
    }

    public static void changeToIframe(String identifierType, String identifierValue){
        driver.switchTo().frame(HelperMethods.selectorTypePicker(identifierType, identifierValue));
    }
    //public static void

}
