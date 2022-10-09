package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseUtils;

import java.util.ArrayList;

public class SearchResults {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(),'Showing')]/parent::div/parent::div/parent::div/parent::div")
    WebElement searchResults;

    public SearchResults(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver,this);
    }

    public void navigateToPDPPage(int productNumber)
    {
        searchResults.findElements(By.xpath("/child::div")).get(productNumber+1)
                .findElement(By.xpath("/descendant::a")).click();
    }
}
