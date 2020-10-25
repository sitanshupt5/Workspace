package Samaritan;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.StudentPojo;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PatchRestTest {
    @Test
    public void patchStudent()
    {
        Faker fake = new Faker();

        StudentPojo student = new StudentPojo();
        student.setEmail(fake.internet().emailAddress());


        Response response =given().
                pathParam("id", 103).
                when().
                contentType(ContentType.JSON).
                body(student).
                patch("/{id}").
                then().
                statusCode(200).extract().response();
        response.prettyPrint();
    }
}
