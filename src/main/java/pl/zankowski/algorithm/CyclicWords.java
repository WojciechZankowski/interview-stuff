package pl.zankowski.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wojciech Zankowski
 */
public class CyclicWords {

    public static int countNonCyclicWords(List<String> words) {
        List<String> tempWords = new ArrayList<>(words);
        for (int i = 0; i < tempWords.size(); i++) {
            String currentWord = tempWords.get(i);
            removeAllCyclicWords(i, currentWord, tempWords);
        }
        return tempWords.size();
    }

    public static int countCyclicWords(List<String> words) {
        return words.size() - countNonCyclicWords(words);
    }

    private static void removeAllCyclicWords(int currentIndex, String currentWord, List<String> words) {
        for (int j = currentIndex + 1; j < words.size(); j++) {
            if (isCyclicWord(currentWord, words.get(j))) {
                words.remove(j--);
                currentIndex--;
            }
        }
    }

    protected static boolean isCyclicWord(String s1, String s2) {
        return s1.length() == s2.length() && s1.concat(s1).contains(s2);
    }

    public static void main(String[] args) {

    }

}
