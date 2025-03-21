package payment;

public class UPIPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Received "+amount+" rupees by upi!!!");
        return true;
    }
}
