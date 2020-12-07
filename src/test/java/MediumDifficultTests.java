import exercises.MediumDifficult;
import org.junit.Test;
import util.mediumdifficult.Pair;
import static org.junit.Assert.*;

public class MediumDifficultTests {
    @Test
    public void testNumberSwap() {
        int a = 5;
        int b = 6;
        Pair x = new Pair(a,b);
        MediumDifficult.swap(x);
        assertEquals(x.a, b);
        assertEquals(x.b, a);
    }

    @Test
    public void testCountFactZerosReturns2() {
        int a = 10;
        assertEquals(3628800, MediumDifficult.factorial(a));
        assertEquals(2, MediumDifficult.countFactZeros(a));
    }

    @Test
    public void testFactorialErrorReturnMinus1() {
        int a = -4;
        assertEquals(-1, MediumDifficult.factorial(a));
    }

    @Test
    public void testMastermindOneHitOnePartial() {
        MediumDifficult.Result expectedResult = new MediumDifficult.Result();
        expectedResult.hits = 1;
        expectedResult.pseudoHits = 1;
        MediumDifficult.Result actual = MediumDifficult.estimate("CZNP", "ZZCC");
        assertEquals(expectedResult, actual);
    }

    @Test
    public void testMastermindAllCorrect() {
        MediumDifficult.Result expectedResult = new MediumDifficult.Result();
        expectedResult.hits = 4;
        expectedResult.pseudoHits = 0;
        MediumDifficult.Result actual = MediumDifficult.estimate("CZNP", "CZNP");
        assertEquals(expectedResult, actual);
    }
}
