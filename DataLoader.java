import java.io.FileNotFoundException;
import java.util.UUID;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader extends DataConstants {
    public static ArrayList<User> getUsers() throws IOException, ParseException {
        ArrayList<User> users = new ArrayList<User>();
        try{
            FileReader reader = new FileReader(USERS_FILENAME);
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray)new JSONParser().parse(reader);
        
        for (int i=0; i< a.size(); i++) {
		    JSONObject user = (JSONObject)a.get(i);
		    String username = (String) user.get(USER_USERNAME);
		    String password = (String) user.get(USER_PASSWORD);
            UUID uuid = UUID.fromString((String)user.get(USER_UUID));
		    int age = ((Long)user.get(USER_AGE)).intValue();
		    String address = (String) user.get(USER_ADDRESS);
		    boolean frequentFlyer = (boolean) user.get(USER_FRQFLYER);
		    String homeAirport = (String) user.get(USER_HOMEAIRPORT);
		    boolean passport = (boolean) user.get(USER_PASSPORT);
		    boolean hasDisabilities = (boolean) user.get(USER_HASDISABILITY);	
		    //JSONArray tickets = (JSONArray) user.get("tickets");
		    
            // for (Object c: tickets) {
            //     JSONObject flight = (JSONObject) c;
            //     //System.out.println((String) flight.get("myFlight"));
            // }
		    // JSONArray hotelBookings = (JSONArray) user.get("hotelBookings");
		    // for (Object c: hotelBookings) {
            //     JSONObject hotel = (JSONObject) c;
            //     //System.out.println((int) (double) hotel.get("confirmationNumber"));
		    // }
            User ex = new User(username, password,uuid, age, address, frequentFlyer, homeAirport, passport, hasDisabilities);
            users.add(ex);
            }
            return users;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
        }

    public static ArrayList<Hotel> getHotels() throws FileNotFoundException, IOException, ParseException {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        ArrayList<Room> rooms = new ArrayList<Room>();
        try{
            JSONParser parser = new JSONParser();
            JSONArray hotelsJSON = (JSONArray) new JSONParser().parse(HOTELS_FILENAME);
            JSONArray roomsJSON = (JSONArray) new JSONParser().parse(HOTELS_FILENAME);
            for(int i=0; i<hotelsJSON.size(); i++){
                JSONObject hotelJSON = (JSONObject)roomsJSON.get(i);
                String hotelAddress = (String)hotelJSON.get(HOTEL_ADDRESS);
                String hotelName = (String)hotelJSON.get(HOTEL_NAME);
                String hotelState = (String)hotelJSON.get(HOTEL_STATE);
                String hotelCity = (String)hotelJSON.get(HOTEL_CITY);
                int price = (int)hotelJSON.get(HOTEL_PRICE); 
                int hotelStars = (int)hotelJSON.get(HOTEL_STARS);
                Boolean hotelPool = (Boolean)hotelJSON.get(HOTEL_HASPOOL);
                UUID hotelID = (UUID)hotelJSON.get(HOTEL_ID);
                
                for(int j=0; j<roomsJSON.size(); i++){
                    int roomNumber = (int)hotelJSON.get(ROOM_NUMBER);
                    int roomPrice = (int)hotelJSON.get(ROOM_PRICE);
                    int numBeds = (int)hotelJSON.get(ROOM_BEDS);
                    rooms.add(new Room(roomNumber, roomPrice, numBeds));
                }
                hotels.add(new Hotel(rooms, hotelAddress, hotelCity, hotelState, hotelName, price, hotelID, hotelStars, hotelPool));
            }
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        return hotels;
    }

    public static ArrayList<Flight> getFlights() throws FileNotFoundException, IOException, ParseException {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        JSONParser parser = new JSONParser();
        ArrayList<Seat> seats = new ArrayList<Seat>();
        JSONArray a = (JSONArray) parser.parse(new FileReader(FLIGHTS_FILENAME));
        for (Object o: a) {
            JSONObject flight = (JSONObject) o;
            JSONArray seater = (JSONArray) flight.get("flightseats");
            for (Object c: seater) {
                JSONObject seat = (JSONObject) c;
                double price = Double.parseDouble((String) seat.get("price"));
                String seatSection = (String) seat.get("seatSection");
                int row = Integer.parseInt((String) seat.get("row"));
                char seatPosition = ((String) seat.get("seatPosition")).charAt(0);
                boolean extraLegRoom = (boolean) seat.get("extraLegRoom");
                Seat ex2 = new Seat(price, seatSection, row, seatPosition, extraLegRoom);
                seats.add(ex2);
            }
            int flightLength = (int) (double) flight.get("flightlength");
            boolean hasTV = (boolean) flight.get("flightTV");
            String depart = (String) flight.get("flightDeparture");
            String arrival = (String) flight.get("flightArrival");
            UUID id = (UUID) flight.get("flightID");
            int flightNumber = (int) flight.get("flightNumber");
            String airline = (String) flight.get("flightAirline");
            int connectingNum = (int) flight.get("connectingFLNumber");
            Seat[] epi = new Seat[seats.size()];
            for (int g = 0; g < epi.length; g++) {
                epi[g] = seats.get(g);
            }
            Flight ex = new Flight(epi, flightLength, hasTV, depart, arrival, id, flightNumber, airline, connectingNum);
            flights.add(ex);
        }
        return flights;
    }
}
