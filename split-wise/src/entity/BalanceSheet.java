package entity;

public class BalanceSheet {

    private final String id;
    private double totalAmountYouPaid;
    private double amountYouOwe;
    private double amountYouGetBack;

    public BalanceSheet(String id, double totalAmountYouPaid, double amountYouOwe, double amountYouGetBack) {
        this.totalAmountYouPaid = totalAmountYouPaid;
        this.amountYouOwe = amountYouOwe;
        this.amountYouGetBack = amountYouGetBack;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double gettotalAmountYouPaid() {
        return totalAmountYouPaid;
    }

    public void settotalAmountYouPaid(double totalAmountYouPaid) {
        this.totalAmountYouPaid = totalAmountYouPaid;
    }

    public double getAmountYouOwe() {
        return amountYouOwe;
    }

    public void setAmountYouOwe(double amountYouOwe) {
        this.amountYouOwe = amountYouOwe;
    }

    public double getamountYouGetBack() {
        return amountYouGetBack;
    }

    public void setamountYouGetBack(double amountYouGetBack) {
        this.amountYouGetBack = amountYouGetBack;
    }
}
