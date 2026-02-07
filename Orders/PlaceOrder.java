package Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DB.ConnectionDb;
import Product.Product;

public class PlaceOrder {

    private ArrayList<OrderItem> items;
    private double totalAmount;

    public PlaceOrder() {
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addToCart(Product product, int quantity) {
        if (product.isInStock(quantity)) {
            OrderItem item = new OrderItem(product, quantity);
            items.add(item);
            totalAmount += item.getTotalPrice();
            System.out.println("Product added to order.");
        } else {
            System.out.println("Not enough stock!");
        }
    }


    public void placeMyOrder(int cusId) {
    String sql = "INSERT INTO orderDetails (customerId, productId, quantity) VALUES (?, ?, ?)";

    try {
        Connection con = ConnectionDb.connect();
         PreparedStatement ps = con.prepareStatement(sql);

        for (OrderItem orderItem : items) {
            ps.setInt(1, cusId);
            ps.setInt(2, orderItem.getProduct().getProductId());
            ps.setInt(3, orderItem.getQuantity());

            ps.executeUpdate(); 
        }

        System.out.println("Order placed successfully");

    } catch (Exception e) {
        System.out.println("Issue happens while placing order");
    }
}



    public void showOrder() {
        System.out.println("==========Orders==========");
        for (OrderItem item : items) {
            System.out.println(
                item.getProduct().getName() +
                " x " + item.getQuantity() +
                " = Rs." + item.getTotalPrice()
            );
        }
        System.out.println("Total Bill: Rs." + totalAmount);
    }

    public ArrayList<OrderItem> getOrders(){
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}