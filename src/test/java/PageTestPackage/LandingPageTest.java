package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LandingPageTest extends BaseClass {
    HomePage hp;
    LoginPage lp;
    LandingPage landp;
    public LandingPageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        Initialization();
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        landp = new LandingPage(driver);
        hp.ClickLogin();
        lp.loginmethod(prop.getProperty("username"), prop.getProperty("password") );
        landp = lp.clickSubmit();
    }
    @AfterMethod
    public void Teardown() throws InterruptedException {
        Thread.sleep(7000);
        driver.quit();
        System.out.println("Landing Page Tests got executed");
    }
    @Test(priority = 30)
    public void Testwbl(){
        boolean wb = landp.checkWBL();
        Assert.assertTrue(wb);
        System.out.println("Landing Page - WBL existed");
    }
    @Test(priority = 31)
    public void TestMailid(){
        boolean mail = landp.checkMailid();
        Assert.assertTrue(mail);
        System.out.println("Landing Page - MailId exists");
    }
}
