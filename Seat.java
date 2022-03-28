public class Seat extends Item {
    private double price;
    private boolean extraLegRoom;
    private char seatPosition;
    private int row;
    private String seatSection;
    private boolean availability = true;

    public Seat(double price, String seatSection, int row, char seatPosition, boolean extraLegRoom) {
        this.price = price;
        this.seatSection = seatSection;
        this.row = row;
        this.seatPosition = seatPosition;
        this.extraLegRoom = extraLegRoom;
    }

    public String getExactPosition() {
        return row + seatPosition;
    }

    public String getSection() {
        return this.seatSection;
    }

    public boolean hasLegRoom() {
        return this.extraLegRoom;
    }

    public void fillSeat() {
        this.availability = false;
    }

    public boolean getAvailability() {
        return this.availability;
    }
}