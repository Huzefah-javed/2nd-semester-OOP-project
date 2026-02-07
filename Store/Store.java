package Store;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import Product.Product;
import Orders.PlaceOrder;
import Payments.*;
import DB.ConnectionDb;

public class Store {

    private ArrayList<Product> products;

    public Store() {
        products = new ArrayList<>();
        loadProducts();
    }

    private void loadProducts() {
         try {
             
             Connection con = ConnectionDb.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            while (rs.next()) {
               
                   int pID =  rs.getInt("productId") ;
                   int pStock =  rs.getInt("stock") ;
                   String pName = rs.getString("name"); 
                   String pDescription = rs.getString("description"); 
                   String pCategory = rs.getString("category");
                   double pPrice =  rs.getDouble("price");

                 products.add(new Product(pID, pName, pCategory, pPrice, pStock, pDescription));
                
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Got some errors while loading products");
        }
    }
    
    public void showProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            p.displayProduct();
        }
    }

    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getProductId() == id)
                return p;
        }
        return null;
    }

    public void checkout(PlaceOrder order, Payment payment) {
        order.showOrder();
        boolean success = payment.pay(order.getTotalAmount());
        if (success) {
            System.out.println("Order completed successfully!");
        }
    }
}
