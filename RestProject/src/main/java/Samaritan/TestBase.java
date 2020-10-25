package Samaritan;

import org.testng.annotations.BeforeTest;
import io.restassured.RestAssured;

public class TestBase {

//    @BeforeTest
    public  static  void init()
    {
        RestAssured.baseURI = "http://localhost";
        //Student App
        //        RestAssured.port = 8080;
        //        RestAssured.basePath = "/student";

        //Best Buy
        RestAssured.port = 3030;
    }
}
