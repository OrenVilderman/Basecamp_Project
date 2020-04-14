package Extensions.Web;     //Actions we commonly do on UI objects will be wrapped here with our methods in order to simplify
                            //the process. Inherits from CommonOps.

import Utilities.CommonOps;
import Utilities.HelperMethods;
import jdk.nashorn.internal.ir.WhileNode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;

import static Utilities.HelperMethods.getDataFromXML;

public class UiActions extends CommonOps {

    public static void click (WebElement elem){
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    public static void insertKeys (WebElement elem, String info){
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
        elem.sendKeys(info);
    }

    public static void insertKeysAndClick (WebElement elem1, String info, WebElement elem2){
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem1));
        insertKeys(elem1, info);
        elem2.click();
    }

    public static void mouseHover (WebElement elem1, WebElement elem2){
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web"))
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

}
