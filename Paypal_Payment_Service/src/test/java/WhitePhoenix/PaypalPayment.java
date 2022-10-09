package WhitePhoenix;

import WhitePhoenix.utils.JsonBodyCreator;
import WhitePhoenix.utils.TestBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PaypalPayment extends TestBase {
    public static String paymentId;

    @Test(description = "Create a payment instance in paypal")
    public void createPayment()
    {
        ValidatableResponse response = given()
                .spec(requestSpec)
                .log().all()
                .when()
                .post("/payments/payment")
                .then()
                .log().all();
        paymentId = response.extract().path("id");
        System.out.println("Payment Id is:"+paymentId);
    }

    @Test(description = "Create a payment instance in paypal instance 2")
    public void createPayment1()
    {
        ValidatableResponse response = given()
                .spec(requestSpec)
                .log().all()
                .when()
                .post("/payments/payment")
                .then()
                .log().all();
        paymentId = response.extract().path("id");
        System.out.println("Payment Id is:"+paymentId);
    }

    @Test(description = "Fetch details a payment instance in Paypal")
    public void getPaymentDetails()
    {
        requestSpec.pathParam("payment_id",paymentId);
        ValidatableResponse response = given()
                .spec(requestSpec)
                .log().all(true)
                .when()
                .get("/payments/payment/{payment_id}")
                .then().log().all();
    }

    @Test
    public void requestMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> requestMap = mapper.readValue(new FileReader(System.getProperty("user.dir")
                    + "//src//main//java//WhitePhoenix//resources//payloads//createPayment.json"), new TypeReference<Map<String, Object>>() {
            });
            System.out.println(requestMap);
        }catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }catch (IOException e)
        {
            System.out.println("Unable to read file");
        }
    }
}
