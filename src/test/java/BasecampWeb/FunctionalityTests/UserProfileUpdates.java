package BasecampWeb.FunctionalityTests;

import Utilities.CommonOps;
import Utilities.HelperMethods;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utilities.HelperMethods.getDataFromXML;

@Listeners(Utilities.Listeners.class)
public class UserProfileUpdates extends CommonOps {

    @Test(description = "Updating user avatar")
    @Description("Test description: Updating the image of user avatar")
    public void userProfileUpdatesTest01() {
        if (!HelperMethods.assertForHomePage()) {
            WebFlows.signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        }
        WebFlows.changeProfileImage(getDataFromXML("ImageRepo") + "Untitled-10-Small.png");

    }

}
