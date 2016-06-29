package pl.zankowski.algorithm;

import org.junit.Test;
import pl.zankowski.algorithm.AlgorithmException;
import pl.zankowski.algorithm.Fibonacci;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Wojciech Zankowski
 */
public class FibonacciTest {

    /**
     * Negative n
     */
    @Test
    public void testFibonacciSequenceRecursion_NegativeN_01() {
        try {
            Fibonacci.fibonacciSequenceRecursion(-1);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Negative number of fibonacci sequence elements.", e.getMessage());
        }
    }

    /**
     * n = 0
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceRecursion_N0_02() throws AlgorithmException {
        assertEquals(0, Fibonacci.fibonacciSequenceRecursion(0).length);
    }

    /**
     * n = 1
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceRecursion_N1_03() throws AlgorithmException {
        long[] expectedSequence = new long[]{0};
        assertArrayEquals(expectedSequence, Fibonacci.fibonacciSequenceRecursion(1));
    }

    /**
     * n = 2
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceRecursion_N2_04() throws AlgorithmException {
        long[] expectedSequence = new long[]{0, 1};
        assertArrayEquals(expectedSequence, Fibonacci.fibonacciSequenceRecursion(2));
    }

    /**
     * n = 3
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceRecursion_N3_05() throws AlgorithmException {
        long[] expectedSequnece = new long[]{0, 1, 1};
        assertArrayEquals(expectedSequnece, Fibonacci.fibonacciSequenceRecursion(3));
    }

    /**
     * n = 10
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceRecursion_N10_06() throws AlgorithmException {
        long[] expectedSequence = new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertArrayEquals(expectedSequence, Fibonacci.fibonacciSequenceRecursion(10));
    }

    /**
     * n = 94
     */
    @Test
    public void testFibonacciSequenceRecursion_N93_07() {
        try {
            System.out.println(Arrays.toString(Fibonacci.fibonacciSequenceRecursion(93)));
            Fibonacci.fibonacciSequenceRecursion(94);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci n = 94 out of range.", e.getMessage());
        }
    }

    /**
     * Negative n
     */
    @Test
    public void testFibonacciSequenceLoop_NegativeN_01() {
        try {
            Fibonacci.fibonacciSequenceLoop(-1);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Negative number of fibonacci sequence elements.", e.getMessage());
        }
    }

    /**
     * n = 0
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceLoop_N0_02() throws AlgorithmException {
        assertEquals(0, Fibonacci.fibonacciSequenceLoop(0).length);
    }

    /**
     * n = 1
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceLoop_N1_03() throws AlgorithmException {
        long[] expectedSequence = new long[]{0};
        assertArrayEquals(expectedSequence, Fibonacci.fibonacciSequenceLoop(1));
    }

    /**
     * n = 2
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceLoop_N2_04() throws AlgorithmException {
        long[] expectedSequence = new long[]{0, 1};
        assertArrayEquals(expectedSequence, Fibonacci.fibonacciSequenceLoop(2));
    }

    /**
     * n = 3
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceLoop_N3_05() throws AlgorithmException {
        long[] expectedSequnece = new long[]{0, 1, 1};
        assertArrayEquals(expectedSequnece, Fibonacci.fibonacciSequenceLoop(3));
    }

    /**
     * n = 10
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciSequenceLoop_N10_06() throws AlgorithmException {
        long[] expectedSequence = new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertArrayEquals(expectedSequence, Fibonacci.fibonacciSequenceLoop(10));
    }

    /**
     * n = 93
     */
    @Test
    public void testFibonacciSequenceLoop_N93_07() {
        try {
            System.out.println(Arrays.toString(Fibonacci.fibonacciSequenceLoop(93)));
            Fibonacci.fibonacciSequenceLoop(94);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci n = 94 out of range.", e.getMessage());
        }
    }

    /**
     * Negative n
     */
    @Test
    public void testFibonacciTailRecursion_NegativeN_01() {
        try {
            Fibonacci.fibonacciTailRecursion(-1);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci element number must be bigger than 0.", e.getMessage());
        }
    }

