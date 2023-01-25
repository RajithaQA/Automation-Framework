package BasePackage;

import UtilityPackage.Utilis;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {    //Parent Class
    public static WebDriver driver;
    public static Properties prop;
    public static Logger logger;     //Code Used for Log4j - to log

    public BaseClass() {        //Constructor
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\Raji\\IdeaProjects\\SelAutomationProj2\\src\\main\\java\\ConfigPackage\\Config.Properties");
            prop.load(fis); //Statement is important to load the URL specified in the config.Properties
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        /* One of these exceptions ( the above way or the below way) can be used but most optimal to catch 2 exceptions specifically - as below
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
    public void Initialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        System.out.println("URL: " + prop.getProperty("url"));

        //Code for Log4j use

        logger = Logger.getLogger("Automation Framework For SelAutomationProj2 Project Log");   //For Logging with Log4j
        PropertyConfigurator.configure("C:\\Users\\Raji\\IdeaProjects\\SelAutomationProj2\\src\\main\\resources\\Log4j.Properties");
        //Until above code for Log4j use

        driver.manage().timeouts().pageLoadTimeout(Utilis.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Utilis.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
}
