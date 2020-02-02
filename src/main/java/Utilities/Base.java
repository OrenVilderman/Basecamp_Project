package Utilities;      //A class meant for declaring objects being used commonly across the project, such as WebDriver, WebDriverWait, Actions, Screenshot,
                        // PageObjects, primitives and more

import PageObjects.BasecampMobile.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Base {

    public static WebDriver driver;
    public static AndroidDriver AndroidDriver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imgDiff;
    public static ImageDiff diff;

    public static PageObjects.BasecampWeb.IntroPage basecampIntroPage;
    public static PageObjects.BasecampWeb.MainPage basecampMainPage;
    public static PageObjects.BasecampWeb.SignInPage basecampSignInPage;
    public static PageObjects.BasecampWeb.ProjectMainPage basecampProjectMainPage;
    public static PageObjects.BasecampWeb.UpperMenuBar basecampUpperMenu;
    public static PageObjects.BasecampWeb.EditProjectDetails basecampEditProjectDetailsPage;
    public static PageObjects.BasecampWeb.GetHelpIframe basecampGetHelpIframe;
    public static PageObjects.BasecampWeb.UpperMenuFindWindow basecampUpperMenuFindWindowPage;
    public static PageObjects.BasecampWeb.SignUpFlow basecampSignUpFlow;
    public static PageObjects.BasecampWeb.NewProjectFlow basecampNewProjectFlow;
    public static PageObjects.BasecampWeb.RemoveAProjectFlow basecampRemoveAProjectFlow;
    public static PageObjects.BasecampWeb.AvatarMenu basecampAvatarMenu;
    public static PageObjects.BasecampWeb.EditProfilePage basecampEditProfilePage;

    //Mobile
    public static DesiredCapabilities dc;
    public static String reportDirectory = "reports";
    public static String reportFormat = "xml";
    public static String testName = "Mobile App Test";

    public static PageObjects.BasecampMobile.LoginPage basecampLoginPage;

}
