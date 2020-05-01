import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.CESSNA);
    }

    @Test
    public void getPlaneCapacity() {
        assertEquals(4, plane.getPlaneType().getCapacity());
    }

    @Test
    public void getPlaneWeightLimit() {
        assertEquals(50, plane.getPlaneType().getTotalWeight());
    }
}
