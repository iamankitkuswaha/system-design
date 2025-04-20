package expansesplitstrategy;

import entity.User;

public class EqualExpenseSplitStrategy extends Split {
    public EqualExpenseSplitStrategy(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmaount(double amount){
        this.amount = amount;
    }

}
