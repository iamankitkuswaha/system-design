package service;

import entity.Order;
import payment.UPIPaymentStrategy;
import payment.PaymentStrategy;
import repository.InMemoryRepository;

import java.util.List;
public class OrderService {
    private PaymentStrategy paymentStrategy;
    private ProductService productService;
    public OrderService(){
        paymentStrategy = new UPIPaymentStrategy();
        productService =  new ProductService();
    }
    public void createOrder(List<String> productIds, List<Integer> quantityOfProducts, String orderId){
        InMemoryRepository.orderMap.put(orderId, new Order(orderId, productIds, quantityOfProducts));
        System.out.println("Order created successfully");
    }

    public void confirmOrder(String orderld){
        if(paymentStrategy.processPayment()){
            System.out.println("Order confirmed");
            if(InMemoryRepository.orderMap.containsKey(orderld)) {
                List<String> products = InMemoryRepository.orderMap.get(orderld).getProductList();
                List<Integer> orderedQuantity = InMemoryRepository.orderMap.get(orderld).getQuantityOfProduct();
                for (String id : products) {
                    productService.updateProductInventory(id, orderedQuantity.get(Integer.valueOf(id)));
                }
            }
        }
    }
}
