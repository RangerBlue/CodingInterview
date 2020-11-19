
import org.junit.Test;
import util.java.CircularArray;

import static org.junit.Assert.assertEquals;

public class JavaTests {
    @Test
    public void testRemoveDuplicatesSuccess() {
        CircularArray<Integer> array = new CircularArray<>(5);
        array.set(0, 0);
        array.set(1, 1);
        array.set(2, 2);
        array.set(3, 3);
        array.set(4, 4);
        array.rotate(2);
        int result = array.get(0);
        assertEquals(2, result);
    }
}
