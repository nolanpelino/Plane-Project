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

    /**
     * Class used for interactions that call for a more complex user. Extends BasicUser
     * @param username
     * @param password
     * @param age
     * @param address
     * @param hasDisability
     * @param homeAirport
     * @param passport
     */
    public User(String username, String password, int age, String address, boolean hasDisability,String homeAirport, boolean passport) {
        super(username,age,passport,hasDisability);
        this.homeAirport = homeAirport;
        this.address=address;
        this.passport=passport;
    }

    /**
     * Returns the user's username as a string
     * @return String
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Returns true if the user has a passport
     * @return boolean
     */
    public boolean hasPassport() {
        return this.passport;
    }

    /**
     * Returns the age of the user
     * @return int
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets the user's frequent flyer status to true if they have more than 3 lifetime flights
     */
    public void setFrFlyer() {
        if(tickets.size() > 3)
            frequentFlyer=true;
    }
    
    /**
     * Adds a basic user to the modified user's family
     * @param familyMember
     */
    public void linkFamily(BasicUser familyMember) {
        familyUsers.add(familyMember);
    }

    /**
     * Displays all of te users Boarding Passes
     */
    public void printTickets() {
        for (PlaneTicket tck : tickets) {
            tck.displayTicket();
        }
    }

    /**
     * Displays all of the users hotel reservations
     */
    public void printHotelBookings() {
        for (HotelBooking htl : hotelBookings) {
            htl.displayHBooking();
        }
    }

    public ArrayList<Flight> sortFlightsDeparting(String departingAirport) {
        System.out.println("What would ");
    }

    public ArrayList<Flight> sortFlightsArrival(String arrivalAirport) {

    }

    public ArrayList<Flight> sortFlightsByTime() {
        
    }

    public Hotel sortHotel(String address) {

    }
    
}
