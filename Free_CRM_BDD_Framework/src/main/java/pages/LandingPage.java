package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()= 'Sign Up']")
    WebElement signuplink;

    @FindBy(xpath = "//a[text()= 'About']")
    WebElement aboutlink;

    @FindBy(xpath = "//a[text()= 'CRM']")
    WebElement crmmenu;

    @FindBy(xpath = "//a[text()= 'Apps']")
    WebElement appsmenu;

    @FindBy(xpath = "//a[text()= 'Compare']")
    WebElement comparemenu;

    @FindBy(xpath = "//a[text()= 'Pricing']")
    WebElement pricinglink;

    @FindBy(xpath = "//span[text()= 'Log In']/parent::a")
    WebElement loginlink;

    public WebElement getSignuplink()
    {
        return wait.until(ExpectedConditions.visibilityOf(signuplink));
    }

    public WebElement getAboutlink()
    {
        return wait.until(ExpectedConditions.visibilityOf(aboutlink));
    }

    public WebElement getCrmmenu()
    {
        return wait.until(ExpectedConditions.visibilityOf(crmmenu));
    }

    public WebElement getAppsmenu()
    {
        return wait.until(ExpectedConditions.visibilityOf(appsmenu));
    }

    public  WebElement getComparemenu()
    {
        return wait.until(ExpectedConditions.visibilityOf(comparemenu));
    }

    public WebElement getPricinglink()
    {
        return wait.until(ExpectedConditions.visibilityOf(pricinglink));
    }

    public LoginPage loginLink()
    {
        wait.until(ExpectedConditions.visibilityOf(loginlink)).click();
        return new LoginPage(driver);
    }

}
