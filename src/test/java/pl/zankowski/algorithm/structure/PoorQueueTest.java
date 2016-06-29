package pl.zankowski.algorithm.structure;

import org.junit.Test;
import pl.zankowski.algorithm.structures.PoorQueue;

import static org.junit.Assert.assertEquals;

/**
 * @author Wojciech Zankowski
 */
public class PoorQueueTest {

    @Test
    public void testPoorQueue()  {
        PoorQueue<Integer> queue = new PoorQueue<>();

        final Integer value1 = 1;
        final Integer value2 = 3;
        final Integer value3 = 5;

        queue.push(value2);
        queue.push(value3);
        queue.push(value1);

        assertEquals(value2, queue.peek());
        assertEquals(value2, queue.pop());

        assertEquals(value3, queue.peek());
        assertEquals(value3, queue.pop());

        assertEquals(value1, queue.peek());
        assertEquals(value1, queue.pop());
    }

}
