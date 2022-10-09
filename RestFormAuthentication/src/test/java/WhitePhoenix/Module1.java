package WhitePhoenix;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;
import static  org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Module1 {

    public static SessionFilter sessionFilter;

    @Test
    public void login(){
        sessionFilter = new SessionFilter();
        RestAssured.baseURI = "http://localhost:8085";
        ValidatableResponse response = given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd"))
                .log().all()
                .filter(sessionFilter)
                .when()
                .get()
                .then()
                .log().all();

        System.out.println(sessionFilter.getSessionId());
    }

    @Test(dependsOnMethods = "login")
    public void getStudentList()
    {
        RestAssured.baseURI = "http://localhost:8085";
        ValidatableResponse response = given()
                .sessionId(sessionFilter.getSessionId())
                .log().all()
                .when()
                .get("/student/list")
                .then()
                .log().all();
    }

    @Test
    public void extractTitle()
    {
        RestAssured.baseURI = "http://localhost:8085";
        Response response = given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd"))
                .log().all()
                .when()
                .get();
        System.out.println(response.asString());

        Document document = Jsoup.parse(response.asString());
        System.out.println("Title of the page is: "+document.title().toUpperCase());

    }

    @Test
    public void extractElementByTag()
    {
        RestAssured.baseURI = "http://localhost:8085";
        Response response = given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd"))
                .when()
                .get();

        Document document = Jsoup.parse(response.asString());
        Elements element = document.getElementsByTag("form");
        System.out.println("the number of form elements is: "+element.size());
        for(Element e:element)
        {
            System.out.println(e);
        }

    }

    @Test
    public void extractElementById()
    {
        RestAssured.baseURI = "http://localhost:8085";
        Response response = given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd"))
                .when()
                .get();

        Document document = Jsoup.parse(response.asString());
        Element element = document.getElementById("command");
        System.out.println("The element contents are: "+element);

    }

    @Test
    public void extractLinks()
    {
        RestAssured.baseURI = "http://localhost:8085";
        Response response = given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd"))
                .when()
                .get();

        Document document = Jsoup.parse(response.asString());
        Elements links = document.select("a[href]");
        for(Element e:links)
        {
            System.out.println(e);
        }

    }

    @Test(dependsOnMethods = "login")
    public void extractEmailIds()
    {
        RestAssured.baseURI = "http://localhost:8085";
        Response response = given()
                .sessionId(sessionFilter.getSessionId())
                .when()
                .get("/student/list");

        Document document = Jsoup.parse(response.asString());
        Elements emails = document.select("table tbody tr td:nth-child(4)");
        System.out.println("Number of email ids is: "+emails.size());
        for(Element e: emails)
        {
            System.out.println(e.text());
        }

        ArrayList<String> emailIds = new ArrayList<String>();
        for(Element e:emails)
        {
            emailIds.add(e.text());
        }

        assertThat(emailIds,hasItem("eu.tellus@anuncIn.edu"));

    }
}

