package pl.zankowski.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Wojciech Zankowski
 */
public class ReverseStringTest {

    @Test
    public void testReverseStringLoop() {
        String value = "StringWithMoreThanOneWord";
        String expectedValue = new StringBuffer().append(value).reverse().toString();
        assertEquals(expectedValue, ReverseString.reverseStringLoop(value));
    }

    @Test
    public void testReverseStringRecursion() {
        String value = "StringWithMoreThanOneWord";
        String expectedValue = new StringBuffer().append(value).reverse().toString();
        assertEquals(expectedValue, ReverseString.reverseStringRecursion(value));
    }

    @Test
    public void testReverseStringBuilderLoop() {
        String value = "StringWithMoreThanOneWord";
        String expectedValue = new StringBuffer().append(value).reverse().toString();
        assertEquals(expectedValue, ReverseString.reverseStringBuilderLoop(value));
    }

}
