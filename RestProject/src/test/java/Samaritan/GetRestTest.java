package Samaritan;

import com.jayway.jsonpath.JsonPath;
import  io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRestTest {

    @Test
    public void getMethod1() {
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");

        int code = res.getStatusCode();
        System.out.println(code);
        Assert.assertEquals(code, 200);
    }

    @Test
    public void getMethod2() {
        RestAssured.baseURI = "https://reqres.in";
        Response response = given().queryParam("page", 2)
                .proxy(5555)
                .when().get("/api/users")
                .then().assertThat().statusCode(200)
                .extract().response();

        response.prettyPrint();
        List<String> firstname = JsonPath.read(response.asString(), "$.data[?(@.id>10)].first_name");
        System.out.println(firstname);


    }

    @Test
    public void getMethod3(){
        RequestSpecification specs =  RestAssured.given();
        Response res = specs.get("https://reqres.in/api/users?page=2");
        res.prettyPrint();

        ValidatableResponse validres = res.then();
        validres.statusCode(200);


    }
}
