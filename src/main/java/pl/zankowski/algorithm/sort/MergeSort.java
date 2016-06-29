package pl.zankowski.algorithm.sort;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class MergeSort {

    public static <T extends Comparable> void sort(T[] objectArray) {
        if (objectArray.length < 2) {
            return;
        }

        T[] copy = Arrays.copyOfRange(objectArray, 0, objectArray.length);
        mergeSort(0, objectArray.length - 1, objectArray, copy);

    }

    private static <T extends Comparable> void mergeSort(int left, int right, T[] sourceArray, T[] resultArray) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(left, middle, sourceArray, resultArray);
            mergeSort(middle + 1, right, sourceArray, resultArray);

            merge(left, right, middle + 1, sourceArray, resultArray);
        }
    }

    private static <T extends Comparable> void merge(int left, int right, int middle, T[] sourceArray, T[] resultArray) {
        int leftEnd = middle - 1;
        int k = left;
        int num = right - left + 1;

        while (left <= leftEnd && middle <= right) {
            if (sourceArray[left].compareTo(sourceArray[middle]) <= 0) {
                resultArray[k++] = sourceArray[left++];
            } else {
                resultArray[k++] = sourceArray[middle++];
            }
        }

        while (left <= leftEnd) {
            resultArray[k++] = sourceArray[left++];
        }

        while (middle <= right) {
            resultArray[k++] = sourceArray[middle++];
        }

        for (int i = 0; i < num; i++, right--) {
            sourceArray[right] = resultArray[right];
        }
    }
}
