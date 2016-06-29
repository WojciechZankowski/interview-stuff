package pl.zankowski.algorithm.benchmark;

import org.openjdk.jmh.annotations.*;
import pl.zankowski.algorithm.ReverseString;

import java.util.concurrent.TimeUnit;

/**
 * @author Wojciech Zankowski
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@State(Scope.Thread)
public class ReverseStringBenchmark {

    public static final String VALUE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    @Benchmark
    public void reverseStringLoopBenchmark() {
        ReverseString.reverseStringLoop(VALUE);
    }

    @Benchmark
    public void reverseStringRecursionBenchmark() {
        ReverseString.reverseStringRecursion(VALUE);
    }

    @Benchmark
    public void reverseStringBuilderLoopBenchmark() {
        ReverseString.reverseStringBuilderLoop(VALUE);
    }
}
