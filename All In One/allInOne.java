import java.util.Scanner;


public class allInOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        logIn login = new logIn();
        Methods manager = new Methods();
        certsAndBlotter records = new certsAndBlotter();
        boolean loggedIn = false;
        boolean running = true;

        
        
        while (running) {
        System.out.println();
        System.out.println("1. Login");
        System.out.println("2. Change Gmail Account or Password");
        System.out.println("3. Exit");
        System.out.print(">> ");
        String log = scan.nextLine();

        if ( log.equals("1")) {
            loggedIn = login.login(scan);
            manager.updateData();
            while (loggedIn) {
                System.out.println();
                System.out.println("Choose");
                System.out.println("1. Add New Resident");
                System.out.println("2. Resident Records");
                System.out.println("3. Blotter Records");
                System.out.println("4. Report Case");
                System.out.println("5. Clearance/Certificate");
                System.out.println("6. See Edit History");
                System.out.println("7. Log Out");
                System.out.print(">> ");
                int choice = scan.nextInt();
                scan.nextLine();
    
                if ( choice == 1 ) {
                    
                    manager.addResident(scan);
    
                } else if ( choice == 2 ) {
    
                    manager.residentRecords(scan);
     
                } else if ( choice == 3 ) {
    
                    records.blotterRecords(scan);
                    
                } else if ( choice == 4 ) {
    
                    records.newReport(scan);
    
                } else if ( choice == 5 ) {
    
                    records.makeCertificate(scan);
    
                } else if ( choice == 6 ) {

                    manager.displayHistory();

                } else if ( choice == 7 ) {
    
                    loggedIn = false;
    
                } else {
                    System.out.println("Invalid");
                }
    
    
                
            }
        } else if ( log.equals("2")) {
            login.change(scan);
        } else {
            running = false;
        }
    }

       

        
    }
}
