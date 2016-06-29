package pl.zankowski.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Wojciech Zankowski
 */
public class DuplicateTest {

    @Test
    public void testFindIntegerDuplicate() {
        int[] testArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5};
        int expectedValue = 5;
        int actualValue = Duplicate.findDuplicate(testArray, 55);
        assertEquals(5, actualValue);
    }

    @Test
    public void testFindDuplicates() {
        Integer[] testArray = new Integer[]{1, 2, 3, 3, 4, 6, 5, 2, 3, 10, 11};
        Integer[] expectedResult = new Integer[]{2, 3};
        Object[] actualResult = Duplicate.findDuplicates(testArray);

        assertEquals(2, expectedResult.length);
        assertArrayEquals(expectedResult, actualResult);
    }


}
