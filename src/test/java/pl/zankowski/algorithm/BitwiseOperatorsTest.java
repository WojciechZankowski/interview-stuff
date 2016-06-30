package pl.zankowski.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Wojciech Zankowski
 */
public class BitwiseOperatorsTest {

    /**
     * 17 |  0001 0001
     * 11 |  0000 1011
     * ----------------
     * 1  |  0000 0001
     */
    @Test
    public void testBitwiseAnd_01() {
        final byte value1 = 17;
        final byte value2 = 11;

        assertEquals(1, value1 & value2);
    }

    /**
     * 21 |  0001 0101
     * 16 |  0001 0000
     * ----------------
     * 16 |  0001 0000
     */
    @Test
    public void testBitwiseAnd_02() {
        final byte value1 = 21;
        final byte value2 = 16;

        assertEquals(16, value1 & value2);
    }

    /**
     * 16 |  0001 0000
     * 5  |  0000 0101
     * ----------------
     * 0  |  0000 0000
     */
    @Test
    public void testBitwiseAnd_03() {
        final byte value1 = 16;
        final byte value2 = 5;

        assertEquals(0, value1 & value2);
    }

    /**
     * -13 |  1111 0011
     * 5   |  0000 0101
     * -----------------
     * 5   |  0000 0001
     */
    @Test
    public void testBitwiseAnd_04() {
        final byte value1 = -13;
        final byte value2 = 5;

        assertEquals(1, value1 & value2);
    }

    /**
     * -18 | 1110 1110
     * -17 | 1110 1111
     * ----------------
     * -18 | 1110 1110
     */
    @Test
    public void testBitwiseAnd_05() {
        final byte value1 = -18;
        final byte value2 = -17;

        assertEquals(-18, value1 & value2);
    }

    /**
     * -35 | 1101 1101
     * -51 | 1100 1101
     * ----------------
     * -51 | 1100 1101
     */
    @Test
    public void testBitwiseAnd_06() {
        final byte value1 = -35;
        final byte value2 = -51;

        assertEquals(-51, value1 & value2);
    }

    /**
     * -3 | 1111 1101
     * 5  | 0000 0101
     * ---------------
     * 5  | 0000 0101
     */
    @Test
    public void testBitwiseAnd_07() {
        final byte value1 = -3;
        final byte value2 = 5;

        assertEquals(5, value1 & value2);
    }

}
