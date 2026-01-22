/**
 * Provides utilities for measuring and reporting the execution time of operations.
 * <br>
 * This package contains classes designed to help developers measure performance in a clear and consistent way.
 * Currently, it includes the {@link com.ggiova.utilities.time.Timing} class which allows timing of
 * {@link java.util.function.Supplier} and {@link java.lang.Runnable} operations.
 * <br>
 * Example usage:
 * <pre>{@code
 * // Timing a Supplier that returns a result
 * double result = Timing.timeMillis("Square root", () -> Math.sqrt(100));
 *
 * // Timing a Runnable with no return value
 * Timing.timeMillis("Print operation", () -> System.out.println("Hello, world!"));
 * }</pre>
 */
package com.ggiova.utilities.time;