package Samaritan;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.StudentPojo;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PutRestTest extends TestBase{

    @Test
    public void modifyStudent()
    {
        Faker fake = new Faker();
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Selenium");
        courses.add("Testng");
        courses.add("Maven");

        StudentPojo student = new StudentPojo();
        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("Electronics & Instrumentation");
        student.setCourses(courses);

        Response response =given().
                pathParam("id", 103).
                log().all().
                when().
                contentType(ContentType.JSON).
                body(student).
                put("/{id}").
                then().
                statusCode(200).extract().response();
        response.prettyPrint();
    }
}
