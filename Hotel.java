import java.util.UUID;

public class Hotel {
    private Room[] rooms;
    private String address;
    private String name;
    private int price;
    private UUID id;
    private int stars;
    private boolean pool;

    public Hotel(Room[] roomarr, int price, String addr, String name, UUID ID,
    int review, boolean pool) {
        this.price = price;
        this.address = addr;
        this.name = name;
        this.stars = review;
        this.pool = pool;
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
    public void showOpenRooms(Date day) {
        
    }
}
