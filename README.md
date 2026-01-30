# Utilities
This library is designed to offer functional classes to quicken development times.

## Features

### Time Measurement (`com.ggiova.utilities.time.Timing`)
A comprehensive utility class for measuring and reporting the execution time of operations with automatic or manual unit selection.

#### Key Features
- **Automatic unit selection** - Chooses the most appropriate time unit (s, ms, μs, ns) for readability
- **Multiple time units** - Measure in seconds, milliseconds, microseconds, or nanoseconds
- **Flexible API** - Works with both `Supplier<T>` (value-returning) and `Runnable` (void) operations
- **Optional labeling** - Add descriptive labels to timing output

#### Quick Start
```java
import com.ggiova.utilities.time.Timing;

public static void main(String[] args) {
    // Automatically select the best unit
    double result = Timing.timeAuto("Heavy computation", () -> {
        double sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += Math.sqrt(i);
        }
        return sum;
    });
    // Output: Heavy computation took 4.25 ms
    
    // Measure in specific units
    Timing.timeMillis("Database query", () -> executeQuery());
    Timing.timeMicros("Cache lookup", () -> cache.get(key));
    Timing.timeNanos("Array access", () -> array[index]);
    
    // Time void operations without labels
    Timing.timeAuto(() -> System.out.println("Hello, world!"));
    // Output: Hello, world!
    //         Took 42.30 μs
}
```

#### Available Methods
Each timing method comes in four variants:
- `timeXxx(String label, Supplier<T> action)` - With label, returns result
- `timeXxx(Supplier<T> action)` - Without label, returns result
- `timeXxx(String label, Runnable action)` - With label, void operation
- `timeXxx(Runnable action)` - Without label, void operation

Where `Xxx` can be:
- `Auto` - Automatically selects the most appropriate unit
- `Seconds` - Measures in seconds (2 decimal places)
- `Millis` - Measures in milliseconds (2 decimal places)
- `Micros` - Measures in microseconds (2 decimal places)
- `Nanos` - Measures in nanoseconds (whole numbers)

## Requirements

- Java 25 or higher
