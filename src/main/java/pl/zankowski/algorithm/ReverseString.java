package pl.zankowski.algorithm;

/**
 * @author Wojciech Zankowski
 */
public class ReverseString {

    public static String reverseStringLoop(String value) {
        char[] newString = new char[value.length()];
        char[] oldString = value.toCharArray();
        for (int i = 0, j = value.length() - 1; i < value.length(); i++, j--) {
            newString[i] = oldString[j];
        }
        return new String(newString);
    }

    public static String reverseStringRecursion(String value) {
        if (value.length() < 2) {
            return value;
        }

        return reverseStringRecursion(value.substring(1)) + value.charAt(0);
    }

    public static String reverseStringBuilderLoop(String value) {
        StringBuilder builder = new StringBuilder();

        char[] oldValue = value.toCharArray();
        for (int i = value.length() - 1; i >= 0; i--) {
            builder.append(oldValue[i]);
        }

        return builder.toString();
    }

}
