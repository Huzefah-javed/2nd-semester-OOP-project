package Users;

import java.util.ArrayList;
import java.util.Scanner;

import Orders.OrderHistory;
import Orders.OrderItem;
import Orders.PlaceOrder;
import Payments.CardPayment;
import Payments.CashPayment;
import Payments.Payment;
import Product.Product;
import Store.Store;

public class Customer extends Person {

    public Customer(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void showMenu(Scanner sc) {
         while (true) {
                System.out.println("Welcome Customer: " + getName());
                System.out.println("1: check OrderHistory: ");
                System.out.println("2: browse store");
                System.out.println("3. Logout");
                System.out.print("enter choice : ");
                
                int cusChoice  = sc.nextInt();
                
                if (cusChoice == 1) {
                    System.out.println("Loading....");
                    OrderHistory ordHis = new OrderHistory();
                    ordHis.getOrderHistory();
                    ordHis.showOrderHistory();
                }else if (cusChoice == 2) {
                    System.out.println("Loading....");
                    Store store = new Store();
                    PlaceOrder placeOrd= new PlaceOrder();
                    while (true) {
                        store.showProducts();    
                        System.out.print("Enter Product ID (0 to checkout): ");
                        int pid = sc.nextInt();
                        
                        if (pid == 0) break;
                        
                        Product p = store.getProductById(pid);
                        if (p == null) {
                            System.out.println("Invalid Product ID");
                            continue;
                        }
                        
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        placeOrd.addToCart(p, qty);
                    }
                    ArrayList<OrderItem> ordItems = placeOrd.getOrders();
                    if (!ordItems.isEmpty()) {
                        System.out.println("Payment Method:");
                        System.out.println("1. Cash");
                        System.out.println("2. Card");
                        int payChoice = sc.nextInt();
                        Payment payment = (payChoice == 1) ? new CashPayment(): new CardPayment();
                        store.checkout(placeOrd, payment);
                        System.out.println("Loading....");
                        placeOrd.placeMyOrder(id);
                    }
        }else {
             break;       
                }
                
            }
        }
        }