public class PlaneTicket {
    private Flight myFlight;
    private Seat yourSeat;
    private String gate;
    private String username;
    private int age;

    public PlaneTicket(Flight myFlight, String username, int age, Seat yourSeat, String gate) {
        this.myFlight = myFlight;
        this.yourSeat = yourSeat;
        this.gate = gate;
    }

    public void displayTicket() {
        System.out.println(username);
        
        if(passenger.getAge() < 12)
            System.out.println("Child Passenger");
        else
            System.out.println("Age " + age);

        System.out.println("Flight " + myFlight.getFlightNumber());
        System.out.println("From " + myFlight.getDeparture() + " to " + myFlight.getArrival());
        System.out.println("Gate " + gate + " Seat " + yourSeat.getExactPosition());
    }
}
