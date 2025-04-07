package expansesplitstrategy;

import entity.User;

public class EqualExpenseSplitStrategy extends Split {
    private double amount;
    public EqualExpenseSplitStrategy(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
