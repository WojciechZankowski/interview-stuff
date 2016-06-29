package pl.zankowski.algorithm.structure;

import org.junit.Test;
import pl.zankowski.algorithm.structures.PoorSinglyLinkedList;

import static org.junit.Assert.assertEquals;

/**
 * @author Wojciech Zankowski
 */
public class PoorSinglyLinkedListTest {

    @Test
    public void testPoorLinkedListBehaviour() {
        PoorSinglyLinkedList<Integer> linkedList = new PoorSinglyLinkedList<>();

        final Integer value = 10;
        final Integer value2 = 12;

        linkedList.add(value);
        assertEquals(value, linkedList.getLast());
        assertEquals(value, linkedList.getFirst());

        linkedList.add(value2);
        assertEquals(value2, linkedList.getLast());
        assertEquals(value, linkedList.getFirst());
    }

    @Test
    public void testPoorLinkedListBehaviourAll() {
        PoorSinglyLinkedList<Long> linkedList = new PoorSinglyLinkedList<>();

        final Long value1 = 1L;
        final Long value2 = 3L;
        final Long value3 = 5L;

        linkedList.add(value1);
        linkedList.add(value2);
        linkedList.add(value3);

        assertEquals(value1, linkedList.getFirst());
        assertEquals(value3, linkedList.getLast());

        linkedList.remove(value1);

        assertEquals(value2, linkedList.getFirst());
        assertEquals(value3, linkedList.getLast());
    }

}
