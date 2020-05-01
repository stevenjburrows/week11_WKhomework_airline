import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private ArrayList<Passenger> passengers;
    private String destination;
    private String departure;
    private String departureTime;
    private int availableSeats;




    public Flight(Plane plane, String destination, String departure, String departureTime) {
        this.plane = plane;
        this.passengers = new ArrayList<Passenger>();
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.availableSeats = getAvailableSeats();
    }

    public Plane getPlane() {
        return plane;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public int getAvailableSeats() {
        return plane.getPlaneType().getCapacity();
    }

    public void addPassenger(Passenger passenger) {
        if (availableSeats > 0) {
            passengers.add(passenger);
            availableSeats -=1;
        }
    }
}
