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

    public String getAddress() {
        return this.address;
    }

    public ArrayList<BasicUser> getFamilyUsers() {
        return this.familyUsers;
    }

    public String getHomeAirport() {
        return this.homeAirport;
    }

    public boolean getHasDisability() {
        return this.hasDisability;
    }

    public ArrayList<PlaneTicket> getTickets() {
        return this.tickets;
    }

    public ArrayList<HotelBooking> getHotelBookings() {
        return this.hotelBookings;
    }

    public boolean getFrFlyer() {
        return this.frequentFlyer;
    }

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
}
