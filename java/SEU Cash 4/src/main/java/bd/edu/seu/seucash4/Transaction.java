package bd.edu.seu.seucash4;

public class Transaction {
    private String mobileNumber;
    private double amount;
    private String type;

    public Transaction(String mobileNumber, double amount, String type) {
        this.mobileNumber = mobileNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
