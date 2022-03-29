import java.util.UUID;

public class InternationalFlight extends Flight {
    private String originCountry;
    private String destinationCountry;
    private boolean hasPassport;

    public InternationalFlight(String planeModel, Seat[] seats, int flightlength, boolean hasTV, String depart,
            String arrival, UUID id, String flightNumber, String airline,
            int arrivalTime, int departureTime, String originCountry, String destinationCountry,
            boolean hasPassport) {
        super(seats, flightlength, hasTV, depart, arrival, id, destinationCountry, airline, arrivalTime, departureTime);
        this.originCountry = originCountry;
        this.destinationCountry = destinationCountry;
        this.hasPassport = hasPassport;
    }
    
    public String getOriginCountry() {
        return this.originCountry;
    }

    public String getDestinationCountry() {
        return this.destinationCountry;
    }

    public boolean getPassport(){
    	return this.hasPassport;
    }
    
}