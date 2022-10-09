package WhitePhoenix.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class TestBase {
    public String accessToken;
    public JSONObject request;
    public Properties properties;
    public RequestSpecBuilder requestSpecBuilder;
    public RequestSpecification requestSpec;

    public void setProperties()
    {
        FileInputStream file;
        try{
            properties = new Properties();
            file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//WhitePhoenix//resources//config_files//paypal_config.properties");
            properties.load(file);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void initialize(ITestContext context)
    {
        setURLParameters();
        setProperties();
        getAccessToken();
        System.out.println();
        String name = context.getCurrentXmlTest().getClasses().stream().findFirst().get().getName();
        String classname = name.substring(name.lastIndexOf(".")+1);
        requestBuilder(context.getName(), classname);
    }

    public void setURLParameters()
    {
        RestAssured.baseURI = "https://api.sandbox.paypal.com";
        RestAssured.basePath = "/v1";
    }

    public void getAccessToken()
    {
        accessToken = given().param("grant_type","client_credentials")
                .auth().preemptive()
                .basic(properties.getProperty("client_id"), properties.getProperty("client_secret"))
                .when()
                .post("/oauth2/token")
                .then()
                .log().all()
                .extract()
                .path("access_token");
    }

    public void requestBuilder(String testCase, String testSuite)
    {
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Authentication","Bearer "+accessToken);
        requestSpecBuilder.addHeader("Content-Type","application/json");
        try{
            JsonBodyCreator bodyCreator = new JsonBodyCreator(testSuite,testCase);
            requestSpecBuilder.setBody(bodyCreator.createJsonBody());
            requestSpecBuilder.setContentType(ContentType.JSON);
            requestSpec = requestSpecBuilder.build();
            requestSpec.auth().preemptive().oauth2(accessToken);
        }catch(Exception e)
        {
            requestSpec = requestSpecBuilder.build();
            requestSpec.auth().preemptive().oauth2(accessToken);
        }
//        if(jsonReader(testCase))
//        {
//            requestSpecBuilder.setBody(jsonReader(testCase));
//            requestSpecBuilder.setContentType(ContentType.JSON);
//            requestSpec = requestSpecBuilder.build();
//            requestSpec.auth().preemptive().oauth2(accessToken);
//        }
//        else
//        {
//            requestSpec = requestSpecBuilder.build();
//            requestSpec.auth().preemptive().oauth2(accessToken);
//        }

    }

    public void getBody(String testCase)
    {
        JSONParser  jsonParser = new JSONParser();
        try{
            Object object = jsonParser.parse(new FileReader(System.getProperty("user.dir")+"//src//main//java//WhitePhoenix//resources//payloads//"+testCase+".json"));
            request = (JSONObject)object;
        } catch (ParseException e) {
            System.out.println("Payload json format is invalid");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found. Assuming service does not have a body.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
