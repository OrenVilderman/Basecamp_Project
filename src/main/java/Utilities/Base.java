package Utilities;      //A class meant for declaring objects being used commonly across the project, such as WebDriver, WebDriverWait, Actions, Screenshot,
                        // PageObjects, primitives and more

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imgDiff;
    public static ImageDiff diff;

    public static PageObjects.Basecamp.IntroPage basecampIntroPage;
    public static PageObjects.Basecamp.MainPage basecampMainPage;
    public static PageObjects.Basecamp.SignInPage basecampSignInPage;
    public static PageObjects.Basecamp.ProjectMainPage basecampProjectMainPage;
    public static PageObjects.Basecamp.UpperMenuBar basecampUpperMenu;
    public static PageObjects.Basecamp.EditProjectDetails basecampEditProjectDetailsPage;
    public static PageObjects.Basecamp.GetHelpIframe basecampGetHelpIframe;
    public static PageObjects.Basecamp.UpperMenuFindWindow basecampUpperMenuFindWindowPage;
    public static PageObjects.Basecamp.SignUpFlow basecampSignUpFlow;
    public static PageObjects.Basecamp.NewProjectFlow basecampNewProjectFlow;
    public static PageObjects.Basecamp.RemoveAProjectFlow basecampRemoveAProjectFlow;
    public static PageObjects.Basecamp.AvatarMenu basecampAvatarMenu;
    public static PageObjects.Basecamp.EditProfilePage basecampEditProfilePage;


}
