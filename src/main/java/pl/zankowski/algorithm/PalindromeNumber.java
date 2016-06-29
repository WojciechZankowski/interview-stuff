package pl.zankowski.algorithm;

import java.util.Map;

/**
 * @author Wojciech Zankowski
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    private static int reverse(int number) {
        int reverse = 0;

        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return reverse;
    }

}
