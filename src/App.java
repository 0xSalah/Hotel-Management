import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);

        System.out.println("\n===== Setting up the hotel system =====");
        System.out.print("Enter the number of Standard Rooms : ");
        int standardRoomNumber = cin.nextInt();
        System.out.print("Enter the price of standard rooms : $");
        double standardRoomPrice = cin.nextDouble();

        System.out.print("Enter the number of suite Rooms : ");
        int suiteRoomNumber = cin.nextInt();
        System.out.print("Enter the price of suite rooms : $");
        double suiteRoomPrice = cin.nextDouble();

        HotelManag hotel = new HotelManag(standardRoomNumber, standardRoomPrice, suiteRoomNumber, suiteRoomPrice);
        boolean run = true;

        while (run) {
            System.out.println("\n=== Hotel Management System Project ===");
            System.out.println("Press 1 for Manager Mode");
            System.out.println("Press 2 for Customer Mode");
            System.out.println("Press 0 to Exit");
            System.out.println("=================");
            System.out.print("Enter choice : ");
            int x = cin.nextInt();

            switch (x) {
                case 0:
                    System.out.println("\n=================================");
                    System.out.println("== You have exited the system ==");
                    System.out.println("Prepared by: Salah Adel Al-batati");
                    System.out.println("=================================\n");
                    run = false;
                    break;
            
                case 1 :
                    boolean ManagerMode = false;
                    System.out.print("Enter Username : ");
                    String username = cin.next();

                    System.out.print("Enter Password : ");
                    String password = cin.next();
                    if (username.equals("Admin") && password.equals("123")){
                        ManagerMode = true;
                    }else {
                        System.out.println("You are not a Admin");
                        break;
                    }
                    while (ManagerMode) {
                        
                        System.out.println("\n==== Manager Mode ====");
                        System.out.println("Press 1 for view Total Earning");
                        System.out.println("Press 2 to check the status of a Standard room");
                        System.out.println("Press 3 to check the status of a Suite");
                        System.out.println("Press 4 to change the room price");
                        System.out.println("Press 5 to change the suite price");

                        System.out.println("Press 0 to Return to Main Menu");
                        System.out.println("===============================");
                        System.out.print("Enter choice : ");

                        int y = cin.nextInt();

                        switch (y) {
                            case 1:
                                System.out.println("\n----------------------------------------------");
                                System.out.println("==== Total Earnings ====");
                                System.out.println("The Total Earnings : " +  "$" + hotel.getTotalEarning());
                                System.out.println("-----------------------------------------------\n");
                                break;
                        
                            case 2:
                                System.out.print("The room number to check : ");
                                int roomNumber = cin.nextInt();
                                System.out.println("\n------ Status of room number " + roomNumber + " ------");
                                hotel.showRoomStatus(roomNumber);
                                System.out.println("---------------------------------\n");
                                break;


                            case 3:
                                System.out.print("The room number to check : ");
                                int suiteNumber = cin.nextInt();
                                System.out.println("\n----- Status of room number " + suiteNumber + " ----------");
                                hotel.showRoomStatus(suiteNumber);
                                System.out.println("------------------------------------------------\n");
                                break;

                            case 4:
                                System.out.print("Set the new price :");
                                int newPrice = cin.nextInt();
                                hotel.changeRoomPrice(newPrice);
                                System.out.println("Price update successfully!");
                                break;

                            case 5:
                                System.out.print("Set the new price :");
                                int newSuitePrice = cin.nextInt();
                                hotel.changeSuitePrice(newSuitePrice);
                                System.out.println("Price update successfully!");
                                break;

                            case 0 :
                                System.out.println("Return to Main menu...");
                                ManagerMode = false;
                                break;
                        }

                    }
                    break;

                case 2 :
                    boolean CustomerMode = true;
                    while (CustomerMode) {
                    
                        System.out.println("\n==== Customer Mode ====");
                        System.out.println("Press 1 to book a Standard Room");
                        System.out.println("Press 2 to book a Suite");
                        System.out.println("Press 3 to cancel Standard Room");
                        System.out.println("Presss 4 to cancel Suite");
                        System.out.println("Press 0 to Return to Main Menu");
                        System.out.println("========================");
                        System.out.print("Enter choice : ");
                        int y = cin.nextInt();

                        switch (y) {
                            case 1:
                                System.out.println("==============");
                                System.out.print("Enter your name :");
                                String name = cin.next();
                                System.out.print("Enter your phone number : ");
                                String phoneNumber = cin.next();

                                hotel.bookStandardRoom(name, phoneNumber);
                                break;

                            case 2 :
                                System.out.println("==============");
                                System.out.print("Enter your name :");
                                String nameS = cin.next();
                                System.out.print("Enter your phone number : ");
                                String phoneNumberS = cin.next();

                                hotel.bookSuiteRoom(nameS, phoneNumberS);
                                break;

                            case 3 :
                                System.out.println("==============");
                                System.out.print("The room number to cancle :");
                                int num = cin.nextInt();
                                hotel.cancelStandardRoom(num);
                                break;

                            case 4 :
                                System.out.println("==============");
                                System.out.print("The Suite number to cancle :");
                                int numS = cin.nextInt();
                                hotel.cancelSuiteRoom(numS);
                                break;

                            case 0 :
                                System.out.println("Return to Main menu...");
                                CustomerMode = false;
                                break;
                        }   

                    }
                    break;
                
            }   
        }
    }
}
