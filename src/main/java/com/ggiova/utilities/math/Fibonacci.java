package com.ggiova.utilities.math;

import java.math.BigInteger;
import java.util.*;

/**
 * Represents a Fibonacci number at a specific index in the Fibonacci sequence.
 *
 * <p>The Fibonacci sequence is defined as:
 * <ul>
 *   <li>F(0) = 0</li>
 *   <li>F(1) = 1</li>
 *   <li>F(n) = F(n-1) + F(n-2) for n ≥ 2</li>
 *   <li>F(-n) = (-1)^(n+1) × F(n) for negative indices</li>
 * </ul>
 *
 * <p>This class provides efficient computation using the fast doubling algorithm
 * with memoization for improved performance on repeated calculations.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_sequence">Fibonacci Sequence</a>
 * @see <a href="https://oeis.org/A000045">OEIS (A000045)</a>
 */
public class Fibonacci implements Comparable<Fibonacci> {
    /**
     * Cache for computed Fibonacci values to avoid redundant calculations
     */
    private static final Map<Integer, BigInteger> CACHE = new HashMap<>();
    
    static {
        // Pre-populate cache with base cases
        CACHE.put(0, BigInteger.ZERO);
        CACHE.put(1, BigInteger.ONE);
        CACHE.put(2, BigInteger.ONE);
        CACHE.put(3, BigInteger.TWO);
    }
    
    private final int index;
    
    private final BigInteger value;
    
    /**
     * Creates a Fibonacci number at the specified index.
     *
     * @param index the index in the Fibonacci sequence (can be negative)
     */
    public Fibonacci(int index) {
        this.index = index;
        this.value = compute(index);
    }
    
    /**
     * Computes the Fibonacci number at the given index using fast doubling algorithm with memoization.
     *
     * @param index the index to compute
     * @return the Fibonacci number at that index
     */
    private static BigInteger compute(final int index) {
        // Check cache first
        if (CACHE.containsKey(index)) return CACHE.get(index);
        
        // Handle negative indices: F(-n) = (-1)^(n+1) × F(n)
        if (index < 0) {
            BigInteger computed = compute(-index);
            if (Maths.isOdd(index)) computed = computed.negate();
            CACHE.put(index, computed);
            return computed;
        }
        
        // Check if both neighbors are cached (optimization)
        if (CACHE.containsKey(index - 1) && CACHE.containsKey(index - 2)) {
            BigInteger result = CACHE.get(index - 1).add(CACHE.get(index - 2));
            CACHE.put(index, result);
            return result;
        }
        
        // Fast doubling algorithm: O(log n)
        int halfIndex = index >>> 1;
        BigInteger fHalfPlus1 = compute(halfIndex + 1);
        BigInteger fHalf      = compute(halfIndex);
        
        BigInteger result;
        if (Maths.isEven(index)) {
            // F(2k) = F(k) × (2×F(k+1) - F(k))
            result = fHalf.multiply(fHalfPlus1.shiftLeft(1).subtract(fHalf));
        } else {
            // F(2k+1) = F(k+1)² + F(k)²
            result = fHalfPlus1.multiply(fHalfPlus1).add(fHalf.multiply(fHalf));
        }
        
        CACHE.put(index, result);
        return result;
    }
    
    /**
     * Creates a range of Fibonacci numbers from start (inclusive) to end (exclusive). This method is optimized to reuse
     * computed values.
     *
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     * @return a list of Fibonacci numbers in the range
     * @throws IllegalArgumentException if start >= end
     */
    public static List<Fibonacci> range(int start, int end) {
        if (start >= end)
            throw new IllegalArgumentException("Start must be less than end");
        
        List<Fibonacci> list = new ArrayList<>(end - start);
        for (int index = start; index < end; index++) {
            list.add(new Fibonacci(index));
        }
        return list;
    }
    
    /**
     * Creates a list of the first n Fibonacci numbers starting from F(0).
     *
     * @param count the number of Fibonacci numbers to generate
     * @return a list of the first n Fibonacci numbers
     * @throws IllegalArgumentException if count is negative
     */
    public static List<Fibonacci> first(int count) {
        if (count < 0)
            throw new IllegalArgumentException("Count must be non-negative");
        return range(0, count);
    }
    
    /**
     * Creates a Fibonacci number at the specified index.
     *
     * @param index the index in the Fibonacci sequence (can be negative)
     * @return a new Fibonacci object.
     */
    public static Fibonacci of(int index) {
        return new Fibonacci(index);
    }
    
