import entity.Expense;
import entity.Group;
import entity.User;
import expansesplitstrategy.EqualExpenseSplitStrategy;
import expansesplitstrategy.PercentageExpenseSplitStrategy;
import service.SpliteWiseService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SplitWiseApplication {
    public static void main(String[] args) {
        SpliteWiseService spliteWiseService = SpliteWiseService.getInstance();

        System.out.println("\n---------------------------------------------");
        // create users
        User user1 = new User("1","Aditya");
        User user2 = new User("2","Abhimanyu");
        User user3 = new User("3","Arjun");
        User user4 = new User("4","Abhi");
        // add users
        spliteWiseService.addUser(user1);
        spliteWiseService.addUser(user2);
        spliteWiseService.addUser(user3);
        spliteWiseService.addUser(user4);

        // create a group
        Group group1 = new Group("G1","College");
        Group group2 = new Group("G2","Hostel");
        spliteWiseService.addGroup(group1);
        spliteWiseService.addGroup(group2);
        spliteWiseService.addMemberToGroup("G1",user1);
        spliteWiseService.addMemberToGroup("G1",user2);
        spliteWiseService.addMemberToGroup("G2",user3);
        spliteWiseService.addMemberToGroup("G2",user4);

        // create expense
        Expense expense1 = new Expense("E1","Movie Ticket",600, user1);
        Expense expense2 = new Expense("E2","Dinner",600, user3);
        EqualExpenseSplitStrategy equalSplit1 = new EqualExpenseSplitStrategy(user1);
        EqualExpenseSplitStrategy equalSplit2 = new EqualExpenseSplitStrategy(user2);
        PercentageExpenseSplitStrategy perSplit1 = new PercentageExpenseSplitStrategy(user3, 20.0);
        PercentageExpenseSplitStrategy perSplit2 = new PercentageExpenseSplitStrategy(user4, 80.0);
        // add splits to expense
        expense1.setSplits(new ArrayList<>(List.of(equalSplit1,equalSplit2)));
        expense2.setSplits(new ArrayList<>(List.of(perSplit1,perSplit2)));

        // add expense to the group
        spliteWiseService.addExpense("G1", expense1);
        spliteWiseService.addExpense("G2",expense2);

        System.out.println("\n---------------------------------------------");
        spliteWiseService.settleAmount("1","2");

        System.out.println("\n---------------------------------------------");
        for (User user : Arrays.asList(user1, user2, user3, user4)) {
            System.out.println("User: " + user.getName());
            for (Map.Entry<String, Double> entry : user.getBalanceSheetMap().entrySet()) {
                System.out.println("  Balance with " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}