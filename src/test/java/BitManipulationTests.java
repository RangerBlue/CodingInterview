import issuesandalgorithms.BitManipulation;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitManipulationTests {

    @Test
    public void testUpdateBits() {
        int input_n = 0b10000000000;
        int input_m = 0b10011;
        int output = BitManipulation.updateBits(input_n, input_m, 2, 6);
        assertEquals(0b10001001100, output);
    }

    @Test
    public void testUpdateBitsNotEnoughPlace() {
        int input_n = 0b10000000000;
        int input_m = 0b10011;
        int output = BitManipulation.updateBits(input_n, input_m, 6, 2);
        assertEquals(-1, output);
    }
}
