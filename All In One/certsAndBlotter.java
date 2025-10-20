import java.sql.*;
import java.util.Scanner;

public class certsAndBlotter extends DatabaseConnection {
    
    public void blotterRecords(Scanner scan) {
        
        try {
            sql();
            boolean found = false;
            int count = 0;
            String times;


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
                System.out.println("Officer in Charge: " + rs.getString("officer_in_charge"));
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

    public void newReport (Scanner scan) {

        try {
            
            sql();

            System.out.println("Report A Case");
            System.out.print("Enter First Name of Complainant >> ");
            String complainantFirst = scan.nextLine();

            System.out.print("Enter Middle Name of Complainant (Leave Blank if None) >> ");
            String complainantMiddle = scan.nextLine();

            System.out.print("Enter Last Name of Complainant >> ");
            String complainantLast = scan.nextLine();

            System.out.print("Enter the Age of Complainant >> ");
            String complainantAge = scan.nextLine();


            System.out.print("Enter Complainant Address >> ");
            String complainantAddress = scan.nextLine();

            System.out.print("Enter the First Name of the Respondent that is Blottered >> ");
            String complainedFirst = scan.nextLine();

            System.out.print("Enter the Middle Name of the Respondent that is Blottered (Leave Blank if None)>> ");
            String complainedMiddle = scan.nextLine();

            System.out.print("Enter the Last Name of the Respondent thats is Blottered >> ");
            String complainedLast = scan.nextLine();

            System.out.print("Enter the Age of the Respondent Complained >> ");
            String complainedAge = scan.nextLine();

            System.out.print("Enter the Address of the Respondent Complained >> ");
            String complainedAddress = scan.nextLine();

            System.out.print("Enter Statement of Complain >> ");
            String statementOfComplain = scan.nextLine();

            System.out.print("Enter the Action Taken >> ");
            String actionTaken = scan.nextLine();

            System.out.print("Enter Location of Incidence >> ");
            String locationOfIncidence = scan.nextLine();

            System.out.print("Enter the Date of Complain ( YYYY-MM-DD ) >> ");
            String dateOfComplain = scan.nextLine();

            System.out.println("Select Status");
            System.out.println("1.Active  2.Resolved  3.Referred  4.Pending");
            System.out.print(">> ");
            String blotter = scan.nextLine();
            String blotterStatus;
            if ( blotter.equals("1")) {
                blotterStatus = "Active";
            } else if ( blotter.equals("2")) {
                blotterStatus = "Resolved";
            } else if ( blotter.equals("3")) {
                blotterStatus = "Referred";
            } else {
                blotterStatus = "Pending";
            }

            System.out.print("Officer in Charge >> ");
            String officer = scan.nextLine();
            
            String insertQuery = "INSERT INTO blotter (complainant_first_name, complainant_middle_name, complainant_last_name, complainant_age, complainant_address, blottered_first_name, blottered_middle_name, blottered_last_name, complained_age, complained_address, statement_of_complain, action_taken, location_of_incidence, date_of_complain, blotter_status, officer_in_charge)" + 
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1, complainantFirst);
            pstmt.setString(2, complainantMiddle);
            pstmt.setString(3, complainantLast);
            pstmt.setString(4, complainantAge);
            pstmt.setString(5, complainantAddress);
            pstmt.setString(6, complainedFirst);
            pstmt.setString(7, complainedMiddle);
            pstmt.setString(8, complainedLast);
            pstmt.setString(9, complainedAge);
            pstmt.setString(10, complainedAddress);
            pstmt.setString(11, statementOfComplain);
            pstmt.setString(12, actionTaken);
            pstmt.setString(13, locationOfIncidence);
            pstmt.setString(14, dateOfComplain);
            pstmt.setString(15,blotterStatus);
            pstmt.setString(16, officer);


        
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Blotter Filed Successfully");
            } else {
                System.out.println("Not Successful");
            }

            pstmt.close();
            con.close();
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }

    }

