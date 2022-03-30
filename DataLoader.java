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
        /*JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(USERS_FILENAME)){ 
            Object obj = JSONParser.parse(reader);
            JSONArray userJSON = (JSONArray) obj;
            
        }*/
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader(USERS_FILENAME));
        for (Object o: a) {
		    JSONObject user = (JSONObject) o;
		    String username = (String) user.get("username");
		    //System.out.println(username);
		
		    String password = (String) user.get("password");
		    //System.out.println(password);

		    int age = (int) (double) user.get("age");
		    //System.out.println(age);

		    String address = (String) user.get("address");
		    //System.out.println(address);

		    //JSONArray family = (JSONArray) user.get("familyUsers");
		    //if (family != null){
                //for (Object c: family) 
		            //System.out.println(c+" ");
            //}
		    boolean frequentFlyer = (boolean) user.get("frequentFlyer");

		    String homeAirport = (String) user.get("homeAirport");
		    //System.out.println(homeAirport);

		    boolean passport = (boolean) user.get("passport");

		    boolean hasDisabilities = (boolean) user.get("hasDisability");
		
		    JSONArray tickets = (JSONArray) user.get("tickets");
		    for (Object c: tickets) {
                JSONObject flight = (JSONObject) c;
                //System.out.println((String) flight.get("myFlight"));
            }
		    JSONArray hotelBookings = (JSONArray) user.get("hotelBookings");
		    for (Object c: hotelBookings) {
                JSONObject hotel = (JSONObject) c;
                //System.out.println((int) (double) hotel.get("confirmationNumber"));
		    }
            User ex = new User(username, password, age, address, hasDisabilities, homeAirport, passport);
            users.add(ex);
        }
        return users;
    }

    public static ArrayList<Hotel> getHotels() throws FileNotFoundException, IOException, ParseException {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        ArrayList<Room> totRooms = new ArrayList<Room>();
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader(HOTELS_FILENAME));
        for (Object o: a) {
            JSONObject hotel = (JSONObject) o;
            JSONArray rooms = (JSONArray) hotel.get("hotelRooms");
            for (Object c: rooms) {
                JSONObject goon = (JSONObject) c;
                int roomNumber = Integer.parseInt((String) goon.get("roomNumber"));
                double price = Double.parseDouble((String) goon.get("price"));
                int numBeds = Integer.parseInt((String)goon.get("numBeds"));
                Room exor = new Room(roomNumber, price, numBeds);
                totRooms.add(exor);
            }

            String address = (String) hotel.get("hotelAddress");

            String name = (String) hotel.get("hotelName");

            int stars = (int) (double) hotel.get("hotelStars");

            boolean pool = (boolean) hotel.get("hotelPool");

            UUID id = (UUID) hotel.get("hotelID");
            Room[] fin = new Room[totRooms.size()];
            for (int h = 0; h < fin.length; h++) {
                fin[h] = totRooms.get(h);
            }
            Hotel ex = new Hotel(fin, address, name, stars, pool, id);
            hotels.add(ex);
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
            String flightNumber = (int) flight.get("flightNumber");
            String airline = (String) flight.get("flightAirline");
            int connectingNum = (int) flight.get("connectingFLNumber");
            Seat[] epi = new Seat[seats.size()];
            for (int g = 0; g < epi.length; g++) {
                epi[g] = seats.get(g);
            }
            Flight ex = new Flight(epi, flightLength, hasTV, depart, arrival, id, flightNumber, airline);
            flights.add(ex);
        }
        return flights;
    }
}
