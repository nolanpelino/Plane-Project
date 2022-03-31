import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> uList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < uList.size(); i++) {
            jsonUsers.add(getUserJSON(uList.get(i)));
        }

        try (FileWriter file = new FileWriter(USERS_FILENAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getUserJSON(User usr) {
        JSONObject userInfo = new JSONObject();
        userInfo.put(USER_USERNAME, usr.getUsername());
        userInfo.put(USER_PASSWORD, usr.getPassword());
        userInfo.put(USER_AGE, usr.getAge());
        userInfo.put(USER_ADDRESS, usr.getAddress());
        userInfo.put(USER_FRQFLYER, usr.getFrFlyer());
        userInfo.put(USER_HOMEAIRPORT, usr.getHomeAirport());
        userInfo.put(USER_PASSPORT, usr.hasPassport());
        userInfo.put(USER_HASDISABILITY, usr.getHasDisability());

        return userInfo;
    }

    public static void saveFlights() throws FileNotFoundException, IOException, ParseException {
        FlightList flights = FlightList.getInstance();
        ArrayList<Flight> fList = flights.getFlights();
        JSONArray jsonFlights = new JSONArray();

        for (int i = 0; i < fList.size(); i++) {
            jsonFlights.add(getFlightJSON(fList.get(i)));
        }

        try (FileWriter file = new FileWriter(FLIGHTS_FILENAME)) {
            file.write(jsonFlights.toJSONString());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getFlightJSON(Flight flg) {
        JSONObject flightInfo = new JSONObject();
        flightInfo.put(FLIGHT_SEATS, flg.getOpenSeats());
        flightInfo.put(FLIGHT_LENGTH, flg.getLength());
        flightInfo.put(FLIGHT_HASTV, flg.hasTVs());
        flightInfo.put(FLIGHT_DEPART, flg.getDeparture());
        flightInfo.put(FLIGHT_ARRIVAL, flg.getArrival());
        flightInfo.put(FLIGHT_ID, flg.getFlightNumber());
        flightInfo.put(FLIGHT_NUMBER, flg.getFlightNumber());
        flightInfo.put(FLIGHT_AIRLINE, flg.getAirline());

        return flightInfo;
    }

    public static void saveHotel() {
        HotelList hotels = HotelList.getInstance();
        ArrayList<Hotel> hList = hotels.getHotels();
        JSONArray jsonHotels = new JSONArray();

        for (int i = 0; i < hList.size(); i++) {
            jsonHotels.add(getHotelJSON(hList.get(i)));
        }

        try (FileWriter file = new FileWriter(HOTELS_FILENAME)) {
            file.write(jsonHotels.toJSONString());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getHotelJSON(Hotel htl) {
        JSONObject hotelInfo = new JSONObject();
        hotelInfo.put(HOTEL_ADDRESS, htl.getAddress());
        hotelInfo.put(HOTEL_NAME, htl.getName());
        hotelInfo.put(HOTEL_STARS, htl.getRating());
        hotelInfo.put(HOTEL_PRICE, htl.getPrice());
        hotelInfo.put(HOTEL_ID, htl.getID());
        hotelInfo.put(HOTEL_ROOMS, htl.getRooms());
        hotelInfo.put(HOTEL_HASPOOL, htl.hasPool());

        return hotelInfo;
    }

}
