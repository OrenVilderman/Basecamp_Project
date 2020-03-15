package Utilities;      //A class to provide with all the routine operations and methods being used with every test run, such as browser initializing method,
// before/after class/method, getData method to extract data from external files and more. Inherits from Base class

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Utilities.HelperMethods.getDataFromXML;

public class CommonOps extends Base {

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            driver = initIEDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = initEdgeDriver();
        } else if (browserType.equalsIgnoreCase("opera")) {
            driver = initOperaDriver();
        } else {
            throw new RuntimeException("Invalid Browser Name Selected.");
        }
        driver.manage().window().maximize();
        driver.get(getDataFromXML("URL"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXML("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getDataFromXML("TimeOut")));
        action = new Actions(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
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
        } else System.out.println("Driver type is not recognized.");
    }   // More work needed on driver selector

    public static void awakeGrafanaServer() throws IOException {
        Runtime.getRuntime().exec(getDataFromXML("grafanaServerExe"), null, new File(getDataFromXML("grafanaServerDir")));
        RestAssured.baseURI = getDataFromXML("APIurl");
        httpRequest = RestAssured.given().auth().preemptive().
                basic(getDataFromXML("grafanaUserName"),
                        getDataFromXML("grafanaPassword"));
    }

    public AndroidDriver getDriver() {  // More work needed on driver selector for android driver
        return androidDriver;
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

    @BeforeClass
    public void startSession() throws IOException {
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web")) {
            initBrowser(getDataFromXML("BrowserName"));
            ManagePages.initWeb();
        } else if (getDataFromXML("PlatformName").equalsIgnoreCase("mobile")) {
            initMobile();
            ManagePages.initMobile();
        } else if (getDataFromXML("PlatformName").equalsIgnoreCase("api")) {
            awakeGrafanaServer();
        } else if (getDataFromXML("PlatformName").equalsIgnoreCase("electron")) {
            initElectron();
            ManagePages.initElectron();
        } else
            throw new RuntimeException("Given Platform Is Invalid.");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        if (getDataFromXML("PlatformName").equalsIgnoreCase("api")||getDataFromXML("PlatformName").equalsIgnoreCase("electron")) {
        } else if (!getDataFromXML("PlatformName").equalsIgnoreCase("mobile")) {
            basecampUpperMenu.home_btn.click();
            Thread.sleep(2500);
        } else {
            driverSelector("AndroidDriver");
            androidDriver.resetApp();
        }// More work needed on driver selector
    }

    @AfterClass
    public void closeSession() throws InterruptedException {
        if (getDataFromXML("PlatformName").equalsIgnoreCase("api")) {
        } else if (!getDataFromXML("PlatformName").equalsIgnoreCase("mobile")) {
            Thread.sleep(2000);
            driver.quit();
        } else {
            driverSelector("AndroidDriver");
            androidDriver.quit();
        }

    }


}
