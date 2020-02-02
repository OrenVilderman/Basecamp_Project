package Helpers;

import Extensions.Web.Verifications;
import Utilities.CommonOps;
import Utilities.HelperMethods;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VirtualTesting extends CommonOps{
    String avatarCurrentImageFilePath;

    @Test
    public void createScreenshot(){
        WebFlows.signIn(getDataFromXML("UserEmail"),getDataFromXML("Password"));
        avatarCurrentImageFilePath = HelperMethods.takeElementScreenshot(basecampMainPage.avatarIcon_btn, "Ziv_"+HelperMethods.returnRandomThreeDigitNumber()+"_");
        System.out.println(avatarCurrentImageFilePath);
    }

    @Test(description = "Compare avatar images", enabled = false)
    @Description("Test description: compare expected avatar image to the current image")
    public void visualTest01() {
        if(!HelperMethods.assertForHomePage()) {
            WebFlows.signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        }
        assertTrue(Verifications.verifyImageElement(basecampMainPage.avatarIcon_btn, avatarCurrentImageFilePath));
    }


}