    /**
     * n = 0
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciTailRecursion_N0_02() throws AlgorithmException {
        try {
            Fibonacci.fibonacciTailRecursion(0);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci element number must be bigger than 0.", e.getMessage());
        }
    }

    /**
     * n = 1
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciTailRecursion_N1_03() throws AlgorithmException {
        assertEquals(0, Fibonacci.fibonacciTailRecursion(1));
    }

    /**
     * n = 2
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciTailRecursion_N2_04() throws AlgorithmException {
        assertEquals(1, Fibonacci.fibonacciTailRecursion(2));
    }

    /**
     * n = 3
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciTailRecursion_N3_05() throws AlgorithmException {
        assertEquals(1, Fibonacci.fibonacciTailRecursion(3));
    }

    /**
     * n = 10
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciTailRecursion_N10_06() throws AlgorithmException {
        assertEquals(34, Fibonacci.fibonacciTailRecursion(10));
    }

    /**
     * n = 94
     */
    @Test
    public void testFibonacciTailRecursion_N93_07() {
        try {
            System.out.println(Fibonacci.fibonacciTailRecursion(93));
            Fibonacci.fibonacciTailRecursion(94);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci n = 94 out of range.", e.getMessage());
        }
    }

    /**
     * Negative n
     */
    @Test
    public void testFibonacciRecursion_NegativeN_01() {
        try {
            Fibonacci.fibonacciRecursion(-1);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci element number must be bigger than 0.", e.getMessage());
        }
    }

    /**
     * n = 0
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciRecursion_N0_02() throws AlgorithmException {
        try {
            Fibonacci.fibonacciRecursion(0);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci element number must be bigger than 0.", e.getMessage());
        }
    }

    /**
     * n = 1
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciRecursion_N1_03() throws AlgorithmException {
        assertEquals(0, Fibonacci.fibonacciRecursion(1));
    }

    /**
     * n = 2
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciRecursion_N2_04() throws AlgorithmException {
        assertEquals(1, Fibonacci.fibonacciRecursion(2));
    }

    /**
     * n = 3
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciRecursion_N3_05() throws AlgorithmException {
        assertEquals(1, Fibonacci.fibonacciRecursion(3));
    }

    /**
     * n = 10
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciRecursion_N10_06() throws AlgorithmException {
        assertEquals(34, Fibonacci.fibonacciRecursion(10));
    }

    /**
     * n = 94
     */
    @Test
    public void testFibonacciRecursion_N93_07() {
        try {
            Fibonacci.fibonacciRecursion(94);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci n = 94 out of range.", e.getMessage());
        }
    }

    /**
     * Negative n
     */
    @Test
    public void testFibonacciLoop_NegativeN_01() {
        try {
            Fibonacci.fibonacciLoop(-1);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci element number must be bigger than 0.", e.getMessage());
        }
    }

    /**
     * n = 0
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciLoop_N0_02() throws AlgorithmException {
        try {
            Fibonacci.fibonacciLoop(0);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci element number must be bigger than 0.", e.getMessage());
        }
    }

    /**
     * n = 1
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciLoop_N1_03() throws AlgorithmException {
        assertEquals(0, Fibonacci.fibonacciLoop(1));
    }

    /**
     * n = 2
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciLoop_N2_04() throws AlgorithmException {
        assertEquals(1, Fibonacci.fibonacciLoop(2));
    }

    /**
     * n = 3
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciLoop_N3_05() throws AlgorithmException {
        assertEquals(1, Fibonacci.fibonacciLoop(3));
    }

    /**
     * n = 10
     *
     * @throws AlgorithmException
     */
    @Test
    public void testFibonacciLoop_N10_06() throws AlgorithmException {
        assertEquals(34, Fibonacci.fibonacciLoop(10));
    }

    /**
     * n = 94
     */
    @Test
    public void testFibonacciLoop_N93_07() {
        try {
            System.out.println(Fibonacci.fibonacciLoop(93));
            Fibonacci.fibonacciLoop(94);
            fail();
        } catch (AlgorithmException e) {
            assertEquals("Fibonacci n = 94 out of range.", e.getMessage());
        }
    }

}
