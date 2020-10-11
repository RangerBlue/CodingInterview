import org.junit.Test;

import static org.junit.Assert.*;

import util.StackArray;

public class StacksAndArraysTests {

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
}
