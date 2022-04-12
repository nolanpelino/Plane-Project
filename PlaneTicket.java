public class PlaneTicket {
    private Flight myFlight;
    private Seat yourSeat;
    private String gate;
    private User currentUser;

    public PlaneTicket(Flight myFlight, Seat yourSeat, String gate) {
        this.myFlight = myFlight;
        this.yourSeat = yourSeat;
        this.gate = gate;
    }

    public void displayTicket() {
        currentUser = FlightSystemUI.getCurrentUser();
        System.out.println(currentUser.getUsername());
        if(currentUser.getAge() < 12)
            System.out.println("Child Passenger");
        else
            System.out.println("Age " + currentUser.getAge());

        System.out.println("Flight " + myFlight.getFlightNumber());
        System.out.println("From " + myFlight.getDeparture() + " to " + myFlight.getArrival());
        System.out.println("Gate " + gate + " Seat " + yourSeat.getExactPosition());
        System.out.println("Price $"+yourSeat.getPrice()+"0");
    }
}
