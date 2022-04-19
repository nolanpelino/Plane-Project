import static org.junit.Assert.assertEquals;
import java.util.UUID;


import org.junit.Test;
public class FlightTest {
    
    @Test
    public void testTakeOpenSeat(){
        Seat[] seats = new Seat[30]; 
        UUID testUUID = UUID.randomUUID();
        Seat testSeat = new Seat(200, "First Class", 1, 'B', true);
        seats[0]=testSeat;
        Flight testFlight = new Flight(seats, 200, true, "CLT", "ATL", testUUID, 2209, "American", 0);
        Seat finalTestedSeat = testFlight.takeSeat("1B");
        assertEquals(testSeat, finalTestedSeat);
    }

    @Test
    public void testTakeNotOpenSeat(){

    }
}
