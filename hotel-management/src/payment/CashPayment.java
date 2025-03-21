package payment;

public class CashPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Received payment in cash");
        return true;
    }
}
