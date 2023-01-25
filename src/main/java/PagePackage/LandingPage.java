package PagePackage;

import BasePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseClass {    //Create this Landing Page before returning this kind of the Page in any other class
    @FindBy(id = "wblhead")
    WebElement wbl;
    @FindBy(xpath = "//a[@href='mailto:info@whitebox-learning.com']") WebElement mailid;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkWBL(){
        return wbl.isDisplayed();
    }

    public boolean checkMailid(){
        return mailid.isDisplayed();

    }
}
