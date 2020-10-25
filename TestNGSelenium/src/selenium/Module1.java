package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Module1 extends Utilities{

    @Test
    public void Opengoogle() throws IOException
    {
        WebDriver driver = OpenBrowser();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.close();
    }

    @Test
    public void autoSuggestive() throws IOException
    {
        WebDriver driver = OpenBrowser();
        driver.get("https://ksrtc.in/oprs-web/");
        driver.manage().window().maximize();
        WebElement from_place = driver.findElement(By.xpath("//input[@id= 'fromPlaceName']"));
        from_place.sendKeys("BENG");
        from_place.sendKeys(Keys.DOWN);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String text = (String) js.executeScript(script);

        while(!text.contains("AIRPORT"))
        {
            from_place.sendKeys(Keys.DOWN);
            text  = (String) js.executeScript(script);
        }

        from_place.sendKeys(Keys.ENTER);
        driver.close();
    }


    @Test
    public void limitingScope() throws IOException
    {
        WebDriver driver = OpenBrowser();
        driver.get("http://www.qaclickacademy.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement exit_modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'NO THANKS']")));
        exit_modal.click();
        driver.manage().window().maximize();
        WebElement prefooter = driver.findElement(By.xpath("//div[@id = 'prefooter']/descendant::div[@class = 'col-sm-3']"));
        System.out.println("Number of columns in footer is- "+(driver.findElements(By.xpath("//div[@id = 'prefooter']/descendant::div[@class = 'col-sm-3']")).size()));
        WebElement firstcolumn = driver.findElement(By.xpath("//h3[text() = 'Quick Links']/following-sibling::nav/descendant::*"));
        System.out.println("Number of links in first column is- "+ (firstcolumn.findElements(By.tagName("a")).size()));
        int link_count  = firstcolumn.findElements(By.tagName("a")).size();
        for(int i = 0; i<link_count; i++)
        {
            String openlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstcolumn.findElements(By.tagName("a")).get(i).sendKeys(openlinktab);

        }

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        for (int i = 0; it.hasNext(); i++)
        {
            String id = it.next();
            driver.switchTo().window(id);
            System.out.println("Title of " + i + "window is : "+ driver.getTitle());
        }
        driver.close();
    }

    @Test
    public void mouseActions() throws IOException
    {
        WebDriver driver = OpenBrowser();
        Actions action = new Actions(driver);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebElement accounts = driver.findElement(By.xpath("//span[contains(text(),'Hello')]/following-sibling::span/span[@class = 'nav-icon nav-arrow']"));
        Action mouseOver = action.moveToElement(accounts).build();
        mouseOver.perform();
        driver.close();
    }

    @Test
    public void takeScreenshot() throws IOException
    {
        WebDriver driver = OpenBrowser();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\WorkSpace\\ScreenShots\\screenshot.png"));
        driver.close();
    }

}
