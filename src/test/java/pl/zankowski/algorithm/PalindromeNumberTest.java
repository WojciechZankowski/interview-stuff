package pl.zankowski.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Wojciech Zankowski
 */
public class PalindromeNumberTest {

    @Test
    public void testPalindrome() {
        assertTrue(PalindromeNumber.isPalindrome(121));
        assertFalse(PalindromeNumber.isPalindrome(12));
        assertTrue(PalindromeNumber.isPalindrome(1));
        assertTrue(PalindromeNumber.isPalindrome(3));
        assertFalse(PalindromeNumber.isPalindrome(34));
        assertTrue(PalindromeNumber.isPalindrome(13231));
    }

}
