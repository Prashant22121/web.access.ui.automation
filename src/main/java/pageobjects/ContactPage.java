package pageobjects;

import commonfunctions.Base;
import commonfunctions.SampleTest;
import commonfunctions.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class ContactPage extends Base {

    private WebDriver driver;

    public ContactPage()
    {
        driver= Base.driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5),this);
    }

    @FindBy(id = "forename")
    private WebElement forenameTextbox;

    @FindBy(xpath = "//a[@aria-label='submit']")
    private WebElement submitButton;

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "message")
    private WebElement messageTextBox;

    @FindBy(id = "forename-err")
    private WebElement forenameError;

    @FindBy(id = "email-err")
    private WebElement emailError;

    @FindBy(id = "message-err")
    private WebElement messageError;

    public void verifyContactPageError()
    {
      String forenameErrorText= forenameError.getText();
      String emailErrorText= emailError.getText();
      String messageErrorText= messageError.getText();
      String expectedforenameError="Forename is required";
      String expectedEmailError="Email is required";
      String expectedMessageError="Message is required";

      Assert.assertEquals(forenameErrorText,expectedforenameError);
      Assert.assertEquals(emailErrorText,expectedEmailError);
      Assert.assertEquals(messageErrorText,expectedMessageError);
    }

    public void enterDetailsAndVerifyError()
    {
        forenameTextbox.sendKeys("Dan");
        Assert.assertTrue(Utility.elementNotExists(forenameError));

        emailTextBox.sendKeys("dan@abc.com");
        Assert.assertTrue(Utility.elementNotExists(emailError));

        messageTextBox.sendKeys("Nice Pizza");
        Assert.assertTrue(Utility.elementNotExists(messageError));
    }

    public void clickOnSubmit()
    {
        Utility.clickonButton(submitButton);
    }
}
