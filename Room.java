import java.sql.Date;
import java.util.ArrayList;

public class Room extends Item {
    private double price;
    private int roomNumber;
    private int numBeds;
    private ArrayList<Date> availability;

    /**
     * Class that represents a room in a hotel
     * @param roomNumber
     * @param price
     * @param numBeds
     */
    public Room(int roomNumber, double price, int numBeds) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.numBeds = numBeds;
        availability = new ArrayList<Date>();
    }

    /**
     * Returns the room number
     * @return int
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Returns the number of beds in a hotel room
     * @return int
     */
    public int getBeds() {
        return this.numBeds;
    }

    /**
     * @return the price of a room
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Books the room for the entered Date
     * @param day
     */
    public void setAvailability(Date day) {
        availability.add(day);
    }

    /**
     * Returns true if the room is available for the parameterized day
     * @param day
     * @return boolean
     */
    public boolean getAvailability(Date day) {
        if (availability.contains(day))
            return false;
        else
            return true;
    }

    
}
