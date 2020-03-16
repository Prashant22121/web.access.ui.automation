package commonfunctions;

import commonfunctions.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.ContactPage;

import java.util.concurrent.TimeUnit;

public class SampleTest {

    public static WebDriver driver;
    private static String basePath=System.getProperty("user.dir");
    private static String pathOfEnvironmentFile=basePath+"/src/test/resources/testconfig/Environment.properties";
    private static String chromedriverpath=basePath+"/src/test/resources/chromedriver/chromedriver.exe";
    public ContactPage contactPage;
    String urltoLaunch= Utility.readPropertyFile(pathOfEnvironmentFile,"URL");

    public SampleTest() throws Exception {

        this.driver=driver;

    }

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",chromedriverpath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(urltoLaunch);
    }

    @Test
    public void testContactUsPage() throws Exception {

        driver.findElement(By.xpath("//html/body/div/div/div[6]/nav/div/div[2]/a[4]/div")).click();
        contactPage=new ContactPage();
        //contactPage.navigateToContactPage();
        contactPage.clickOnSubmit();
        contactPage.verifyContactPageError();
        contactPage.enterDetailsAndVerifyError();
    }

    @AfterTest
    public void quitDriver()
    {
        driver.quit();
    }
}
