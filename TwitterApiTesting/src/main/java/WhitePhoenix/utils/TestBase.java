package WhitePhoenix.utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public Properties properties;

    @BeforeClass
    public void intialize()
    {
        setProperties();
        buildURL();
    }

    public void buildURL()
    {
        RestAssured.baseURI = "https://api.twitter.com/1.1";
        RestAssured.basePath = "/statuses";
    }

    public void setProperties()
    {
        properties = new Properties();
        FileInputStream file  = null;
        try {
            file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\WhitePhoenix\\resources\\configs\\twitter_config.properties");
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
