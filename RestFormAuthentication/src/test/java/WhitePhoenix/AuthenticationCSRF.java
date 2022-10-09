package WhitePhoenix;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthenticationCSRF {
    public static SessionFilter sessionFilter;

    @Test
    public void login(){
        sessionFilter = new SessionFilter();
        RestAssured.baseURI = "http://localhost:8885";
        ValidatableResponse response = given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd").withAutoDetectionOfCsrf())
                .log().all()
                .filter(sessionFilter)
                .when()
                .get()
                .then()
                .log().all();

        System.out.println(sessionFilter.getSessionId());
    }

}
