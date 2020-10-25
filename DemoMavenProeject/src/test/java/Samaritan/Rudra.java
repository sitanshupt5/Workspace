package Samaritan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Rudra {

    @Test
    public void openGoogle()
    {
        System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.co.in");
        driver.manage().window().maximize();
        System.out.println( driver.getTitle());

    }

}
