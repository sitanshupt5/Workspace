package otherapplications;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CalculatorSoapApp {

    @Test(description = "Add two numbers using Soap request")
    public void calculateAdditon()
    {
        String wsdlUrl = "http://www.dneonline.com/calculator.asmx?wsdl";
        String payLoad = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tem:Add>\n" +
                "         <tem:intA>10</tem:intA>\n" +
                "         <tem:intB>15</tem:intB>\n" +
                "      </tem:Add>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        RestAssured.given()
                .contentType("text/xml")
                .body(payLoad)
                .log().all(true)
                .when()
                .post(wsdlUrl)
                .then()
                .log().all(true);
    }
}
