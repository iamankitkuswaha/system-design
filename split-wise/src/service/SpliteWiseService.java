package service;

import entity.Expense;
import entity.Group;
import entity.User;
import expansesplitstrategy.EqualExpenseSplitStrategy;
import expansesplitstrategy.PercentageExpenseSplitStrategy;
import expansesplitstrategy.Split;
import repository.InMemoryRepository;

import java.util.List;

public class SpliteWiseService {
    private static SpliteWiseService spliteWiseService;
    private GroupService groupService;
    private UserService userService;
    private ExpenseService expenseService;
    private SpliteWiseService(){
    }
    public static synchronized SpliteWiseService getInstance(){
        if(spliteWiseService == null)
            return new SpliteWiseService();
        return spliteWiseService;
    }

    public void addExpense(String groupId, Expense expense){
        Group group = InMemoryRepository.groupMap.get(groupId);
        if(group!=null){
            groupService.addExpenseToGroup(groupId, expense);
            spliteExpense(expense);
        }
    }

    private void spliteExpense(Expense expense){
        double totalExpense  = expense.getExpenseAmount();
        List<Split> splits =  expense.getSplits();
        int splitSize = splits.size();
        double splitAmount = totalExpense/splitSize;

        for(Split split : splits){
            if(split instanceof EqualExpenseSplitStrategy){
                split.setAmount(splitAmount);
            }else if(split instanceof PercentageExpenseSplitStrategy percentageExpenseSplitStrategy){
                split.setAmount(totalExpense*percentageExpenseSplitStrategy.getPercent()/100.0);
            }
        }
    }

    private void updateBalance(Expense expense){
        List<Split> splits = expense.getSplits();
        for(Split split : splits){
            User paidByUser = expense.getPaidBy();
            User user = split.getUser();
            double splitAmount = split.getAmount();
            if(!paidByUser.equals(user)){
                updateBalance(paidByUser, user, splitAmount);
                updateBalance(user, paidByUser, -splitAmount);
            }
        }
    }

    // id1_id2 : 250 -- means user1 will 250 from user2
    // id2_id1: -250 -- means user2 will pay 250 to user1
    private void updateBalance(User user1, User user2, double splitAmount){
        String key = getBalanceKey(user1, user2);
        user1.getBalanceSheetMap().put(key, user1.getBalanceSheetMap().getOrDefault(key, 0.0) + splitAmount);
    }

    private String getBalanceKey(User user1, User user2){
        return user1.getId()+"_"+user2.getId();
    }

    public void settleAmount(String userId1, User userId2){
        User user1 = InMemoryRepository.userMap.get(userId1);
        User user2 = InMemoryRepository.userMap.get(userId2);
        if(user1 != null && user2 != null){
            String key = getBalanceKey(user1, user2);
            double balance = user1.getBalanceSheetMap().getOrDefault(key,0.0);
            if(balance>0){
                // Payment
                System.out.println(user2.getName()+" paid "+balance+" to "+user1.getName());
                user1.getBalanceSheetMap().put(key,0.0);
                user2.getBalanceSheetMap().put(getBalanceKey(user2,user1),0.0);
            }else if(balance<0){
                // Payment
                System.out.println(user1.getName()+" paid "+balance+" to "+user2.getName());
                user1.getBalanceSheetMap().put(key,0.0);
                user2.getBalanceSheetMap().put(getBalanceKey(user2,user1),0.0);
            }
        }
    }
}
