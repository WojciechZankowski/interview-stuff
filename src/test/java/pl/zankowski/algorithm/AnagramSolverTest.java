package pl.zankowski.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Wojciech Zankowski
 */
public class AnagramSolverTest {

    @Test
    public void testIsAnagramWordShortWord() {
        String s1 = "cat";
        String s2 = "act";

        assertTrue(AnagramSolver.isAnagram(s1, s2));
    }

    @Test
    public void testIsAnagramWordBigLetterWord() {
        String s1 = "Protectional";
        String s2 = "Lactoprotein";

        assertTrue(AnagramSolver.isAnagram(s1, s2));
    }

    @Test
    public void testNonAnagramWords() {
        String s1 = "testand";
        String s2 = "nottest";

        assertFalse(AnagramSolver.isAnagram(s1, s2));
    }

    @Test
    public void testNullWords() {
        assertFalse(AnagramSolver.isAnagram(null, "word"));
        assertFalse(AnagramSolver.isAnagram("word", null));
    }

    @Test
    public void testDifferentLengthWords() {
        String s1 = "verylongword";
        String s2 = "short";

        assertFalse(AnagramSolver.isAnagram(s1, s2));
    }

}
