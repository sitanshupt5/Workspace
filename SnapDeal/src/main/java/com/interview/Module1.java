package com.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Module1 {

   public static void main(String[] args){

       System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//java//com//resources//chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.snapdeal.com/");
       driver.manage().window().maximize();
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search products & brands']")))
               .sendKeys("headphones");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'searchformButton')]")))
               .click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='searchMessageContainer']/descendant::span[contains(text(),'headphones')]")))
               .isDisplayed();

       WebElement brand = driver.findElement(By.xpath("//div[@data-name='Brand']/child::div"));

       String brandName = driver.findElement(By.xpath("//div[@data-name='Brand']/child::div/child::input")).getAttribute("value");
       brand.click();
       WebElement searchResults= driver.findElement(By.xpath("//section[@data-dpwlbl='Product Grid']/child::div/child::div[@class='product-tuple-image ']/child::a"));
       searchResults.click();
       String productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@itemprop='name']"))).getText();
       Assert.assertTrue(productTitle.contains(brandName),"Product Title does not contain brand name");


   }


}
