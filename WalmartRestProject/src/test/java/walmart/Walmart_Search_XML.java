package walmart;

import io.restassured.internal.path.xml.NodeChildrenImpl;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.with;

public class Walmart_Search_XML extends TestBase {

//    @Test(description = "sample")
//    public void getProduct()
//    {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("query", "phone");
//        params.put("format", "xml");
//        params.put("apiKey", api_key );
//        Response response = given().queryParams(params).log().all().
//                when().get("/search");
//        response.prettyPrint();
//
//    }

    @Test(description = "Test Case1: Extract number of items from response body")
    public void getProduct1() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        String num = given().queryParams(params).
                when().get("/search").then().extract().path("searchresponse.numItems");
        System.out.println("Number Of Items is:" + num);

    }

    @Test(description = "Test Case2: Extract search query from response body")
    public void getProduct2() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        String query = given().queryParams(params).
                when().get("/search").then().extract().path("searchresponse.query");
        System.out.println("Search query is:" + query);

    }

    @Test(description = "Test Case1: Extract name of first item from response body")
    public void getProduct3() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        String productName = given().queryParams(params).
                when().get("/search").then().extract().path("searchresponse.items.item[0].name");
        System.out.println("Product name is:" + productName);

    }

    @Test(description = "Test Case1: Extract gift options for first item from response body")
    public void getProduct4() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        String xml = given().queryParams(params).
                when().get("/search").asString();
        String giftOptions = with(xml).getString("searchresponse.items.item[0].giftOptions");
        System.out.println("gift Options are:" + giftOptions);

    }

    @Test(description = "Test Case1: Extract size items array from response body")
    public void getProduct5() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        NodeChildrenImpl val = given().queryParams(params).
                when().get("/search").then().extract().path("searchresponse.items.item");
        System.out.println("Size of items array is:" + val.size());

    }

    @Test(description = "Test Case1: Extract name of all available items from response body")
    public void getProduct6() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        String xml = given().queryParams(params).
                when().get("/search").asString();
        List<String> names = with(xml).getList("searchresponse.items.item.name");
        System.out.println("List of all items is:");
        names.stream().forEach(System.out::println);

    }


    @Test(description = "Test Case1: Extract sale price value for Apple iPhone from response body")
    public void getProduct7() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        String xml = given().queryParams(params).
                when().get("/search").asString();
        List<String> salePrice = with(xml).getList("searchresponse.items.item.findAll{it.name==~/.*Apple iPhone.*/}.salePrice");
        System.out.println("Following are the sale price of Apple iPhone:");
        salePrice.stream().forEach(System.out::println);

    }

    @Test(description = "Test Case1: Extract sale price value for Apple iPhone from response body with deep search")
    public void getProduct8() {
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "xml");
        params.put("apiKey", api_key);
        String xml = given().queryParams(params).
                when().get("/search").asString();
        List<String> salePrice = with(xml).getList("**.findAll{it.name==~/.*Apple iPhone.*/}.salePrice");
        System.out.println("Following are the sale price of Apple iPhone:");
        salePrice.stream().forEach(System.out::println);

    }
}


