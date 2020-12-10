import exercises.MediumDifficult;
import org.junit.Test;
import util.mediumdifficult.Pair;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MediumDifficultTests {
    //17.1
    @Test
    public void testNumberSwap() {
        int a = 5;
        int b = 6;
        Pair x = new Pair(a, b);
        MediumDifficult.swap(x);
        assertEquals(x.a, b);
        assertEquals(x.b, a);
    }

    //17.3
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


    //17.5
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

    //17.8
    @Test
    public void testGetMaxSumSuccess() {
        int[] input = {1, 2, 1, -4, 1};
        assertEquals(4, MediumDifficult.getMaxSum(input));
    }

    @Test
    public void testGetMaxSumNegativeOnly() {
        int[] input = {-1, -2, -5, -4};
        assertEquals(-1, MediumDifficult.getMaxSum(input));
    }

    //17.12
    @Test
    public void testFindSumPairsReturnTwo() {
        int[] input = {1, 2, 3, 0, 5, 11, 2};
        ArrayList<Pair> result = MediumDifficult.findPairSums(input, 3);
        assertEquals(2, result.size());
        assertEquals(0, result.get(0).a);
        assertEquals(3, result.get(0).b);
        assertEquals(1, result.get(1).a);
        assertEquals(2, result.get(1).b);
    }
}
