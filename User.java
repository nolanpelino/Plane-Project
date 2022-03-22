import java.util.ArrayList;

public class User extends BasicUser{
    private String username;
    private String password;
    private int age;
    private String address;
    private ArrayList<BasicUser> familyUser;
    private boolean frequentFlyer;
    private String airportOfOrigin;
    private boolean passport;
    private boolean hasDisability;
    private ArrayList<PlaneTicket> tickets;
    private ArrayList<HotelBooking> hotelBookings;

    public User(String username, String password, int age, String address, boolean hasDisability, boolean passport){

    }

    public boolean hasPassport(){

    }

    public int getAge(){

    }

    public void setFlyer(){

    }

    public void linkFamily(){

    }

    public Flight sortFlightsDeparting(String departingAirport){

    }

    public Flight sortFlightsArrival(String arrivalAirport){

    }

    public Hotel sortHotel(String address){

    }
    
}
