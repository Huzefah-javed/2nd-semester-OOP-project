import java.util.Scanner;

import Users.*;
import Store.Store;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Authentication auth = new Authentication();

        while (true) {
            
            System.out.println("Welcome to Smart Store System");
            System.out.println("1. Employee Login");
        System.out.println("2. Customer Login");
        System.out.println("3. Browse as Guest");
        System.out.print("Choice: ");

        int choice = sc.nextInt();
        sc.nextLine();
        
        if (choice == 1) {
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();
            System.out.println("Loading....");
            boolean isLoginSuccessFul = auth.employeeAuth(email, pass);
            
            if (!isLoginSuccessFul) {
                System.out.println("Invalid Employee Credentials");
                continue;
            }
            
            System.out.println("Welcome Employee: " + Authentication.getRegisteredEmployee().getName());
            Authentication.getRegisteredEmployee().showMenu(sc);
        }
        
        else if (choice == 2) {
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();
            
            System.out.println("Loading....");
            boolean isLoginSuccessFul = auth.customerAuth(email, pass);
            
            if (!isLoginSuccessFul) {
                System.out.println("Invalid Customer Credentials");
                continue;
            }
            System.out.println("Welcome Customer: " + Authentication.getRegisteredCustomer().getName());
            Authentication.getRegisteredCustomer().showMenu(sc);
        }else if (choice == 3) {
            
            System.out.println("Loading....");
            Store store = new Store();
            
            store.showProducts();
            System.out.print("0 to back: ");
            int pid = sc.nextInt();
            
            if (pid == 0) continue;
            
        }else{
            sc.close();
            break;
        }
    }
}
    
   }
