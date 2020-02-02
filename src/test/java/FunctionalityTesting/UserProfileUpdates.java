package FunctionalityTesting;


import Utilities.CommonOps;
import Utilities.HelperMethods;
import Utilities.Listeners;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

@org.testng.annotations.Listeners(Listeners.class)
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
