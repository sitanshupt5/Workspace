package walmart.assertions;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.walmart.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AssertingValues extends TestBase {
    ValidatableResponse validatableResponse;

    @BeforeMethod
    public void getResponse()
    {
        Map<String, Object> params = new HashMap<>();
        params.put("query","phone");
        params.put("format","json");
        params.put("apiKey",api_key);
        validatableResponse = given().log().all(true).queryParams(params).when().get("/search").then();
    }

    @Test(description = "Assert number of items")
    public void getProduct1()
    {
//        validatableResponse.extract().response().prettyPrint();
        validatableResponse.body("numItems",equalTo(10)).log().status();
    }

    @Test(description = "Verify Query String")
    public void getProduct2(){
//        validatableResponse.extract().response().prettyPrint();
        validatableResponse.body("query", equalToIgnoringCase("phone")).log().status();
    }

    @Test(description = "Check single name in ArrayList")
    public void getProduct3(){
        validatableResponse.body("items.name",hasItem("Straight Talk Motorola Moto e6, 16GB Black – Prepaid Smartphone"));
    }

    @Test(description = "Check multiple item  name in ArrayList")
    public void getProduct4(){
        validatableResponse.body("items.name",hasItems("Straight Talk Motorola Moto e6, 16GB Black – Prepaid Smartphone", "Straight Talk Apple iPhone 7 w/32GB Prepaid Phone, Black"));
    }

    @Test(description = "Check values inside Map using hasValues")
    public void getProduct5(){
        validatableResponse.body("items[0].bestMarketplacePrice", hasKey("sellerInfo"));
    }

//    @Test(description = "Check hasmap values inside a list")
//    public void getProduct6(){
//        validatableResponse.body("items.name",hasEntry("name","Straight Talk LG Journey Smartphone"));
//        //hasItems(hasEntry()
//    }

    @Test(description="Multiple hard Assertions")
    public void getProduct6(){
//        validatableResponse.extract().response().prettyPrint();
        validatableResponse.body("query", equalToIgnoringCase("phone")).
                body("items.name",hasItem("Straight Talk Motorola Moto e6, 16GB Black – Prepaid Smartphone")).
                body("items[0].bestMarketplacePrice", hasKey("sellerInfo")).log().status();
    }

    @Test(description="Multiple soft Assertions")
    public void getProduct7(){
//        validatableResponse.extract().response().prettyPrint();
        validatableResponse.body("query", equalToIgnoringCase("phone"),
                "items.name",hasItem("Straight Talk Motorola Moto e6, 16GB Black – Prepaid Smartphone"),
                "items[0].bestMarketplacePrice", hasKey("sellerInfo")).log().status();
    }

}
