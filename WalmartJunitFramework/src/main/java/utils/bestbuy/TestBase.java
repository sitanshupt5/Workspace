package utils.bestbuy;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    @BeforeClass
    public void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
    }
}
