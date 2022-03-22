import java.sql.Date;
import java.util.ArrayList;

public class Room extends Item {
    private double price;
    private int roomNumber;
    private int numBeds;
    private ArrayList<Date> availability;

    public Room(int roomNumber, double price, int numBeds) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.numBeds = numBeds;
        availability = new ArrayList<Date>();
    }

    public void setAvailability(Date day) {
        availability.add(day);
    }

    public boolean getAvailability(Date day) {
        if (availability.contains(day))
            return false;
        else
            return true;
    }
}
