import java.util.UUID;

public class Flight {
    private Seat[] seats;
    private int flightlength;
    private boolean hasTV;
    private String departureAirport;
    private String arrivalAirport;
    private UUID id;
    private String flightNumber;

    public Flight(Seat[] seats, int flightlength, boolean hasTV,
    String depart, String arrival, UUID id, String flightNumber, String airline) {
        this.seats = seats;
        this.flightlength = flightlength;
        this.hasTV = hasTV;
        this.departureAirport = depart;
        this.arrivalAirport = arrival;
        this.id = id;
        this.flightNumber = flightNumber;
    }
    public int getLength() {
        return this.flightlength;
    }

    public String getDeparture() {
        return this.departureAirport;
    }

    public String getArrival() {
        return this.arrivalAirport;
    }
    public boolean hasTVs() {
        return this.hasTV;
    }

    public int getFlightNumber() {
        return this.flightNumber;
    }
}
