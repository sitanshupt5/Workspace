package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginErrorStepDefinitions {

    WebDriver driver;

    @Given("^login page is open$")
    public void login_page_is_open() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.freecrm.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement loginlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Log In']/parent::a")));
        loginlink.click();
        Assert.assertEquals("Cogmento CRM", driver.getTitle());
    }

    @When("^username and password are entered$")
    public void username_and_password_are_entered() {
        driver.findElement(By.xpath("//input[@placeholder = 'E-mail address']")).sendKeys("sitanshupt5.sp@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("Bapuna10@");
    }

    @When("^invalid username and password are entered$")
    public void invalid_username_and_password_are_entered(DataTable credentials) {
        for(Map<String, String> loginData : credentials.asMaps(String.class, String.class)) {
            driver.findElement(By.xpath("//input[@placeholder = 'E-mail address']")).sendKeys(loginData.get("username"));
            driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(loginData.get("password"));
        }
    }


    @When("^login button is clicked$")
    public void login_button_is_clicked() {
        driver.findElement(By.xpath("//div[text() = 'Login']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Then("^login error message is displayed$")
    public void login_error_message_is_displayed() {
        Assert.assertEquals("Invalid login", driver.findElement(By.xpath("//div[text() = 'Something went wrong...']/following-sibling::*")).getText());
    }


}
