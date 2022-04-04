import java.util.ArrayList;
import java.util.UUID;

public class User extends BasicUser{
    private String username;
    private String password;
    private UUID uuid;
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
     * Constructor for loading from files
     * @param username
     * @param password
     * @param age
     * @param address
     * @param hasDisability
     * @param homeAirport
     * @param passport
     */
    public User(String username, String password,UUID uuid, int age, String address, boolean frequentFlyer, String homeAirport, boolean passport, boolean hasDisability) {
        super(username,age,passport,hasDisability);
        this.username = username;
        this.password = password;
        this.age = age;
        this.frequentFlyer = frequentFlyer;
        this.uuid=uuid;
        this.homeAirport = homeAirport;
        this.address=address;
        this.passport=passport;
        this.hasDisability = hasDisability;
    }
    
    /**
     * Constructor for making user in the UI
     * @param username
     * @param password
     * @param age
     * @param address
     * @param frequentFlyer
     * @param homeAirport
     * @param passport
     * @param hasDisability
     */
    public User(String username, String password, int age, String address, boolean frequentFlyer, String homeAirport, boolean passport, boolean hasDisability) {
        super(username,age,passport,hasDisability);
        this.username = username;
        this.password = password;
        this.age = age;
        this.uuid=UUID.randomUUID();
        this.homeAirport = homeAirport;
        this.address=address;
        this.frequentFlyer = frequentFlyer;
        this.passport=passport;
        this.hasDisability = hasDisability;
    }

    /**
     * @return The user's username as a string
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 
     * @return The user's password
     */
    public String getPassword() {
        return this.password;
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
     * 
     * @return User's Adress
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 
     * @return ArrayList of the user's family
     * BasicUser objects
     */
    public ArrayList<BasicUser> getFamilyUsers() {
        return this.familyUsers;
    }

    /**
     * @return String of the user's home airport
     */
    public String getHomeAirport() {
        return this.homeAirport;
    }

    /**
     * 
     * @return Boolean value of the user's disabiilites
     */
    public boolean getHasDisability() {
        return this.hasDisability;
    }

    /**
     * 
     * @return ArrayList of all the user's tickets
     */
    public ArrayList<PlaneTicket> getTickets() {
        return this.tickets;
    }

    /**
     * 
     * @return ArrayList of all the user's hotel's
     */
    public ArrayList<HotelBooking> getHotelBookings() {
        return this.hotelBookings;
    }

    /**
     * 
     * @return The user's frequent flyer status
     */
    public boolean getFrFlyer() {
        return this.frequentFlyer;
    }

    /**
     * 
     * @return The UUID of a user
     */
    public UUID getUUID(){
        return this.uuid;
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
    public void printLinkedAccounts() {
        for (BasicUser bsc : familyUsers) {
            bsc.displayAccount();
        }

    }
    /*
    * Adds a PlaneTicket to the ArrayList
    */
    public void addFlightTicket(PlaneTicket planeTicket) {
    	tickets.add(planeTicket);
    }
}
