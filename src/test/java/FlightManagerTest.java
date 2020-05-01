import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Flight flight1;
    private Plane plane1;
    private Passenger john;
    private Passenger sam;
    private FlightManager flightManager;
    private Date date1;
    SimpleDateFormat sdf ;

    @Before
    public void before() throws ParseException {
        sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        date1 = sdf.parse("14:00 12/06/2020");
        plane1 = new Plane(PlaneType.ECLIPSE);
        flight1 = new Flight(plane1, "GLA", "EDI", date1);
        john = new Passenger("John", 3);
        sam = new Passenger("Sam", 5);
        flight1.addPassenger(john);
        flight1.addPassenger(sam);
        flightManager = new FlightManager(flight1);
    }

    @Test
    public void getFlight() {
        assertEquals(flight1, flightManager.getFlight());
    }

    @Test
    public void getBaggageWeight() {
        assertEquals(30, flightManager.getBaggageforEachPassenger(john));
    }

    @Test
    public void getTotalBaggageWeight() {
        assertEquals(80, flightManager.getTotalBaggaeWeight());
    }

    @Test
    public void remainingWeightAllowance() {
        assertEquals(20, flightManager.getremainingWeightAllowance());
    }
}
