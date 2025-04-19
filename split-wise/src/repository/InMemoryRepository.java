package repository;

import entity.Expense;
import entity.Group;
import entity.User;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository {
    public static  Map<String, User> userMap;
    public static Map<String, Group> groupMap;
    public static Map<String, Expense> expenseMap;
    public static Map<String, Double> balanceSheetMap;

    public InMemoryRepository(){
        userMap =  new ConcurrentHashMap<>();
        groupMap = new ConcurrentHashMap<>();
        expenseMap = new ConcurrentHashMap<>();
        balanceSheetMap =  new ConcurrentHashMap<>();
    }
}
