import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.UUID;


import org.junit.Test;
public class FlightTest {
    
    @Test
    public void testTakeOpenSeat(){
        Seat[] seats = new Seat[1]; 
        UUID testUUID = UUID.randomUUID();
        Seat testSeat = new Seat(200, "First Class", 1, 'B', true);
        seats[0]=testSeat;//Sets the test seat to the first seat in the array
        Flight testFlight = new Flight(seats, 200, true, "CLT", "ATL", testUUID, 2209, "American", 0);
        Seat finalTestedSeat = testFlight.takeSeat("1B");//Attempts to book this seat (should return that seat)
        assertEquals(testSeat, finalTestedSeat);
    }

    @Test
    public void testTakeNotOpenSeat(){
        Seat[] seats = new Seat[1]; 
        UUID testUUID = UUID.randomUUID();
        Seat testSeat = new Seat(200, "First Class", 1, 'B', true);
        seats[0]=testSeat;
        Flight testFlight = new Flight(seats, 200, true, "CLT", "ATL", testUUID, 2209, "American", 0);
        Seat takenSeat = testFlight.takeSeat("1B");//Seat is taken and therefore should not be able to be booked
        Seat tryingToTake = testFlight.takeSeat("1B");//Attempting to book the seat again (should return null)
        assertEquals(null, tryingToTake);

    }

    @Test 
    public void testGetOpenSeats(){
        ArrayList<Seat> correctSeatArrayList = new ArrayList<>();
        Seat[] seats = new Seat[3]; 
        UUID testUUID = UUID.randomUUID();
        Seat testSeat1 = new Seat(200, "First Class", 1, 'A', true);
        Seat testSeat2 = new Seat(200, "First Class", 1, 'B', true);
        Seat testSeat3 = new Seat(200, "First Class", 1, 'C', true);
        seats[0]=testSeat1;
        seats[1]=testSeat2;
        seats[2]=testSeat3;
        correctSeatArrayList.add(testSeat1);
        correctSeatArrayList.add(testSeat2);
        correctSeatArrayList.add(testSeat3);
        Flight testFlight = new Flight(seats, 200, true, "CLT", "ATL", testUUID, 2209, "American", 0);
        ArrayList<Seat> testSeatArrayList;
        testSeatArrayList = testFlight.getOpenSeats();
        assertEquals(correctSeatArrayList, testSeatArrayList);
    }

    @Test
    public void testGetNoOpenSeats(){
        ArrayList<Seat> correctSeatArrayList = new ArrayList<>();
        Seat[] seats = new Seat[3]; 
        UUID testUUID = UUID.randomUUID();
        Seat testSeat1 = new Seat(200, "First Class", 1, 'A', true);
        Seat testSeat2 = new Seat(200, "First Class", 1, 'B', true);
        Seat testSeat3 = new Seat(200, "First Class", 1, 'C', true);
        seats[0]=testSeat1;
        seats[1]=testSeat2;
        seats[2]=testSeat3;
        Flight testFlight = new Flight(seats, 200, true, "CLT", "ATL", testUUID, 2209, "American", 0);
        testFlight.takeSeat("1A");
        testFlight.takeSeat("1B");
        testFlight.takeSeat("1C");
        ArrayList<Seat> testSeatArrayList;
        testSeatArrayList = testFlight.getOpenSeats();
        assertEquals(correctSeatArrayList, testSeatArrayList);
    }
}
