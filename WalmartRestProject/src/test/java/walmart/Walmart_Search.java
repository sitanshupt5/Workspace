package walmart;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Walmart_Search extends TestBase {

//    @Test(description = "sample")
//    public void getProduct()
//    {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("query", "phone");
//        params.put("format", "json");
//        params.put("apiKey", api_key );
//        Response response = given().queryParams(params).log().all().
//                when().get("/search");
//        response.prettyPrint();
//
//    }

    @Description("Extract number of items from response body")
    @Test(description = "Test Case1: Extract number of items from response body")
    public void getProduct1()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        int num = given().queryParams(params).
                when().get("/search").then().extract().path("numItems");
        System.out.println("Number Of Items is:"+ num);

    }


    @Description("Extract search query from response body")
    @Test(description = "Test Case2: Extract search query from response body")
    public void getProduct2()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        String query = given().queryParams(params).
                when().get("/search").then().extract().path("query");
        System.out.println("Search query is:"+ query);

    }

    @Description("Extract name of the first product from response body")
    @Test(description = "Test Case3: Extract name of the first product from response body")
    public void getProduct3()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        String productName = given().queryParams(params).
                when().get("/search").then().extract().path("items[0].name");
        System.out.println("Product name is:"+ productName);

    }

    @Description("Extract gift options for the first product from response body")
    @Test(description = "Test Case4: Extract gift options for the first product from response body")
    public void getProduct4()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        HashMap<String, String> giftOptions = given().queryParams(params).
                when().get("/search").then().extract().path("items[0].giftOptions");
        System.out.println("gift Options are:"+ giftOptions);

    }


    @Description("Extract size of items array from response body")
    @Test(description = "Test Case5: Extract size of items array from response body")
    public void getProduct5()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        int size = given().queryParams(params).
                when().get("/search").then().extract().path("items.size()");
        System.out.println("Size of items array is:"+ size);

    }

    @Description("Extract name of all items from response body")
    @Test(description = "Test Case6: Extract name of all items from response body")
    public void getProduct6()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        List<String> names = given().queryParams(params).
                when().get("/search").then().extract().path("items.name");
//        System.out.println("Following are the names of all items:"+ names);
        names.stream().forEach(System.out::println);

    }

    @Description("Extract details for Straight Talk LG Journey Smartphone from response body")
    @Test(description = "Test Case7: Extract details for Straight Talk LG Journey Smartphone from response body")
    public void getProduct7()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        List<HashMap<String,Object>> details = given().queryParams(params).
                when().get("/search").then().extract().path("items.findAll{it.name=='Straight Talk LG Journey Smartphone'}");
//        System.out.println("Following are the names of all items:"+ names);
        details.stream().forEach(System.out::println);

    }


    @Description("Extract all sale price values for Straight Talk LG Journey Smartphone")
    @Test(description = "Test Case8: Extract all sale price values for Straight Talk LG Journey Smartphone")
    public void getProduct8()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        List<Float> salePrice = given().queryParams(params).
                when().get("/search").then().extract().path("items.findAll{it.name=='Straight Talk LG Journey Smartphone'}.salePrice");
//        System.out.println("Following are the names of all items:"+ names);
        salePrice.stream().forEach(System.out::println);

    }

    @Description("Extract names of all products with sale price less that 100$")
    @Test(description = "Test Case9: Extract names of all products with sale price less that 100$")
    public void getProduct9()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        List<String> names = given().queryParams(params).
                when().get("/search").then().extract().path("items.findAll{it.salePrice<100}.name");
//        System.out.println("Following are the names of all items:"+ names);
        names.stream().forEach(System.out::println);

    }

    @Description("Extract msrp for all Straight Talk phone")
    @Test(description = "Test Case10: Extract msrp for all Straight Talk phone")
    public void getProduct10()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        List<Integer> msrps = given().queryParams(params).
                when().get("/search").then().extract().path("items.findAll{it.name==~/Straight Talk.*/}.msrp");
        System.out.println("Straight Talk phones msrps are:"+ msrps);


    }

    @Description("Extract msrp for Apple iPhones")
    @Test(description = "Test Case11: Extract msrp for Apple iPhones")
    public void getProduct11()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", api_key );
        List<Integer> msrps = given().queryParams(params).
                when().get("/search").then().extract().path("items.findAll{it.name==~/.*Apple iPhone.*/}.msrp");
        System.out.println("Apple iPhone msrps are:"+ msrps);


    }
}
