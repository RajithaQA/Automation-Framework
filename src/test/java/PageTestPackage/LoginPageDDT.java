package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import UtilityPackage.ReadXL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageDDT extends BaseClass {
    HomePage hp;
    LoginPage lp;
    LandingPage landP;

    public LoginPageDDT(){
        super();
    }

    @BeforeMethod
    public void setup(){
        Initialization();
        logger.info("intialization of webdriver");
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        landP = new LandingPage(driver);
        hp.ClickLogin();
    }
    @AfterMethod
    public void Teardown() throws InterruptedException {
        //  Thread.sleep(4000);
        driver.close();
        logger.info("assertions");
        logger.info("Boolean");
        System.out.println("Login Page Test got executed");
    }
    @Test(dataProvider = "logindata")
    public void loginddt(String user, String pwd) throws InterruptedException {
       /*     lp.setusername(user);
            logger.info("sending user name from excel");
            lp.setpassword(pwd);
            logger.info("sending password from excel");
            lp.clickSubmit();
*/
            lp.loginmethod(user, pwd);
            landP=new LandingPage(driver);
/* --
            Thread.sleep(3000);
            try {
                if(landpage.checktable()) {
                    System.out.println("successful login");
                    logger.info("check to see if login is successful");
                }
            }
            catch(Exception e) {
                System.out.println("login failed");
                logger.info("check to see if login is unsuccessful");
                try {
                    hp.captureScreen(driver,"whiteboxtest");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Assert.assertFalse(true);
            } */
        }

        @DataProvider(name="logindata")
            String [][]getdata() throws IOException {
            String path="C:\\Users\\Raji\\IdeaProjects\\SelAutomationProj2\\src\\test\\resources\\testdata.xlsx";
            int rownum= ReadXL.getRowCount(path, "Sheet1"); //Make sure the data file is in Sheet1 of the Excel
            int colcount=ReadXL.getCellCount(path, "Sheet1", 1);
            String logindata[][]=new String[rownum][colcount];
            //0 is for header..column is 0
            for(int i=1;i<=rownum;i++) {
                for(int j=0;j<colcount;j++ ) {
                    logindata[i-1][j]=ReadXL.getCellData(path, "Sheet1", i, j);//1  0
                }
            }
            return logindata;
        }

    }
