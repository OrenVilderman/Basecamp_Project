package Utilities;      //A class to provide with all the routine operations and methods being used with every test run, such as browser initializing method,
                        // before/after class/method, getData method to extract data from external files and more. Inherits from Base class

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static Utilities.HelperMethods.getDataFromXML;

public class CommonOps extends Base{
    JavascriptExecutor js = (JavascriptExecutor)driver;




    public static void initBrowser(String browserType){
        if(browserType.equalsIgnoreCase("chrome")){
            driver = initChromeDriver();
        }
        else if(browserType.equalsIgnoreCase("ie")){
            driver = initIEDriver();
        }
        else if(browserType.equalsIgnoreCase("firefox")){
            driver = initFirefoxDriver();
        }
        else if(browserType.equalsIgnoreCase("edge")){
            driver = initEdgeDriver();
        }
        else if(browserType.equalsIgnoreCase("opera")){
            driver = initOperaDriver();
        }else {
            throw new RuntimeException("Invalid Browser Name Selected.");
        }
        driver.manage().window().maximize();
        driver.get(getDataFromXML("URL"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXML("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getDataFromXML("TimeOut")));
        action = new Actions(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public static WebDriver initOperaDriver(){
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        return driver;
    }

    public static void initMobile(){
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("Mobile App Test", testName);
        dc.setCapability(MobileCapabilityType.UDID, getDataFromXML("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getDataFromXML("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getDataFromXML("APP_ACTIVITY"));
        try{
        driver = new AndroidDriver(new URL("http://localhost:4724/wd/hub"), dc);
        } catch (Exception e){
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }

    }

    @BeforeClass
    public void startSession(){
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web")){
            initBrowser(getDataFromXML("BrowserName"));
            ManagePages.initWeb();
        }else if (getDataFromXML("PlatformName").equalsIgnoreCase("mobile")) {
            initMobile();
            ManagePages.initMobile();
        }else
            throw new RuntimeException("Given Platform Is Invalid.");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        if (!getDataFromXML("PlatformName").equalsIgnoreCase("mobile")){
        basecampUpperMenu.home_btn.click();
        Thread.sleep(2500);}
        else AndroidDriver.resetApp();
    }

    @AfterClass
    public void closeSession() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



}
