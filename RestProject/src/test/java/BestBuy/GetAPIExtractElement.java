package BestBuy;

import Samaritan.TestBase;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetAPIExtractElement extends TestBase {

    @Test(description = "Root Element")
    public void extractElement1()
    {
        String response = given().when().get("/products").asString();
        Map<String,?> rootElement = JsonPath.read(response, "$");
        System.out.print(rootElement.toString());
    }

    @Test(description = "total value")
    public void extractElement2()
    {
        String response = given().when().get("/products").asString();
        int total = JsonPath.read(response, "$.total");
        System.out.print(total);
    }

    @Test(description = "data elements")
    public void extractElement3()
    {
        String response = given().when().get("/products").asString();
        List<HashMap<String,Object>> dataElements= JsonPath.read(response, "$.data");
        dataElements.stream().forEach(System.out::println);
    }

    @Test(description = "first data element")
    public void extractElement4()
    {
        String response = given().when().get("/products").asString();
        HashMap<String,Object> firstElement= JsonPath.read(response, "$.data[0]");
        System.out.println(firstElement);
    }

    @Test(description = "last data element")
    public void extractElement5()
    {
        String response = given().when().get("/products").asString();
        HashMap<String,Object> lastElement= JsonPath.read(response, "$.data[-1]");
        System.out.println(lastElement);
    }

    @Test(description = "id of data element")
    public void extractElement6()
    {
        String response = given().when().get("/products").asString();
        List<String> allIds= JsonPath.read(response, "$.data[*].id");
        System.out.println(allIds);
    }

    @Test(description = "all ids")
    public void extractElement7()
    {
        String response = given().when().get("/products").asString();
        List<String> allIds= JsonPath.read(response, "$.data[*]..id");
        System.out.println(allIds);
    }

    @Test(description = "price<5")
    public void extractElement8()
    {
        String response = given().when().get("/products").asString();
        List<HashMap<String,Object>> dataElements= JsonPath.read(response, "$.data[?(@.price<5)]");
        dataElements.stream().forEach(System.out::println);
    }

    @Test(description = "product name for price>5")
    public void extractElement9()
    {
        String response = given().when().get("/products").asString();
        List<String> dataElements= JsonPath.read(response, "$.data[?(@.price>5)].name");
        dataElements.stream().forEach(System.out::println);
    }
}
