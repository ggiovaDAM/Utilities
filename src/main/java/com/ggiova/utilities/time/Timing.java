package com.ggiova.utilities.time;

import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;

/**
 * Utility class for measuring the execution time of operations.
 * <p>
 * Provides methods to measure the time taken by operations expressed as {@link java.util.function.Supplier Suppliers}
 * (returning a value) or {@link java.lang.Runnable Runnables} (void operations). Execution time is measured and printed
 * to the standard output.
 * <p>
 * Example usage:
 * <pre>{@code
 * // Timing a Supplier that returns a result
 * double result = Timing.timeMillis("Square root", () -> Math.sqrt(100));
 *
 * // Timing a Runnable with no return value
 * Timing.timeMillis("Print operation", () -> System.out.println("Hello, world!"));
 * }</pre>
 */
public final class Timing {
    private static final long NANOS_PER_MILLI = ChronoUnit.MILLIS.getDuration().toNanos();
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Returns the result of the
     * operation.
     * <br>
     * Example code:
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
        long start = System.nanoTime();
        T result = action.get();
        long end = System.nanoTime();
        // Conversion from nanoseconds to milliseconds
        double ms = (double) (end - start) / NANOS_PER_MILLI;
        System.out.println(label + " took " + ms + " ms");
        return result;
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Returns the result of the
     * operation.
     * <br>
     * Example code:
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
        long start = System.nanoTime();
        T result = action.get();
        long end = System.nanoTime();
        // Conversion from nanoseconds to milliseconds
        double ms = (double) (end - start) / NANOS_PER_MILLI;
        System.out.println("Took " + ms + " ms");
        return result;
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Does not return anything.
     * <br>
     * Example code:
     * <pre>{@code
     * double result = Timing.timeMillis(
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
     * <br>
     * Example code:
     * <pre>{@code
     * double result = Timing.timeMillis(
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
}
