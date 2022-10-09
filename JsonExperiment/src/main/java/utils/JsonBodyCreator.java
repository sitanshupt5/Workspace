package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pojos.OrderStatus;
import pojos.OrderStatusUpdate;
import pojos.OrderStatusUpdateRequest;
import pojos.Shipment;

import static io.restassured.RestAssured.given;

public class JsonBodyCreator {

    public OrderStatusUpdate[] createJsonBody() throws JsonProcessingException {
        Shipment shipment = new Shipment();
        shipment.setBrand("MCOM");
        shipment.setStatus("BACKORDER_RESPONSE");
        shipment.setLineNbr("1");
        shipment.setNoteType("275");
        shipment.setDate("12/31/2025");
        shipment.setOldExpShpDate("12/15/2025");
        shipment.setNewExpShpDate("12/31/2025");
        shipment.setAdjExpShpDate("12/10/2025");

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setShipment(shipment);


        OrderStatusUpdate[] statusUpdates = new OrderStatusUpdate[1];
        statusUpdates[0] = new OrderStatusUpdate();
        statusUpdates[0].setOrderStatus(orderStatus);
        statusUpdates[0].setOrderId("1234567890");
        statusUpdates[0].setEnvName("mcom-068");



        return statusUpdates;
    }

    @Test
    public void testcase1() throws JsonProcessingException {
        JSONObject object = new JSONObject(createJsonBody());
        System.out.println(object.toString());
        RestAssured.baseURI = "https://localhost:8080";
        ValidatableResponse response=given()
                .header("Content-Type", ContentType.JSON)
                .body(createJsonBody())
                .log().all()
                .when()
                .post()
                .then();
    }

}
