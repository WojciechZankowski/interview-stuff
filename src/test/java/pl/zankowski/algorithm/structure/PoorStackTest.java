package pl.zankowski.algorithm.structure;

import org.junit.Test;
import pl.zankowski.algorithm.structures.PoorStack;

import static org.junit.Assert.assertEquals;

/**
 * @author Wojciech Zankowski
 */
public class PoorStackTest {

    @Test
    public void testPoorStack() {
        PoorStack<Integer> stack = new PoorStack<>();

        final Integer value1 = 1;
        final Integer value2 = 3;
        final Integer value3 = 5;

        stack.push(value2);
        stack.push(value3);
        stack.push(value1);

        assertEquals(value1, stack.peek());
        assertEquals(value1, stack.pop());

        assertEquals(value3, stack.peek());
        assertEquals(value3, stack.pop());

        assertEquals(value2, stack.peek());
        assertEquals(value2, stack.pop());
    }

}
