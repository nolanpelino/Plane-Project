import java.util.UUID;

public class InternationalFlight extends Flight {
    private String originCountry;
    private String destinationCountry;
    private boolean hasPassport;

    /**
     * 
     * Creates an instance of a InternationalFlight that uses objects from Flight
     * @param planeModel
     * @param seats
     * @param flightlength
     * @param hasTV
     * @param depart
     * @param arrival
     * @param id
     * @param flightNumber
     * @param airline
     * @param arrivalTime
     * @param departureTime
     * @param originCountry
     * @param destinationCountry
     * @param hasPassport 
     */
    public InternationalFlight(String planeModel, Seat[] seats, int flightlength, boolean hasTV, String depart,
            String arrival, UUID id, int flightNumber, String airline, int connectingFlight,
            int arrivalTime, int departureTime, String originCountry, String destinationCountry,
            boolean hasPassport) {
        super(seats, flightlength, hasTV, depart, arrival, id, flightNumber, airline, connectingFlight);
        this.originCountry = originCountry;
        this.destinationCountry = destinationCountry;
        this.hasPassport = hasPassport;
    }
    /**
     * 
     * @return returns the origin country as a String
     */
    public String getOriginCountry() {
        return this.originCountry;
    }

    /**
     * 
     * @return returns the destination country as a String
     */
    public String getDestinationCountry() {
        return this.destinationCountry;
    }

    /**
     * 
     * @return returns true if the user has a passportl; false if not.
     */
    public boolean getPassport(){
    	return this.hasPassport;
    }
    
}