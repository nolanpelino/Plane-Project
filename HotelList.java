import java.util.ArrayList;

public class HotelList {
    private static HotelList hotelList;
    private ArrayList<Hotel> hotels;

    private HotelList() {
        //TODO
    }

    public HotelList getInstance() {
        if(hotelList == null) {
            hotelList = new HotelList();
            return hotelList;
        }
        else {
            return hotelList;
        }
    }

    public Hotel getHotel() {
        //TODO
    }
}
