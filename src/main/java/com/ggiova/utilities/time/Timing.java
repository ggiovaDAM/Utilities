package com.ggiova.utilities.time;

import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;

/**
 * Utility class for measuring the execution time of operations.
 *
 * <p>Provides methods to measure the time taken by operations expressed as
 * {@link java.util.function.Supplier Suppliers} (returning a value) or {@link java.lang.Runnable Runnables} (void
 * operations). Execution time is measured and printed to the standard output.
 *
 * <p>Example usage:
 * <pre>{@code
 * // Timing a Supplier that returns a result
 * double result = Timing.timeMillis("Square root", () -> Math.sqrt(100));
 *
 * // Timing a Runnable with no return value
 * Timing.timeNanos("Print operation", () -> System.out.println("Hello, world!"));
 * }</pre>
 */
public final class Timing {
    private static final long NANOS_PER_MILLI = ChronoUnit.MILLIS.getDuration().toNanos();
    
    private static final long NANOS_PER_MICRO = ChronoUnit.MICROS.getDuration().toNanos();
    
    private static <T> Calculation<T> calculateTime(Supplier<T> action) {
        long start = System.nanoTime();
        T result = action.get();
        long end = System.nanoTime();
        return new Calculation<>(result, (double) end - start);
    }
    
    private record Calculation<T>(T result, double time) {}
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Returns the result of the
     * operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeMillis(
     *     "SQRT",
     *     () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT took 0.0294 ms}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static <T> T timeMillis(String label, Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        // Conversion from nanoseconds to milliseconds
        double ms = calculation.time() / NANOS_PER_MILLI;
        System.out.printf("%s took %.2f ms%n", label, ms);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Returns the result of the
     * operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeMillis(
     *     () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 0.0294 ms}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static <T> T timeMillis(Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        // Conversion from nanoseconds to milliseconds
        double ms = calculation.time() / NANOS_PER_MILLI;
        System.out.printf("Took %.2f ms%n", ms);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeMillis(
     *     "Print operation",
     *     () -> System.out.println("Hello, world!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, world!
     * Print operation took 0.1217 ms
     * }</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     */
    public static void timeMillis(String label, Runnable action) {
        timeMillis(label, () -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeMillis(
     *     () -> System.out.println("Hello, world!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, world!
     * Took 0.0633 ms
     * }</pre>
     *
     * @param action Action to be measured
     */
    public static void timeMillis(Runnable action) {
        timeMillis(() -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in microseconds. Returns the result of the
     * operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeMicros(
     *     "SQRT",
     *     () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT took 15,00 μs}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static <T> T timeMicros(String label, Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        // Conversion from nanoseconds to microseconds
        double ms = calculation.time() / NANOS_PER_MICRO;
        System.out.printf("%s took %.2f μs%n", label, ms);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in microseconds. Returns the result of the
     * operation.
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeMicros(
     *     () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 12,20 μs}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static <T> T timeMicros(Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        // Conversion from nanoseconds to microseconds
        double ms = calculation.time() / NANOS_PER_MICRO;
        System.out.printf("Took %.2f μs%n", ms);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in microseconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeMicros(
     *     "Print operation",
     *     () -> System.out.println("Hello, world!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, world!
     * Print operation took 166,50 μs
     * }</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     */
    public static void timeMicros(String label, Runnable action) {
        timeMicros(label, () -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in microseconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeMicros(
     *     () -> System.out.println("Hello, world!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, world!
     * Took 150,80 μs
     * }</pre>
     *
     * @param action Action to be measured
     */
    public static void timeMicros(Runnable action) {
        timeMicros(() -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in nanoseconds. Returns the result of the
     * operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeNanos(
     *     "SQRT",
     *     () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT took 15800 ns}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static <T> T timeNanos(String label, Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        System.out.printf("%s took %.0f ns%n", label, calculation.time());
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in nanoseconds. Returns the result of the
     * operation.
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeNanos(
     *     () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 26500 ns}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static <T> T timeNanos(Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        System.out.printf("Took %.0f ns%n", calculation.time());
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in nanoseconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeNanos(
     *     "Print operation",
     *     () -> System.out.println("Hello, world!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, world!
     * Print operation took 227200 ns
     * }</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     */
    public static void timeNanos(String label, Runnable action) {
        timeNanos(label, () -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in nanoseconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeNanos(
     *     () -> System.out.println("Hello, world!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, world!
     * Took 186000 ns
     * }</pre>
     *
     * @param action Action to be measured
     */
    public static void timeNanos(Runnable action) {
        timeNanos(() -> {
            action.run();
            return null;
        });
    }
}
