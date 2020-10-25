package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@name = 'email']")
    WebElement username;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement password;

    @FindBy(xpath = "//div[text() = 'Login']")
    WebElement loginbutton;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public HomePage Login(String userName, String Password)
    {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(Password);
        wait.until(ExpectedConditions.visibilityOf(loginbutton)).click();
        return new HomePage(driver);
    }

    public boolean verifyLogin()
    {
        return wait.until(ExpectedConditions.visibilityOf(loginbutton)).isDisplayed();
    }
}
