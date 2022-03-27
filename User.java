import java.util.ArrayList;

public class User extends BasicUser{
    private String username;
    private String password;
    private int age;
    private String address;
    private ArrayList<BasicUser> familyUsers;
    private boolean frequentFlyer;
    private String homeAirport;
    private boolean passport;
    private boolean hasDisability;
    private ArrayList<PlaneTicket> tickets;
    private ArrayList<HotelBooking> hotelBookings;

    public User(String username, String password, int age, String address, boolean hasDisability,String homeAirport, boolean passport) {
        super(username,age,passport,hasDisability);
        this.homeAirport = homeAirport;
        this.address=address;
        this.passport=passport;
    }

    public String getUsername() {
        return this.username;
    }
    
    public boolean hasPassport() {
        return this.passport;
    }

    public int getAge() {
        return this.age;
    }

    public void setFrFlyer() {
        if(tickets.size() > 3)
            frequentFlyer=true;
    }
    
    public void linkFamily(BasicUser familyMember) {
        familyUsers.add(familyMember);
    }

    public Flight sortFlightsDeparting(String departingAirport) {
        
    }

    public Flight sortFlightsArrival(String arrivalAirport) {

    }

    public Hotel sortHotel(String address) {

    }
    
}