    /**
     * Creates Fibonacci numbers for multiple indices.
     *
     * @param indices the indices to create Fibonacci numbers for
     * @return an array of Fibonacci objects
     */
    public static Fibonacci[] of(int... indices) {
        Fibonacci[] result = new Fibonacci[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[i] = new Fibonacci(indices[i]);
        }
        return result;
    }
    
    /**
     * Calculates the sum of the Fibonacci Numbers from {@code 0} up to {@code index}.
     *
     * <p>This method uses the identity: ∑(F_i) from i=0 to n = F_(n+2) - 1
     *
     * <p>Derivation: Since Fibonacci numbers can be represented using matrix exponentiation:
     * <pre>
     * ⌈ 1 1 ⌉ ^ n  =  ⌈ F_(n+1) F_n     ⌉
     * ⌊ 1 0 ⌋         ⌊ F_n     F_(n-1) ⌋
     * </pre>
     *
     * We replace F_n with X ^ n. The sum can be expressed as a geometric series:
     * <pre>
     * index          index
     *   Σ  F_n  =      Σ  X ^ n   =  ( X^(index + 1) - I ) × ( X - I )^-1
     * n = 0          n = 0
     * </pre>
     *
     * Computing ( X - I )^-1:
     * <pre>
     * ( ⌈ 1 1 ⌉ - ⌈ 1 0 ⌉ ) ^ -1  =  ( ⌈ 0  1 ⌉ ) ^ -1
     *   ⌊ 1 0 ⌋   ⌊ 0 1 ⌋              ⌊ 1 -1 ⌋
     * </pre>
     *
     * We'll define Q to be:
     * <pre>
     *     ( ⌈ 0  1 ⌉ ) ^ -1 = Q ^ - 1
     *       ⌊ 1 -1 ⌋
     * </pre>
     *
     * We'll try to solve for Q.
     * <p>Since Q ^ -1 = V   &rarr;   I = V × Q
     * <p>If we try replacing V with X, we get:
     * <pre>
     *   ⌈ 0  1 ⌉  *  ⌈ 1 1 ⌉  = ⌈ 0×1 + 1× 1  0×1 + 1× 0  ⌉  =  ⌈ 1 0 ⌉  =  I
     *   ⌊ 1 -1 ⌋     ⌊ 1 0 ⌋    ⌊ 1×1 + 1×-1  1×1 + 0×-1  ⌋     ⌊ 0 1 ⌋
     * </pre>
     *
     * So ( X - I )^-1 = X
     * <p>Resulting in:
     * <pre>
     *  index
     *   Σ  F_n   =    ( X^(index + 1) - I ) × X   =    X^(index + 2) - X
     * n = 0
     * </pre>
     *
     * Replacing X ^ n with F_n, we get:
     * <pre>
     * index
     *   Σ  F_n   =   F_(index + 2) - F_1  =   F_(index + 2) - 1
     * n = 0
     * </pre>
     *
     * @param index Index (must be non-negative)
     * @return The sum of the Fibonacci Numbers from F(0) to F(index)
     * @throws IllegalArgumentException if index is negative
     * @see <a href="https://en.wikipedia.org/wiki/Generalizations_of_Fibonacci_numbers" target="_blank">Generalizations
     * of Fibonacci numbers</a>
     */
    public static BigInteger sumOfFibonacci(final int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index must be non-negative");
        return Fibonacci.of(index + 2).toBigInteger().subtract(BigInteger.ONE);
    }
    
    /**
     * Returns the next Fibonacci number in the sequence (index + 1). This is efficient as it reuses the cached value of
     * the current number.
     *
     * @return the next Fibonacci number
     */
    public Fibonacci next() {
        return new Fibonacci(this.index + 1);
    }
    
    /**
     * Returns the previous Fibonacci number in the sequence (index - 1). This is efficient as it reuses the cached
     * value of the current number.
     *
     * @return the previous Fibonacci number
     */
    public Fibonacci prior() {
        return new Fibonacci(this.index - 1);
    }
    
    /**
     * Returns the index of this Fibonacci number in the sequence.
     *
     * @return the index
     */
    public int getIndex() {
        return this.index;
    }
    
    /**
     * Converts this Fibonacci number to an int.
     *
     * @return the int value
     * @throws ValueOverflowException if the value exceeds int range
     */
    public int toInt() {
        try {
            return this.value.intValueExact();
        } catch (ArithmeticException ae) {
            throw new ValueOverflowException(Integer.class);
        }
    }
    
    /**
     * Converts this Fibonacci number to a long.
     *
     * @return the long value
     * @throws ValueOverflowException if the value exceeds long range
     */
    public long toLong() {
        try {
            return this.value.longValueExact();
        } catch (ArithmeticException ae) {
            throw new ValueOverflowException(Long.class);
        }
    }
    
