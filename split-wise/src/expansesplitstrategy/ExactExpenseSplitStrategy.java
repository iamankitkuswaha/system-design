package expansesplitstrategy;

import entity.User;

public class ExactExpenseSplitStrategy extends Split {

    private final double amount;

    public ExactExpenseSplitStrategy(User user, double amount){
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
