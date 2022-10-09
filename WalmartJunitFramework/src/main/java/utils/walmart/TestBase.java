package utils.walmart;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.Matchers.*;

public class TestBase {
    public String api_key;
    public Properties properties;
    public static RequestSpecBuilder builder;
    public static RequestSpecification requestSpec;
    public static ResponseSpecBuilder responseBuilder;
    public static ResponseSpecification responseSpec;
    public static StringWriter requestWriter;
    public static PrintStream requestCapture;
    public static StringWriter responseWriter;
    public static PrintStream responseCapture;
    public static StringWriter errorWriter;
    public static PrintStream errorCapture;


    @BeforeClass
    public void init()
    {
        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//properties//walmartconfig.properties");
            properties = new Properties();
            properties.load(fis);
        }catch(Exception e)
        {
            e.printStackTrace();

        }
        Map<String, Object> params = new HashMap<>();
        params.put("query", "phone");
        params.put("format", "json");
        params.put("apiKey", properties.getProperty("api_Key"));
        params.put("facet","on");
        builder = new RequestSpecBuilder();
        builder.addQueryParams(params);
        builder.addHeader("Accept","*/*");
        requestSpec = builder.build();

        responseBuilder = new ResponseSpecBuilder();
        Map<String,Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json;charset=utf-8");
        headers.put("Server","Mashery Proxy");
        headers.put("Content-Encoding","gzip");
        responseBuilder.expectHeaders(headers);
        responseBuilder.expectStatusCode(200);
        responseBuilder.expectBody("query",equalTo("phone"));
        responseBuilder.expectBody("items.name",hasItem("Verizon SAMSUNG Galaxy A01, 16GB - Prepaid Smartphone"));

        responseSpec = responseBuilder.build();

    }


}
