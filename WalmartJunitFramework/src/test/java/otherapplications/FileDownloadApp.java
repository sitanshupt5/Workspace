package otherapplications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FileDownloadApp {

    @Test(description = "Compare downloaded file with existing file")
    public void verifyDownloadedFile()
    {
        File existingFile = new File(System.getProperty("user.dir")+"//src//main//java//resources//files//geckodriver-v0.27.0-win64.zip");
        int expectedSize = (int)existingFile.length();
        System.out.println("Expected size of file is: "+expectedSize+" bytes");
        //https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-win64.zip
        byte[] actualsize = given().
                when()
                .get("https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-win64.zip")
                .then()
                .extract().asByteArray();
        Assert.assertTrue(expectedSize == actualsize.length,"Expected size not equal to actual size");

    }

    @Test(description = "Check Download Time")
    public void verifyDownloadedTime()
    {
        long responseTime= given().
                when()
                .get("https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-win64.zip")
                .timeIn(TimeUnit.SECONDS);
        System.out.println("Response time is: "+responseTime);

    }

    @Test(description = "Check Response Time")
    public void verifyResponseTime()
    {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectResponseTime(lessThan(5L),  TimeUnit.SECONDS);
        ResponseSpecification responseSpec = builder.build();
        ValidatableResponse response = given()
                .log().all(true)
                .when()
                .get("https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-win64.zip")
                .then();
        response.spec(responseSpec);

    }
}
