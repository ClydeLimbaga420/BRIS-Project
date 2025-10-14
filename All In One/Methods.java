import java.sql.*;
import java.util.Scanner;

public class Methods extends DatabaseConnection {

    public void addResident(Scanner scan) {
        try {
            sql();

            System.out.println("Add New Resident");
            System.out.print("Enter Last Name >> ");
            String lastName = scan.nextLine();
            System.out.print("Enter First Name >> ");
            String firstName = scan.nextLine();
            System.out.print("Enter Middle Name >> ");
            String middleName = scan.nextLine();
            
            System.out.println("Select Suffix");
            System.out.println("1.None  2.Jr  3.Sr  4.III  5.IV  6.V  Other");
            System.out.print(">> ");
            String suffix;
            String suffixChoice = scan.nextLine();
            if ( suffixChoice.equals("1")) {
                suffix = "None";
            } else if ( suffixChoice.equals("2")) {
                suffix = "Jr.";
            } else if ( suffixChoice.equals("3")) {
                suffix = "Sr.";
            } else if ( suffixChoice.equals("4")) {
                suffix = "III";
            } else if ( suffixChoice.equals("5")) {
                suffix = "IV";
            } else if ( suffixChoice.equals("6")) {
                suffix = "V";
            } else {
                System.out.print("Other: ");
                suffix = scan.nextLine();
            }
            
            System.out.println("Select Sex");
            System.out.println("1.Male  2.Female");
            System.out.print(">> ");
            String sex;
            String sexChoice = scan.nextLine();
            if ( sexChoice.equals("1")) {
                sex = "Male";
            } else {
                sex = "Female";
            }
           
            System.out.print("Birthdate (YYYY-MM-DD) >> ");
            String birthdate = scan.nextLine();
            
            System.out.print("Enter Age >> ");
            int age = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Select Civil Status");
            System.out.println("1.Separated  2.Married  3.Widowed  4.Single");
            System.out.print(">> ");
            String civilStatus;
            String status = scan.nextLine();
            if ( status.equals("1")) {
                civilStatus = "Separated";
            } else if ( status.equals("2")) {
                civilStatus = "Married";
            } else if ( status.equals("3")) {
                civilStatus = "Widowed";
            } else {
                civilStatus = "Single";
            }
            
            System.out.print("Enter Sitio >> ");
            String sitio = scan.nextLine();
            
            System.out.print("Enter Occupation >> ");
            String occupation = scan.nextLine();
            
            System.out.print("Enter Contact Number >> ");
            String contactNumber = scan.nextLine();
            
            System.out.print("Enter Email >> ");
            String email = scan.nextLine();
            
            System.out.print("Select Voter Status: ");
            System.out.println("1.Registered  2.Not Registered");
            System.out.print(">> ");
            String voterStatus;
            String voter = scan.nextLine();
            if ( voter.equals("1")) {
                voterStatus = "Registered";
            } else {
                voterStatus = "Not Registered";
            }
           
            System.out.print("Number of People in Household >> ");
            String numHousehold = scan.nextLine();
            
            String senior;
            if ( age >= 60 ) {
                senior = "Yes";
            } else {
                senior = "No";
            }
        
            
            System.out.print("Select Condition: ");
            System.out.println("1.Deceased  2. Alive");
            System.out.print(">> ");
            String conditions = scan.nextLine();
            String deceased;
            if ( conditions.equals("1")) {
                deceased = "Deceased";
            } else {
                deceased = "Alive";
            }
            
            System.out.println("Select Religion");
            System.out.println("1.Roman Catholic  2.Islam  3.Iglesia Ni Cristo  4. Born Again   Others");
            System.out.print(">> ");
            String religionChoice = scan.nextLine();
            String religion;
            if ( religionChoice.equals("1")) {
                religion = "Roman Catholic";
            } else if ( religionChoice.equals("2")) {
                religion = "Islam";
            } else if ( religionChoice.equals("3")) {
                religion = "Iglesia Ni Cristo";
            } else if ( religionChoice.equals("4")) {
                religion = "Born Again";
            } else {
                System.out.print("Other: ");
                religion = scan.nextLine();
            }

            System.out.print("Is the Resident a PWD?: ");
            System.out.println("Y or N");
            System.out.print(">> ");
            String pwdInput = scan.nextLine();
            String PWD = pwdInput.equalsIgnoreCase("Y") ? "Yes" : "No";
            
            System.out.println("Select Blood Type");
            System.out.println("1.A   2.B   3.AB    4.O");
            System.out.println("5.A+  6.B+  7.AB+   8.O+");
            System.out.println("9.A-  10.B- 11.AB-  12.O-");
            System.out.print(">> ");
            String blood = scan.nextLine();
            String bloodType;

            if ( blood.equals("1")) {
                bloodType = "A";
            } else if ( blood.equals("2")) {
                bloodType = "B";
            } else if ( blood.equals("3")) {
                bloodType = "AB";
            } else if ( blood.equals("4")) {
                bloodType = "O";
            } else if ( blood.equals("5")) {
                bloodType = "A+";
            } else if ( blood.equals("6")) {
                bloodType = "B+";
            } else if ( blood.equals("7")) {
                bloodType = "AB+";
            } else if ( blood.equals("8")) {
                bloodType = "O+";
            } else if ( blood.equals("9")) {
                bloodType = "A-";
            } else if ( blood.equals("10")) {
                bloodType = "B-";
            } else if ( blood.equals("11")) {
                bloodType = "AB-";
            } else if ( blood.equals("12")) {
                bloodType = "O-";
            } else {
                bloodType = "N/A";
            }

            System.out.println("Select Educational Attainment");
            System.out.println("1.Elementary Level  2.Elementary Graduate  3.High School Level  4.High School Graduate  5.Senior High School Level  Others");
            System.out.print(">> ");
            String education;
            String educAttainment = scan.nextLine();
            if ( educAttainment.equals("1")) {
                education = "Elementary Level";
            } else if ( educAttainment.equals("2")) {
                education = "Elementary Graduate";
            } else if ( educAttainment.equals("3")) {
                education = "High School Level";
            } else if ( educAttainment.equals("4")) {
                education = "High School Graduate";
            } else if ( educAttainment.equals("5")) {
                education = "Senior High School Level";
            } else {
                System.out.print("Others: ");
                education = scan.nextLine();
            }

            String insert = "INSERT INTO residents_details (last_name, first_name, middle_name, suffix, sex, birthdate, age, civil_status, sitio, occupation, contact_number, email_address, voter_status, no_household, senior, conditions, religion, PWD, blood_type, educational_attainment)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstmt.setString(15, senior);
            pstmt.setString(16, deceased);
            pstmt.setString(17, religion);
            pstmt.setString(18, PWD);
            pstmt.setString(19, bloodType);
            pstmt.setString(20, education);


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
            sql();

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
                System.out.println("Enter Voter Status >> ");
                String value = scan.nextLine();
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE voter_status = ?");
                pstmt.setString(1, value);
            }else if ( look == 7 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE age >= 60");
            } else if ( look == 8 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE conditions = 'Deceased'");
            } else if ( look == 10 ) {
                pstmt = con.prepareStatement("SELECT * FROM residents_details WHERE PWD = 'Yes'");
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
                    System.out.println("Senior: " + rs.getString("senior"));
                    System.out.println("Conditions: " + rs.getString("conditions"));
                    System.out.println("Religion: " + rs.getString("religion"));
                    System.out.println("PWD: " + rs.getString("PWD"));
                    
                    
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