    /**
     * Returns the BigInteger representation of this Fibonacci number.
     *
     * @return the BigInteger value
     */
    public BigInteger toBigInteger() {
        return this.value;
    }
    
    /**
     * Converts this Fibonacci number to a float.
     *
     * @return the float value
     * @throws ValueOverflowException if the value exceeds float range
     */
    public float toFloat() {
        float val = this.value.floatValue();
        if (Float.isInfinite(val)) {
            throw new ValueOverflowException(Float.class);
        }
        return val;
    }
    
    /**
     * Converts this Fibonacci number to a double.
     *
     * @return the double value
     * @throws ValueOverflowException if the value exceeds double range
     */
    public double toDouble() {
        double val = this.value.doubleValue();
        if (Double.isInfinite(val)) {
            throw new ValueOverflowException(Double.class);
        }
        return val;
    }
    
    /**
     * Checks if this Fibonacci number is even.
     *
     * @return true if even, false otherwise
     */
    public boolean isEven() {
        return !this.value.testBit(0);
    }
    
    /**
     * Checks if this Fibonacci number is odd.
     *
     * @return true if odd, false otherwise
     */
    public boolean isOdd() {
        return this.value.testBit(0);
    }
    
    /**
     * Checks if this Fibonacci number is positive.
     *
     * @return true if positive, false otherwise
     */
    public boolean isPositive() {
        return this.value.compareTo(BigInteger.ZERO) > 0;
    }
    
    /**
     * Checks if this Fibonacci number is negative.
     *
     * @return true if negative, false otherwise
     */
    public boolean isNegative() {
        return this.value.compareTo(BigInteger.ZERO) < 0;
    }
    
    /**
     * Returns the number of decimal digits in this Fibonacci number.
     *
     * @return the number of digits
     */
    public int digitCount() {
        if (this.value.equals(BigInteger.ZERO)) return 1;
        return this.value.abs().toString().length();
    }
    
    /**
     * Calculates the ratio of this Fibonacci number to the previous one, which approximates the golden ratio φ for
     * large indices.
     *
     * @return the ratio F(n)/F(n-1), or null if index is 0
     */
    public Double ratioToPrior() {
        if (this.index == 0) return null;
        BigInteger priorValue = compute(this.index - 1);
        if (priorValue.equals(BigInteger.ZERO)) return null;
        return this.value.doubleValue() / priorValue.doubleValue();
    }
    
    /**
     * Checks if a given number is a Fibonacci number. A positive integer n is a Fibonacci number if and only if one of
     * {@code 5n² + 4} or {@code 5n² - 4} is a perfect square.
     *
     * @param n the number to check
     * @return true if n is a Fibonacci number, false otherwise
     */
    public static boolean isFibonacciNumber(long n) {
        if (n < 0) return false;
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }
    
    /**
     * Checks if a number is a perfect square.
     *
     * @param n the number to check
     * @return true if n is a perfect square, false otherwise
     */
    private static boolean isPerfectSquare(long n) {
        // Should be moved to Maths class
        if (n < 0) return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    
    /**
     * Clears the internal cache. Useful for memory management in long-running applications.
     */
    public static void clearCache() {
        CACHE.clear();
        // Restore base cases
        CACHE.put(0, BigInteger.ZERO);
        CACHE.put(1, BigInteger.ONE);
        CACHE.put(2, BigInteger.ONE);
        CACHE.put(3, BigInteger.TWO);
    }
    
    /**
     * Returns the current cache size.
     *
     * @return the number of cached values
     */
    public static int getCacheSize() {
        return CACHE.size();
    }
    
    @Override
    public int compareTo(Fibonacci other) {
        return this.value.compareTo(other.value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fibonacci that = (Fibonacci) obj;
        return this.index == that.index;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(index, value);
    }
    
    @Override
    public String toString() {
        return String.format("F(%d) = %s", index, value);
    }
    
    /**
     * Returns a detailed string representation including additional information.
     *
     * @return detailed string representation
     */
    public String toDetailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fibonacci Number%n"));
        sb.append(String.format(" Index: %d%n", index));
        sb.append(String.format(" Value: %s%n", value));
        sb.append(String.format(" Digits: %d%n", digitCount()));
        sb.append(String.format(" Even: %b%n", isEven()));
        Double ratio = ratioToPrior();
        if (ratio != null) {
            sb.append(String.format(" Ratio to prior: %.10f%n", ratio));
            sb.append(String.format(" Golden ratio: %.10f%n", Maths.GOLDEN_RATIO));
            sb.append(String.format(" Difference: %.10e", Math.abs(ratio - Maths.GOLDEN_RATIO)));
        }
        return sb.toString();
    }
}