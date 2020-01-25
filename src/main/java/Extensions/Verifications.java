package Extensions;     //Methods that are meant to verify our tests will be written here and get called from the tests.
                        //The class inherits from CommonOps class

import Utilities.CommonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Verifications extends CommonOps {

    public static void verifyTextInElement(WebElement elem, String actual, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(actual, expected);
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

    public static boolean verifyImageElement(WebElement elem, String expected){
        boolean ImagesEqual;
        BufferedImage exp = null;
        try {
            exp = ImageIO.read((new File(expected)));
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
