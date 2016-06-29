package pl.zankowski.algorithm.structure;

import org.junit.Test;
import pl.zankowski.algorithm.structures.PoorHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Wojciech Zankowski
 */
public class PoorHashMapTest {

    @Test
    public void testPoorHashMapBehaviour() {
        PoorHashMap<Integer, String> map = new PoorHashMap<>();

        final Integer key = 10;
        final String value = "test";
        map.put(key, value);
        String actualValue = map.get(key);
        assertEquals(value, actualValue);

        final String value2 = "test3";
        map.put(key, value2);
        actualValue = map.get(key);
        assertEquals(value2, actualValue);

        assertEquals(value2, map.remove(key));
        actualValue = map.get(key);
        assertNull(actualValue);
    }

    @Test
    public void testPoorHashMapMultipleKeys() {
        PoorHashMap<Long, Integer> map = new PoorHashMap<>();

        final Long key1 = 1L;
        final Long key2 = 3L;
        final Long key3 = 5L;
        final Integer value1 = 2;
        final Integer value2 = 4;
        final Integer value3 = 6;

        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);

        assertEquals(value1, map.get(key1));
        assertEquals(value2, map.get(key2));
        assertEquals(value3, map.get(key3));

        assertEquals(value1, map.remove(key1));
        assertEquals(value2, map.remove(key2));
        assertEquals(value3, map.remove(key3));

        assertNull(map.get(key1));
        assertNull(map.get(key2));
        assertNull(map.get(key3));
    }

}
