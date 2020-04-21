package Utilities;      //A class meant for declaring objects being used commonly across the project, such as WebDriver, WebDriverWait, Actions, Screenshot,
// PageObjects, primitives and more

import io.appium.java_client.android.AndroidDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Base {

    public static WebDriver driver = null;
    public static AndroidDriver androidDriver = null;
    public static RemoteWebDriver remoteWebDriver = null;
    public static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imgDiff;
    public static ImageDiff diff;

    //Parameters Variables
    public static String platform;
    public static String webSite;
    public static String browser;

    //Web
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

    public static int _numberOfProjectsBeforeAddingOrRemoving;
    public static String _projectName;
    public static String avatarCurrentImageFilePath;

    //Data info that is fed to the DB while signing up a new user - Basecamp sanity - signup test
    public static String _userName;
    public static String _userEmail;
    public static String _password;
    public static String _companyName;

    public static String imageFilePath;
    public static SimpleDateFormat dateFormat;
    public static List<Team> teamNameList = new ArrayList<Team>();

    //Mobile
    public static DesiredCapabilities dc;
    public static String reportDirectory = "reports";
    public static String reportFormat = "xml";
    public static String testName = "Mobile App Test";

    public static PageObjects.BasecampMobile.LoginPage mobileBasecampLoginPage;
    public static PageObjects.BasecampMobile.BottomMenu mobileBottomMenu;
    public static PageObjects.BasecampMobile.MyStuffPage mobileMyStuffPage;

    //API
    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;
    public static String teamName;
    public static String teamEmail;
    public static String teamIdForDelete;
    public static int teamIndexForUiVerification;

    //Electron
    public static PageObjects.ElectronAPIDemos.MainPage electronMainPage;

    //Desktop
    public static PageObjects.Calculator.MainPage calculatorMainPage;

    //DB Connection
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static PageObjects.GrafanaForDB.LoginFlow grafanaForDbLoginPage;
    public static PageObjects.GrafanaForDB.MainPage grafanaForDbMainPage;
}
