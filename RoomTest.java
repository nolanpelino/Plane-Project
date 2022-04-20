import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import org.junit.Test;

public class RoomTest {
    @Test
    public void getAvailabilityTest(){
        Date dateTaken = new Date(System.currentTimeMillis());
        Room testRoom = new Room(203, 100, 2);
        testRoom.setAvailability(dateTaken);
        assertFalse(testRoom.getAvailability(dateTaken));
    }

    @Test
public void getNoAvailabilityTest(){
    Date dateTaken = new Date(System.currentTimeMillis());
    Room testRoom = new Room(203, 100, 2);
    Date dateTakenLater = new Date(System.currentTimeMillis());
    testRoom.setAvailability(dateTaken);
    assertTrue(testRoom.getAvailability(dateTakenLater));
    }   
}