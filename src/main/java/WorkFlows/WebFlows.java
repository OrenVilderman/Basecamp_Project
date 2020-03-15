package WorkFlows;  //Represents regular routine tasks and operations that the system does: Creating / removing users,
                    // new tasks etc. - Inherits from CommonOps

import Extensions.Web.UiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebFlows extends CommonOps {
    public static String _userName;
    public static String _projectName;


    @Step("Sign in to Basecamp")
    public static void signIn(String userEmail, String userPassword){
        UiActions.click(basecampIntroPage.signIn_btn);
        UiActions.insertKeysAndClick(basecampSignInPage.userIdentifierInput_Field, userEmail, basecampSignInPage.next_btn);
        UiActions.insertKeysAndClick(basecampSignInPage.userPasswordInput_Field, userPassword, basecampSignInPage.login_btn);
    }

    @Step("Sign up to Basecamp")
    public static void signUp(String name, String email, String password, String companyName) {
        /*UiActions.clickMultiple(new ArrayList(basecampIntroPage.tryItFree_btn, basecampSignUpFlow.startFreeTrial_btn);*/
        UiActions.click(basecampIntroPage.tryItFree_btn);
        UiActions.click(basecampSignUpFlow.startFreeTrial_btn);
        UiActions.insertKeys(basecampSignUpFlow.name_Field, name);
        _userName = name;
        UiActions.insertKeys(basecampSignUpFlow.email_Field, email);
        UiActions.insertKeys(basecampSignUpFlow.password_Field, password);
        UiActions.click(basecampSignUpFlow.createMyAccount_btn);
        UiActions.insertKeys(basecampSignUpFlow.companyName_Field, companyName);
        /*ArrayList<WebElement> arr = new ArrayList();*/
        /*UiActions.clickMultiple(new ArrayList(basecampSignUpFlow.nextButtonSecond_btn, basecampSignUpFlow.nextButtonThird_btn));*/
        UiActions.click(basecampSignUpFlow.nextButtonSecond_btn);
        UiActions.click(basecampSignUpFlow.nextButtonThird_btn);
        UiActions.click(basecampSignUpFlow.nextButtonForth_btn);
        UiActions.click(basecampSignUpFlow.allDone_btn);
    }

    @Step("Add new project")
    public static void addNewProject(String projectName, String description) throws InterruptedException {
        UiActions.click(basecampMainPage.addAnotherProject_btn);
        UiActions.insertKeys(basecampNewProjectFlow.nameThisProject_field, projectName);
        _projectName = projectName;
        UiActions.insertKeysAndClick(basecampNewProjectFlow.addDescription_box, description, basecampNewProjectFlow.createThisProject_btn);
        Thread.sleep(2000);
        UiActions.click(basecampUpperMenu.home_btn);
        Thread.sleep(2000);
    }

    @Step("Remove first project")
    public static void removeAProject(){
        wait.until(ExpectedConditions.visibilityOf(basecampMainPage.addAnotherProject_btn));
        if (basecampMainPage.projects_list.size()>0){
            UiActions.click(basecampMainPage.projects_list.get(0));
            UiActions.click(basecampProjectMainPage.optionsMenu_btn);
            UiActions.click(basecampRemoveAProjectFlow.menuDeleteThisProject_btn);
            UiActions.click(basecampRemoveAProjectFlow.redDeleteThisProject_btn);
            wait.until(ExpectedConditions.visibilityOf(basecampMainPage.addAnotherProject_btn));
        }
    }

    @Step("Change profile image")
    public static void changeProfileImage(String imagePath){
        UiActions.click(basecampMainPage.avatarIcon_btn);
        UiActions.click(basecampAvatarMenu.myProfile_btn);
        UiActions.click(basecampEditProfilePage.uploadAPhoto_btn);
        UiActions.insertKeys(basecampEditProfilePage.sendImageElement, imagePath);
    }                   //impossible due to DOM definitions
}
