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
    public Flight getFlight(String keyWord) {
        //TODO
    }
}
