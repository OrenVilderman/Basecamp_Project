package Utilities;      //A class to provide with all the routine operations and methods being used with every test run, such as browser initializing method,
// before/after class/method, getData method to extract data from external files and more. Inherits from Base class

import WorkFlows.WebFlows;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Utilities.HelperMethods.getDataFromXML;

public class CommonOps extends Base {

    public static void initBrowser() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = initIEDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = initEdgeDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            driver = initOperaDriver();
        } else {
            throw new RuntimeException("Invalid Browser Name Selected.");
        }
        driver.manage().window().maximize();
        if (webSite.equalsIgnoreCase("grafana")) {
            try {
                awakeGrafanaServer();
                ManagePages.initGrafanaForDB();
                driver.get(getDataFromXML("ApiUrl"));
            } catch (Exception e) {
                System.out.println("Could not initiate Grafana server");
            }
        } else {
            driver.get(getDataFromXML("URL"));
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXML("TimeOut")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getDataFromXML("TimeOut")));
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public static WebDriver initOperaDriver() {
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        return driver;
    }

    public static void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("Mobile App Test", testName);
        dc.setCapability(MobileCapabilityType.UDID, getDataFromXML("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getDataFromXML("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getDataFromXML("APP_ACTIVITY"));
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
        driverSelector("AndroidDriver");
    }

    public static void awakeGrafanaServer() throws IOException {
        Runtime.getRuntime().exec(getDataFromXML("grafanaServerExe"), null, new File(getDataFromXML("grafanaServerDir")));
        RestAssured.baseURI = getDataFromXML("APIurl");
        httpRequest = RestAssured.given().auth().preemptive().
                basic(getDataFromXML("grafanaUserName"),
                        getDataFromXML("grafanaPassword"));
    }

    public static void initElectron() {
        dc = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", getDataFromXML("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getDataFromXML("EletronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXML("TimeOut")), TimeUnit.SECONDS);
    }

    public static void initDesktop() throws IOException {
        String command = getDataFromXML("WinAppDriverExe");
        ProcessBuilder builder = new ProcessBuilder(command).inheritIO();
        Process p = builder.start();
        dc = new DesiredCapabilities();
        dc.setCapability("app", getDataFromXML("appID"));
        try {
            driver = new WindowsDriver(new URL(getDataFromXML("WindowsDriverURL")), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXML("TimeOut")), TimeUnit.SECONDS);
    }

    public static void driverSelector(String driverType) {
        if (driverType.equalsIgnoreCase("RemoteWebDriver"))
            try {
                remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4724/wd/hub"), dc);
            } catch (Exception e) {
                System.out.println("Can not Connect to Appium Server, See Details: " + e);
            }
        else if (driverType.equalsIgnoreCase("AndroidDriver")) {
            try {
                androidDriver = new AndroidDriver(new URL("http://localhost:4724/wd/hub"), dc);
            } catch (Exception e) {
                System.out.println("Can not Connect to Appium Server, See Details: " + e);
            }
        } else if ((driverType.equalsIgnoreCase("WebDriver"))) {
            initBrowser();
        } else System.out.println("Driver type is not recognized.");
    }   // More work needed on driver selector

    public AndroidDriver getDriver() {  // More work needed on driver selector for android driver
        return androidDriver;
    }

    @BeforeClass
    @Parameters({"platformName", "siteTested", "browserName"})
    public void startSession(String platformName, String siteTested, String browserName) throws IOException {
        platform = platformName;
        webSite = siteTested;
        browser = browserName;
        if (platform.equalsIgnoreCase("web")) {
            initBrowser();
            ManagePages.initWeb();
        } else if (platform.equalsIgnoreCase("mobile")) {
            initMobile();
            ManagePages.initMobile();
        } else if (platform.equalsIgnoreCase("api")) {
            awakeGrafanaServer();
        } else if (platform.equalsIgnoreCase("electron")) {
            initElectron();
            ManagePages.initElectron();
        } else if (platform.equalsIgnoreCase("desktop")) {
            initDesktop();
            ManagePages.initDesktop();
        } else
            throw new RuntimeException("Given Platform Is Invalid.");
        ManageDB.initConnection(getDataFromXML("DBURL"), getDataFromXML("DBuser"), getDataFromXML("DBpassword"));
    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web") &&
                webSite.equalsIgnoreCase("basecamp")) {
            if (basecampUpperMenu.listOfUpperMenuItems.size() == 6) {
                WebFlows.signOut();
            }
        }
    }

    @AfterClass
    public void closeSession(String PlatformName, String SiteTested) throws InterruptedException {
        ManageDB.closeConnection();
        if (platform.equalsIgnoreCase("api")) {
        } else if (!platform.equalsIgnoreCase("mobile")) {
            Thread.sleep(2000);
            driver.quit();
        } else {
        }
    }


}
