package Product;

public class Product {

    private int productId;
    private String name;
    private String category;
    private double price;
    private int stock;
    private String description;

    // Constructor
    public Product(int productId, String name, String category,double price, int stock, String description) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    
    public double getPrice() {
        return price;
    }

    public boolean isInStock(int quantity) {
        return stock >= quantity;
    }


    public void displayProduct() {
        System.out.println("--------------------------------");
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: RS" + price);
        System.out.println("Stock: " + stock);
        System.out.println("Description: " + description);
        System.out.println("--------------------------------");
    }
}
