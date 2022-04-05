import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class HotelList {
    private static HotelList hotelList = null;
    private ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    private HotelList() throws FileNotFoundException, IOException, ParseException {
        hotels = DataLoader.getHotels();
    }

    /**
     * @return An instance of a hotel list if it is not null
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static HotelList getInstance() throws FileNotFoundException, IOException, ParseException {
        if(hotelList == null) {
            hotelList = new HotelList();
            return hotelList;
        }
        else {
            return hotelList;
        }
    }

    /**
     * @param address
     * @return A hotel object matching the passed in address
     */
    public Hotel getHotel(String address) {
        for (Hotel htl : hotels) {
            if (htl.getAddress().equalsIgnoreCase(address))
                return htl;
        }
        System.out.println("Hotel not found");
        return null;
    }

    /**
     * @return ArrayList contained in the HotelList object
     */
    public ArrayList<Hotel> getHotels() {
		return hotels;
	}
}
