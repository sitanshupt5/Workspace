package WhitePhoenix;

import WhitePhoenix.utils.TestBase;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PostTweet extends TestBase{
    ValidatableResponse response;

    @BeforeMethod
    public void setResponse()
    {
        response = given().
                auth()
                .oauth(properties.getProperty("api_key"),properties.getProperty("api_key_secret"),properties.getProperty("access_token"),properties.getProperty("access_token_secret"))
                .queryParam("status","This message is just for test.")
                .log().all(true)
                .when()
                .post("/update.json")
                .then().log().all();
    }

    @Test(description = "Validate POST tweet response")
    public void postTweet()
    {
        Assert.assertTrue(response.extract().statusCode()==200,"Status code mismatch");
        System.out.println("Status code of response is 200");
    }
}
