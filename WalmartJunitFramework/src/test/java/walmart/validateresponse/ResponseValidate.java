package walmart.validateresponse;

import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.walmart.TestBase;

import java.io.PrintStream;
import java.io.StringWriter;

import static io.restassured.RestAssured.given;


public class ResponseValidate extends TestBase {

    ValidatableResponse validatableResponse;

    @BeforeMethod
    public void getResponse(){
        requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);
        responseWriter = new StringWriter();
        responseCapture = new PrintStream(new WriterOutputStream(responseWriter),true);
        errorWriter = new StringWriter();
        errorCapture = new PrintStream(new WriterOutputStream(responseWriter),true);
        validatableResponse = given().spec(requestSpec).
                filter(new RequestLoggingFilter(requestCapture)).
                filter(new ResponseLoggingFilter(responseCapture)).
                filter(new ErrorLoggingFilter(errorCapture)).
                when().get("/search").then();
        System.err.println(requestWriter.toString());
        System.err.println(responseWriter.toString());
//        System.err.println(errorWriter.toString());
    }

    @Test(description = "Validate Response")
    public void validateResponse(){
        validatableResponse.spec(responseSpec);
    }
}
