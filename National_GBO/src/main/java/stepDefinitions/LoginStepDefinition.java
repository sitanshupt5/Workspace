package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {

    WebDriver driver;

    @Given("^user is on the facebook landing page$")
    public void user_is_on_the_facebook_landing_page() {
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("https://www.facebook.com/");
    }

    @When("^user enters \"(.*)\" and password$")
    public void user_enters_email_id_and_password(String username){
       driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(username);
       driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Bapuna10@");
    }

    @And("^user clicks on login button$")
    public void user_clicks_on_login_button(){
        driver.findElement(By.xpath("//input[@value = 'Log In']")).click();
    }

    @Then("^user should be redirected to the HomePage$")
    public void user_should_be_redirected_to_the_HomePage() throws InterruptedException{
       Thread.sleep(10000);
        Assert.assertEquals("(4) Facebook", driver.getTitle());
        driver.close();
        driver.quit();
    }
}
