package DB;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDb {
        public static Connection connect(){
              final String URL = "MyCloudUrl";     
        final String USER = "userName";
        final String PASSWORD = "my_password";

        Connection con = null;

        try {  
    con = DriverManager.getConnection(URL, USER, PASSWORD);
}  catch (SQLException e) {
    System.out.println("Db connecton failed");
}

return con;
        }
}
