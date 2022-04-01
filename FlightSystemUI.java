import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;
public class FlightSystemUI {
    Scanner scan;
    private HotelList hotels;
    private UserList users;
    private FlightList flights;
    private User currentUser;

    public FlightSystemUI(){
        scan = new Scanner(System.in);
    }
    public void run() throws IOException, ParseException{
        users = UserList.getInstance();
        hotels = HotelList.getInstance();
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


    /**
     * Checks user's input to see if it matches a profile from the data
     * @throws ParseException
     * @throws IOException
     */
    public void loginCheck() throws IOException, ParseException {
        String usname;
        String password;
        boolean exists = false;
        int scanAllow = 0;

        // Username section
        System.out.println("Welcome to the flight booking experience.\nEnter your Username: ");
        usname = scan.next();
        scan.nextLine();
        while(!exists) {
            if (scanAllow > 0) {  //allows the usname to be inttialized regardless of exist value
                usname = scan.next();
                scan.nextLine();
            }
            users = UserList.getInstance();
            for (User us : users.getUsers()) {
                if (us.getUsername()==null || us.getUsername().equals(usname)) {
                    exists = true;
                    continue;
                }
            }
            if (!exists) {
                System.out.println("User not found");
                System.out.println("Would you like to create an account or retry(N)? (Y/N)");
                if (scan.next().equalsIgnoreCase("y")) {
                    exists = true;
                    createAccount();
                }

            }
            scanAllow++;
        }
        exists = false;

        // Password Section
        System.out.println("Enter your password: ");
        while(!exists) {
            password = scan.next();
            scan.nextLine();
            for (User us : users.getUsers()) {
                if (us.getUsername().equals(usname) && us.getPassword().equals(password)) {
                    exists = true;
                    System.out.println("Logging in...");
                    continue;
                }
            }
            if (!exists)
                System.out.println("Incorrect password, try again");
        }   
    }

    /**
     * Displays menu options and reads user input
     * @return returns an int matching the menu choice
     */
    public int displayOptions() {
        int myChoice=1;
        boolean correct = false;
        int choice;
        while (!correct) {
            try {
                System.out.println("Choose your menu option :");
                System.out.println("1- Book flight\n2- Book hotel\n3- View my flights\n4- View my hotel bookings\n5- View my family");
                choice = scan.nextInt();
                if (choice < 1 || choice > 5){
                    System.out.println("Sorry that is not an option");
                } 
                else{
                    correct = true;
                    myChoice = choice;
                }
            } 
            catch (InputMismatchException e) {
                System.err.println("Input numbers only please.");
                scan.nextLine();
            }
        }
        return myChoice;
    }

    /**
     * Function to create user
     */
    private void createAccount() {
        boolean uniqueUsername = false;
        while(!uniqueUsername) {
            System.out.println("Username:");
            String userName=scan.next();
            System.out.println("Password:");
            String password=scan.next();
            System.out.println("Age:");
            int age=scan.nextInt();
            scan.nextLine();
            System.out.println("Address:");
            String address=scan.nextLine();
            System.out.println("Frequent flyer? (true/false):");
            boolean frequentFlyer=scan.nextBoolean();
            scan.nextLine();
            System.out.println("Home Airport code:");
            String homeAirport=scan.next();
            System.out.println("Passport? (true/false):");
            boolean passport=scan.nextBoolean();
            scan.nextLine()
            System.out.println("Disability? (true/false):");
            boolean hasDisability=scan.nextBoolean();
            scan.nextLine();

            if(users.addUser(userName, password, age, address, frequentFlyer, homeAirport, passport, hasDisability)){
                System.out.println("You have created an account!");
                uniqueUsername = true;
            }
            else {
                System.out.println("Oh no an account with that name exists");
            }
        }
    }
    /**
     * Function books a flight off of the user's departure and arrival choices
     */
    public void bookFlight() {
        String depPort, arrPort;
        ArrayList<Flight> allFlights = flights.getFlights();
        System.out.println("Flight booking protocol:\nEnter your departing airport: ");
        depPort = scan.next();
        quit(depPort);
        scan.nextLine();

        System.out.println("Enter your arrival airport: ");
        arrPort = scan.next();
        scan.nextLine();
        System.out.println("Here are the available flights:");

        for(Flight f : allFlights) {  // removes all flights that do not have the airports entered
            if ((!f.getDeparture().equalsIgnoreCase(depPort)) || (!f.getArrival().equalsIgnoreCase(arrPort)))
                allFlights.remove(f);
        }
        for (Flight f : allFlights) {
            f.printAllInfo();
        }
    }

    /**
     * Books a hotel based off of the User's preferences
     */
    public void bookHotel() {
        String state, city;
        ArrayList<Hotel> allHotels = hotels.getHotels();
        System.out.println("Hotel booking protocol:\nEnter State (Abrreviated)");
        state = scan.next();
        System.out.println("Enter city");
        city = scan.next();
        System.out.println("Here are the available hotels");

        for (Hotel h : allHotels) {
            if ((!h.getState().equalsIgnoreCase(state)) || (!h.getCity().equalsIgnoreCase(city))) {
                allHotels.remove(h);
            }
        }

        for (Hotel h : allHotels) {
            h.printBasicInfo();
        }
    }

    /**
     * Prints all the user's past and present flights
     */
    public void viewFlights() {
        System.out.println("Here are all of your previous flights");
        for (PlaneTicket t : currentUser.getTickets()) {
            t.displayTicket();
        }
    }

     /**
     * Prints all the user's past, present, and future flights
     */
    public void viewHotelBookings() {
        System.out.println("Here are all of your hotel bookings:");
        currentUser.printHotelBookings();
        
    }

    /**
     * Prints out the user's family
     */
    public void viewFamily() {
        System.out.println("Here are your linked family members:");
        currentUser.printLinkedAccounts();
    }

    /**
     * Extits the program
     * @param keyword must be "q" to quit
     */
    public void quit(String keyword) {
        if (keyword.equalsIgnoreCase("quit"))
            System.exit(0);
    }

    public static void main(String[] args) throws IOException, ParseException {
        FlightSystemUI flightSystemUI = new FlightSystemUI();
        flightSystemUI.run();
    }
}
