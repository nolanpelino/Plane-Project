public class Seat extends Item {
    private double price;
    private boolean extraLegRoom;
    private char seatPosition;
    private int row;
    private String seatSection;
    private boolean availability = true;

    /**
     * Object that represents a seat on a flight. Extends item
     * @param price
     * @param seatSection
     * @param row
     * @param seatPosition
     * @param extraLegRoom
     */
    public Seat(double price, String seatSection, int row, char seatPosition, boolean extraLegRoom) {
        this.price = price;
        this.seatSection = seatSection;
        this.row = row;
        this.seatPosition = seatPosition;
        this.extraLegRoom = extraLegRoom;
    }

    /**
     *
     * @return  Returns a combination of the row number and seat position as a String. 
     */
    public String getExactPosition() {
        return row + seatPosition;
    }

    /**
     *  e.g. First Class, Business, economy
     * @return Returns the general section of a seat
     */
    public String getSection() {
        return this.seatSection;
    }

    /**
     * 
     * @return boolean value. True if there is extra leg room.
     */
    public boolean hasLegRoom() {
        return this.extraLegRoom;
    }

    /**
     * Sets the seats availability to false
     */
    public void fillSeat() {
        this.availability = false;
    }

    /**
     * 
     * @return returns the avalaibility value of the seat as a boolean
     */
    public boolean getAvailability() {
        return this.availability;
    }
}