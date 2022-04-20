
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.junit.Test;
public class FlightListTest {
    
    @Test
    public void testAddFlight() throws FileNotFoundException, IOException, ParseException{
        FlightList testFlightList = FlightList.getInstance();
        Seat[] seats = new Seat[1]; 
        UUID testUUID = UUID.randomUUID();
        Seat testSeat = new Seat(200, "First Class", 1, 'B', true);
        seats[0]=testSeat;
        testFlightList.addFlight(seats, 200, true, "CLT", "ATL", testUUID, 2209, "American", 0);
        testFlightList.getFlight(2209);
        Flight actualFlight = new Flight(seats, 200, true, "CLT", "ATL", testUUID, 2209, "American", 0);
        assertEquals(actualFlight, testFlightList.getFlight(2209));
    }

    @Test
    public void testAddFlightAgain(){

    }
}
