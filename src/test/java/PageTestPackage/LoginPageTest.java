package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {

    HomePage hp;
    LoginPage lp;
    LandingPage landP; //We have to Create the Landing Page before returning this kind of the Page in any other class

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        Initialization();
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        landP = new LandingPage(driver);
        hp.ClickLogin();
    }
    @AfterMethod
  //  @AfterTest  // Changed to AfterTest instead of @AfterMethod - worked for individual page tests are run
    public void Teardown() throws InterruptedException {
      //  Thread.sleep(4000);
        driver.close();
        logger.info("driver will be closed");
        System.out.println("Login Page Test got executed");
        logger.info("assertions");
        logger.info("Boolean");
    }
    @Test(priority = 20)
    public void TestLogin(){
        logger.info("checking username and password");
        lp.loginmethod(prop.getProperty("username"), prop.getProperty("password") );
        landP = lp.clickSubmit();   //We have to Create the Landing Page before returning this kind of the Page in any other class
        System.out.println("Entered Username, Password & Login button Clicked");
        logger.info("assertions");
        logger.info("Boolean");
    }
}
