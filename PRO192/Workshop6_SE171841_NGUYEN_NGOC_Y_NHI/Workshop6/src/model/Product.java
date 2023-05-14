
package model;


public class Product {
    private String id;
    private String name;
    private double price;
    private int amountOfProducts;
    

    public Product() {
        
    }

    public Product(String id, String name, double price, int amountOfProducts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amountOfProducts = amountOfProducts;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getAmountOfProducts() {
        return amountOfProducts;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", price=" + price + ", amountOfProducts=" + amountOfProducts;
    }
    
    

    
    
    
    
    
    
}
