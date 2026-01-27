/**
 * Classes that contain constants that complement the primitive wrappers. These classes are:
 * <ul>
 *     <li>{@link com.ggiova.utilities.primitives.Integers}: contains methods for treating {@code int}s.</li>
 *     <li>{@link com.ggiova.utilities.primitives.Floats}: contains constants used in calculations the complement those
 *     in the {@link java.lang.Float Float class}.</li>
 *     <li>{@link com.ggiova.utilities.primitives.Doubles}: contains constants used in calculations the complement those
 *     in the {@link java.lang.Double Double class}.</li>
 * </ul>
 * {@code Floats} and {@code Doubles} have the same constants but tailored to their respective types. These
 * constants are:
 * <ul>
 *     <li>{@code ZERO_BITS}: Bits for {@code 0}.</li>
 *     <li>{@code NEGATIVE_ZERO_BITS}: Bits for {@code -0}.</li>
 *     <li>{@code POSITIVE_INFINITY_BITS}: Bits for positive infinity.</li>
 *     <li>{@code NEGATIVE_INFINITY_BITS}: Bits for negative infinity.</li>
 *     <li>{@code SIGN_MASK}: Mask to isolate the sign bit.</li>
 *     <li>{@code EXPONENT_LENGTH}: Stores the length of the exponent.</li>
 *     <li>{@code MANTISSA_LENGTH}: Stores the length of the mantissa.</li>
 *     <li>{@code SIGN_MASK}: Mask for the sign bits.</li>
 *     <li>{@code MANTISSA_MASK}: Mask to isolate the mantissa.</li>
 *     <li>{@code EXPONENT_MASK}: Mask to isolate the exponent.</li>
 *     <li>{@code TINY_EXPONENT}: Smallest exponent that is not zero (Mask).</li>
 *     <li>{@code MAX_EXPONENT_MASK}: Biggest exponent that is not infinity nor NaN.</li>
 *     <li>{@code EXPONENT_BIAS}: Difference done to the exponent bits to get the exponent used.</li>
 *     <li>{@code UNIT_EXPONENT_MASK}: Exponent used with the unit (1) (Mask).</li>
 *     <li>{@code LOSS_DECIMAL_PRECISION_EXPONENT}: Biggest exponent that still has decimal precision.</li>
 *     <li>{@code LOSS_DECIMAL_PRECISION}: The smallest number that looses all decimal precision.</li>
 *     <li>{@code LOSS_DECIMAL_PRECISION_MASK}: The smallest number that looses all decimal precision, but as a mask.</li>
 *     <li>{@code SQUARE_ROOT_MAX_VALUE}: Square root of the max value.</li>
 * </ul>
 * {@code Integers}, {@code Floats}, and {@code Doubles} have methods to get their bits as {@code String}s:
 * <ul>
 *     <li>{@code toBinaryString(type)}: Returns the bits as a {@code String} with bits separated in specific ways.</li>
 *     <li>{@code toBinaryHexString(type)}: Returns the bits grouped by bytes as a {@code String}.</li>
 * </ul>
 */
package com.ggiova.utilities.primitives;