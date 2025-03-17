package entity;

import java.util.List;


public class Order {
    private String orderId;
    private List<String>productList;
    private List<Integer>quantityOfProduct;

    public Order(String orderId, List<String>productList, List<Integer>quantityOfProduct){
        this.orderId = orderId;
        this.productList = productList;
        this.quantityOfProduct = quantityOfProduct;
    }
    public String getOrderId() {
        return orderId;
    }


    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public List<Integer> getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(List<Integer> quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }
}
