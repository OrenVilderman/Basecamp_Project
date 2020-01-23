package Utilities;      //A class to provide with all the routine operations and methods being used with every test run, such as browser initializing method,
                        // before/after class/method, getData method to extract data from external files and more. Inherits from Base class

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.w3c.dom.Document;
import org.testng.annotations.BeforeClass;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{
    JavascriptExecutor js = (JavascriptExecutor)driver;

    public static String getDataFromXML(String nodeName){
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
        }

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



    @BeforeClass
    public void startSession(){
        if (getDataFromXML("PlatformName").equalsIgnoreCase("web")){
            initBrowser(getDataFromXML("BrowserName"));
        }/*else if (getDataFromXML("PlatformName").equalsIgnoreCase("mobile"){
            initBrowser();*/
        else {throw new RuntimeException("Given Platform Is Invalid.");}
        ManagePages.init();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        basecampUpperMenu.home_btn.click();
        Thread.sleep(2500);
    }

    @AfterClass
    public void closeSession() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



}
