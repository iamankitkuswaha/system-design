package payment;

import payment.PaymentStrategy;

public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment() {
        System.out.println("payment successfully done");
        return true;
    }
}
