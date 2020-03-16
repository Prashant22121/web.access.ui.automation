package pageobjects;

import commonfunctions.Base;
import commonfunctions.SampleTest;
import commonfunctions.Utility;
import gherkin.deps.com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends Base {

    private WebDriver driver;

    public HomePage()
    {
        driver= Base.driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5),this);
    }

    @FindBy(xpath = "//div/div[2]/a[4]/div")
    private WebElement contactUsLink;

    public ContactPage clickOnContactLink()
    {
        Utility.clickonButton(contactUsLink);
        return new ContactPage();
    }

}
