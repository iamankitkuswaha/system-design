import repository.InMemoryRepository;
import service.OrderService;
import service.ProductService;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InMemoryRepository memoryRepository = new InMemoryRepository();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        productService.createProduct("0","P0",5);
        productService.createProduct("1","P1",10);
        productService.createProduct("2","p2",4);

        // ordered product
        List<String>productIds = Arrays.asList("0","1","2");
        List<Integer>productCount = Arrays.asList(2,3,1);

        System.out.println("___________ product inventory _______");
        System.out.println("P0 "+productService.getInventory("0"));
        System.out.println("P1 "+productService.getInventory("1"));
        System.out.println("P2 "+productService.getInventory("2"));

        System.out.println("_____________________ create order _________");
        orderService.createOrder(productIds, productCount, "1" );

        System.out.println("_____________ Confirm order _________");
        orderService.confirmOrder("1");

        System.out.println("___________ product inventory after order _______");
        System.out.println("P0 "+productService.getInventory("0"));
        System.out.println("P1 "+productService.getInventory("1"));
        System.out.println("P2 "+productService.getInventory("2"));

    }
}