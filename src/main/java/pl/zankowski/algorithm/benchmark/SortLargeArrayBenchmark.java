package pl.zankowski.algorithm.benchmark;

import org.openjdk.jmh.annotations.*;
import pl.zankowski.algorithm.sort.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Wojciech Zankowski
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@State(Scope.Thread)
public class SortLargeArrayBenchmark {

    public static final Long[] TEST_ARRAY = new Long[10000];

    static {
        Random random = new Random();
        for (int i = 0; i < TEST_ARRAY.length; i++) {
            TEST_ARRAY[i] = random.nextLong();
        }
    }

    @Benchmark
    public void bubbleSortBenchmark() {
        BubbleSort.sort(TEST_ARRAY);
    }

    @Benchmark
    public void insertionSortBenchmark() {
        InsertionSort.sort(TEST_ARRAY);
    }

    @Benchmark
    public void mergeSortBenchmark() {
        MergeSort.sort(TEST_ARRAY);
    }

    @Benchmark
    public void quickSortBenchmark() {
        QuickSort.sort(TEST_ARRAY);
    }

    @Benchmark
    public void selectionSortBenchmark() {
        SelectionSort.sort(TEST_ARRAY);
    }

}
