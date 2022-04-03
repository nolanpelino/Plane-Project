import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.parser.ParseException;

public class FlightList {
    private static FlightList flightList;
    private ArrayList<Flight> flights;

    private FlightList() throws FileNotFoundException, IOException, ParseException {
        flights = DataLoader.getFlights();
    }

    public static FlightList getInstance() throws FileNotFoundException, IOException, ParseException {
        if(flightList == null) {
            flightList = new FlightList();
            return flightList;
        }
        else {
            return flightList;
        }
    }

    /**
     * Checks to see if user's flight already exists
     * @param userName
     * @return
     */
    public boolean haveFlight(int flightNum){
        for(Flight fl : flights){
            if(fl.getFlightNumber() == flightNum){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param keyWord
     * @return An instance of a flight that contains the same flight number that was passed in
     */
    public Flight getFlight(int flightNum) {
        for (Flight fl : flights) {
            if(fl.getFlightNumber() == flightNum)
                return fl;
        }
        System.out.println("Flight not found");
        return null;
    }

    /**
     * 
     * @return the list of users
     */ 
    public ArrayList<Flight> getFlights() {
		return flights;
	}

    public boolean addFlight(Seat[] seats, int flightlength, boolean hasTV,
    String depart, String arrival, UUID id, int flightNumber, String airline, int connectingFlight) {
        if(haveFlight(flightNumber)){
            return false;
        }
            flights.add(new Flight(seats, flightlength, hasTV, depart, arrival, id, flightNumber, airline, connectingFlight));
            return true;
        }

    public void saveFlights() throws IOException, ParseException{
        DataWriter.saveFlights();
    }
}
