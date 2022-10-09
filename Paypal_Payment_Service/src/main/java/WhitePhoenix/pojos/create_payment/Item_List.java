package WhitePhoenix.pojos.create_payment;

import java.util.List;

public class Item_List {
    private List<Items> items;
    private ShippingAddress shipping_address;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public ShippingAddress getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(ShippingAddress shipping_address) {
        this.shipping_address = shipping_address;
    }
}
