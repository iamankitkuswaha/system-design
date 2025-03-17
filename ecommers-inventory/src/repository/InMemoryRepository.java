package repository;

import entity.Order;
import entity.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository {
    public static Map<String, Product>productMap;
    public static Map<String, Order>orderMap;
    public InMemoryRepository(){
        productMap = new ConcurrentHashMap<>();
        orderMap =  new ConcurrentHashMap<>();
    }
}
