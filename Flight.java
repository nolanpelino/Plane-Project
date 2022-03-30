import java.util.ArrayList;
import java.util.UUID;

public class Flight {
    private Seat[] seats;
    private int flightlength;
    private boolean hasTV;
    private String departureAirport;
    private String arrivalAirport;
    private UUID id;
    private int flightNumber;
    private int arrivalTime;
    private int departureTime;
    private String airline;

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
    String depart, String arrival, UUID id, int flightNumber, String airline,
    int arrivalTime, int departureTime) {
        this.seats = seats;
        this.flightlength = flightlength;
        this.hasTV = hasTV;
        this.departureAirport = depart;
        this.arrivalAirport = arrival;
        this.id = id;
        this.flightNumber = flightNumber;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.airline = airline;
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
     * 
     * @return The arrival time as an integer. Kept in military time
     */
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * @return The departure time as an integer. Kept in military time
     */
    public int getDepartureTIme() {
        return this.departureTime;
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
    public void takeSeat(String seatNum) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].getExactPosition().equalsIgnoreCase(seatNum)) {
                if (seats[i].getAvailability()) {
                    seats[i].fillSeat();
                    System.out.println("Seat was availible and has been filled.");
                    return;
                } else {
                    System.out.println("Seat is already taken");
                    return;
                }
            }
        }
        System.out.println("Seat not found");
    }
}
