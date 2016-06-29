package pl.zankowski.algorithm.sort;

/**
 * @author Wojciech Zankowski
 */
public class QuickSort {

    public static <T extends Comparable> void sort(T[] objectArray) {
        if (objectArray.length < 2) {
            return;
        }
        sort(objectArray, 0, objectArray.length - 1);
    }

    private static <T extends Comparable> void sort(T[] objectArray, int left, int right) {
        T pivot = objectArray[left + ((right - left) / 2)];

        int i = left;
        int j = right;

        while (true) {
            if (i > j) {
                break;
            }
            while (objectArray[i].compareTo(pivot) < 0) {
                i++;
            }
            while (objectArray[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                T tempObject = objectArray[j];
                objectArray[j] = objectArray[i];
                objectArray[i] = tempObject;
                i++;
                j--;
            }
        }

        if (left < j) {
            sort(objectArray, left, j);
        }
        if (i < right) {
            sort(objectArray, i, right);
        }
    }

}
