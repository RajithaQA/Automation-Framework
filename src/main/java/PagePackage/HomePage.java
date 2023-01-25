package PagePackage;

import BasePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//img[@id = 'logo']")
    WebElement wbllogo;     //declaring the elements

    @FindBy(xpath = "//button[@id=\"headerfblogin\"]")
    WebElement freestudent;

    @FindBy(id="loginButton") //Can also use - @FindBy(xpath = "//a[@id="loginButton"]");
    WebElement loginbtn;

    public HomePage(WebDriver driver){      //Constructor
     this.driver = driver;
        PageFactory.initElements(driver, this); //Indicating both drivers & their functionality is the same

    }

    public boolean CheckWblLogo(){
        return wbllogo.isDisplayed();
    }

    public boolean CheckFreeStudent(){
        return freestudent.isDisplayed();
    }

    public LoginPage ClickLogin(){      //Returns a page = LoginPage
        loginbtn.click();
        return new LoginPage(driver);
    }

}
