package pojos;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderStatusUpdateRequest {
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private OrderStatusUpdate[] statusUpdate;

    public OrderStatusUpdate[] getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(OrderStatusUpdate[] statusUpdate) {
        this.statusUpdate = statusUpdate;
    }
}
