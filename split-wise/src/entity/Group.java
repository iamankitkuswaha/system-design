package entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final String id;
    private String name;
    private List<User> groupMembers;
    private List<Expense> expensesList;

    public Group(String id, String name){
        this.id = id;
        this.name = name;
        groupMembers = new ArrayList<>();
        expensesList =  new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<User> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public List<Expense> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expense> expensesList) {
        this.expensesList = expensesList;
    }
}
