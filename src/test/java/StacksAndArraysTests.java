import org.junit.Test;

import static org.junit.Assert.*;

import util.HanoiTower;
import util.SetOfStacks;
import util.StackArray;
import util.StackWithMinimum;

public class StacksAndArraysTests {

    //3.1
    @Test
    public void testImplementationOf3StacksIn1Array() throws Exception {
        StackArray stack = new StackArray();
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);
        stack.push(0, 4);
        assertFalse(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertTrue(stack.isEmpty(2));
        assertEquals(4, stack.peek(0));
        assertEquals(4, stack.pop(0));
        assertEquals(3, stack.peek(0));
    }

    @Test(expected = Exception.class)
    public void testImplementationOf3StacksIn1ArrayEmptyStackThrowsException() throws Exception {
        StackArray stack = new StackArray();
        stack.pop(0);
    }

    @Test(expected = Exception.class)
    public void testImplementationOf3StacksIn1ArrayOutOfBoundaryThrowsException() throws Exception {
        StackArray stack = new StackArray();
        int i = 0;
        while (i != 100) {
            stack.push(0, i);
            i++;
        }
        stack.push(100, 0);
    }

    //3.2
    @Test
    public void testStackWithMinValue() {
        StackWithMinimum stack = new StackWithMinimum();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.min());
    }

    @Test
    public void testStackWithFewMinValues() {
        StackWithMinimum stack = new StackWithMinimum();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        assertEquals(2, stack.min());
        stack.pop();
        assertEquals(3, stack.min());
    }

    //3.3
    @Test
    public void testSetOfStacks() {
        SetOfStacks setOfStacks = new SetOfStacks(3);
        int i = 0;
        while (i != 10) {
            setOfStacks.push(1);
            i++;
        }
        assertEquals(1, setOfStacks.pop());
        assertTrue(setOfStacks.isStackFull(setOfStacks.getLastStack()));
    }

    //3.4
    @Test
    public void testHanoiTower() {
        int n = 3;
        HanoiTower[] towers = new HanoiTower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new HanoiTower(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);

        assertEquals(0, towers[2].disks.pop().intValue());
        assertEquals(1, towers[2].disks.pop().intValue());
        assertEquals(2, towers[2].disks.pop().intValue());
    }

}
