import java.util.ArrayList;

public class FlightList {
    private static FlightList flightList;
    private ArrayList<Flight> flights;

    private FlightList() {
        //TODO
    }

    public FlightList getInstance() {
        if(flightList == null) {
            flightList = new FlightList();
            return flightList;
        }
        else {
            return flightList;
        }
    }

    /**
     * 
     * @param keyWord
     * @return An instance of a flight that contains the same flight number that was passed in
     */
    public Flight getFlight(String keyWord) {
        for (Flight fl : flights) {
            if(fl.getFlightNumber().equalsIgnoreCase(keyWord))
            return fl;
        }
        System.out.println("Flight not found");
        return null;
    }
}
