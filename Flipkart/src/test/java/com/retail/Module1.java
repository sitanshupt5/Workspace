package com.retail;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResults;
import utils.BaseUtils;

public class Module1 extends BaseUtils {

    @Test(description = "Search product as a logged in user")
    public void testCase1()
    {
        HomePage homePage = new HomePage(driver);
        homePage.login("sitanshupt5@gmail.com","Bapuna10@");

        SearchResults result= homePage.searchEntity("redmi note");
        result.navigateToPDPPage(0);

    }

}
