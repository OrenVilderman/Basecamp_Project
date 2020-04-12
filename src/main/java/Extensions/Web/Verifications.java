package Extensions.Web;     //Methods that are meant to verify our tests will be written here and get called from the tests.
                        //The class inherits from CommonOps class

import Utilities.CommonOps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import javax.xml.xpath.XPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import static Utilities.HelperMethods.getDataFromXML;
import static org.testng.Assert.assertEquals;

public class Verifications extends CommonOps {

    public static void verifyTextInElement(WebElement elem, String expected){
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        else if (getDataFromXML("PlatformName").equalsIgnoreCase("desktop"))
            assertEquals(elem.getText().replaceAll("Display is","").trim(), expected);
        else
        assertEquals(elem.getText(), expected);
        System.out.println("Expected result is: " + expected + ".\nActual result is: " + elem.getText());
    }

    public static void verifyNumberOfElementsProjectAdd(List<WebElement> actual, int expected) throws InterruptedException {
        Thread.sleep(1500);
        basecampUpperMenu.home_btn.click();
        assertEquals(actual.size(), expected+1);
    }
    public static void verifyNumberOfElementsProjectRemove(List<WebElement> actual, int expected) throws InterruptedException {
        Thread.sleep(1500);
        basecampUpperMenu.home_btn.click();
        assertEquals(actual.size(), expected-1);
    }

    public static boolean verifyImageElement(WebElement elem, String expectedImageFilePath){
        boolean ImagesEqual;
        BufferedImage exp = null;
        try {
            exp = ImageIO.read((new File(expectedImageFilePath)));
        } catch (Exception e) {
            System.out.println("Error reading the file: "+e);
        }
        Screenshot imageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, elem);
        BufferedImage actualImage = imageScreenshot.getImage();
        imgDiff = new ImageDiffer();
        diff = imgDiff.makeDiff(actualImage, exp);
        ImagesEqual = (!diff.hasDiff());
        return ImagesEqual;
    }
}
