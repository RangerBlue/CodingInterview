import org.junit.Test;
import recursionanddynamicprogramming.RecursionAndDynamicProgramming;
import util.recursionanddynamicprogramic.Point;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class RecursionAndDynamicProgrammingTests {
    @Test
    public void testCountWays() {
        assertEquals(53798080, RecursionAndDynamicProgramming.countWays(30));
        assertEquals(1, RecursionAndDynamicProgramming.countWays(0));
        assertEquals(1, RecursionAndDynamicProgramming.countWays(1));
    }

    @Test
    public void testCountWaysDP() {
        int[] input = new int[400];
        assertEquals(53798080, RecursionAndDynamicProgramming.countWaysDP(30, input));
        assertEquals(1, RecursionAndDynamicProgramming.countWays(0));
        assertEquals(1, RecursionAndDynamicProgramming.countWays(1));
    }

    @Test
    public void testGetPath() {
        ArrayList<Point> list = new ArrayList();
        assertTrue(RecursionAndDynamicProgramming.getPath(1, 1, list));
        assertEquals(5, list.size());
    }

}

