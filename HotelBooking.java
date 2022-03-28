import java.sql.Date;
import java.util.ArrayList;

public class HotelBooking {
    private int confirmationNumber;
    private Hotel yourHotel;
    private ArrayList<Date> stayDates;
    private Room yourRoom;
    private User guest;

    public HotelBooking(int confirmationNumber, Hotel yourHotel, ArrayList<Date> stayDates, Room yourRoom, User guest) {
        this.confirmationNumber = confirmationNumber;
        this.yourHotel = yourHotel;
        this.stayDates = stayDates;
        this.yourRoom = yourRoom;
        this.guest = guest;
    }

    public void displayHBooking() {
        System.out.println("Hotel booking for " + guest.getUsername());
        System.out.println("Confirmation Number: " + confirmationNumber);
        System.out.println("Staying at " + yourHotel.getName() + " Adress: " + yourHotel.getAddress());
        System.out.println("Room " + yourRoom.getRoomNumber() + "; has " + yourRoom.getBeds() + " beds.");
        System.out.println(stayDates.get(0).toString() + "-" + stayDates.get(stayDates.size() - 1).toString());
    }
}