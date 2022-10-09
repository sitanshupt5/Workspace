package Samaritan;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import model.StudentPojo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostRestTest extends TestBase{

//    @Test(description = "Create Student")
//    public void createStudent1()
//    {
//        String payload = "{\"firstName\":\"Sitanshu\",\"lastName\":\"Pati\",\"email\":\"sitanshupt5@gmail.com\",\"programme\":\"Electronics & Instrumentation\",\"courses\":[\"Selenium\",\"Testng\",\"Maven\",\"Extent Reports\"]}";
//        Response response =given().
//                when().
//                contentType(ContentType.JSON).
//                body(payload).
//                post().
//                then().
//                statusCode(201).extract().response();
//        response.prettyPrint();
//    }

    @Test(description = "Create Student from POJO")
    public void createStudent2()
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
                log().all().
                when().
                contentType(ContentType.JSON).
                body(student).
                post().
                then().
                log().all(true).
                statusCode(201).extract().response();
        response.prettyPrint();
    }



}
