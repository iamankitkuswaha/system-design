package service;

import entity.Customer;
import repository.InMemoryRepository;

import java.util.Map;

public class CustomerService {
    private Map<String, Customer> customerMap;

    public CustomerService(InMemoryRepository inMemoryRepository){
        customerMap = inMemoryRepository.getCustomerMap();
    }

    public void addCustomer(Customer customer){
        customerMap.put(customer.getId(), customer);
        System.out.println(customer.getName() +" added successfully!!");
    }

    public void removeCustomer(String customerId){
        if(customerMap.containsKey(customerId)){
            customerMap.remove(customerId);
            System.out.println(customerId+" removed successfully!!");
        }else{
            System.out.println(customerId+" is not present!!");
        }
    }

    public Customer getCustomer(String customerId){
        if(customerMap.containsKey(customerId)){
            return customerMap.get(customerId);
        }else{
            System.out.println(customerId+" is not present!!");
            return null;
        }
    }
}
