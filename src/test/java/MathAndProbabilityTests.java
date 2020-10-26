import issuesandalgorithms.MathAndProbability;
import org.junit.Test;
import util.mathandprobability.Line;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MathAndProbabilityTests {
    //7.3
    @Test
    public void testIsIntersectedReturnsTrue() {
        double a1 = 0.5;
        double b1 = 3;
        Line line1 = new Line(a1, b1);
        double a2 = 0.3;
        double b2 = 3;
        Line line2 = new Line(a2, b2);
        assertTrue(MathAndProbability.areLinesIntersected(line1, line2));
    }

    @Test
    public void testIsIntersectedEpsilonReturnsFalse() {
        double a1 = 0.00000000000005;
        double b1 = 3;
        Line line1 = new Line(a1, b1);
        double a2 = 0.00000000000001;
        double b2 = 1;
        Line line2 = new Line(a2, b2);
        assertFalse(MathAndProbability.areLinesIntersected(line1, line2));
    }

    //7.4
    @Test
    public void testNegate() {
        int a = 5;
        int b = -4;
        int c = 0;
        assertEquals(-5, MathAndProbability.negate(a));
        assertEquals(4, MathAndProbability.negate(b));
        assertEquals(0, MathAndProbability.negate(c));
    }

    @Test
    public void testMinus() {
        assertEquals(0, MathAndProbability.minus(4, 4));
        assertEquals(-3, MathAndProbability.minus(3, 6));
        assertEquals(1, MathAndProbability.minus(-3, -4));
    }

    @Test
    public void testMultiply() {
        assertEquals(4, MathAndProbability.multiply(-2, -2));
        assertEquals(0, MathAndProbability.multiply(0, -2));
        assertEquals(6, MathAndProbability.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(1, MathAndProbability.divide(-2, -2));
        assertEquals(2, MathAndProbability.divide(5, 2));
        assertEquals(-2, MathAndProbability.divide(5, -2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        MathAndProbability.divide(1, 0);
    }
}
