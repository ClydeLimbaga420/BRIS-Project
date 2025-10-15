import java.util.Scanner;

public class allInOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        logIn login = new logIn();
        Methods manager = new Methods();

        boolean loggedIn = login.login(scan);

        if (loggedIn) {
            
            System.out.println("Choose");
            System.out.println("1. Add New Resident");
            System.out.println("2. Resident Records");
            System.out.println("3. Blotter Records");
            System.out.println("4. Report Case");
            System.out.println("5. Clerance/Certificate");
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();

            if ( choice == 1 ) {
                
                manager.addResident(scan);

            } else if ( choice == 2 ) {

                manager.residentRecords(scan);
 
            } else if ( choice == 3 ) {

                manager.blotterRecords(scan);
                
            } else if ( choice == 4 ) {

                manager.newReport(scan);
            }



        }

        scan.close();
    }
}
