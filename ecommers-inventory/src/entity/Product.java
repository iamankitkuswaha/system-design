package entity;

public class Product {
    private String productId;
    private String productName;
    private int productCount;


    public Product(String productId, String productName, int productCount){
        this.productId = productId;
        this.productName = productName;
        this.productCount = productCount;
    }
    public String getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }


    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

}
