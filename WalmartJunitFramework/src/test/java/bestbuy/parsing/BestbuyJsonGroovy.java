package bestbuy.parsing;


import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.bestbuy.TestBase;

import static io.restassured.RestAssured.given;

//import org.junit.Before;
//import org.junit.Test;

public class BestbuyJsonGroovy extends TestBase {
    ValidatableResponse validatableResponse;


    @BeforeMethod
    public void getResponse(){
        validatableResponse = given().when().get("/stores").then();
    }



    @Test
    public void getTotal()
    {
        int total = validatableResponse.extract().jsonPath().get("total");
        System.out.println("Total = "+total);

    }

    @Test
    public void getStoreName()
    {
        String storename = validatableResponse.extract().path("data[0].name");
        System.out.println("Store = "+storename);
    }

    @Test
    public void getServiceName(){
        String serviceName = validatableResponse.extract().path("data[0].services[0].name");
        System.out.println("Service Name is :"+serviceName);
    }

}
