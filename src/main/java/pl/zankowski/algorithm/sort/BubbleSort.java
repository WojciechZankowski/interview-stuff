package pl.zankowski.algorithm.sort;

/**
 * @author Wojciech Zankowski
 */
public class BubbleSort {

    public static <T extends Comparable> void sort(T[] objectArray) {
        boolean swapped = false;
        while (true) {
            for (int i = 1; i < objectArray.length; i++) {
                if (objectArray[i - 1].compareTo(objectArray[i]) > 0) {
                    T tempObject = objectArray[i];
                    objectArray[i] = objectArray[i - 1];
                    objectArray[i - 1] = tempObject;
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
            swapped = false;
        }
    }

}
