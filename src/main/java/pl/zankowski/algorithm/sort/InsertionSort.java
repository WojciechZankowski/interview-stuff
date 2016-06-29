package pl.zankowski.algorithm.sort;

/**
 * @author Wojciech Zankowski
 */
public class InsertionSort {

    public static <T extends Comparable> void sort(T[] objectArray) {
        if (objectArray.length < 2) {
            return;
        }

        for (int i = 1; i < objectArray.length; i++) {
            T tempObject = objectArray[i];
            int j = i;
            while (j > 0 && tempObject.compareTo(objectArray[j - 1]) < 0) {
                objectArray[j] = objectArray[j - 1];
                j--;
            }
            objectArray[j] = tempObject;
        }
    }

}
