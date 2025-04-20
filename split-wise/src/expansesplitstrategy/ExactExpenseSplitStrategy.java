package expansesplitstrategy;

import entity.User;

public class ExactExpenseSplitStrategy extends Split {

    public ExactExpenseSplitStrategy(User user){
        super(user);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }
}
