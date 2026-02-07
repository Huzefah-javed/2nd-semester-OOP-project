package Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.ConnectionDb;

public class Authentication {
     static private Customer registeredCustomer;
     static private Employee registeredEmployee;


 public boolean customerAuth(String email,String pass){
    try {
        Connection  con = ConnectionDb.connect();

        String query  = "Select * from users where email = ? AND password = ? And role = 'customer'";
            
                PreparedStatement pr = con.prepareStatement(query);
        
        pr.setString(1, email);
        pr.setString(2, pass);
        
        ResultSet rs = pr.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String userName = rs.getString("name");
            String userEmail = rs.getString("email");
            String password = rs.getString("password");
           registeredCustomer = new Customer(id, userName, userEmail,  password);
           return true;
        }else{
            System.out.println("Invalid email or password");
            registeredCustomer = null;
            return false;
        }
        
    } catch (Exception e) {
        System.out.println("Failed to authenticate customer");
        return false;
    }
}

public boolean employeeAuth(String email,String pass){
    try {
        Connection  con = ConnectionDb.connect();
        
        String query  = "Select * from users where email = ? AND password = ? And role = 'employee'";
            
                PreparedStatement pr = con.prepareStatement(query);
        
        pr.setString(1, email);
        pr.setString(2, pass);
        
        ResultSet rs = pr.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("id");
            String userName = rs.getString("name");
            String userEmail = rs.getString("email");
            String password = rs.getString("password");
           registeredEmployee = new Employee(id, userName, userEmail,  password);
           return true;
        }else{
            System.out.println("Invalid email or password");
            registeredEmployee = null;
            return false;
        }
        
    } catch (Exception e) {
        System.out.println("Failed to authenticate Employee");
        return false;
      }
}

static public Customer getRegisteredCustomer(){
            return registeredCustomer;
}
static public Employee getRegisteredEmployee(){
            return registeredEmployee;
}
}