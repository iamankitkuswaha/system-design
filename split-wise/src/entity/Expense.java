package entity;

import expansesplitstrategy.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expense {
    private final String id;
    private String description;
    private final double expenseAmount;
    private final User paidBy;
    private ExpenseSplitType splitType;
    private  List<Split> splits;
    public Expense(String id, String description, double expenseAmount, User paidBy) {
        this.id = id;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidBy = paidBy;
//        this.splits = splits;
//        this.splitType = splitType;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(ArrayList<Split> splits){
        this.splits = new ArrayList<>(splits);
    }

    public ExpenseSplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(ExpenseSplitType splitType) {
        this.splitType = splitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return id.equals(expense.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
