package WorkFlows;  //Represents regular routine tasks and operations that the system does: Creating / removing users,
                    // new tasks etc. - Inherits from CommonOps

import Utilities.CommonOps;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebFlows extends CommonOps {
    public static String _userName;
    public static String _projectName;



    public static void signIn(String userEmail, String userPassword){
        wait.until(ExpectedConditions.visibilityOf(basecampIntroPage.signIn_btn));
        basecampIntroPage.signIn_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignInPage.userIdentifierInput_Field));
        basecampSignInPage.userIdentifierInput_Field.sendKeys(userEmail);
        basecampSignInPage.next_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignInPage.userPasswordInput_Field));
        basecampSignInPage.userPasswordInput_Field.sendKeys(userPassword);
        basecampSignInPage.login_btn.click();
    }

    public static void signUp(String name, String email, String password, String companyName) {
        wait.until(ExpectedConditions.visibilityOf(basecampIntroPage.tryItFree_btn));
        basecampIntroPage.tryItFree_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignUpFlow.startFreeTrial_btn));
        basecampSignUpFlow.startFreeTrial_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignUpFlow.nextButtonFirst_btn));
        basecampSignUpFlow.name_Field.clear();
        basecampSignUpFlow.name_Field.sendKeys(name);
        _userName = name;
        basecampSignUpFlow.email_Field.clear();
        basecampSignUpFlow.email_Field.sendKeys(email);
        basecampSignUpFlow.nextButtonFirst_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignUpFlow.createMyAccount_btn));
        basecampSignUpFlow.password_Field.clear();
        basecampSignUpFlow.password_Field.sendKeys(password);
        basecampSignUpFlow.createMyAccount_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignUpFlow.nextButtonSecond_btn));
        basecampSignUpFlow.companyName_Field.clear();
        basecampSignUpFlow.companyName_Field.sendKeys(companyName);
        basecampSignUpFlow.nextButtonSecond_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignUpFlow.nextButtonThird_btn));
        basecampSignUpFlow.nextButtonThird_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignUpFlow.nextButtonForth_btn));
        basecampSignUpFlow.nextButtonForth_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampSignUpFlow.allDone_btn));
        basecampSignUpFlow.allDone_btn.click();
    }

    public static void addNewProject(String projectName, String description) throws InterruptedException {
        //signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        wait.until(ExpectedConditions.visibilityOf(basecampMainPage.addAnotherProject_btn));
        basecampMainPage.addAnotherProject_btn.click();
        wait.until(ExpectedConditions.visibilityOf(basecampNewProjectFlow.createThisProject_btn));
        basecampNewProjectFlow.nameThisProject_field.clear();
        basecampNewProjectFlow.nameThisProject_field.sendKeys(projectName);
        _projectName = projectName;
        basecampNewProjectFlow.addDescription_box.clear();
        basecampNewProjectFlow.addDescription_box.sendKeys(description);
        basecampNewProjectFlow.createThisProject_btn.click();
        Thread.sleep(2000);
        basecampUpperMenu.home_btn.click();
        Thread.sleep(2000);
    }

    public static void removeAProject(){
        wait.until(ExpectedConditions.visibilityOf(basecampMainPage.addAnotherProject_btn));
        if (basecampMainPage.projects_list.size()>0){
            basecampMainPage.projects_list.get(0).click();
            wait.until(ExpectedConditions.visibilityOf(basecampProjectMainPage.optionsMenu_btn));
            basecampProjectMainPage.optionsMenu_btn.click();
            basecampRemoveAProjectFlow.menuDeleteThisProject_btn.click();
            wait.until(ExpectedConditions.visibilityOf(basecampRemoveAProjectFlow.redDeleteThisProject_btn));
            basecampRemoveAProjectFlow.redDeleteThisProject_btn.click();
            wait.until(ExpectedConditions.visibilityOf(basecampMainPage.addAnotherProject_btn));
        }
    }

    public static void changeProfileImage(String imagePath){
        wait.until(ExpectedConditions.visibilityOf(basecampMainPage.avatarIcon_btn));
        basecampMainPage.avatarIcon_btn.click();
        basecampAvatarMenu.myProfile_btn.click();
        basecampEditProfilePage.uploadAPhoto_btn.click();
        basecampEditProfilePage.sendImageElement.sendKeys(imagePath);
    }                   //impossible due to DOM definitions
}
