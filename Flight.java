import java.util.ArrayList;
import java.util.UUID;

public class Flight {
    private ArrayList<Seat> seats;
    private int flightlength;
    private boolean hasTV;
    private String departureAirport;
    private String arrivalAirport;
    private UUID id;
    private String flightNumber;

    /**
     * Flight Constructor
     * @param Seat
     * @param int
     * @param boolean
     * @param String
     * @param String
     * @param UUID
     * @param String
     * @param String
     */
    public Flight(ArrayList<Seat> seats, int flightlength, boolean hasTV,
    String depart, String arrival, UUID id, String flightNumber, String airline) {
        this.seats = seats;
        this.flightlength = flightlength;
        this.hasTV = hasTV;
        this.departureAirport = depart;
        this.arrivalAirport = arrival;
        this.id = id;
        this.flightNumber = flightNumber;
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
    public String getFlightNumber() {
        return this.flightNumber;
    }

    /**
     * Returns an array list of open seats
     * @return ArrayList<Seat>
     */
    public ArrayList getOpenSeats() {
        ArrayList<Seat> opens = new ArrayList<Seat>();
        for (Seat s : seats) {
            if (s.getAvailability())
                opens.add(s);
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
            if (counter == 4) {
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
        for (Seat s : seats) {
            if (s.getExactPosition().equalsIgnoreCase(seatNum)) {
                if (s.getAvailability()) {
                    s.fillSeat();
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
