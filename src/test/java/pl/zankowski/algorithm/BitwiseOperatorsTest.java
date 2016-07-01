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

    /**
     * -11 | 1111 0101
     * 11  | 0000 1011
     * ----------------
     * 1   | 0000 0001
     */
    @Test
    public void testBitwiseAnd_08() {
        final byte value1 = -11;
        final byte value2 = 11;

        assertEquals(1, value1 & value2);
    }

    /**
     * 17 |  0001 0001
     * 11 |  0000 1011
     * ----------------
     * 27 |  0001 1011
     */
    @Test
    public void testBitwiseOr_01() {
        final byte value1 = 17;
        final byte value2 = 11;

        assertEquals(27, value1 | value2);
    }

    /**
     * 16 | 0001 0000
     * 8  | 0000 1000
     * ---------------
     * 24 | 0001 1000
     */
    @Test
    public void testBitwiseOr_02() {
        final byte value1 = 16;
        final byte value2 = 8;

        assertEquals(24, value1 | value2);
    }

    /**
     * 4  | 0000 0100
     * 15 | 0000 1111
     * ---------------
     * 15 | 0000 1111
     */
    @Test
    public void testBitwiseOr_03() {
        final byte value1 = 4;
        final byte value2 = 15;

        assertEquals(15, value1 | value2);
    }

    /**
     * 7  | 0000 0111
     * -8 | 1111 1000
     * ---------------
     * -1 | 1111 1111
     */
    @Test
    public void testBitwiseOr_04() {
        final byte value1 = 7;
        final byte value2 = -8;

        assertEquals(-1, value1 | value2);
    }

    /**
     * -12 | 1111 0100
     * -19 | 1110 1101
     * ----------------
     * -3  | 1111 1101
     */
    @Test
    public void testBitwiseOr_05() {
        final byte value1 = -12;
        final byte value2 = -19;

        assertEquals(-3, value1 | value2);
    }

    /**
     * 3  | 0000 0011
     * 14 | 0000 1110
     * ---------------
     * 13 | 0000 1101
     */
    @Test
    public void testBitwiseXor_01() {
        final byte value1 = 3;
        final byte value2 = 14;

        assertEquals(13, value1 ^ value2);
    }

    /**
     * 23 | 0001 0111
     * 31 | 0001 1111
     * ---------------
     * 8  | 0000 1000
     */
    @Test
    public void testBitwiseXor_02() {
        final byte value1 = 23;
        final byte value2 = 31;

        assertEquals(8, value1 ^ value2);
    }

    /**
     * 111 | 0110 1111
     * 1   | 0000 0001
     * ----------------
     * 110 | 0110 1110
     */
    @Test
    public void testBitwiseXor_03() {
        final byte value1 = 111;
        final byte value2 = 1;

        assertEquals(110, value1 ^ value2);
    }

    /**
     * 14  | 0000 1110
     * -11 | 1111 0101
     * ----------------
     * -5  | 1111 1011
     */
    @Test
    public void testBitwiseXor_04() {
        final byte value1 = 14;
        final byte value2 = -11;

        assertEquals(-5, value1 ^ value2);
    }

    /**
     * -8  | 1111 0111
     * -21 | 1110 1011
     * ----------------
     * 19  | 0001 0011
     */
    @Test
    public void testBitwiseXor_05() {
        final byte value1 = -8;
        final byte value2 = -21;

        assertEquals(19, value1 ^ value2);
    }

    /**
     * 15  | 0000 1111
     * ---------------
     * -16 | 1111 0000
     */
    @Test
    public void testBitwiseNot_01() {
        final byte value1 = 15;

        assertEquals(-16, ~value1);
    }

    /**
     * 3  | 0000 0011
     * --------------
     * -4 | 1111 1100
     */
    @Test
    public void testBitwiseNot_02() {
        final byte value1 = 3;

        assertEquals(-4, ~value1);
    }

    /**
     * -41 | 1101 0111
     * ----------------
     * 40  | 0010 1000
     */
    @Test
    public void testBitwiseNot_03() {
        final byte value1 = -41;

        assertEquals(40, ~value1);
    }

    /**
     * -7 | 1111 1001
     * ---------------
     * 6  | 0000 0110
     */
    @Test
    public void testBitwiseNot_04() {
        final byte value1 = -7;

        assertEquals(6, ~value1);
    }

    /**
     * 6  | 0000 0110
     * ---------------
     * >> 1
     * 3  | 0000 0011
     * ---------------
     * >> 2
     * 1  | 0000 0001
     * ---------------
     * >> 3
     * 0  | 0000 0000
     */
    @Test
    public void testRightShift_01() {
        final byte value1 = 6;

        assertEquals(3, value1 >> 1);
        assertEquals(1, value1 >> 2);
        assertEquals(0, value1 >> 3);
    }

    /**
     * 31 | 0001 1111
     * ---------------
     * >> 1
     * 15 | 0000 1111
     * ---------------
     * >> 2
     * 7  | 0000 0111
     * ---------------
     * >> 3
     * 3  | 0000 0011
     */
    @Test
    public void testRightShift_02() {
        final byte value1 = 31;

        assertEquals(15, value1 >> 1);
        assertEquals(7, value1 >> 2);
        assertEquals(3, value1 >> 3);
    }

    /**
     * -9 | 1111 0111
     * ---------------
     * >> 1
     * -5 | 1111 1011
     * ---------------
     * >> 2
     * -3 | 1111 1101
     * ---------------
     * >> 3
     * -2 | 1111 1110
     */
    @Test
    public void testRightShift_03() {
        final byte value = -9;

        assertEquals(-5, value >> 1);
        assertEquals(-3, value >> 2);
        assertEquals(-2, value >> 3);
    }

    /**
     * 15  | 0000 1111
     * ----------------
     * << 1
     * 30  | 0001 1110
     * ----------------
     * << 2
     * 60  | 0011 1100
     * ----------------
     * << 3
     * 120 | 0111 1000
     */
    @Test
    public void testLeftShift_01() {
        final byte value = 15;

        assertEquals(30, value << 1);
        assertEquals(60, value << 2);
        assertEquals(120, value << 3);
    }

    /**
     * 6  | 0000 0110
     * ---------------
     * << 1
     * 12 | 0000 1100
     * ---------------
     * << 2
     * 24 | 0001 1000
     * ---------------
     * << 3
     * 48 | 0011 0000
     */
    @Test
    public void testLeftShift_02() {
        final byte value = 6;

        assertEquals(12, value << 1);
        assertEquals(24, value << 2);
        assertEquals(48, value << 3);
    }

    /**
     * -127 | 1000 0001
     * -----------------
     * << 1
     * -254 | 1 0000 0010
     */
    @Test
    public void testLeftShift_03() {
        final byte value = -127;

        assertEquals(-254, value << 1);
    }

    /**
     * -7  | 1111 1001
     * ----------------
     * << 1
     * -14 | 1111 0010
     * ----------------
     * << 2
     * -28 | 1110 0100
     * ----------------
     * << 3
     * -56 | 1100 1000
     */
    @Test
    public void testLeftShift_04() {
        final byte value = -7;

        assertEquals(-14, value << 1);
        assertEquals(-28, value << 2);
        assertEquals(-56, value << 3);
    }

}
