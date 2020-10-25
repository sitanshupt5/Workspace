package Samaritan;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRest extends TestBase{


    @Test
    void deleteStudent() {
        given().
                pathParam("id",102).
                when().
                contentType(ContentType.JSON).
                delete("/{id}").
                then().statusCode(204);
    }
}
