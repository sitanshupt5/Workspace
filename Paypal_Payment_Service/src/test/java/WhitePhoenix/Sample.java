package WhitePhoenix;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Sample {
    static String accessToken;

    @Test(description=" get paypal client authorisation credentials")
    public void getToken() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//WhitePhoenix//resources//paypal_config.properties");
        Properties prop = new Properties();
        prop.load(fis);

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addParam("grant_type","client_credentials");
        RequestSpecification requestSpec = builder.build();
        requestSpec.auth().preemptive().basic(prop.getProperty("client_id"), prop.getProperty("client_secret"));
        accessToken=given().spec(requestSpec)
                .when()
                .post("https://api.sandbox.paypal.com/v1/oauth2/token")
                .then()
                .log().all(true)
                .extract().path("access_token");
    }
}
