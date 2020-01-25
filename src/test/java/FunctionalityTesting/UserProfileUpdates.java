package FunctionalityTesting;


import Extensions.Verifications;
import Utilities.CommonOps;
import Utilities.HelperMethods;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class UserProfileUpdates extends CommonOps {

    @Test(description = "Updating user avatar")
    @Description("Test description: Updating the image of user avatar")
    public void userProfileUpdatesTest01(){
        if (!HelperMethods.assertForHomePage()){
            WebFlows.signIn(getDataFromXML("UserEmail"),getDataFromXML("Password"));
        }
        WebFlows.changeProfileImage(getDataFromXML("ImageRepo")+"Untitled-10-Small.png");

    }

}
