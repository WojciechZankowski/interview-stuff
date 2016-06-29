package pl.zankowski.algorithm.benchmark;

import org.openjdk.jmh.annotations.*;
import pl.zankowski.algorithm.AlgorithmException;
import pl.zankowski.algorithm.Fibonacci;

import java.util.concurrent.TimeUnit;

/**
 * @author Wojciech Zankowski
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@State(Scope.Thread)
public class FibonacciBenchmark {

    @Benchmark
    public void benchmarkRecursion() throws AlgorithmException {
        Fibonacci.fibonacciRecursion(40);
    }

    @Benchmark
    public void benchmarkTailRecursion() throws AlgorithmException {
        Fibonacci.fibonacciTailRecursion(40);
    }

    @Benchmark
    public void benchmarkLoop() throws AlgorithmException {
        Fibonacci.fibonacciLoop(40);
    }

}
