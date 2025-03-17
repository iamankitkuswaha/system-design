package service;

import entity.Product;
import repository.InMemoryRepository;

public class ProductService {

    public ProductService(){
    }
    public void createProduct(String productld, String name, int count){
        InMemoryRepository.productMap.put(productld, new Product(productld, name, count));
        System.out.println("Product "+name+" added successfully");
    }

    public int getInventory(String productId){
        if(InMemoryRepository.productMap.containsKey(productId))
                return InMemoryRepository.productMap.get(productId).getProductCount();
        return 0;
    }

    public void updateProductInventory(String productId, int orderdedQuantity){
        if(InMemoryRepository.productMap.containsKey(productId)){
            Product product =  InMemoryRepository.productMap.get(productId);
            product.setProductCount(product.getProductCount()-orderdedQuantity);
            InMemoryRepository.productMap.put(productId, product);
        }
        else{
            System.out.println("Product with product id: "+productId+" is not present");
        }
    }
//
//    public List<entity.Product> getProductList(){
//        return productList;
//    }
}
