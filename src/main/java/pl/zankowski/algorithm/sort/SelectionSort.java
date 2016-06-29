package pl.zankowski.algorithm.sort;

/**
 * @author Wojciech Zankowski
 */
public class SelectionSort {

    public static <T extends Comparable> void sort(T[] objectArray) {
        if (objectArray.length < 2) {
            return;
        }

        int swapIndex = 0;
        for (int i = 0; i < objectArray.length - 1; i++) {
            swapIndex = i;
            for (int j = i + 1; j < objectArray.length; j++) {
                if (objectArray[j].compareTo(objectArray[swapIndex]) < 0) {
                    swapIndex = j;
                }
            }
            if (swapIndex != i) {
                T tempObject = objectArray[i];
                objectArray[i] = objectArray[swapIndex];
                objectArray[swapIndex] = tempObject;
            }
        }
    }

}
