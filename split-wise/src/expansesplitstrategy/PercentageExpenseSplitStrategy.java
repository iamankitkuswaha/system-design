package expansesplitstrategy;

import entity.User;

public class PercentageExpenseSplitStrategy extends Split {
    private final double percent;
    public PercentageExpenseSplitStrategy(User user, double percent){
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
