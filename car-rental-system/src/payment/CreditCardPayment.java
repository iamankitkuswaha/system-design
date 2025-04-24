package payment;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount) {
        System.out.println(amount+ " paid successfully!!");
        return true;
    }
}
