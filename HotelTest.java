import org.junit.Test;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;


public class HotelTest {
    
    @Test
    public void testEmptyShowOpenRooms() {
        //Tests with empty ArrayList
        ArrayList<Room> roomsList = new ArrayList<Room>();
        String id = "468676b4-9709-455e-941d-bc89e0846f7f";
        Date today = new Date(System.currentTimeMillis());  // Current Time
        UUID hotelID = UUID.fromString(id);

        ArrayList<Date> stayDates = new ArrayList<Date>();
        stayDates.add(today);  // User is looking to stay at what is technically runtime

        Hotel tstHotel = new Hotel(roomsList, "address", "city", "state", "name",
         200, hotelID , 4, true);
        tstHotel.showOpenRooms(stayDates);
    }

    @Test
    public void testChooseRoom() {
        // Testing choose room for a time thats taken
        ArrayList<Room> roomsList = new ArrayList<Room>();
        Room rm = new Room(222, 200, 1);
        roomsList.add(rm);
        String id = "468676b4-9709-455e-941d-bc89e0846f7f";
        Date today = new Date(System.currentTimeMillis());  // Current Time
        UUID hotelID = UUID.fromString(id);

        ArrayList<Date> stayDates = new ArrayList<Date>();
        stayDates.add(today);  // User is looking to stay at what is technically runtime
        rm.setAvailability(today);  // Sets the room unavailable for the same time the user would be looking for

        Hotel tstHotel = new Hotel(roomsList, "address", "city", "state", "name",
         200, hotelID , 4, true);
        tstHotel.chooseRoom(222, stayDates);
    }
}
