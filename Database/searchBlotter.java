import java.sql.*;
import java.util.Scanner;

public class searchBlotter {
    
    public static void main ( String[] args ) {
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        int count = 0;
        String times;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/systemdb","root","clydelimbaga123");

            System.out.println("See How Many Blotters the Respondent received by Searching");
            System.out.println();
            System.out.print("Enter First Name >> ");
            String firstName = scan.nextLine();
            System.out.print("Enter Middle Name ( Type None If None ) >> ");
            String middleName = scan.nextLine();
            System.out.print("Enter Last Name >> ");
            String lastName = scan.nextLine();

            String search = "SELECT * FROM blotter WHERE blottered_first_name = ? AND blottered_middle_name = ? AND blottered_last_name = ? ";
            PreparedStatement pstmt = con.prepareStatement(search);
            pstmt.setString(1, firstName);
            pstmt.setString(2, middleName);
            pstmt.setString(3, lastName);


            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                found = true;
                System.out.println();
                if ( rs.getString("blottered_middle_name").equalsIgnoreCase("None") ) {
                    System.out.println("Name of the Respondent Complained: " + rs.getString("blottered_first_name") + " " + rs.getString("blottered_last_name"));
                } else {
                System.out.println("Name of the Respondent Complained: " + rs.getString("blottered_first_name") + " " + rs.getString("blottered_middle_name") + " " + rs.getString("blottered_last_name"));
                }
                if ( rs.getString("complainant_middle_name").equals("None")) {
                    System.out.println("Name of Complainant: " + rs.getString("complainant_first_name") + " " + rs.getString("complainant_last_name"));
                
                } else {
                System.out.println("Name of Complainant: " + rs.getString("complainant_first_name") + " " + rs.getString("complainant_middle_name") + " " + rs.getString("complainant_last_name"));
                }
                System.out.println("Reason of Complaint #" + (count + 1) + ": " + rs.getString("statement_of_complain"));
                System.out.println("Date of Complain: " + rs.getDate("date_of_complain"));
                System.out.println();
                count++;
            }

            if ( count == 1 ) {
                times = "time";
            } else {
                times = "times";
            }

            if (found && middleName.equalsIgnoreCase("None")) {
            System.out.println(firstName + " " + lastName + " has been blottered " + count + " " + times + "!");
            } else if (found ) {
                System.out.println(firstName + " " + middleName + " " + lastName + " has been blottered " + count + " " + times + "!");
            
            } else if (!found) {
                System.out.println("No Person Found");
            }
            rs.close();
            pstmt.close();

            

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }


    }

}
