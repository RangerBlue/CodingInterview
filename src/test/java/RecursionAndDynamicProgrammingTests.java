import org.junit.Test;
import issuesandalgorithms.RecursionAndDynamicProgramming;
import util.recursionanddynamicprogramic.Color;
import util.recursionanddynamicprogramic.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class RecursionAndDynamicProgrammingTests {
    //9.1
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

    //9.3
    @Test
    public void testFindMagicIndexSuccess() {
        int[] input = {-10, -5, 0, 1, 2, 4, 6, 8, 11};
        assertEquals(6, RecursionAndDynamicProgramming.findMagicIndex(input));
    }

    @Test
    public void testFindMagicIndexFailure() {
        int[] input = {-10, -5, 0, 1, 2, 4, 7, 8, 11};
        assertEquals(-1, RecursionAndDynamicProgramming.findMagicIndex(input));
    }

    //9.4
    @Test
    public void testGetSubsets() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        ArrayList<Integer> output0 = new ArrayList<>();
        ArrayList<Integer> output1_1 = new ArrayList<>();
        output1_1.add(1);
        ArrayList<Integer> output1_2 = new ArrayList<>();
        output1_2.add(2);
        ArrayList<Integer> output1_3 = new ArrayList<>();
        output1_3.add(3);
        ArrayList<Integer> output2_3_2 = new ArrayList<>();
        output2_3_2.add(3);
        output2_3_2.add(2);
        ArrayList<Integer> output2_3_1 = new ArrayList<>();
        output2_3_1.add(3);
        output2_3_1.add(1);
        ArrayList<Integer> output2_2_1 = new ArrayList<>();
        output2_2_1.add(2);
        output2_2_1.add(1);
        ArrayList<Integer> output3_3_2_1 = new ArrayList<>();
        output3_3_2_1.add(3);
        output3_3_2_1.add(2);
        output3_3_2_1.add(1);
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(output0);
        expected.add(output1_3);
        expected.add(output1_2);
        expected.add(output2_3_2);
        expected.add(output1_1);
        expected.add(output2_3_1);
        expected.add(output2_2_1);
        expected.add(output3_3_2_1);

        assertEquals(expected, RecursionAndDynamicProgramming.getSubsets(input, 0));
    }

    //9.5
    @Test
    public void testGetPermutations() {
        String input = "ABC";
        ArrayList<String> expected = new ArrayList<>();
        expected.add("ABC");
        expected.add("BAC");
        expected.add("BCA");
        expected.add("ACB");
        expected.add("CAB");
        expected.add("CBA");
        assertEquals(expected, RecursionAndDynamicProgramming.getPermutations(input));
    }

    //9.6
    @Test
    public void testGetParens() {
        Set<String> expected = new HashSet<>();
        expected.add("()()()");
        expected.add("()(())");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("((()))");
        assertEquals(expected, RecursionAndDynamicProgramming.generateParens(3));
    }

    //9.7
    @Test
    public void testPaintFill() {
        Color[][] input = {
                {Color.Black, Color.Black, Color.Black},
                {Color.Black, Color.Black, Color.Black},
                {Color.Black, Color.Black, Color.Black}
        };
        Color[][] output = {
                {Color.Green, Color.Green, Color.Green},
                {Color.Green, Color.Green, Color.Green},
                {Color.Green, Color.Green, Color.Green}
        };
        RecursionAndDynamicProgramming.paintFill(input, 1, 1, Color.Green);
        assertArrayEquals(output,input );
    }
}