    public void makeCertificate(Scanner scan) {

        try {

            sql();
            System.out.println("1. Make Certificate");
            System.out.println("2. Make Clearance");
            System.out.println("3. Check History");
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();



            if ( choice == 1 ) {
                System.out.println("Choose Certificate");
                System.out.println("1. Indigency");
                System.out.println("2. Residency");
                System.out.print(">> ");
                int cert = scan.nextInt();
                scan.nextLine();

                if ( cert == 1 ) {
                    String Kind = "Indigency";
                    System.out.print("Date Made: YYYY-MM-DD >> ");
                    String dateMade = scan.nextLine();
                    System.out.print("Enter Full Name >> ");
                    String fullName = scan.nextLine();
                    System.out.print("Enter Age >> ");
                    String age = scan.nextLine();
                    System.out.print("Enter Sitio >> ");
                    String sitio = scan.nextLine();
                    System.out.print("Enter Purpose >> ");
                    String purpose = scan.nextLine();

                    String makecert = "INSERT INTO certificates (certificates_choice, issue_date, full_name, age, sitio, purpose ) VALUES (?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(makecert);
                    pstmt.setString(1, Kind);
                    pstmt.setDate(2, Date.valueOf(dateMade));
                    pstmt.setString(3, fullName);
                    pstmt.setString(4, age);
                    pstmt.setString(5, sitio);
                    pstmt.setString(6, purpose);

                    pstmt.executeUpdate();
                    System.out.println("Successful");

                    pstmt.close();
                    con.close();

                    

                } else if ( cert == 2 ) {
                    String Kind = "Residency";
                    System.out.print("Date Made: YYYY-MM-DD >> ");
                    String dateMade = scan.nextLine();
                    System.out.print("Enter Full Name >> ");
                    String fullName = scan.nextLine();
                    System.out.print("Enter Age >> ");
                    String age = scan.nextLine();
                    System.out.print("Enter Sitio >> ");
                    String sitio = scan.nextLine();
                    System.out.print("Enter Purpose >> ");
                    String purpose = scan.nextLine();

                    String makecert = "INSERT INTO certificates (certificates_choice, issue_date, full_name, age, sitio, purpose )VALUES (?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(makecert);
                    pstmt.setString(1, Kind);
                    pstmt.setDate(2, Date.valueOf(dateMade));
                    pstmt.setString(3, fullName);
                    pstmt.setString(4, age);
                    pstmt.setString(5, sitio);
                    pstmt.setString(6, purpose);

                    pstmt.executeUpdate();
                    System.out.println("Successful");

                    pstmt.close();
                    con.close();
                }
            } else if ( choice == 2 ) {
                System.out.println("Choose Clearance");
                System.out.println("1. Barangay Clearance");
                System.out.println("2. Business Clearance");
                System.out.print(">> ");
                int cert = scan.nextInt();
                scan.nextLine();

                if ( cert ==  1 ) {
                    String Kind = "Barangay Clerance";
                    System.out.print("Date Made: YYYY-MM-DD >> ");
                    String dateMade = scan.nextLine();
                    System.out.print("Enter Full Name >> ");
                    String fullName = scan.nextLine();
                    System.out.print("Enter Age >> ");
                    String age = scan.nextLine();
                    System.out.print("Enter Sitio >> ");
                    String sitio = scan.nextLine();
                    System.out.print("Enter Purpose >> ");
                    String purpose = scan.nextLine();

                    String makecert = "INSERT INTO certificates (certificates_choice, issue_date, full_name, age, sitio, purpose )VALUES (?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(makecert);
                    pstmt.setString(1, Kind);
                    pstmt.setDate(2, Date.valueOf(dateMade));
                    pstmt.setString(3, fullName);
                    pstmt.setString(4, age);
                    pstmt.setString(5, sitio);
                    pstmt.setString(6, purpose);

                    pstmt.executeUpdate();
                    System.out.println("Successful");

                    pstmt.close();
                    con.close();
                } else if ( cert == 2 ) {
                    String Kind = "Business Clearance";
                    System.out.print("Date Made: YYYY-MM-DD >> ");
                    String dateMade = scan.nextLine();
                    System.out.print("Enter Full Name >> ");
                    String fullName = scan.nextLine();
                    System.out.print("Enter Age >> ");
                    String age = scan.nextLine();
                    System.out.print("Enter Sitio >> ");
                    String sitio = scan.nextLine();
                    System.out.print("Enter Purpose >> ");
                    String purpose = scan.nextLine();

                    String makecert = "INSERT INTO certificates (certificates_choice, issue_date, full_name, age, sitio, purpose )VALUES (?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(makecert);
                    pstmt.setString(1, Kind);
                    pstmt.setDate(2, Date.valueOf(dateMade));
                    pstmt.setString(3, fullName);
                    pstmt.setString(4, age);
                    pstmt.setString(5, sitio);
                    pstmt.setString(6, purpose);

                    pstmt.executeUpdate();
                    System.out.println("Successful");

                    pstmt.close();
                    con.close();
                }

            } else if ( choice == 3 ) {
                System.out.println("History Of Certificates Made");
                System.out.println();
                String history = "SELECT certificate_id, certificates_choice, full_name, purpose, issue_date FROM certificates ORDER BY certificate_id DESC";
                PreparedStatement pstmt = con.prepareStatement(history);
                ResultSet rs = pstmt.executeQuery();

                boolean hasHistory = false;
                
                while (rs.next()) {
                    hasHistory = true;

                    int id = rs.getInt("certificate_id");
                    String certChoice = rs.getString("certificates_choice");
                    String fullName = rs.getString("full_name");
                    String purpose = rs.getString("purpose");
                    Date issueDate = rs.getDate("issue_date");

                    System.out.println("Certificate ID: " + id + " |" + "Certificate: " + certChoice + " |" +"Name: "+ fullName + " |" + "Date: " + issueDate);
                    System.out.println("Purpose: " + purpose);
                    System.out.println();
                }

                if (!hasHistory) {
                    System.out.println("No Certificates Made");
                }
                rs.close();
                pstmt.close();

            } else {
                System.out.println("Invalid");
            }
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scan.close();
        }
    }
}
