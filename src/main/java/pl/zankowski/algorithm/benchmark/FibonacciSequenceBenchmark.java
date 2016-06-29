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
public class FibonacciSequenceBenchmark {

    @Benchmark
    public void benchmarkSequenceRecursion() throws AlgorithmException {
        Fibonacci.fibonacciSequenceRecursion(93);
    }

    @Benchmark
    public void benchmarkSequenceLoop() throws AlgorithmException {
        Fibonacci.fibonacciSequenceLoop(93);
    }

}
