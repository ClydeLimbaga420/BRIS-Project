import java.sql.*;
import java.util.Scanner;

public class makeCertificate {
    
    public static void main ( String [] args ) {

        Scanner scan = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/systemdb","root","clydelimbaga123");
        
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
                //System.out.println("Certificate Id Certificate Name Purpose Date");
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
        
        
        
        } catch(Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }finally {
            scan.close();
    }




    }

}
