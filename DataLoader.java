import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USERS_FILENAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < userJSON.size(); i++) {

            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Hotel> getHotels() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        
        try {
            FileReader reader = new FileReader(HOTELS_FILENAME);
            JSONParser parser = new JSONParser();
            JSONArray hotelsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < hotelsJSON.size(); i++) {
                
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public static ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader(USERS_FILENAME);
            JSONParser parser = new JSONParser();
            JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < flightsJSON.size(); i++) {
                
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }
}
