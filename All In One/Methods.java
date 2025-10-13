import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Methods extends DatabaseConnection {

    public void addResident(Scanner scan) {
        try {
            connect();

            System.out.println("Add New Resident");
            System.out.print("Enter Last Name >> ");
            String lastName = scan.nextLine();
            System.out.print("Enter First Name >> ");
            String firstName = scan.nextLine();
            System.out.print("Enter Middle Name >> ");
            String middleName = scan.nextLine();
            System.out.print("Enter Suffix >> ");
            String suffix = scan.nextLine();
            System.out.print("Male or Female >> ");
            String sex = scan.nextLine();
            System.out.print("Birthdate (YYYY-MM-DD) >> ");
            String birthdate = scan.nextLine();
            System.out.print("Enter Age >> ");
            int age = scan.nextInt();
            scan.nextLine();
            System.out.print("Status (Single, Married, etc.) >> ");
            String civilStatus = scan.nextLine();
            System.out.print("Enter Sitio >> ");
            String sitio = scan.nextLine();
            System.out.print("Enter Occupation >> ");
            String occupation = scan.nextLine();
            System.out.print("Enter Contact Number >> ");
            String contactNumber = scan.nextLine();
            System.out.print("Enter Email >> ");
            String email = scan.nextLine();
            System.out.print("Voter Status (Registered/Not Registered) >> ");
            String voterStatus = scan.nextLine();
            System.out.print("Number of People in Household >> ");
            String numHousehold = scan.nextLine();
            boolean senior = age >= 60;
            System.out.print("Deceased? (1 = yes, 0 = no) >> ");
            String deceased = scan.nextLine();
            System.out.print("Religion >> ");
            String religion = scan.nextLine();
            System.out.print("PWD? (yes or no) >> ");
            String pwdInput = scan.nextLine();
            String PWD = pwdInput.equalsIgnoreCase("yes") ? "1" : "0";
            System.out.print("Blood Type >> ");
            String bloodType = scan.nextLine();

            String insert = "INSERT INTO residents_details (last_name, first_name, middle_name, suffix, sex, birthdate, age, civil_status, sitio, occupation, contact_number, email_address, voter_status, no_household, senior, deceased, religion, PWD, blood_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            pstmt.setString(3, middleName);
            pstmt.setString(4, suffix);
            pstmt.setString(5, sex);
            pstmt.setDate(6, Date.valueOf(birthdate));
            pstmt.setInt(7, age);
            pstmt.setString(8, civilStatus);
            pstmt.setString(9, sitio);
            pstmt.setString(10, occupation);
            pstmt.setString(11, contactNumber);
            pstmt.setString(12, email);
            pstmt.setString(13, voterStatus);
            pstmt.setString(14, numHousehold);
            pstmt.setBoolean(15, senior);
            pstmt.setString(16, deceased);
            pstmt.setString(17, religion);
            pstmt.setString(18, PWD);
            pstmt.setString(19, bloodType);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Resident added successfully!");
            } else {
                System.out.println("Failed to add resident.");
            }

            pstmt.close();
            close();

        } catch (Exception e) {
            System.out.println("Error adding resident: " + e.getMessage());
        }
    }

    public void residentRecords(Scanner scan) {
        try {
            connect();

            System.out.println("Select Category to Search:");
            System.out.println("0. Search by Full Name");
            System.out.println("1. Search Resident by ID");
            System.out.println("2. Search Resident by Last Name");
            System.out.println("3. Search Residents by Sex");
            System.out.println("4. Search Residents by Civil Status");
            System.out.println("5. Search Residents by Sitio");
            System.out.println("6. Search Residents by Voter Status");
            System.out.println("7. Search Senior Residents");
            System.out.println("8. Search Deceased Residents");
            System.out.println("9. Search Resident by Religion");
            System.out.println("10. Search PWD");
            System.out.print(">> ");
            int look = scan.nextInt();
            scan.nextLine(); 

            PreparedStatement pstmt = null;
            ResultSet rs = null;

            
            if (look == 1) {
                System.out.print("Enter Resident's ID to Search >> ");
                int value = scan.nextInt();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE residents_id = ?");
                pstmt.setInt(1, value);
            } else if (look == 2) {
                System.out.print("Enter Last Name >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE last_name = ?");
                pstmt.setString(1, value);
            } else if (look == 3) {
                System.out.print("Enter Sex >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE sex = ?");
                pstmt.setString(1, value);
            } else if ( look == 4 ) {
                System.out.println("Enter Civil Status >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE civil_status = ?");
                pstmt.setString(1, value);
            } else if ( look == 5 ) {
                System.out.println("Enter Sitio >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE sitio = ?");
                pstmt.setString(1, value);
            } else if ( look == 6 ) {
                System.out.println("Enter Civil Status >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE civil_status = ?");
                pstmt.setString(1, value);
            }else if ( look == 7 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE age >= 60");
            } else if ( look == 8 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE deceased = 1");
            } else if ( look == 10 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE PWD = 1");
            } else if ( look == 0 ) {
                System.out.print("Enter First Name >> ");
                String firstName = scan.nextLine();
                System.out.print("Enter Middle Name (Put 'None' if 'None') >> ");
                String middleName = scan.nextLine();
                System.out.print("Enter First Name >> ");
                String lastName = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE first_name = ? AND middle_name = ? AND last_name = ?");
                pstmt.setString(1, firstName);
                pstmt.setString(2, middleName);
                pstmt.setString(3, lastName);
            }else {
                System.out.println("Invalid option or not yet implemented.");
            }

            if (pstmt != null) {
                rs = pstmt.executeQuery();
                boolean found = false;
                int count = 0;
                
                while (rs.next()) {
                    found = true;
                    count++;
                    System.out.println("");
                    
                    System.out.println("Residents ID: " + rs.getInt("residents_id"));
                    System.out.println("Last Name: " + rs.getString("last_name"));
                    System.out.println("First Name: " + rs.getString("first_name"));
                    System.out.println("Middle Name: " + rs.getString("middle_name"));
                    System.out.println("Suffix: " + rs.getString("suffix"));
                    System.out.println("Sex: " + rs.getString("sex"));
                    System.out.println("Birthdate: " + rs.getDate("birthdate"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Civil Status: " + rs.getString("civil_status"));
                    System.out.println("Sitio: " + rs.getString("sitio"));
                    System.out.println("Occupation: " + rs.getString("occupation"));
                    System.out.println("Contact Number: " + rs.getString("contact_number"));
                    System.out.println("Email Address: " + rs.getString("email_address"));
                    System.out.println("Voter Status: " + rs.getString("voter_status"));
                    System.out.println("Number of Household: " + rs.getString("no_household"));
                    System.out.println("Senior: " + rs.getBoolean("senior"));
                    System.out.println("Deceased: " + rs.getBoolean("deceased"));
                    System.out.println("Religion: " + rs.getString("religion"));
                    System.out.println("PWD: " + rs.getBoolean("PWD"));
                    
                    
                }
                System.out.println("");
                System.out.println("Resident Found (" + count + ")");

                if (!found) {
                    System.out.println("No Residents Found.");
                }

                rs.close();
                pstmt.close();
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
