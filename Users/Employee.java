package Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import DB.ConnectionDb;

public class Employee extends Person {

    public Employee(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    

    public void showMenu(Scanner sc) {
        while (true) {   
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2.Add Stock");
            System.out.println("2.Decrease Stock");
            System.out.println("4. Logout");
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 4) {
                break;
            }
            if (choice == 1) {
                try {
                    System.out.println("Loading.....");
                    Connection con = ConnectionDb.connect();
                    String sql = "INSERT INTO products (name, category, price, stock, description)\n" + //
                    "VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pr = con.prepareStatement(sql);
                    System.out.print("Enter product Name: ");
                    String productName =  sc.nextLine();
                    System.out.print("Enter product category: ");
                    String productCategory =  sc.nextLine();
                    System.out.print("Enter product Description: ");
                    String productDescription =  sc.nextLine();
                    System.out.print("Enter product price: ");
                    double productPrice =  sc.nextDouble();
                    System.out.print("Enter product stock: ");
                    int productStock =  sc.nextInt();
                    
                    pr.setString(1, productName);
                    pr.setString(2, productCategory);
                    pr.setDouble(3, productPrice);
                    pr.setInt(4, productStock);
                    pr.setString(5, productDescription);
                    
                    pr.executeUpdate();
                    System.out.print("Product added successfully");
                    con.close();
                } catch (Exception e) {
                    System.out.print(e);
                }
            }else if (choice == 2){ 
                try {
                    System.out.println("Loading.....");
                    Connection con = ConnectionDb.connect();
                    String sql = "update products \n" + //
                    "set stock = stock + ?\n" + //
                    "where productId = ?";
                    
                    PreparedStatement pr = con.prepareStatement(sql);
                    
                    System.out.print("Enter product Id: ");
                    int productId = sc.nextInt();
                    System.out.print("Enter addition stock for product: ");
                    int additionalStock = sc.nextInt();
                    
                    pr.setInt(1, additionalStock);
                    pr.setInt(2, productId);
                    
                    pr.executeUpdate();
                    System.out.print("Stock updated successfully");
                } catch (Exception e) {
                    System.out.println("There is error came out while updating stock");
                    System.out.println(e);
                }
                
            }else if (choice == 3){ 
                try {
                    System.out.println("Loading.....");
                    Connection con = ConnectionDb.connect();
                    String sql = "update products \n" + //
                    "set stock = stock - ?\n" + //
                    "where productId = ?";
                    
                    PreparedStatement pr = con.prepareStatement(sql);
                    
                    System.out.print("Enter product Id: ");
                    int productId = sc.nextInt();
                    System.out.print("Enter addition stock for product: ");
                    int additionalStock = sc.nextInt();
                    
                    pr.setInt(1, additionalStock);
                    pr.setInt(2, productId);
                    
                    pr.executeUpdate();
                    System.out.print("Stock updated successfully");
                } catch (Exception e) {
                    System.out.println("There is error came out while updating stock");
                  }
                
            }else{
                System.out.print("----Plz enter valid input---");
                continue;   
            }
        }
    }
}
