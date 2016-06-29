package pl.zankowski.algorithm;

/**
 * @author Wojciech Zankowski
 */
public class Fibonacci {

    private static long FIRST_FIBONACCI_NUMBER = 0;
    private static long SECOND_FIBONACCI_NUMBER = 1;

    public static long[] fibonacciSequenceRecursion(int n) throws AlgorithmException {
        if (n < 0) {
            throw new AlgorithmException("Negative number of fibonacci sequence elements.");
        } else if (n == 0) {
            return new long[0];
        } else if (n == 1) {
            return new long[]{FIRST_FIBONACCI_NUMBER};
        } else if (n == 2) {
            return new long[]{FIRST_FIBONACCI_NUMBER, SECOND_FIBONACCI_NUMBER};
        } else if (n > 93) {
            throw new AlgorithmException("Fibonacci n = " + n + " out of range.");
        } else {
            long[] sequence = new long[n];
            sequence[0] = FIRST_FIBONACCI_NUMBER;
            sequence[1] = SECOND_FIBONACCI_NUMBER;
            return fibonacciSequenceRecursion(2, sequence);
        }
    }

    private static long[] fibonacciSequenceRecursion(int i, long[] sequence) {
        if (i >= sequence.length) {
            return sequence;
        } else {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
            return fibonacciSequenceRecursion(++i, sequence);
        }
    }

    public static long[] fibonacciSequenceLoop(int n) throws AlgorithmException {
        if (n < 0) {
            throw new AlgorithmException("Negative number of fibonacci sequence elements.");
        } else if (n == 0) {
            return new long[0];
        } else if (n == 1) {
            return new long[]{FIRST_FIBONACCI_NUMBER};
        } else if (n == 2) {
            return new long[]{FIRST_FIBONACCI_NUMBER, SECOND_FIBONACCI_NUMBER};
        } else if (n > 93) {
            throw new AlgorithmException("Fibonacci n = " + n + " out of range.");
        } else {
            long[] sequence = new long[n];
            sequence[0] = FIRST_FIBONACCI_NUMBER;
            sequence[1] = SECOND_FIBONACCI_NUMBER;
            for (int i = 2; i < n; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2];
            }
            return sequence;
        }
    }

    public static long fibonacciTailRecursion(int n) throws AlgorithmException {
        if (n <= 0) {
            throw new AlgorithmException("Fibonacci element number must be bigger than 0.");
        } else if (n == 1) {
            return FIRST_FIBONACCI_NUMBER;
        } else if (n == 2) {
            return SECOND_FIBONACCI_NUMBER;
        } else if (n > 93) {
            throw new AlgorithmException("Fibonacci n = " + n + " out of range.");
        } else {
            return fibonacciTailRecursion(n, FIRST_FIBONACCI_NUMBER, SECOND_FIBONACCI_NUMBER);
        }
    }

    private static long fibonacciTailRecursion(int n, long x1, long x2) {
        return n == 1 ? x1 : fibonacciTailRecursion(--n, x2, x1 + x2);
    }

    public static long fibonacciRecursion(int n) throws AlgorithmException {
        if (n <= 0) {
            throw new AlgorithmException("Fibonacci element number must be bigger than 0.");
        } else if (n == 1) {
            return FIRST_FIBONACCI_NUMBER;
        } else if (n == 2) {
            return SECOND_FIBONACCI_NUMBER;
        } else if (n > 93) {
            throw new AlgorithmException("Fibonacci n = " + n + " out of range.");
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    public static long fibonacciLoop(int n) throws AlgorithmException {
        if (n <= 0) {
            throw new AlgorithmException("Fibonacci element number must be bigger than 0.");
        } else if (n == 1) {
            return FIRST_FIBONACCI_NUMBER;
        } else if (n == 2) {
            return SECOND_FIBONACCI_NUMBER;
        } else if (n > 93) {
            throw new AlgorithmException("Fibonacci n = " + n + " out of range.");
        } else {
            long x1 = FIRST_FIBONACCI_NUMBER;
            long x2 = SECOND_FIBONACCI_NUMBER;
            long fibonacci = x1 + x2;
            for (int i = 2; i < n; i++) {
                fibonacci = x1 + x2;
                x1 = x2;
                x2 = fibonacci;
            }
            return fibonacci;
        }
    }

}
