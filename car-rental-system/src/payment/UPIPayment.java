package payment;

public class UPIPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount) {
        System.out.println(amount+" paid by upi!!");
        return true;
    }
}
