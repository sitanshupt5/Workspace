package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseUitlities {

    public static WebDriver driver;
    public static Properties properties;

    public static WebDriver initializeDriver()
    {
        setProperties();
        String browserName = properties.getProperty("browser");
        String mode = "head";
        System.out.println(browserName);
        System.out.println(properties.getProperty("chrome_driver_path"));
        if(browserName.equals("chrome"));
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+properties.getProperty("chrome_driver_path"));
            ChromeOptions options = new ChromeOptions();
            if(mode.equalsIgnoreCase("headless"))
            {
                options.addArguments("--headless");
            }

            driver = new ChromeDriver(options);

        }
        if(browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+properties.getProperty("firefox_driver_path"));
            FirefoxOptions options = new FirefoxOptions();
            if(mode.equalsIgnoreCase("headless"))
            {
                options.addArguments("--headless");
            }

            driver = new FirefoxDriver(options);

        }

        else
        {
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+properties.getProperty("edge_driver_path"));
            driver = new EdgeDriver();

        }

        return driver;

    }

    public static void setProperties()
    {
        try
        {
            properties = new Properties();
            FileInputStream project_config_file = new FileInputStream(System.getProperty("user.dir")+"\\src\\project_config.properties");
            properties.load(project_config_file);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}

