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

    public User(String username, String password, int age, String address, boolean hasDisability,String airportOfOrigin, boolean passport){
        super(username,age,passport,hasDisability);
        this.airportOfOrigin=airportOfOrigin;
        this.address=address;
        this.passport=passport;
    }
    
    public boolean hasPassport(){
        return passport;
    }

    public int getAge(){
        return age;
    }

    public void setFrFlyer(){
        if(tickets.)
        frequentFlyer=true;
    }
    
    public void linkFamily(BasicUser family){
        familyUser.add(family);
    }

    public Flight sortFlightsDeparting(String departingAirport){
        
    }

    public Flight sortFlightsArrival(String arrivalAirport){

    }

    public Hotel sortHotel(String address){

    }
    
}
