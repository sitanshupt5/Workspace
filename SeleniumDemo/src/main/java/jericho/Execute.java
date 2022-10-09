package jericho;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class Execute {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//java//resources//chromedriver.exe");
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/popup.php");
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        for (String windowHandle:driver.getWindowHandles())
        {
            if(!parent.equals((windowHandle)))
            {
                System.out.println(windowHandle);
                driver.switchTo().window(windowHandle);
            }
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("sitanshupt5@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        Thread.sleep(5000);
    }
}
