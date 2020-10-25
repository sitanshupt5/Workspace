package Automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class seleniumConcepts {

    @Test(timeOut = 40000)
    public void openGoogle()
    {
        System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test(timeOut = 40000)
    public void mouseHover()
    {
        System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        Actions action = new Actions(driver);
        WebElement accounts = driver.findElement(By.xpath("//span[contains(text(),'Hello')]/following-sibling::span/span[@class = 'nav-icon nav-arrow']"));
        Action mouseOver = action.moveToElement(accounts).build();
        mouseOver.perform();
        System.out.println(driver.getTitle());
        driver.close();

    }

    @Test(timeOut = 40000)
    public void takeScreenShot() throws IOException
    {
        System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\WorkSpace\\ScreenShots\\screenshot1.png"));
        System.out.println(driver.getTitle());
        driver.close();

    }


}
