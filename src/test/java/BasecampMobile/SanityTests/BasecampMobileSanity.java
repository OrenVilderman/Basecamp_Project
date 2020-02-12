package BasecampMobile.SanityTests;

import Extensions.Mobile.UiActions;
import Extensions.Web.Verifications;
import Utilities.CommonOps;
import WorkFlows.MobileFlows;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utilities.HelperMethods.getDataFromXML;


@Listeners(Utilities.Listeners.class)
public class BasecampMobileSanity extends CommonOps {

    @Test(description = "Mobile Login Sanity Test")
    @Description("Test description: Logging in with a user to mobile app")
    public void testLoginMobile() throws InterruptedException {
        MobileFlows.login(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        /*Verifications.verifyTextInElement(basecampMainPage.pageTitle_txt, basecampMainPage.pageTitle_txt.getText(), "Your Projects");*/
    }

    @Test(description = "Mobile Logout Sanity Test")
    @Description("Test description: Logging out user from the mobile app")
    public void testLoguotMobile(){
        MobileFlows.logout();
    }


}



