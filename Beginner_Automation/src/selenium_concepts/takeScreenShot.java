package selenium_concepts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class takeScreenShot {
    public static void main(String[] args) throws IOException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\WorkSpace\\ScreenShots\\screenshot.png"));
    }
}
