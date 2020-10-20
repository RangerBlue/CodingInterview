import issuesandalgorithms.BitManipulation;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitManipulationTests {


    //5.1
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

    //5.2
    @Test
    public void testPrintBinarySuccess() {
        assertEquals("111", BitManipulation.printBinary(0.875));
        assertEquals("11", BitManipulation.printBinary(0.75));
        assertEquals("ERROR2", BitManipulation.printBinary(0.72));
        assertEquals("ERROR1", BitManipulation.printBinary(1.72));
    }

    //5.3
    @Test
    public void testGetNextCloseBinaryValue() {
        assertEquals(22, BitManipulation.getNextBinary(21));
        assertEquals(34663, BitManipulation.getNextBinary(34654));
        assertEquals(0, BitManipulation.getNextBinary(0));
    }

    @Test
    public void testGetPrevCloseBinaryValue() {
        assertEquals(19, BitManipulation.getPrevBinary(21));
        assertEquals(3456545, BitManipulation.getPrevBinary(3456546));
        assertEquals(0, BitManipulation.getPrevBinary(0));
    }
}
