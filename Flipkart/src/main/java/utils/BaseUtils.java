package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.*;

public class BaseUtils {
    public WebDriver driver;
    public Properties properties;

    @BeforeMethod
    public void initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream project_config_file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\project_config.properties");
        properties.load(project_config_file);
        if (properties.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+properties.getProperty("chromedriver_path"));
            driver = new ChromeDriver();
        }
        else if (properties.getProperty("browser").equals("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+properties.getProperty("firefoxdriver_path"));
            driver = new ChromeDriver();
        }
        else if (properties.getProperty("browser").equals("edge")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+properties.getProperty("edgedriver_path"));
            driver = new ChromeDriver();
        }

        driver.get(properties.getProperty("website"));
        driver.manage().window().maximize();
    }

}
