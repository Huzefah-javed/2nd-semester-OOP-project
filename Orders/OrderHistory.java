package Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB.ConnectionDb;
import Product.Product;
import Users.Authentication;

public class OrderHistory {
    private ArrayList<OrderItem> items;
    private double totalAmount;

    public OrderHistory() {
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }


    public void setHistory(Product product, int quantity) {
            OrderItem item = new OrderItem(product, quantity);
            items.add(item);
            totalAmount += item.getTotalPrice();
    }

    public void showOrderHistory() {
        System.out.println("<<<====Order History===>>>");
        for (OrderItem item : items) {
            System.out.println(
                item.getProduct().getName() +
                " x " + item.getQuantity() +
                " = Rs." + item.getTotalPrice()
            );
        }
        System.out.println("Total Bill: Rs." + totalAmount);
    }
    
    public void getOrderHistory(){
             try {
                        Connection  con = ConnectionDb.connect();
                        Statement stmt =  con.createStatement();

                        String query  = "select \n" + //
                                        "    ord.productId,\n" + //
                                        "    ord.quantity,\n" + //
                                        "    p.name,\n" + //
                                        "    p.category,\n" + //
                                        "    p.price,\n" + //
                                        "    p.stock,\n" + //
                                        "    p.description\n" + //
                                        "from orderDetails as ord\n" + //
                                        "left  join products as p\n" + 
                                        "on ord.productId = p.productId\n" + //
                                        "where ord.customerId = "+ Authentication.getRegisteredCustomer().getId();
                            ResultSet result = stmt.executeQuery(query);

                            while (result.next()) {
                                int product_id = result.getInt("productId");
                                double price = result.getDouble("price");
                                int stock = result.getInt("stock");
                                int quantity = result.getInt("quantity");
                                String name = result.getString("name");
                                String category = result.getString("category");
                                String description= result.getString("description");


                                Product p = new Product(product_id, name, category,price, stock, description);
                                        setHistory(p, quantity);
            
            }
    } catch (Exception e) {
                             System.out.print("Issue happens while loading order history");
    }
    }
}
