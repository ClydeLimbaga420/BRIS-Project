import java.sql.*;
import java.util.Scanner;

public class update {
    
    public static void main ( String[] args ) {

        Scanner scan = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/systemdb", "root", "clydelimbaga123");

            System.out.print("Press 1 to Update >> ");
            String update = scan.nextLine();

            if ( update.equals("1") ) {

                String updateQuery = "UPDATE residents_details SET age = TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) WHERE deceased = 0";
                PreparedStatement pstmt = con.prepareStatement(updateQuery);
                pstmt.executeUpdate();

                
        
                System.out.println("Updated Succesfully");
                
                pstmt.close();
            } else {
                System.out.println("Invalid");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }
        
    } 

}
