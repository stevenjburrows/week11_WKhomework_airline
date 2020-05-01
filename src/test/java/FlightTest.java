import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight1;
    private Plane plane1;
    private Passenger john;
    private Passenger sam;

    @Before
    public void before(){
        plane1 = new Plane(PlaneType.ERCOUPE);
        flight1 = new Flight(plane1, "GLA", "EDI", "Sat 14:00");
        john = new Passenger("John", 3);
        sam = new Passenger("Sam", 5);
    }

    @Test
    public void canGetDestination() {
        assertEquals("GLA", flight1.getDestination());
    }

    @Test
    public void canGetDeparture() {
        assertEquals("EDI", flight1.getDeparture());
    }

    @Test
    public void canGetDepartureTime() {
        assertEquals("Sat 14:00", flight1.getDepartureTime());
    }

    @Test
    public void canGetPlane() {
        assertEquals(PlaneType.ERCOUPE, flight1.getPlane().getPlaneType());
    }

    @Test
    public void getNoOfAvailableSeats(){
        assertEquals(1, flight1.getAvailableSeats());
    }

    @Test
    public void addPassenger() {
        flight1.addPassenger(john);
        assertEquals(1, flight1.getPassengers().size());
    }

    @Test
    public void cantAddPassenger() {
        flight1.addPassenger(john);
        flight1.addPassenger(sam);
        assertEquals(1, flight1.getPassengers().size());
    }
}

