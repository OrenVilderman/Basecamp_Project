package Utilities;      //A class that will define an object for each page/section class of the app and initialize the
                        // objects we define in each and every one. Inherits from Base class

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base{

    public static void initWeb(){
        basecampIntroPage = PageFactory.initElements(driver, PageObjects.BasecampWeb.IntroPage.class);
        basecampMainPage = PageFactory.initElements(driver, PageObjects.BasecampWeb.MainPage.class);
        basecampSignInPage = PageFactory.initElements(driver, PageObjects.BasecampWeb.SignInPage.class);
        basecampProjectMainPage = PageFactory.initElements(driver, PageObjects.BasecampWeb.ProjectMainPage.class);
        basecampUpperMenu = PageFactory.initElements(driver, PageObjects.BasecampWeb.UpperMenuBar.class);
        basecampEditProjectDetailsPage = PageFactory.initElements(driver, PageObjects.BasecampWeb.EditProjectDetails.class);
        basecampGetHelpIframe = PageFactory.initElements(driver, PageObjects.BasecampWeb.GetHelpIframe.class);
        basecampUpperMenuFindWindowPage = PageFactory.initElements(driver, PageObjects.BasecampWeb.UpperMenuFindWindow.class);
        basecampSignUpFlow = PageFactory.initElements(driver, PageObjects.BasecampWeb.SignUpFlow.class);
        basecampNewProjectFlow = PageFactory.initElements(driver, PageObjects.BasecampWeb.NewProjectFlow.class);
        basecampRemoveAProjectFlow = PageFactory.initElements(driver, PageObjects.BasecampWeb.RemoveAProjectFlow.class);
        basecampAvatarMenu = PageFactory.initElements(driver, PageObjects.BasecampWeb.AvatarMenu.class);
        basecampEditProfilePage = PageFactory.initElements(driver, PageObjects.BasecampWeb.EditProfilePage.class);
    }

    public static void initMobile(){
        mobileBasecampLoginPage = PageFactory.initElements(driver, PageObjects.BasecampMobile.LoginPage.class);
        mobileBottomMenu = PageFactory.initElements(driver, PageObjects.BasecampMobile.BottomMenu.class);
        mobileMyStuffPage = PageFactory.initElements(driver, PageObjects.BasecampMobile.MyStuffPage.class);
    }

    public static void initElectron(){
        electronMainPage = PageFactory.initElements(driver, PageObjects.ElectronAPIDemos.MainPage.class);
    }

    public static void initDesktop(){
        calculatorMainPage = PageFactory.initElements(driver, PageObjects.Calculator.MainPage.class);
    }
}
