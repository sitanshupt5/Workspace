package jericho;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

public class Execute2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://demo.guru99.com/popup.php");
        driver.manage().window().maximize();
        String parent = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        Thread.sleep(3000);
        for(String page:windows)
        {
            if(!parent.equals(page))
            {
                driver.switchTo().window(page);
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("sitanshupt5@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Thread.sleep(3000);

    }
}
