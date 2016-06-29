package pl.zankowski.algorithm;

import java.util.*;

/**
 * @author Wojciech Zankowski
 */
public class Duplicate {

    /**
     * Question 4
     * http://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html
     *
     * @param array
     * @param sum
     * @return
     */
    public static int findDuplicate(int[] array, int sum) {
        int arraySum = Arrays.stream(array).sum();
        return arraySum - sum;
    }

    /**
     * Question 9
     * http://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html
     *
     * @param array
     * @return
     */
    public static Object[] findDuplicates(Object[] array) {
        Map<Object, Integer> map = new HashMap<>();
        Set<Object> duplicates = new TreeSet<>();
        for (Object object : array) {
            Integer freq = map.get(object);
            if (freq != null) {
                duplicates.add(object);
            }
            map.put(object, freq == null ? 1 : freq + 1);
        }
        return duplicates.toArray(new Object[duplicates.size()]);
    }

}
