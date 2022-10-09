package WhitePhoenix.pojos.create_payment;

public class Transaction_Amount {
    private String total;
    private String currency;
    private Transaction_Details details;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Transaction_Details getDetails() {
        return details;
    }

    public void setDetails(Transaction_Details details) {
        this.details = details;
    }

}
