import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightManagerTest {

    private Flight flight1;
    private Plane plane1;
    private Passenger john;
    private Passenger sam;
    private Passenger ari;
    private Passenger sara;
    private Passenger stephen;
    private Passenger rob;
    private FlightManager flightManager;
    private Date date1;
    SimpleDateFormat sdf ;

    @Before
    public void before() throws ParseException {
        sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        date1 = sdf.parse("14:00 12/06/2020");
        plane1 = new Plane(PlaneType.ECLIPSE);
        flight1 = new Flight(plane1, "EC526", "GLA", "EDI", date1);
        john = new Passenger("John", 3);
        sam = new Passenger("Sam", 5);
        ari = new Passenger("Ari", 1);
        sara = new Passenger("sara", 2);
        stephen = new Passenger("Stephen", 1);
        rob = new Passenger("Rob", 1);
        flightManager = new FlightManager(flight1);
        flightManager.addPassenger(john);
        flightManager.addPassenger(sam);

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
        assertEquals(20, flightManager.getRemainingWeightAllowance());
    }

    @Test
    public void addFlightToPassenger () {
        assertEquals("EC526", john.getFlight());
    }

    @Test
    public void addSeatNumber () {
        flightManager.addPassenger(ari);
        flightManager.addPassenger(sara);
        flightManager.addPassenger(stephen);
        flightManager.addPassenger(rob);
        assertNotEquals(0, ari.getSeatNumber());
    }

    @Test
    public void sortBySeatNumber () {
        flightManager.addPassenger(ari);
        flightManager.addPassenger(sara);
        flightManager.addPassenger(stephen);
        flightManager.addPassenger(rob);
        flightManager.sortBySeatNumber();

        assertEquals(1, flight1.getPassengers().get(0).getSeatNumber());
    }

    @Test
    public void findBySeatNumber(){
        flightManager.addPassenger(ari);
        flightManager.addPassenger(sara);
        flightManager.addPassenger(stephen);
        flightManager.addPassenger(rob);
        Passenger found = flightManager.findPassengerBySeatNumber(3);
        assertEquals(3, found.getSeatNumber());
    }
}
