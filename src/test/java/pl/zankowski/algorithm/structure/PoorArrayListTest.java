package pl.zankowski.algorithm.structure;

import org.junit.Test;
import pl.zankowski.algorithm.structures.PoorArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Wojciech Zankowski
 */
public class PoorArrayListTest {

    @Test
    public void testAddAndGet() {
        PoorArrayList<Integer> arrayList = new PoorArrayList<>();

        final Integer value1 = 1;
        final Integer value2 = 3;
        final Integer value3 = 5;

        arrayList.add(value1);
        assertEquals(value1, arrayList.get(0));

        arrayList.add(value2);
        assertEquals(value2, arrayList.get(1));

        arrayList.add(value3);
        assertEquals(value3, arrayList.get(2));
    }

    @Test
    public void testArrayListBehaviour() {
        PoorArrayList<Long> arrayList = new PoorArrayList<>();

        final Long value1 = 11L;
        final Long value2 = 13L;
        final Long value3 = 17L;

        arrayList.add(value1);
        arrayList.add(value2);
        arrayList.add(value3);
        assertEquals(value1, arrayList.get(0));
        assertEquals(value2, arrayList.get(1));
        assertEquals(value3, arrayList.get(2));

        arrayList.remove(value2);
        assertEquals(value1, arrayList.get(0));
        assertEquals(value3, arrayList.get(1));

        arrayList.remove(0);
        assertEquals(value3, arrayList.get(0));

        arrayList.remove(value3);
        try {
            arrayList.get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Fail.", e.getMessage());
        }
    }

    @Test
    public void testEnsureCapacity() {
        PoorArrayList<Integer> arrayList = new PoorArrayList<>();

        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        assertEquals(Integer.valueOf(13), arrayList.get(13));
        assertEquals(Integer.valueOf(19), arrayList.get(19));
    }

}
