package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseUtils {

    public WebDriver driver;
    public Properties properties;
    public ExcelUtils excel;

    public void initializeDriver() throws IOException
    {
        properties = new Properties();
        FileInputStream project_config_file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\properties\\project_config.properties");
        properties.load(project_config_file);
        if(properties.getProperty("browser").equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+properties.getProperty("chromedriver_path"));
            driver = new ChromeDriver();
        }
        else if(properties.getProperty("browser").equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+properties.getProperty("geckodriver_path"));
            driver = new FirefoxDriver();
        }
        else if(properties.getProperty("browser").equals("edge"))
        {
            System.setProperty("webdriver.edge. driver", System.getProperty("user.dir")+properties.getProperty("edgedriver_path"));
            driver = new EdgeDriver();
        }
    }

    public void startTestCase(String datafilename)
    {
        excel = new ExcelUtils();
        excel.setFilePath(System.getProperty("user.dir")+"\\data\\"+datafilename+".xlsx");
    }

    public void closeBrowser()
    {
        driver.close();
        driver.quit();
    }


}
