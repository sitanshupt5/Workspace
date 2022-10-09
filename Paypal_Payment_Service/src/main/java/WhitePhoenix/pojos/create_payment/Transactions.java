package WhitePhoenix.pojos.create_payment;

public class Transactions {
    private String description;
    private String custom;
    private String invoice_number;
    private String soft_descriptor;

    private PaymentOptions payment_options;
    private Item_List item_list;
    private Transaction_Amount amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getSoft_descriptor() {
        return soft_descriptor;
    }

    public void setSoft_descriptor(String soft_descriptor) {
        this.soft_descriptor = soft_descriptor;
    }

    public PaymentOptions getPayment_options() {
        return payment_options;
    }

    public void setPayment_options(PaymentOptions payment_options) {
        this.payment_options = payment_options;
    }

    public Item_List getItem_list() {
        return item_list;
    }

    public void setItem_list(Item_List item_list) {
        this.item_list = item_list;
    }

    public Transaction_Amount getAmount() {
        return amount;
    }

    public void setAmount(Transaction_Amount amount) {
        this.amount = amount;
    }
}
