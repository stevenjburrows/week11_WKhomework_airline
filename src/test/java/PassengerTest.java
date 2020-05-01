import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Steven", 3);
    }

    @Test
    public void getName() {
        assertEquals("Steven", passenger.getName());
    }

    @Test
    public void getNoOfBags() {
        assertEquals(3, passenger.getNoOfBags());
    }
}
