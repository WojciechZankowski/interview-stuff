package pl.zankowski.algorithm.benchmark;

import org.openjdk.jmh.annotations.*;
import pl.zankowski.algorithm.sort.*;

import java.util.concurrent.TimeUnit;

/**
 * @author Wojciech Zankowski
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@State(Scope.Thread)
public class SortRabbitBenchmark {

    public static final Integer[] TEST_ARRAY = new Integer[]{23, 1, 2, 3, 5, 6, 7, 8, 11, 14, 16, 17, 19, 20, 22, 23};

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
