package commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    protected static WebDriver driver;
    private static String basePath=System.getProperty("user.dir");
    private static String pathOfEnvironmentFile=basePath+"/src/test/resources/testconfig/Environment.properties";
    private static String chromedriverpath=basePath+"/src/test/resources/chromedriver/chromedriver.exe";

    public static WebDriver initialize() throws Exception {
        String browserName=Utility.readPropertyFile(pathOfEnvironmentFile,"BROWSER");
        if(browserName.toLowerCase().equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",chromedriverpath);
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
            return driver;
    }

    public static void launchUrl() throws Exception {
        String urltoLaunch=Utility.readPropertyFile(pathOfEnvironmentFile,"URL");
        driver.get(urltoLaunch);
    }
}
