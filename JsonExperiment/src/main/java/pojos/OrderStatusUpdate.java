package pojos;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "env_name",
        "order_id",
        "res_nbr",
        "order_status"
})
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class OrderStatusUpdate {

    @JsonProperty("env_name")
    private String envName;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("res_nbr")
    private String resNbr;
    @JsonProperty("order_status")
    private OrderStatus orderStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("env_name")
    public String getEnvName() {
        return envName;
    }

    @JsonProperty("env_name")
    public void setEnvName(String envName) {
        this.envName = envName;
    }

    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("res_nbr")
    public String getResNbr() {
        return resNbr;
    }

    @JsonProperty("res_nbr")
    public void setResNbr(String resNbr) {
        this.resNbr = resNbr;
    }

    @JsonProperty("order_status")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @JsonProperty("order_status")
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
