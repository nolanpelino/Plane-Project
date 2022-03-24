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

    public Hotel(ArrayList<Room> rooms, String address, String name, int stars, boolean pool, UUID id) {
        this.rooms = rooms;
        this.address = address;
        this.name = name;
        this.stars = stars;
        this.pool = pool;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getRating() {
        return this.stars;
    }

    public boolean hasPool() {
        return this.pool;
    }

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
