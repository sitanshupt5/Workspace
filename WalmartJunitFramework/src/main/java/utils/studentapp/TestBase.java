package utils.studentapp;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

    public class TestBase {
        @BeforeClass
        public void init(){
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 8080;
            RestAssured.basePath = "student";
        }
    }

