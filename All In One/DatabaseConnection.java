import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    protected Connection con;

    public void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3307/systemdb",  
            "root",                          
        "clydelimbaga123"                         
        );
    }

    public void close() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
