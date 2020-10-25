package utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    public String api_key;
    public Properties properties;

   @BeforeTest
    public void init()
    {
       RestAssured.baseURI = "http://api.walmartlabs.com/v1";
       try
       {
           FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\walmart_config.properties");
           properties = new Properties();
           properties.load(fis);
       }catch(Exception e)
       {
           e.printStackTrace();
       }

       api_key = properties.getProperty("api_Key");

    }
}
