package Module1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Properties;

public class Test1 {


    Logger logger;

    @BeforeMethod
    public void initializeLogFile(Method method)
    {
        /*Test test = method.getAnnotation(Test.class);
        if(test == null)
        {
            return;
        }
        Properties log_config_file = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\log4j2.properties");
            log_config_file.load(fis);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        String locator = MessageFormat.format(log_config_file.getProperty("appender.file.fileName"), "D:\\WorkSpace\\logs\\"+test.testName());
        Path path = Paths.get("D:\\WorkSpace\\logs\\"+test.testName()+".log");
        if(!Files.exists(path))
        {
            try
            {
                Files.createFile(path);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                Files.delete(path);
                Files.createFile(path);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }*/
        logger = LogManager.getLogger(this.getClass().getName());

    }


    @Test(testName = "OpenBrowser")
    public void OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        logger.trace("site opened");
        driver.manage().window().maximize();
        logger.trace("browser maximized");
        logger.trace("Page title is"+driver.getTitle());
    }
}
