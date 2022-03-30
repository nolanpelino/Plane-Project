import java.util.ArrayList;
import java.util.Scanner;
public class FlightSystemUI {
    Scanner scan = new Scanner(System.in);
    private HotelList hotels;
    private UserList users;
    private FlightList flights;

    public FlightSystemUI(){

    }

    public void run(){
        int choice;
        loginCheck();
        choice = displayOptions();
        switch(choice) {
            case 1: bookFlight();
                    break;
            case 2: bookHotel();
                    break;
            case 3: viewFlights();
                    break;
            case 4: viewHotelBookings();
                    break;
            case 5: viewFamily();
                    break;
        }
    }

    

    public ArrayList<Flight> sortFlightsDeparting(String departingAirport) {
        System.out.println("What would ");
        
    }

    public ArrayList<Flight> sortFlightsArrival(String arrivalAirport) {
        
    }

    public ArrayList<Flight> sortFlightsByTime() {
        
    }

    public Hotel sortHotel(String address) {

    }

    /**
     * Checks user's input to see if it matches a profile from the data
     */
    public void loginCheck() {
        String usname;
        String password;
        System.out.println("Welcome to the flight booking experience.\nEnter your Username: ");
        usname = scan.next();
        scan.nextLine();
        // if statement to see if user exists
        System.out.println("Enter your password: ");
        password = scan.next();
        scan.nextLine();
        // if statement to decide if password is correct
        System.out.println("Succesful login.");
    }

    /**
     * Displays menu options and reads user input
     * @return returns an int matching the menu choice
     */
    public int displayOptions() {
        boolean correct = false;
        while (!correct) {
            try {
                System.out.println("Choose your menu option :");
                System.out.println("1- Book flight\n2- Book hotel\n3- View my flights\n4- View my hotel bookings\n5- View my family");
                int choice = scan.nextInt();
                if (choice < 1 || choice > 5){
                    System.out.println("Sorry that is not an option");
                } else {
                    correct = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Input numbers only please.");
                scan.nextLine();
            }
        }
        reutrn choice;
    }

    public void bookFlight() {

    }

    public void bookHotel() {

    }

    public void viewFlights() {

    }

    public void viewHotelBookings() {

    }

    public void viewFamily() {
        
    }

    public void quit(String keyword) {
        if (keyword.equalsIgnoreCase("quit"))
            System.exit(0);
    }

}
