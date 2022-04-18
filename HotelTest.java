import org.junit.Test;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;


public class HotelTest {
    
    @Test
    public void testEmptyShowOpenRooms() {
        //Tests with empty ArrayList and No dates
        ArrayList<Room> roomsList = new ArrayList<Room>();
        String id = "468676b4-9709-455e-941d-bc89e0846f7f";
        UUID hotelID = UUID.fromString(id);
        ArrayList<Date> stayDates = new ArrayList<Date>();
        Hotel tstHotel = new Hotel(roomsList, "address", "city", "state", "name",
         200, hotelID , 4, true);
        tstHotel.showOpenRooms(stayDates);
    }
}
