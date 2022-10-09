package otherapplications;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUploadApp {

    @Test(description = "Upload a file to Zamzar.com")
    public void verifyUploadFile()
    {
        File inputFile = new File(System.getProperty("user.dir")+"//src//main//java//resources//files//screenshot1.png");
        String api_key = "a082894dffb5605f158fc703d44c73bdc1182d33";
        String endpoint = "https://sandbox.zamzar.com/v1/jobs";
                given().auth().basic(api_key,"")
                        .multiPart("source_file",inputFile)
                        .multiPart("target_format","jpg")
                        .log().all(true)
                .when()
                        .post(endpoint)
                .then()
                        .log().all(true);
    }
}
