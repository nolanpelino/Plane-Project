import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.parser.ParseException;
public class FlightSystemUI {
    Scanner scan;
    private HotelList hotels;
    private UserList users;
    private FlightList flights;
    private static User currentUser;

    public FlightSystemUI(){
        scan = new Scanner(System.in);
    }
    public void run() throws IOException, ParseException{
        users = UserList.getInstance();
        hotels = HotelList.getInstance();
        int choice;
        loginCheck();
        choice = displayOptions();
        while(choice!=6){
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
        choice = displayOptions();
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
                    currentUser = us;
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
            scan.nextLine();
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
    public void bookFlight() throws IOException, ParseException {
        String depPort, arrPort;
        int flightCounter = 0;
        flights = FlightList.getInstance();
        Flight bookedFlight = null;
        Seat bookedSeat;
        ArrayList<Flight> allFlights = flights.getFlights();
        System.out.println("Flight booking protocol:\nEnter your departing airport: ");
        depPort = scan.next();
        quit(depPort);
        scan.nextLine();

        System.out.println("Enter your arrival airport: ");
        arrPort = scan.next();
        scan.nextLine();
        System.out.println("Here are the available flights:\n------------------------------------------");
        
        for(Iterator<Flight> iterator = allFlights.iterator(); iterator.hasNext();) {  // removes all flights that do not have the airports entered
            Flight f = iterator.next();
        	if ((!f.getDeparture().equalsIgnoreCase(depPort)) || (!f.getArrival().equalsIgnoreCase(arrPort)))
                iterator.remove();
        }
        for (Flight f : allFlights) {
            System.out.print(flightCounter+1+". ");
            f.printAllInfo();
            flightCounter++;
            System.out.println("------------------------------------------");
        }
        System.out.println("Which flight would you like to book? *(enter the flights number) ");
        int userAnswer = scan.nextInt();

        if (userAnswer<=flightCounter && userAnswer>0) {
        	bookedFlight = allFlights.get(userAnswer-1);
            System.out.println("What seat would you like? (Please enter row and position ex:1a )");
            String seatChoice =scan.next();
        	bookedSeat = bookedFlight.takeSeat(seatChoice);
            if(bookedSeat==null) {
                System.out.println("Not a valid seat. Sorry!");
            }
            else{
        	PlaneTicket planeTicket = new PlaneTicket(bookedFlight, bookedSeat, bookedFlight.getGate());
        	System.out.println("Your flight has been booked!\n");
        	currentUser.addFlightTicket(planeTicket);
            }
        	
        }

        else {
        	System.out.println("Sorry, thats not a valid answer. Restarting flight booking.\n");
        	bookFlight();
        }
        
    }

    /**
     * Books a hotel based off of the User's preferences
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public void bookHotel() throws IOException, ParseException {
        String state, city;
        Hotel bookedHotel = null;
        hotels = HotelList.getInstance();
        ArrayList<Hotel> allHotels = hotels.getHotels();
        ArrayList<Date> dates = new ArrayList<Date>();
        Random r = new Random( System.currentTimeMillis() );
        System.out.println("Hotel booking protocol:\nEnter State (Abrreviated)");
        state = scan.next();
        System.out.println("Enter city");
        city = scan.next();
        System.out.println("Here are the available hotels:\n----------------------------");


        for (Iterator<Hotel> iterator = allHotels.iterator(); iterator.hasNext();) {
        	Hotel h = iterator.next();
             if ((!h.getState().equalsIgnoreCase(state)) && (!h.getCity().equalsIgnoreCase(city))) {
                 iterator.remove();
             }
         }

        for (Hotel h : allHotels) {
            System.out.println("Hotel name: "+h.getName()+"\nAddress: "+h.getAddress()+"\nReviews: "+h.getRating()+" stars");
            System.out.println("----------------------------");
        }
        System.out.println("Do you want to book this hotel? Y/N? ");
         String userAnswer = scan.next();
         if (userAnswer.equalsIgnoreCase("y")) {
             bookedHotel=allHotels.get(0);            //HOTEL IS NEVER BOOKED, now kinda books
             System.out.println("What is your arrival date? MM/DD/YYYY");
             String firstDateS = scan.next(); 
             int monthInt1 = Integer.parseInt(firstDateS.substring(0, 2));
             int dayInt1 = Integer.parseInt(firstDateS.substring(3, 5));
             int yearInt1 = Integer.parseInt(firstDateS.substring(6, 10));
             Date randomDate = new Date(1220227200L * 1000);
             dates.add(new Date(yearInt1-1900, monthInt1-1, dayInt1));
             System.out.println("What is your departure date? MM/DD/YYYY");
             String secondDateS = scan.next(); 
             int monthInt2 = Integer.parseInt(secondDateS.substring(0, 2));
             int dayInt2 = Integer.parseInt(secondDateS.substring(3, 5));
             int yearInt2 = Integer.parseInt(secondDateS.substring(6, 10));
             dates.add(new Date(yearInt2-1900, monthInt2-1, dayInt2));
             bookedHotel.chooseRoom(1, dates);
             bookedHotel.getRooms(); //something like this might work but chooseroom wants an arraylist...  
             int confirmationNumber = 10000 + r.nextInt(20000);
             Room tempRoom = new Room(20, 20.0, 20); 
             HotelBooking hotelBooking = new HotelBooking(confirmationNumber, bookedHotel, dates, tempRoom, currentUser);
             currentUser.addHotelBooking(hotelBooking);
             System.out.println("Your hotel has been booked!");
             
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

    /**
     * 
     * @return An instance of the user contained in the UI object
     */
    public static User getCurrentUser() {
        return currentUser;
    }

    public static void main(String[] args) throws IOException, ParseException {
        FlightSystemUI flightSystemUI = new FlightSystemUI();
        flightSystemUI.run();
    }
}
