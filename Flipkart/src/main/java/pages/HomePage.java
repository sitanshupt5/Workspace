package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseUtils;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "//input[contains(@title,'Search for products')]")
    WebElement searchBox;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginLink;

    @FindBy(xpath = "//input[@type='password']/parent::div/preceding-sibling::div/input[@type = 'text']")
    WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    @FindBy(xpath = "//div[text()='My Account']")
    WebElement myAccountMenu;

    public HomePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(this.driver, 20);
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor)this.driver;
    }

    public void login(String user_name, String account_password)
    {
//        wait.until(ExpectedConditions.visibilityOf(loginLink)).click();
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user_name);
        password.sendKeys(account_password+Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(myAccountMenu));


    }

    public SearchResults searchEntity(String searchString){
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(searchString+ Keys.ENTER);
        return new SearchResults(driver);
    }


    }
