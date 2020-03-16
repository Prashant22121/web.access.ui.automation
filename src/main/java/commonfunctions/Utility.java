package commonfunctions;

import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Utility {

    public static String readPropertyFile(String fileName,String key) throws Exception {
        FileInputStream fileInput=null;
        Properties prop=null;

        fileInput=new FileInputStream(fileName);
        prop=new Properties();
        prop.load(fileInput);
        if(fileInput!=null)
        {
            fileInput.close();
        }
        if(prop==null)
        {
            throw new Exception("Properties file is empty");
        }
        return prop.getProperty(key);

    }


    public static void inputToTextField(WebElement element, String keysToSend)
    {
        element.sendKeys(keysToSend);
    }

    public static void clickonButton(WebElement element)
    {
        element.click();
    }

    public static boolean elementNotExists(WebElement element)
    {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return true;
        }
    }

}
