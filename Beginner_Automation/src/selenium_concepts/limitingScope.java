package selenium_concepts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class limitingScope {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qaclickacademy.com");
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





        }
}
