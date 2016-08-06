package pl.zankowski.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Wojciech Zankowski
 */
public class CyclicWordsTest {

    @Test
    public void testNonCyclicWords() {
        final int expectedResult = 4;
        List<String> words = Arrays.asList("the", "xfo", "brown", "fox", "oxf", "something");

        int result = CyclicWords.countNonCyclicWords(words);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCyclicWords() {
        final int expectedResult = 4;
        List<String> words = Arrays.asList("the", "xfo", "brown", "fox", "oxf", "rownb", "the");

        int result = CyclicWords.countCyclicWords(words);
        assertEquals(expectedResult, result);
    }

    @Test
    public void setTestIsCyclicWordPositive() {
        String s1 = "something";
        String s2 = "thingsome";

        assertTrue(CyclicWords.isCyclicWord(s1, s2));
    }

    @Test
    public void testIsCyclicWordNegative() {
        String s1 = "down";
        String s2 = "own";

        assertFalse(CyclicWords.isCyclicWord(s1, s2));
    }

    @Test
    public void testIsCyclicWordNegativeSameLength() {
        String s1 = "paper";
        String s2 = "rapep";

        assertFalse(CyclicWords.isCyclicWord(s1, s2));
    }

}
