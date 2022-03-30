import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Hotel {
    private String address;
    private String name;
    private int price;
    private UUID id;
    private Room[] rooms;
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
    public Hotel(Room[] rooms, String address, String name, int stars, boolean pool, UUID id) {
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

        for(int i = 0; i < rooms.length; i++) {
            completelyEmpty = true;
            for(Date sd : stayDates) { // goes through every date to ensure the are all open
                if (rooms[i].getAvailability(sd) == false) {
                    completelyEmpty = false;
                    continue;  // if one of the dates has a booked room, the for each loop ends
                }
            }
            if (completelyEmpty) {
                availRooms.add(rooms[i]);
            } else {
                System.out.println("Sorry, there are no rooms available for your chosen dates.");
            }
        } // outer-forloop bracket
        
        System.out.println("These are the open rooms for your stay time: \n");
        for(Room rm : availRooms) {
            if (printCounter == 3) {
                System.out.println("\n");
                printCounter = 0;
            }
            System.out.println(rm.getRoomNumber() + "\t");
            printCounter++;
        }
    }

    /**
     * Books a *AVAILABLE* room of the users choice and on their stay dates.
     * @param roomNum
     * @param stayDates
     */
    public void chooseRoom(int roomNum, ArrayList<Date> stayDates) {  // Does not include a scanner. Input must occur in UI
        for (int i = 0; i < rooms.length; i++) {
            if(roomNum == rooms[i].getRoomNumber()) {
                for(Date stdt : stayDates) {
                    rooms[i].setAvailability(stdt);  // Sets availability as unavailable for all days in the passed array
                }
            }
        }
    }
}
