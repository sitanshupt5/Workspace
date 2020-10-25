package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

     public WebDriver driver;

    public void OpenWebsite(String url) throws IOException
    {

        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("D:\\WorkSpace\\TestNGSelenium\\src\\globalparameters.properties");
        properties.load(file);

        if(properties.getProperty("browser").equals("chrome"))
         {
        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
        driver = new ChromeDriver();

        }
        else if(properties.getProperty("browser").equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "D:\\WorkSpace\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get(url);
    }

    public WebDriver OpenBrowser() throws IOException
    {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("D:\\WorkSpace\\TestNGSelenium\\src\\globalparameters.properties");
        properties.load(file);

        if(properties.getProperty("browser").equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        else if(properties.getProperty("browser").equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "D:\\WorkSpace\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        return driver;

    }
}
