import java.util.ArrayList;

public class HotelList {
    private static HotelList hotelList;
    private ArrayList<Hotel> hotels;

    private HotelList() {
        //TODO
    }

    public static HotelList getInstance() {
        if(hotelList == null) {
            hotelList = new HotelList();
            return hotelList;
        }
        else {
            return hotelList;
        }
    }

    public Hotel getHotel(String adress) {
        for (Hotel htl : hotels) {
            if (htl.getAddress().equalsIgnoreCase(adress))
                return htl;
        }
        System.out.println("Hotel not found");
        return null;
    }

    public ArrayList<Hotel> getHotels() {
		return hotels;
	}
}
