package stepdefinitions.deals;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.DealsPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import testbase.BaseUtils;

import java.io.IOException;

public class DealsStepDefinition extends BaseUtils {

    static LoginPage loginPage;
    static HomePage homePage;
    static DealsPage dealsPage;
    static String tcname;

    @Before
    public void initialSetUp(Scenario scenario) throws IOException
    {
        initializeDriver();
        startTestCase("FreeCRM_Data");
        driver.get("https://www.freecrm.com");
        driver.manage().window().maximize();
        tcname = scenario.getName();

    }


    @Given("^homepage is open$")
    public void homepage_is_open() {

       LandingPage landingPage = new LandingPage(driver);
       loginPage = landingPage.loginLink();
       homePage = loginPage.Login(excel.multiIteration("Deals", "Username", tcname),excel.multiIteration("Deals", "Password", tcname));
    }

    @When("^deals option is clicked$")
    public void deals_option_is_clicked() {
        dealsPage = homePage.openDeals();

    }

    @Then("^Deals page is opened$")
    public void deals_page_is_opened() {
        Assert.assertTrue(dealsPage.verifyDealsHeader());

    }

    @Then("^deals header is displayed$")
    public void deals_header_is_displayed(){
        Assert.assertTrue(dealsPage.verifyDealsHeader());
    }

    @Given("^deals page is open$")
    public void deals_page_is_open() {
        LandingPage landingPage = new LandingPage(driver);
        loginPage = landingPage.loginLink();
        homePage = loginPage.Login(excel.multiIteration("Deals", "Username", tcname),excel.multiIteration("Deals", "Password", tcname));
        dealsPage = homePage.openDeals();
        Assert.assertTrue(dealsPage.verifyDealsHeader());


    }

    @When("^home option is clicked$")
    public void home_option_is_clicked() {
        homePage = dealsPage.openHomePage();

    }

    @Then("^homepage is opened$")
    public void homepage_is_opened() {
        Assert.assertTrue(homePage.userDisplay());
    }

    @Then("^username is displayed$")
    public void username_is_displayed() {
        Assert.assertTrue(homePage.userDisplay());
    }

    @When("^logout button is clicked$")
    public void logout_button_is_clicked(){
        loginPage = dealsPage.logOut();
    }

    @Then("^login page is displayed$")
    public void login_page_is_displayed(){
        Assert.assertTrue(loginPage.verifyLogin());
    }

    @After
    public void shutDown()
    {
        closeBrowser();
    }
}
