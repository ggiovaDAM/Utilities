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
 * <p>Supports multiple time units:
 * <ul>
 *   <li>{@link #timeAuto(String, Supplier)} - Automatically selects the most appropriate unit (s, ms, μs, or ns)</li>
 *   <li>{@link #timeSeconds(String, Supplier)} - Measures in seconds with 2 decimal places</li>
 *   <li>{@link #timeMillis(String, Supplier)} - Measures in milliseconds with 2 decimal places</li>
 *   <li>{@link #timeMicros(String, Supplier)} - Measures in microseconds with 2 decimal places</li>
 *   <li>{@link #timeNanos(String, Supplier)} - Measures in nanoseconds (whole numbers)</li>
 * </ul>
 *
 * <p>Each timing method has four variants:
 * <ul>
 *   <li>With label, returning result: {@code timeXxx(String label, Supplier<T> action)}</li>
 *   <li>Without label, returning result: {@code timeXxx(Supplier<T> action)}</li>
 *   <li>With label, no return: {@code timeXxx(String label, Runnable action)}</li>
 *   <li>Without label, no return: {@code timeXxx(Runnable action)}</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * // Automatically select appropriate unit
 * double result = Timing.timeAuto("Calculate sum", () -> {
 *     double sum = 0;
 *     for (int i = 0; i < 1_000_000; i++) {
 *         sum += Math.sqrt(i);
 *     }
 *     return sum;
 * });
 * // Output: Calculate sum took 4.25 ms
 *
 * // Time a void operation
 * Timing.timeNanos("Print", () -> System.out.println("Hello!"));
 * // Output: Hello!
 * // Print took 85000 ns
 * }</pre>
 */
public final class Timing {
    private static final long NANOS_PER_MILLI = ChronoUnit.MILLIS.getDuration().toNanos();
    
    private static final long NANOS_PER_MICRO = ChronoUnit.MICROS.getDuration().toNanos();
    
    private static final long NANOS_PER_SECOND = ChronoUnit.SECONDS.getDuration().toNanos();
    
    /**
     * Calculates the amount of time taken to perform the action given.
     *
     * @param action action that will be measured
     * @param <T>    type of result of the Supplier
     * @return a record with the result of the Supplier and the amount of time taken
     */
    private static <T> Calculation<T> calculateTime(Supplier<T> action) {
        long start = System.nanoTime();
        T result = action.get();
        long end = System.nanoTime();
        return new Calculation<>(result, (double) end - start);
    }
    
    /**
     * Stores the result of the Supplier and the amount of time taken.
     *
     * @param result the result of the Supplier
     * @param time   amount of time taken
     * @param <T>    type of result of the Supplier
     * @see Supplier
     */
    private record Calculation<T>(T result, double time) {}
    
    /**
     * Times the execution of the given function. Automatically selects and prints the time taken in the most appropriate
     * unit (seconds, milliseconds, microseconds, or nanoseconds). Returns the result of the operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeAuto(
     *         "SQRT Sum",
     *         () -> 1
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT Sum took 5.70 μs}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeAuto(
     *         "SQRT Sum",
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT Sum took 5.53 ms}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeAuto(
     *         "SQRT Sum",
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT Sum took 2.50 s}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
    public static <T> T timeAuto(String label, Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        double ns = calculation.time();
        String unit = "ns";
        if (ns > NANOS_PER_SECOND) {
            ns /= NANOS_PER_SECOND;
            unit = "s";
        } else if (ns > NANOS_PER_MILLI) {
            ns /= NANOS_PER_MILLI;
            unit = "ms";
        } else if (ns > NANOS_PER_MICRO) {
            ns /= NANOS_PER_MICRO;
            unit = "μs";
        }
        System.out.printf("%s took %.2f %s%n", label, ns, unit);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Automatically selects and prints the time taken in the most appropriate
     * unit (seconds, milliseconds, microseconds, or nanoseconds). Returns the result of the operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeAuto(
     *         () -> 1
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 2.60 μs}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeAuto(
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 4.82 ms}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeAuto(
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 2.36 s}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
    public static <T> T timeAuto(Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        double ns = calculation.time();
        String unit = "ns";
        if (ns > NANOS_PER_SECOND) {
            ns /= NANOS_PER_SECOND;
            unit = "s";
        } else if (ns > NANOS_PER_MILLI) {
            ns /= NANOS_PER_MILLI;
            unit = "ms";
        } else if (ns > NANOS_PER_MICRO) {
            ns /= NANOS_PER_MICRO;
            unit = "μs";
        }
        System.out.printf("Took %.2f %s%n", ns, unit);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Automatically selects and prints the time taken in the most appropriate
     * unit (seconds, milliseconds, microseconds, or nanoseconds). Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeAuto(
     *         "Variable creation",
     *         () -> {
     *             double val = 0;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Variable creation took 7.00 μs}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeAuto(
     *         "SQRT Sum",
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT Sum took 2.75 ms}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeAuto(
     *         "SQRT Sum",
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             val *= 2;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT Sum took 2.41 s}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     */
    public static void timeAuto(String label, Runnable action) {
        timeAuto(label, () -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Automatically selects and prints the time taken in the most appropriate
     * unit (seconds, milliseconds, microseconds, or nanoseconds). Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeAuto(
     *         () -> {
     *             double val = 0;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 8.30 μs}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeAuto(
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 2.93 ms}</pre>
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeAuto(
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             val *= 2;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 2.26 s}</pre>
     *
     * @param action Action to be measured
     */
    public static void timeAuto(Runnable action) {
        timeAuto(() -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in seconds. Returns the result of the operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeSeconds(
     *         "SQRT Sum",
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT Sum took 2.33 s}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
    public static <T> T timeSeconds(String label, Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        // Conversion from nanoseconds to seconds
        double s = calculation.time() / NANOS_PER_SECOND;
        System.out.printf("%s took %.2f s%n", label, s);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in seconds. Returns the result of the operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeSeconds(
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 2.11 s}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
    public static <T> T timeSeconds(Supplier<T> action) {
        Calculation<T> calculation = calculateTime(action);
        // Conversion from nanoseconds to seconds
        double s = calculation.time() / NANOS_PER_SECOND;
        System.out.printf("Took %.2f s%n", s);
        return calculation.result();
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in seconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeSeconds(
     *         "Print operation",
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             System.out.println(val);
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * 2.108185105197778E13
     * Print operation took 2.26 s
     * }</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     */
    public static void timeSeconds(String label, Runnable action) {
        timeSeconds(label, () -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in seconds. Does not return anything.
     *
     * <p>Example code:
     * <pre>{@code
     * Timing.timeSeconds(
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             System.out.println(val);
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * 2.108185105197778E13
     * Took 2.13 s
     * }</pre>
     *
     * @param action Action to be measured
     */
    public static void timeSeconds(Runnable action) {
        timeSeconds(() -> {
            action.run();
            return null;
        });
    }
    
    /**
     * Times the execution of the given function. Prints the time taken in milliseconds. Returns the result of the
     * operation.
     *
     * <p>Example code:
     * <pre>{@code
     * double result = Timing.timeMillis(
     *         "SQRT Sum",
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT Sum took 3.93 ms}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
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
     *         () -> {
     *             double val = 0;
     *             for (int ii = 0; ii < 1_000_000; ii++) {
     *                 val += Math.sqrt(ii);
     *             }
     *             return val;
     *         }
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 4.30 ms}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
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
     *         "Print operation",
     *         () -> System.out.println("Hello, time millis!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, time millis!
     * Print operation took 0.04 ms
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
     *         () -> System.out.println("Hello, time millis!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, time millis!
     * Took 0.04 ms
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
     *         "SQRT",
     *         () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT took 5.50 μs}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
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
     *         () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 2.90 μs}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
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
     *         "Print operation",
     *         () -> System.out.println("Hello, time micros!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, time micros!
     * Print operation took 39.70 μs
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
     *         () -> System.out.println("Hello, time micros!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, time micros!
     * Took 27.60 μs
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
     *         "SQRT",
     *         () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code SQRT took 3600 ns}</pre>
     *
     * @param label  Name given to the operation being performed
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
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
     *         () -> Math.sqrt(100)
     * );
     * }</pre>
     * printing:
     * <pre>{@code Took 1600 ns}</pre>
     *
     * @param action Action to be measured
     * @param <T>    Result of the operation
     * @return The result of running the operation
     */
    @SuppressWarnings({"UseOfSystemOutOrSystemErr", "UnusedReturnValue"})
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
     *         "Print operation",
     *         () -> System.out.println("Hello, time nanos!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, time nanos!
     * Print operation took 83300 ns
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
     *         () -> System.out.println("Hello, time nanos!")
     * );
     * }</pre>
     * printing:
     * <pre>{@code
     * Hello, time nanos!
     * Took 28200 ns
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
