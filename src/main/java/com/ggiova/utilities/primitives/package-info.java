/**
 * Classes that contain constants that complement the primitive wrappers. These classes are:
 * <ul>
 *     <li>{@link com.ggiova.utilities.primitives.Floats}: contains constants used in calculations the complement those
 *     in the {@link java.lang.Float Float class}.</li>
 *     <li>{@link com.ggiova.utilities.primitives.Doubles}: contains constants used in calculations the complement those
 *     in the {@link java.lang.Double Double class}.</li>
 * </ul>
 * Both of these classes have the same constants but tailored to their respective types. These constants are:
 * <ul>
 *     <li><b>ZERO_BITS</b>: Bits for {@code 0}.</li>
 *     <li><b>NEGATIVE_ZERO_BITS</b>: Bits for {@code -0}.</li>
 *     <li><b>POSITIVE_INFINITY_BITS</b>: Bits for positive infinity.</li>
 *     <li><b>NEGATIVE_INFINITY_BITS</b>: Bits for negative infinity.</li>
 *     <li><b>SIGN_MASK</b>: Mask to isolate the sign bit.</li>
 *     <li><b>EXPONENT_LENGTH</b>: Stores the length of the exponent.</li>
 *     <li><b>MANTISSA_LENGTH</b>: Stores the length of the mantissa.</li>
 *     <li><b>SIGN_MASK</b>: Mask for the sign bits.</li>
 *     <li><b>MANTISSA_MASK</b>: Mask to isolate the mantissa.</li>
 *     <li><b>EXPONENT_MASK</b>: Mask to isolate the exponent.</li>
 *     <li><b>TINY_EXPONENT</b>: Smallest exponent that is not zero (Mask).</li>
 *     <li><b>MAX_EXPONENT_MASK</b>: Biggest exponent that is not infinity nor NaN.</li>
 *     <li><b>EXPONENT_BIAS</b>: Difference done to the exponent bits to get the exponent used.</li>
 *     <li><b>UNIT_EXPONENT_MASK</b>: Exponent used with the unit (1) (Mask).</li>
 *     <li><b>LOSS_DECIMAL_PRECISION_EXPONENT</b>: Biggest exponent that still has decimal precision.</li>
 *     <li><b>LOSS_DECIMAL_PRECISION</b>: The smallest number that looses all decimal precision.</li>
 *     <li><b>LOSS_DECIMAL_PRECISION_MASK</b>: The smallest number that looses all decimal precision, but as a mask.</li>
 *     <li><b>SQUARE_ROOT_MAX_VALUE</b>: Square root of the max value.</li>
 * </ul>
 */
package com.ggiova.utilities.primitives;