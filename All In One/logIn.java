import java.sql.*;
import java.util.Scanner;

public class logIn extends DatabaseConnection {
    public boolean login(Scanner scan) {
        
        try {
            sql();
            System.out.print("Enter Gmail >> ");
            String gmail = scan.nextLine();
            System.out.print("Enter Password >> ");
            String password = scan.nextLine();

            String query = "SELECT * FROM user_login WHERE gmail_account = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, gmail);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println();
                System.out.println("Login Successful");
                System.out.println();
                rs.close();
                stmt.close();
                close();
                return true;
            } else {
                System.out.println();
                System.out.println("Invalid Gmail Address or Password");
            }
            rs.close();
            stmt.close();
            close();
                  
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        return false;
    }

    public void change(Scanner scan) {

        try {
            sql();
            System.out.println("1. Change Gmail Account");
            System.out.println("2. Change Password");
            System.out.print(">> ");
            String option = scan.nextLine();

            if ( option.equals("1")) {
                System.out.print("Enter New Gmail Account >> ");
                String username = scan.nextLine();
                System.out.print("Enter Password >> ");
                String password = scan.nextLine();

                String query = "UPDATE user_login SET gmail_account = ? WHERE password = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);

                int rs = stmt.executeUpdate();
                if ( rs > 0 ) {
                    System.out.println("Succesfully Changed Gmail Account");
                } else {
                    System.out.println("Wrong Password");
                }
                stmt.close();
                close();
            } else if ( option.equals("2")) {
                System.out.print("Enter Username >> ");
                String username = scan.nextLine();
                System.out.print("Enter New Password >> ");
                String password = scan.nextLine();

                String query = "UPDATE user_login SET gmail_account = ? WHERE password = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);

                int rs = stmt.executeUpdate();
                if ( rs > 0 ) {
                    System.out.println("Succesfully Changed Password");
                } else {
                    System.out.println("Wrong Password");
                }
                stmt.close();
                close();
            } else {
                System.out.println("Invalid");
            }
                 
            
            
            
            
            
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        
    }
}



