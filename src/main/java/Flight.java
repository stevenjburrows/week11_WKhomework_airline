import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private ArrayList<Passenger> passengers;
    private String destination;
    private String departure;
    private Date departureTime;
    private int availableSeats;
    SimpleDateFormat sdf;




    public Flight(Plane plane, String flightNumber, String destination, String departure, Date departureTime) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<Passenger>();
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.availableSeats = plane.getPlaneType().getCapacity();
        this.sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void addPassenger(Passenger passenger) {
        if (availableSeats > 0) {
            passengers.add(passenger);
            availableSeats -=1;
            passenger.setFlight(flightNumber);
        }
    }
}
