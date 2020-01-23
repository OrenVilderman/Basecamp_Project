package Utilities;      //A class that will define an object for each page/section class of the app and initialize the
                        // objects we define in each and every one. Inherits from Base class

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base{

    public static void init(){
        basecampIntroPage = PageFactory.initElements(driver, PageObjects.Basecamp.IntroPage.class);
        basecampMainPage = PageFactory.initElements(driver, PageObjects.Basecamp.MainPage.class);
        basecampSignInPage = PageFactory.initElements(driver, PageObjects.Basecamp.SignInPage.class);
        basecampProjectMainPage = PageFactory.initElements(driver, PageObjects.Basecamp.ProjectMainPage.class);
        basecampUpperMenu = PageFactory.initElements(driver, PageObjects.Basecamp.UpperMenuBar.class);
        basecampEditProjectDetailsPage = PageFactory.initElements(driver, PageObjects.Basecamp.EditProjectDetails.class);
        basecampGetHelpIframe = PageFactory.initElements(driver, PageObjects.Basecamp.GetHelpIframe.class);
        basecampUpperMenuFindWindowPage = PageFactory.initElements(driver, PageObjects.Basecamp.UpperMenuFindWindow.class);
        basecampSignUpFlow = PageFactory.initElements(driver, PageObjects.Basecamp.SignUpFlow.class);
        basecampNewProjectFlow = PageFactory.initElements(driver, PageObjects.Basecamp.NewProjectFlow.class);

    }



}
