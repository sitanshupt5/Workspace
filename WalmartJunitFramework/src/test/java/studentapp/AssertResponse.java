package studentapp;

import io.restassured.response.ValidatableResponse;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.studentapp.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class AssertResponse extends TestBase {
    ValidatableResponse validatableResponse;

    @BeforeMethod
    public void getResponse(){
        validatableResponse = given().when().get("/list").then();
    }

    @Test(description = "Validate entire json response")
    public void getStudentList() throws IOException {
        String expectedValue = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"//src//main//java//resources//sample_responses//studentlist.txt")));
        String actualValue = validatableResponse.extract().response().asString();
        try {
            JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
        }
        catch (JSONException j)
        {
            j.getLocalizedMessage();
        }
    }
}
