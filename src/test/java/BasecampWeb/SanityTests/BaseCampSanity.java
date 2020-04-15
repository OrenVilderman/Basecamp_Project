package BasecampWeb.SanityTests;

import Extensions.Web.Verifications;
import Utilities.CommonOps;
import Utilities.HelperMethods;
import org.testng.annotations.Listeners;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static Utilities.HelperMethods.*;

import static Utilities.HelperMethods.getDataFromXML;

@Listeners(Utilities.Listeners.class)
public class BaseCampSanity extends CommonOps {
    @Test(description = "Login Sanity Test", priority = 2)
    @Description("Test description: Logging in with a user")
    public void testLogin() {
        WebFlows.signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        Verifications.verifyTextInElement(basecampMainPage.pageTitle_txt, "Your Projects");
    }

    @Test(description = "SignUp Sanity Test", priority = 1, enabled = false)
    @Description("Test description: Signing up a new user")
    public void testSignup() throws InterruptedException {
        WebFlows.signUp(returnRandomFullName(), randomEmailGenerator(), returnRandomPassword(), returnRandomCompanyName());
        Verifications.verifyTextInElement(basecampSignUpFlow.userNameTitle_txt, WebFlows._userName);
    }

    @Test(description = "Add new project", priority = 3)
    @Description("Test description: Adding a new project")
    public void testAddNewProject() throws InterruptedException {
            WebFlows.addNewProject(HelperMethods.returnRandomName() + HelperMethods.returnRandomDate(), HelperMethods.returnRandomFullName());
            Verifications.verifyNumberOfElementsProjectAdd(basecampMainPage.projects_list, _numberOfProjectsBeforeAddingOrRemoving);

    }

    @Test(description = "Remove a project", priority = 4)
    @Description("Test description: Removing a project")
    public void testRemoveAProject() throws InterruptedException {
        WebFlows.removeAProject();
        Verifications.verifyNumberOfElementsProjectRemove(basecampMainPage.projects_list, _numberOfProjectsBeforeAddingOrRemoving);
    }

}



