import java.util.UUID;

public class InternationalFlight extends Flight {
    private String originCountry;
    private String destinationCountry;
    private boolean hasPassport;

    public InternationalFlight(String planeModel, Seat[] seats, int flightlength, boolean hasTV, String depart,
            String arrival, UUID id, String originCountry, String destinationCountry,
            boolean hasPassport) {
        super(planeModel, seats, flightlength, hasTV, depart, arrival, id);
        this.originCountry = originCountry;
        this.destinationCountry = destinationCountry;
        this.hasPassport = hasPassport;
    }
    
    
}
