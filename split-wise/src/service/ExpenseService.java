package service;

import com.sun.security.jgss.GSSUtil;
import entity.Expense;
import repository.InMemoryRepository;

public class ExpenseService {
    public void createExpense(Expense expense){
        if(expense!=null)
            InMemoryRepository.expenseMap.put(expense.getId(), expense);
        else
            System.out.println("Expense can not be created!!!");
    }
}
