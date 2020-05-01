import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Flight {

    private Plane plane;
    private ArrayList<Passenger> passengers;
    private String destination;
    private String departure;
    private Date departureTime;
    private int availableSeats;
    SimpleDateFormat sdf;




    public Flight(Plane plane, String destination, String departure, Date departureTime) {
        this.plane = plane;
        this.passengers = new ArrayList<Passenger>();
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.availableSeats = getAvailableSeats();
        this.sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");

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

    public Date getDepartureTime() {
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
