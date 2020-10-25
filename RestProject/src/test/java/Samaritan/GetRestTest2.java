package Samaritan;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRestTest2 extends TestBase{

    @Test(description = "Query Params")
    public void getStudents1()
    {
        Response res = given().
                queryParams("programme","Computer Science","limit",1).
                when().
                get("/list");
        res.prettyPrint();

    }

    @Test(description = "Query Params with Map")
    public void getStudents2()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("programme", "Computer Science");
        params.put("limit",1);

        Response res = given().
                queryParams(params).log().all().
                when().
                get("/list");
        res.prettyPrint();

    }

    @Test(description = "Path Params")
    public void getStudents3()
    {

        Response res = given().
                pathParam("id", 2).log().all().
                when().
                get("/{id}");
        res.prettyPrint();

    }

}
