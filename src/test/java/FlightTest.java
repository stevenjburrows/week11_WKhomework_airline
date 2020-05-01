import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight1;
    private Plane plane1;
    private Passenger john;
    private Passenger sam;
    private Date date1;
    SimpleDateFormat sdf ;

    @Before
    public void before() throws ParseException {
        sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        date1 = sdf.parse("14:00 12/06/2020");
        plane1 = new Plane(PlaneType.ERCOUPE);
        flight1 = new Flight(plane1, "GLA", "EDI", date1);
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
        assertEquals(date1, flight1.getDepartureTime());
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

