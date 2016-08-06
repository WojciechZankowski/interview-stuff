package pl.zankowski.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wojciech Zankowski
 */
public class AnagramSolver {

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            addCharacter(resultMap, s1.charAt(i));
            removeCharacter(resultMap, s2.charAt(i));
        }

        return checkIfNoCharacterLeft(resultMap);
    }

    private static void addCharacter(Map<Character, Integer> resultMap, Character character) {
        Integer freq = resultMap.get(character);
        resultMap.put(character, freq == null ? 1 : freq + 1);
    }

    private static void removeCharacter(Map<Character, Integer> resultMap, Character character) {
        Integer freq = resultMap.get(character);
        resultMap.put(character, freq == null ? -1 : freq - 1);
    }

    private static boolean checkIfNoCharacterLeft(Map<Character, Integer> resultMap) {
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

}
