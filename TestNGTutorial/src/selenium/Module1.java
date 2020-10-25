package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Module1{

    @Test
    public void OpenGoogle()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}
