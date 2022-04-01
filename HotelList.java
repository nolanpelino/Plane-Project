import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class HotelList {
    private static HotelList hotelList;
    private ArrayList<Hotel> hotels;

    private HotelList() throws FileNotFoundException, IOException, ParseException {
        hotels = DataLoader.getHotels();
    }

    public static HotelList getInstance() throws FileNotFoundException, IOException, ParseException {
        if(hotelList == null) {
            hotelList = new HotelList();
            return hotelList;
        }
        else {
            return hotelList;
        }
    }


    public Hotel getHotel(String address) {
        for (Hotel htl : hotels) {
            if (htl.getAddress().equalsIgnoreCase(address))
                return htl;
        }
        System.out.println("Hotel not found");
        return null;
    }

    public ArrayList<Hotel> getHotels() {
		return hotels;
	}
}
