import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FlightSystemUI {
    Scanner scan;
    private HotelList hotels;
    private UserList users;
    private FlightList flights;
    private User currentUser;

    public FlightSystemUI(){
        scan = new Scanner(System.in);

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


    /**
     * Checks user's input to see if it matches a profile from the data
     */
    public void loginCheck() {
        users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        String usname;
        String password;
        System.out.println("Welcome to the flight booking experience.\nEnter your Username: ");
        usname = scan.next();
        scan.nextLine();
        
        if(users.getUser(usname) != null)
        {
            System.out.println("Correct username");
        }
        System.out.println("Enter your password: ");
        password = scan.next();
        scan.nextLine();
        if(users.getUser(usname).getPassword() == password)
        {
            System.out.println("Succesful login.");
            System.out.println("Type q at any time to quit program:");
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

    public void viewFlights() {
        System.out.println("Here are all of your previous flights");
        for (PlaneTicket t : currentUser.getTickets()) {
            t.displayTicket();
        }
    }

    public void viewHotelBookings() {
        System.out.println("Here are all of your hotel bookings:");
        currentUser.printHotelBookings();
        
    }

    public void viewFamily() {
        System.out.println("Here are your linked family members:");
        currentUser.printLinkedAccounts();
    }

    public void quit(String keyword) {
        if (keyword.equalsIgnoreCase("quit"))
            System.exit(0);
    }

    public static void main(String[] args) {
        FlightSystemUI flightSystemUI = new FlightSystemUI();
        flightSystemUI.run();
    }
}
