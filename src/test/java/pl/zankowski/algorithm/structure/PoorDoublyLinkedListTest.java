package pl.zankowski.algorithm.structure;

import org.junit.Test;
import pl.zankowski.algorithm.structures.PoorDoublyLinkedList;

import static org.junit.Assert.assertEquals;

/**
 * @author Wojciech Zankowski
 */
public class PoorDoublyLinkedListTest {

    @Test
    public void testPoorLinkedListBehaviour() {
        PoorDoublyLinkedList<Integer> linkedList = new PoorDoublyLinkedList<>();

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
        PoorDoublyLinkedList<Long> linkedList = new PoorDoublyLinkedList<>();

        final Long value1 = 1L;
        final Long value2 = 3L;
        final Long value3 = 5L;

        linkedList.add(value1);
        linkedList.add(value2);
        linkedList.add(value3);

        assertEquals(value1, linkedList.getFirst());
        assertEquals(value3, linkedList.getLast());
    }

    @Test
    public void testPoorDoublyLinkedListAddFirstLast() {
        PoorDoublyLinkedList<String> linkedList = new PoorDoublyLinkedList<>();

        final String value1 = "value1";
        final String value2 = "value2";
        final String value3 = "value3";
        final String value4 = "value4";

        linkedList.addFirst(value1);
        assertEquals(value1, linkedList.getFirst());
        assertEquals(value1, linkedList.getLast());

        linkedList.addFirst(value2);
        assertEquals(value2, linkedList.getFirst());
        assertEquals(value1, linkedList.getLast());

        linkedList.addFirst(value3);
        assertEquals(value3, linkedList.getFirst());
        assertEquals(value1, linkedList.getLast());

        linkedList.addLast(value4);
        assertEquals(value3, linkedList.getFirst());
        assertEquals(value4, linkedList.getLast());
    }

}
