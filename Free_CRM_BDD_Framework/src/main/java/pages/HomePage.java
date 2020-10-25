package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder = 'Search']")
    WebElement searchbox;

    @FindBy(xpath = "//div[@role = 'listbox']")
    WebElement optionslist;

    @FindBy(xpath = "//span[text() = 'Log Out']")
    WebElement logout;

    @FindBy(xpath = "//span[text() = 'Sitanshu Pati']")
    WebElement userdisplay;

    @FindBy(xpath = "//span[text() = 'Home']/parent::a")
    WebElement refreshbutton;

    @FindBy(xpath = "//span[text() = 'Calendar']/parent::a")
    WebElement calendar;

    @FindBy(xpath = "//span[text() = 'Contacts']/parent::a")
    WebElement contacts;

    @FindBy(xpath = "//span[text() = 'Companies']/parent::a")
    WebElement companies;

    @FindBy(xpath = "//span[text() = 'Deals']/parent::a")
    WebElement deals;

  /*@FindBy(xpath = "//span[text() = 'Tasks']/parent::a")
    WebElement tasks;

    @FindBy(xpath = "//span[text() = 'Cases']/parent::a")
    WebElement cases;

    @FindBy(xpath = "//span[text() = 'Documents']/parent::a")
    WebElement documents;

    @FindBy(xpath = "//span[text() = 'Email']/parent::a")
    WebElement email;

    @FindBy(xpath = "//span[text() = 'Campaigns']/parent::a")
    WebElement campaigns;

    @FindBy(xpath = "//span[text() = 'Forms']/parent::a")
    WebElement forms;*/

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public boolean userDisplay()
    {
        return userdisplay.isDisplayed();
    }

    public void refreshHomePage()
    {
        wait.until(ExpectedConditions.visibilityOf(refreshbutton)).click();
    }

    public void openCalendar()
    {
        wait.until(ExpectedConditions.visibilityOf(calendar)).click();
    }

    public void openContacts()
    {
        wait.until(ExpectedConditions.visibilityOf(contacts)).click();
    }

    public void openCompanies()
    {
        wait.until(ExpectedConditions.visibilityOf(companies)).click();
    }

    public DealsPage openDeals()
    {
        wait.until(ExpectedConditions.visibilityOf(deals)).click();
        return new DealsPage(driver);
    }

    public LoginPage logOut()
    {
        wait.until(ExpectedConditions.visibilityOf(optionslist)).click();
        wait.until(ExpectedConditions.visibilityOf(logout)).click();
        return new LoginPage(driver);
    }


}
