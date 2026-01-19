package com.ggiova.utilities.math;

import com.ggiova.utilities.primitives.Doubles;

/**
 * Utility class providing mathematical operations and predicates for primitive types.
 * <p>
 * This class offers functionality that extends beyond the standard {@link Math} class, with a focus on bit-level
 * operations, floating-point precision handling, and numeric type classification.
 * <p>
 * All methods in this class are static and the class cannot be instantiated.
 *
 * @see Math
 * @see com.ggiova.utilities.primitives.Doubles
 */
public final class Maths {
    /**
     * Determines if {@code number} is a whole number. A whole number (Z) is a number in the set {@code N ∪ {0} ∪ -N}
     * or, more simply, any number in the set: {@code {…, -3, -2, -1, 0, 1, 2, 3, …}}.
     * <br>Since {@code double}s have a wide range of number representation, some especial cases pop up:
     * <ul>
     *     <li>If {@code number} is {@link Double#NaN NaN}, returns {@code false}.</li>
     *     <li>If {@code number} is infinite, either {@link Double#POSITIVE_INFINITY positive} or
     *     {@link Double#NEGATIVE_INFINITY negative} it returns {@code false}.</li>
     *     <li>If the absolute value of {@code number} is more than or equal to <i>2<sup>52</sup></i> or
     *     {@code 4_503_599_627_370_496.0} then it returns {@code true} since, due to loss of precision, all numbers
     *     above it will be whole numbers.</li>
     * </ul>
     * As stated before, all numbers bigger than or equal to <i>2<sup>52</sup></i> will always be whole numbers, this is
     * due to the length of the mantissa. The mantissa of a {@code double} can only store 52 bits, meaning that if a
     * {@code double} stores a number with an {@link Doubles#LOSS_DECIMAL_PRECISION exponent (base 2) of 52}, then,
     * the least-significant bit of the mantissa will store the unit bit (a one). This implies that there is no space
     * for decimals.
     *
     * @param number Value that will be checked.
     * @return {@code true} if {@code number} is an integer, {@code false} otherwise.
     * @see <a href="https://en.wikipedia.org/wiki/Integer" target="_blank">Integer Wikipedia Page</a>
     */
    public static boolean isWholeNumber(final double number) {
        // Takes the number's bits removing the sign.
        final long unsignedBits = Double.doubleToLongBits(number) & ~Doubles.SIGN_MASK;
        return switch (unsignedBits) {
            // If zero, return true.
            case 0L -> true;
            // If bigger than exponent mask return false. This rules out NaNs and Infinities.
            case long l when l >= Doubles.EXPONENT_MASK -> false;
            // If the number is bigger than or equal to LOSS_DECIMAL_PRECISION then it's always a whole number.
            case long l when l >= Doubles.LOSS_DECIMAL_PRECISION_MASK -> true;
            default -> {
                // Gets the exponent and removes the bias.
                int exp = (int) (unsignedBits >>> Doubles.MANTISSA_LENGTH) - Doubles.EXPONENT_BIAS;
                // If the number is smaller than 1, return false.
                if (exp < 0) yield false;
                // Mask for the binary decimals (mantissa) to check whether it has more decimals past the limit or not. Also
                // used to check if the number itself is odd or even.
                long mask = 1L << Doubles.MANTISSA_LENGTH - exp;
                // If unsignedBits & -mask [simplified from ~(mask - 1)] equals unsignedBits, it means that there are no bits
                // after the unit value.
                // Example 15 & 15.1:
                // 15   --> 0b0_10000000010_1110000000000000000000000000000000000000000000000000L
                // The exponent is 3, so we need to check after the next three bits if there are any one's.
                // In this case there aren't, so 15's bits masked equals 15's bits.
                // 15.1 --> 0b0_10000000010_1110001100110011001100110011001100110011001100110011L
                // The exponent is also 3, so we need to check after the next three bits if there are any one's.
                // There are, so this number is not an integer, because 15.1's bits masked are not equal 15.1's bits.
                yield (unsignedBits & -mask) == unsignedBits;
            }
        };
    }
}
