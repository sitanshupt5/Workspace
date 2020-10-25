package selenium_concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class mouseActions {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.get("https://www.amazon.in/");
        WebElement accounts = driver.findElement(By.xpath("//span[contains(text(),'Hello')]/following-sibling::span/span[@class = 'nav-icon nav-arrow']"));
        Action mouseOver = action.moveToElement(accounts).build();
        mouseOver.perform();
    }
}
