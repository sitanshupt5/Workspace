package selenium_concepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class certifications {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.);

        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.close();

    }
}
