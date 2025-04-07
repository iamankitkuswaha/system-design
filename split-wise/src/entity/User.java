package entity;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private final String id;
    private String name;
//    private BalanceSheet balanceSheet;
    private Map<String, Double>balanceSheetMap;
    public User(String id, String name){
        this.id = id;
        this.name = name;
//        this.balanceSheet = balanceSheet;
        balanceSheetMap = new ConcurrentHashMap<>();
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

//    public BalanceSheet getBalanceSheet() {
//        return balanceSheet;
//    }

//    public void setBalanceSheet(BalanceSheet balanceSheet) {
//        this.balanceSheet = balanceSheet;
//    }

    public Map<String, Double> getBalanceSheetMap(){
        return balanceSheetMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
