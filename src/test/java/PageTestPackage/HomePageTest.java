package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseClass {
    HomePage hp;    //Reference variable - object declaration
    LoginPage lp;

    public HomePageTest(){
        super();        // Will use the methods both from this class & it's Parent's Class
    }
    @BeforeMethod         // USed @BeforeTest instead of @BeforeMethod so the following will happen only once for this test
    public void setup(){
     //     logger.info("initialization of WebDriver");
        Initialization();       //Initialization of driver & get URL
        hp = new HomePage(driver);
    }
    @AfterMethod          // USed @AfterTest instead of @AfterMethod so all the Tests run once & finally the driver will close once at the end of this test (testing this page)
    public void Teardown()  {
        //Thread.sleep(5000);
logger.info("the window will be closed");
        driver.close();
        System.out.println("Home Page Tests got executed");
    }
    @Test()
    public void Testlogo(){
       boolean logo = hp.CheckWblLogo();
       logger.info("assertions");
        Assert.assertTrue(logo);
        System.out.println("Logo is Present");
    }
    @Test(priority = 1)
    public void TestFreeStudent(){
        logger.info("assertions");
        logger.info("Boolean");
        boolean student = hp.CheckFreeStudent();
        Assert.assertTrue(student);
        System.out.println("Free Student Access link is Present");
    }

    @Test(priority = 2)
    public void verifylogin(){
        hp.ClickLogin();
        System.out.println("Login Clicked");
    }
}
