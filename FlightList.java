import java.util.ArrayList;

public class FlightList {
    private static FlightList flightList;
    private ArrayList<Flight> flights;

    private FlightList() {
        DataLoader flightLoader = new DataLoader();
        flights = flightLoader.getFlights();
    }

    public static FlightList getInstance() {
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
    public Flight getFlight(int flightNum) {
        for (Flight fl : flights) {
            if(fl.getFlightNumber() == flightNum)
                return fl;
        }
        System.out.println("Flight not found");
        return null;
    }

    /**
     * @return The entire arraylist of Flights from dataLoader
     */
    public ArrayList<Flight> getFlights() {
		return flights;
	}
}
