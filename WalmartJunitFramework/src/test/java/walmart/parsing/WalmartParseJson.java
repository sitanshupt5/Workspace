package walmart.parsing;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.walmart.TestBase;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class WalmartParseJson extends TestBase {

    ValidatableResponse validatableResponse;

    @BeforeMethod
    public void getResponse(){


        validatableResponse = given().spec(requestSpec).
                when().get("/search").then();
    }

    @Test
    public void getProduct1()
    {
        int num = validatableResponse.extract().path("numItems");
        System.out.println("Number Of Items is:"+ num);

    }

    @Test
    //(description = "extract search query")
    public void getProduct2()
    {
        String query = validatableResponse.extract().path("query");
        System.out.println("Search query is:"+ query);

    }

    @Test
    //(description = "extract product name")
    public void getProduct3()
    {
        String productName = validatableResponse.extract().path("items[0].name");
        System.out.println("Product name is:"+ productName);

    }

    @Test
    //(description = "extract gift options")
    public void getProduct4()
    {
        HashMap<String, String> giftOptions = validatableResponse.extract().path("items[0].giftOptions");
        System.out.println("gift Options are:"+ giftOptions);

    }

    @Test
    //(description = "extract size of items array")
    public void getProduct5()
    {
        int size = validatableResponse.extract().path("items.size()");
        System.out.println("Size of items array is:"+ size);

    }

    @Test
    //(description = "Name of all items")
    public void getProduct6()
    {
        List<String> names = validatableResponse.extract().path("items.name");
//        System.out.println("Following are the names of all items:"+ names);
        names.stream().forEach(System.out::println);

    }

    @Test
    //(description = "Extract details for Straight Talk LG Journey Smartphone")
    public void getProduct7()
    {
        List<HashMap<String,Object>> details = validatableResponse.extract().path("items.findAll{it.name=='Straight Talk LG Journey Smartphone'}");
//        System.out.println("Following are the names of all items:"+ names);
        details.stream().forEach(System.out::println);

    }

    @Test
    //(description = "Extract all sale price values for Straight Talk LG Journey Smartphone")
    public void getProduct8()
    {
        List<Float> salePrice = validatableResponse.extract().path("items.findAll{it.name=='Straight Talk LG Journey Smartphone'}.salePrice");
//        System.out.println("Following are the names of all items:"+ names);
        salePrice.stream().forEach(System.out::println);

    }

    @Test
    //(description = "Extract products with sale price less tha 100$")
    public void getProduct9()
    {
        List<String> names = validatableResponse.extract().path("items.findAll{it.salePrice<100}.name");
//        System.out.println("Following are the names of all items:"+ names);
        names.stream().forEach(System.out::println);

    }

    @Test
    //(description = "Extract msrp for Straight Talk phone")
    public void getProduct10()
    {
        List<Integer> msrps = validatableResponse.extract().path("items.findAll{it.name==~/Straight Talk.*/}.msrp");
        System.out.println("Straight Talk phones msrps are:"+ msrps);


    }

    @Test
    //(description = "Extract msrp for Apple iPhones")
    public void getProduct11()
    {
        List<Integer> msrps = validatableResponse.extract().path("items.findAll{it.name==~/.*Apple iPhone.*/}.msrp");
        System.out.println("Apple iPhone msrps are:"+ msrps);


    }


}
