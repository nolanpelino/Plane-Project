import java.util.UUID;

public class Flight {
    private String planeModel;
    private Seat[] seats;
    private int flightlength;
    private boolean hasTV;
    private String departureAirport;
    private String arrivalAirport;
    private UUID id;

    public Flight(String planeModel, Seat[] seats, int flightlength, boolean hasTV,
    String depart, String arrival, UUID id) {
        //TODO
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
    public String displayFlight() {
        return ""; //TODO not sure exactly what to display
    }
    
}
