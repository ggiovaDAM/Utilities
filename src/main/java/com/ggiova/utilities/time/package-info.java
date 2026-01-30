/**
 * Provides utilities for measuring and reporting the execution time of operations.
 *
 * <p>This package contains classes designed to help developers measure performance in a clear and consistent way. The
 * {@link com.ggiova.utilities.time.Timing} class provides comprehensive timing capabilities for both
 * {@link java.util.function.Supplier} and {@link java.lang.Runnable} operations across multiple time units.
 *
 * <h2>Key Features</h2>
 * <ul>
 *   <li>Automatic unit selection for optimal readability</li>
 *   <li>Support for seconds, milliseconds, microseconds, and nanoseconds</li>
 *   <li>Optional operation labeling for clearer output</li>
 *   <li>Works with both value-returning (Supplier) and void (Runnable) operations</li>
 * </ul>
 *
 * <h2>Example Usage</h2>
 * <pre>{@code
 * // Auto-select the most appropriate time unit
 * double result = Timing.timeAuto("Heavy computation", () -> {
 *     // Your code here
 *     return computeResult();
 * });
 *
 * // Measure in specific units
 * Timing.timeMillis("Database query", () -> executeQuery());
 * Timing.timeMicros("Cache lookup", () -> cache.get(key));
 * Timing.timeNanos("Array access", () -> array[index]);
 * }</pre>
 *
 * @see com.ggiova.utilities.time.Timing
 */
package com.ggiova.utilities.time;