import java.util.ArrayList;
import java.util.UUID;
import java.util.Random;

public class Flight {
    private Seat[] seats;
    private int flightlength;
    private boolean hasTV;
    private String departureAirport;
    private String arrivalAirport;
    private UUID id;
    private int flightNumber;
    private String airline;
    private int connectingFlight;

    /**
     * Flight Constructor
     * @param Seat
     * @param int
     * @param boolean
     * @param String      
     * @param String
     * @param String
     * @param String
     * @param String
     */
    public Flight(Seat[] seats, int flightlength, boolean hasTV,
    String depart, String arrival, UUID id, int flightNumber, String airline, int connectingFlight) {
        this.seats = seats;
        this.flightlength = flightlength;
        this.hasTV = hasTV;
        this.departureAirport = depart;
        this.arrivalAirport = arrival;
        this.id = id;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.connectingFlight = connectingFlight;
    }

    /**
     * Returns the connecting flight int
     * @return int
     */
    public int getConnectingFlight() {
        return this.connectingFlight;
    }

    /**
     * Returns the length of the flight
     * @return int
     */
    public int getLength() {
        return this.flightlength;
    }

    /**
     * Returns the departure airport of the flight
     * @return String
     */
    public String getDeparture() {
        return this.departureAirport;
    }

    /**
     * Returns the UUID of the flight
     * @return UUID
     */
    public UUID getID() {
        return this.id;
    }

    /**
     * Returns the destination airport of the flight
     * @return String
     */
    public String getArrival() {
        return this.arrivalAirport;
    }

    /**
     * Returns a boolean value. True if it has TVs and false if it does not
     * @return boolean
     */
    public boolean hasTVs() {
        return this.hasTV;
    }

    /**
     * Returns the flights number
     * @return String
     */
    public int getFlightNumber() {
        return this.flightNumber;
    }

    /**
     * @return The flights airline
     */
    public String getAirline() {
        return this.airline;
    }

    /**
     * Returns an array list of open seats
     * @return ArrayList<Seat>
     */
    public ArrayList<Seat> getOpenSeats() {
        ArrayList<Seat> opens = new ArrayList<Seat>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].getAvailability())
                opens.add(seats[i]);
        }
        return opens;
    }

    /**
     * Prints out an array of all the available seats of a flight object
     */
    public void printOpenSeats() {
        ArrayList<Seat> opens = getOpenSeats();
        int counter = 0;
        System.out.print("Open Seats: ");
        for (Seat s: opens) {
            if (counter == 4) { // Used to determine when to start a new line of prints
                System.out.println("\n" + s.getExactPosition());
                counter = 0;
            } else {
                System.out.println(s.getExactPosition());
                counter++;
            }
        }
    }

    /**
     * Allows the user to take a seat from the flight objects seat ArrayList
     * @param String
     */
    public Seat takeSeat(String seatNum) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].getExactPosition().equalsIgnoreCase(seatNum)) {
                if (seats[i].getAvailability()) {
                    seats[i].fillSeat();
                    System.out.println("Seat was availible and has been filled.");
                    return seats[i];
                } else {
                    System.out.println("Seat is already taken");
                    return null;
                }
            }
        }
        System.out.println("Seat not found");
        return null;
    }

    /**
     * @return A string of the flight's gate number
     * One character and one Int
     */
    public String getGate(){
        char myGate=departureAirport.charAt(0);
        Random rand = new Random();
        String finalGate=String.valueOf(rand.nextInt(10));
        return myGate+finalGate;

    }

    /**
     * Prints out a flights info that is readable for a User
     */
    public void printAllInfo() {
        int timeHours = getLength() / 60;
        int timeMins = getLength() % 60;
        System.out.println(getAirline() + " Flight " + getFlightNumber() + " from " + getDeparture() +
         " to " + getArrival());

        System.out.print("Travel time : " + timeHours + " hours");
        if(timeMins != 0) 
            System.out.println(" and " + timeMins + " minutes");
            
        System.out.print("This flight has " + getOpenSeats().size() + " open seats");
        if(hasTVs())
            System.out.println(" each with a TV.");
        else
            System.out.println(" without TV's.");
    }
}
