package pl.zankowski.algorithm.sort;

import org.junit.Before;
import org.junit.Test;
import pl.zankowski.algorithm.sort.MergeSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Wojciech Zankowski
 */
public class MergeSortTest {

    @Test
    public void testEmptyArray_01() {
        Integer[] expectedArray = new Integer[0];
        Integer[] testArray = new Integer[0];
        MergeSort.sort(testArray);
        assertArrayEquals(expectedArray, testArray);
    }

    @Test
    public void testSingleElementArray_02() {
        Long[] expectedArray = new Long[]{1L};
        Long[] testArray = new Long[]{1L};
        MergeSort.sort(testArray);
        assertArrayEquals(expectedArray, testArray);
    }

    @Test
    public void testUnsortedArray_03() {
        Integer[] expectedArray = new Integer[]{1, 2, 4, 9};
        Integer[] testArray = new Integer[]{1, 9, 4, 2};
        MergeSort.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        assertArrayEquals(expectedArray, testArray);
    }

    @Test
    public void testSortedArray_04() {
        Double[] expectedArray = new Double[]{1d, 1.5d, 2.3d};
        Double[] testArray = new Double[]{1d, 1.5d, 2.3d};
        MergeSort.sort(testArray);
        assertArrayEquals(expectedArray, testArray);
    }

    @Test
    public void testRabbitArray_05() {
        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] testArray = new Integer[]{6, 1, 2, 3, 4, 5};
        MergeSort.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        assertArrayEquals(expectedArray, testArray);
    }

}
