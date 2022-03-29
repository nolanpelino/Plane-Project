import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Hotel {
    private String address;
    private String name;
    private int price;
    private UUID id;
    private ArrayList<Room> rooms;
    private boolean pool;
    private int stars;

    /**
     * Constructor
     * @param Room
     * @param String
     * @param String
     * @param int
     * @param boolean
     * @param UUID
     */
    public Hotel(ArrayList<Room> rooms, String address, String name, int stars, boolean pool, UUID id) {
        this.rooms = rooms;
        this.address = address;
        this.name = name;
        this.stars = stars;
        this.pool = pool;
        this.id = id;
    }

    /**
     * Returns the name of the hotel
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the hotel's adress
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns the hotel's rating
     * @return int
     */
    public int getRating() {
        return this.stars;
    }

    /**
     * Returns the result of the hotel having a pool
     * @return boolean
     */
    public boolean hasPool() {
        return this.pool;
    }

    /**
     * Prints out all of the open rooms of a hotel object
     * @param Date
     */
    public void showOpenRooms(ArrayList<Date> stayDates) {
        ArrayList<Room> availRooms = new ArrayList<Room>();
        boolean completelyEmpty;
        int printCounter = 0;

        for(Room rm : rooms) {
            completelyEmpty = true;
            for(Date sd : stayDates) {
                if (rm.getAvailability(sd) == false) {
                    completelyEmpty = false;
                    continue;
                }
            }
            if (completelyEmpty) {
                availRooms.add(rm);

            }
        } // outer-forloop bracket

        System.out.println("These are the open rooms for your stay time: \n");
        for(Room rm : availRooms) {
            if (printCounter == 3) {
                System.out.println("\n");
                printCounter = 0;
            }
            System.out.println(rm.getRoomNumber() + "   ");
            printCounter++;
        }
    }
}
