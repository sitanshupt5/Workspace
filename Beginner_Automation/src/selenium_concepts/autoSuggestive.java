package selenium_concepts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//Program to illustrate the use JavaScriptExecutor
//JavaScript DOM(Document Object Model) is used to identify hidden elements which are not supported by Selenium
//In simple words it is used to investigate the objects with hidden text
//JavascriptExecutor package is provided by Selenium to use JavaScript DOM
public class autoSuggestive {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://ksrtc.in/oprs-web/");
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




    }
}
