public class PlaneTicket {
    private Flight myFlight;
    private User passenger;
    private Seat yourSeat;
    private String gate;

    public PlaneTicket(Flight myFlight, User passenger, Seat yourSeat, String gate) {
        this.myFlight = myFlight;
        this.passenger = passenger;
        this.yourSeat = yourSeat;
        this.gate = gate;
    }

    public void displayTicket() {
        System.out.println(passenger.getUsername());
        
        if(passenger.getAge() < 12)
            System.out.println("Child Passenger");
        else
            System.out.println("Age " + passenger.getAge());

        System.out.println("Flight " + myFlight.getFlightNumber());
        System.out.println("From " + myFlight.getDeparture() + " to " + myFlight.getArrival());
        System.out.println("Gate " + gate + " Seat " + yourSeat.getExactPosition());
    }
}
