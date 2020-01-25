package Utilities;      //A class that meant to provide additional methods to use for supporting tests, such as taking a screenshot.
                        // Inherits from CommonOps class

import WorkFlows.WebFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import javax.imageio.ImageIO;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class HelperMethods extends CommonOps{
    public static int _numberOfProjectsBeforeAdding;
    public static String imageFilePath;

    public static SimpleDateFormat dateFormat;

    public static String returnRandomDate(){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String newDateFormat = dateFormat.format(new Date());
        return newDateFormat;
    }

    public static String takeElementScreenshot(WebElement elem, String imgName){
        imageFilePath = getDataFromXML("ImageRepo")+imgName+returnRandomDate() + ".png";
        imageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, elem);
        try{
            ImageIO.write(imageScreenshot.getImage(), "png", new File(imageFilePath));

        }catch (Exception e){
            System.out.println("Error writing image file, see details: " + e);
        }
        return imageFilePath;
    }

    public static WebElement selectorTypePicker(String identifierType, String identifierValue) {
        WebElement x;
        if (identifierType.equalsIgnoreCase("id")) {
            x = driver.findElement(By.id(identifierValue));
        } else if (identifierType.equalsIgnoreCase("className")) {
            x = driver.findElement(By.className(identifierValue));
        } else if (identifierType.equalsIgnoreCase("linkText")) {
            x = driver.findElement(By.linkText(identifierValue));
        } else if (identifierType.equalsIgnoreCase("xpath")) {
            x = driver.findElement(By.xpath(identifierValue));
        } else if (identifierType.equalsIgnoreCase("css")) {
            x = driver.findElement(By.cssSelector(identifierValue));
        } else if (identifierType.equalsIgnoreCase("tagName")) {
            x = driver.findElement(By.tagName(identifierValue));
        } else if (identifierType.equalsIgnoreCase("partialLinkText")) {
            x = driver.findElement(By.partialLinkText(identifierValue));
        } else if(identifierType.equalsIgnoreCase("name")) {
            x = driver.findElement(By.name(identifierValue));
        }
        else x = null;
        return x;
    }

    public static String returnRandomName(){
        String[] _names = GeneratorsData.names.split(" ");
        int randomNum = ThreadLocalRandom.current().nextInt(0, _names.length-1);
        return _names[randomNum];
    }

    public static String returnRandomEmailProvider(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        return GeneratorsData.numbersAndSymbols[randomNum];
    }

    public static String returnRandomPassword(){
        //String[] _fullPassword = new String[10];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 17);
            sb.append(GeneratorsData.numbersAndSymbols[randomNum]);
        }
        String fullPassword=sb.toString();
        return fullPassword;
    }

    public static String randomEmailGenerator(){
        String email = returnRandomName()+returnRandomDate()+"@"+returnRandomEmailProvider()+".com";
        return email;
    }

    public static String returnRandomFullName(){
        String randomFullName = returnRandomName()+" "+returnRandomName();
        return randomFullName;
    }

    public static int numberOfProjectsNow(){
        WebFlows.signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        basecampUpperMenu.home_btn.click();
        _numberOfProjectsBeforeAdding = basecampMainPage.projects_list.size();
        return _numberOfProjectsBeforeAdding;
    }

    public static String returnRandomThreeDigitNumber(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
            sb.append(GeneratorsData.numbersAndSymbols[randomNum]);
        }
        String threeDigitNumber = sb.toString();
        return threeDigitNumber;
    }

    public static boolean assertForHomePage(){
        boolean isHomePage = true;
        if (driver.getCurrentUrl().equals("https://basecamp.com/")){
            isHomePage = false;
        }
        return isHomePage;
    }

}
