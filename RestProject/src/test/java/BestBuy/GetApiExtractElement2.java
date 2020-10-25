package BestBuy;

import Samaritan.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetApiExtractElement2 extends TestBase {

    @Test(description = "total")
    public void extractElement1()
    {
        ValidatableResponse response= given().when().get("/stores").then();
        int total = response.extract().path("total");
        System.out.print(total);
    }

    @Test(description = "specific zip code")
    public void extractElement2()
    {
        ValidatableResponse response= given().when().get("/stores").then();
        Map<String, Object> info = response.extract().path("data.find{it.zip =='55901'}");
        System.out.print(info.toString());
    }

    @Test(description = "minimum id")
    public void extractElement3()
    {
        ValidatableResponse response= given().when().get("/stores").then();
        Map<String, Object> info = response.extract().path("data.min{it.id}");
        System.out.print(info.toString());
    }

    @Test(description = "id<10")
    public void extractElement4()
    {
        ValidatableResponse response= given().when().get("/stores").then();
        List<String> info = response.extract().path("data.findAll{it.id<10}.zip");
        info.stream().forEach(System.out::println);
    }
}
