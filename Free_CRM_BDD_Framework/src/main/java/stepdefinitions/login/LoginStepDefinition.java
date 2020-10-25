package stepdefinitions.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LandingPage;
import pages.LoginPage;
import testbase.BaseUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginStepDefinition extends BaseUtils {

    LoginPage loginPage;

    @Given("^login page is open$")
    public void login_page_is_open() throws IOException {
       initializeDriver();
       driver.get("https://www.freecrm.com");
       driver.manage().window().maximize();
       LandingPage landingPage = new LandingPage(driver);
       loginPage = landingPage.loginLink();
    }

    @When("^username and password are entered and login is clicked$")
    public void username_and_password_are_entered_and_login_is_clicked() {
        loginPage.Login("sitanshupt5.sp@gmail.com", "Bapuna10@");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Then("^HomePage is Opened$")
    public void homepage_is_Opened() {
        Assert.assertEquals("Sitanshu Pati", driver.findElement(By.xpath("//span[@class = 'user-display']")).getText());
    }
}
