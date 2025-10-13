import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class logIn extends DatabaseConnection {
    public boolean login(Scanner scan) {
        try {
            connect();
            System.out.print("Enter Username >> ");
            String username = scan.nextLine();
            System.out.print("Enter Password >> ");
            String password = scan.nextLine();

            String query = "SELECT * FROM user_login WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\nLogin Successful");
                System.out.println();
                rs.close();
                stmt.close();
                close();
                return true;
            } else {
                System.out.println("\nInvalid Username or Password");
            }

            rs.close();
            stmt.close();
            close();

        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        return false;
    }
}


