package selenium_concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class calendarUI {
    public static  void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver. get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement from_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for = 'departure']")));
        from_date.click();

        int loop_size = driver.findElements(By.xpath("//div[contains(@class ,'DayPicker-Day--today')]/parent::*/child::*")).size();
        int current_date = Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class ,'DayPicker-Day--today')]/descendant::p[not(@class)]")).getText());
        String month_year = driver.findElement(By.xpath("//div[contains(@class ,'DayPicker-Day--today')]/ancestor::div[@class = 'DayPicker-Month']/child::*/div\n")).getText();
        String arr [];
        arr = month_year.split(" ");
        String current_month = arr[0];
        int current_year = Integer.parseInt(arr[1]);
        System.out.println("current date: "+current_date+"\ncurrent month: "+current_month+"\ncurrent_year: "+current_year);
        List<WebElement> day = driver.findElements(By.xpath("//div[contains(@class ,'DayPicker-Day--today')]/parent::*/following-sibling::div[1]/child::*"));
        day.get(3).click();



    }
}
