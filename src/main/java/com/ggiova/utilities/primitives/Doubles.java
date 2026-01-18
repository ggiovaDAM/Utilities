package com.ggiova.utilities.primitives;

/**
 *
 */
public final class Doubles {
    /**
     * Displays the bits that represent {@code 0.0d}.
     */
    public static final long ZERO_BITS = Double.doubleToLongBits(0.0d);
    
    /**
     * Displays the bits that represent {@code -0.0d}.
     */
    public static final long NEGATIVE_ZERO_BITS = Double.doubleToLongBits(-0.0d);
    
    /**
     * Displays the bit layout that represents positive infinity.
     */
    public static final long POSITIVE_INFINITY_BITS = Double.doubleToLongBits(Double.POSITIVE_INFINITY);
    
    /**
     * Displays the bit layout that represents negative infinity.
     */
    public static final long NEGATIVE_INFINITY_BITS = Double.doubleToLongBits(Double.NEGATIVE_INFINITY);
    
    /**
     * Amount of bits that represent the sign of a {@code double}.
     */
    public static final int SIGN_LENGTH = 1;
    
    /**
     * Amount of bits that represent the exponent of a {@code double}.
     */
    public static final int EXPONENT_LENGTH = 11;
    
    /**
     * Amount of bits that represent the mantissa of a {@code double}. Also used for bit shifting to reach the exponent
     * section of a number.
     */
    public static final int MANTISSA_LENGTH = 52;
    
    /**
     * Mask for {@code double}'s sign bit. To be used in conjunction with {@link Double#doubleToLongBits(double)}.
     */
    public static final long SIGN_MASK = 1L << (Double.SIZE - 1);
    
    /**
     * Mask for {@code double}'s mantissa bits. There are 52 bits that represent the mantissa. To be used in conjunction
     * with {@link Double#doubleToLongBits(double)}.
     */
    public static final long MANTISSA_MASK = (1L << MANTISSA_LENGTH) - 1L;
    
    /**
     * Mask for {@code double}'s exponent bits. There's a total of 11 bits that represents the exponent. To be used in
     * conjunction with {@link Double#doubleToLongBits(double)}.
     */
    public static final long EXPONENT_MASK = ((1L << EXPONENT_LENGTH) - 1L) << MANTISSA_LENGTH;
    
    /**
     * Smallest exponent that is not zero.
     */
    public static final long TINY_EXPONENT = 1L << MANTISSA_LENGTH;
    
    /**
     * Mask for the {@code double}'s exponent bits that represents the highest exponent for a number without turning
     * into {@link Double#POSITIVE_INFINITY infinity} nor {@link Double#NaN NaN}. <u><b>Not</b> to be confused</u> with
     * {@link Doubles#EXPONENT_MASK}.
     */
    public static final long MAX_EXPONENT_MASK = EXPONENT_MASK - TINY_EXPONENT;
    
    /**
     * Is by how much the exponent is shifted when stored. The exponent is stored as {@code 2048} and shifted down by
     * {@code 1023} to represent both a positive and a negative exponent.
     */
    public static final int EXPONENT_BIAS = Double.MAX_EXPONENT;
    
    /**
     * Exponent that represents the unit ({@code 1.0d}). Intended, but not limited, to be used when masking and retaining only
     * the mantissa ({@link Doubles#MANTISSA_MASK}).
     */
    public static final long UNIT_EXPONENT_MASK = (EXPONENT_MASK >>> 1) & EXPONENT_MASK;
    
    /**
     * Represents the biggest exponent (unbiased) that still has decimal precision.
     */
    public static final int LOSS_DECIMAL_PRECISION_EXPONENT = MANTISSA_LENGTH;
    
    /**
     * Upper bound of {@code double} floating-point numbers where they lose all decimal precision. This is due to the
     * fact that the decimal part is stored in {@code 52} bits which means that any number that is more than or equal to
     * 2<sup>52</sup> has no decimal part.
     * <br>Computable as:
     * {@code
     *     Double.longBitsToDouble(LOSS_DECIMAL_PRECISION_MASK)
     * }
     */
    public static final double LOSS_DECIMAL_PRECISION = 0x1.0p52d;
    
    /**
     * Mask that represents the upper bound of {@code double} floating-point numbers where they lose all decimal
     * precision. This is due to the fact that the decimal part is stored in {@code 52} bits which means that any number
     * that is more than or equal to 2<sup>52</sup> has no decimal part.
     */
    public static final long LOSS_DECIMAL_PRECISION_MASK = (long) (EXPONENT_BIAS + LOSS_DECIMAL_PRECISION_EXPONENT) << LOSS_DECIMAL_PRECISION_EXPONENT;
    
    /**
     * Closest floating-point approximation of the square root of the upper limit of {@link Double#MAX_VALUE}.
     * Note that this value squared will not be equal to {@link Double#MAX_VALUE} due to loss in precision.
     */
    public static final double SQUARE_ROOT_MAX_VALUE = Math.sqrt(Double.MAX_VALUE);
    
    static {
        assert (SIGN_LENGTH + EXPONENT_LENGTH + MANTISSA_LENGTH == Double.SIZE) : "ERROR WHILE DEFINING SIZES!";
        
        assert Long.bitCount(SIGN_MASK | EXPONENT_MASK | MANTISSA_MASK) == Double.SIZE
                : "ERROR: bit masks do not cover entire 64-bit range!";
        
        assert (SIGN_MASK     & EXPONENT_MASK) == 0L &&
               (EXPONENT_MASK & MANTISSA_MASK) == 0L &&
               (SIGN_MASK     & MANTISSA_MASK) == 0L  : "ERROR: overlapping mask bits!";
        
        assert (ZERO_BITS)              == 0L                          : "ERROR WHILE DEFINING ZERO";
        assert (NEGATIVE_ZERO_BITS)     == SIGN_MASK                   : "ERROR WHILE DEFINING NEGATIVE ZERO";
        assert (POSITIVE_INFINITY_BITS) == EXPONENT_MASK               : "ERROR WHILE DEFINING POSITIVE INFINITY";
        assert (NEGATIVE_INFINITY_BITS) == (EXPONENT_MASK | SIGN_MASK) : "ERROR WHILE DEFINING POSITIVE INFINITY";
        
        assert LOSS_DECIMAL_PRECISION + 0.5d == LOSS_DECIMAL_PRECISION : "ERROR CHECKING DECIMAL PRECISION LOSS!";
        assert (Double.doubleToLongBits(1.0d) & EXPONENT_MASK) == UNIT_EXPONENT_MASK : "MAJOR ERROR OCCURRED!";
    }
    
    /**
     * Creates a String that contains all the bits of a {@code double} starting with '0b' and ending with 'L'.
     * Underscores are utilized to separate the sign from the exponent and the exponent from the mantissa. For example
     * {@code 1.5d} is transformed into {@code 0b0_01111111111_1000000000000000000000000000000000000000000000000000L}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toBinaryString(final double num) {
        final int BINARY_SHIFT      = 2; // +2 for the '0b'
        final int UNDERSCORE_SHIFT  = 2; // +2 for the underscores
        final int LONG_L_EXTRA      = 1; // +1 for L at end
        final int LENGTH            = Long.SIZE + UNDERSCORE_SHIFT + BINARY_SHIFT + LONG_L_EXTRA;
        final int MAX_INDEX         = LENGTH - 1;
        final int FIRST_UNDERSCORE  = SIGN_LENGTH + BINARY_SHIFT;
        final int SECOND_UNDERSCORE = FIRST_UNDERSCORE + EXPONENT_LENGTH + 1; // +1 for the first underscore shifting
        
        long lb = Double.doubleToLongBits(num);
        
        char[] arr = new char[LENGTH];
        arr[        0] = '0';
        arr[        1] = 'b';
        arr[MAX_INDEX] = 'L';
        for (int ii = MAX_INDEX - LONG_L_EXTRA; ii >= BINARY_SHIFT; ii--) {
            if (ii == FIRST_UNDERSCORE || ii == SECOND_UNDERSCORE) arr[ii] = '_';
            else {
                if ((lb & 1L) == 0L) arr[ii] = '0';
                else                 arr[ii] = '1';
                lb >>>= 1;
            }
        }
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the raw bits of a {@code double} starting with '0b' and ending with 'L'. "Raw"
     * means that the different {@code NaN}s's bits are shown. Underscores are utilized to separate the sign from the
     * exponent and the exponent from the mantissa. For example {@code 1.5d} is transformed into
     * {@code 0b0_01111111111_1000000000000000000000000000000000000000000000000000L}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toRawBinaryString(final double num) {
        final int BINARY_SHIFT      = 2; // +2 for the '0b'
        final int UNDERSCORE_SHIFT  = 2; // +2 for the underscores
        final int LONG_L_EXTRA      = 1; // +1 for L at end
        final int LENGTH            = Long.SIZE + UNDERSCORE_SHIFT + BINARY_SHIFT + LONG_L_EXTRA;
        final int MAX_INDEX         = LENGTH - 1;
        final int FIRST_UNDERSCORE  = SIGN_LENGTH + BINARY_SHIFT;
        final int SECOND_UNDERSCORE = FIRST_UNDERSCORE + EXPONENT_LENGTH + 1; // +1 for the first underscore shifting
        
        long lb = Double.doubleToRawLongBits(num);
        
        char[] arr = new char[LENGTH];
        arr[        0] = '0';
        arr[        1] = 'b';
        arr[MAX_INDEX] = 'L';
        for (int ii = MAX_INDEX - LONG_L_EXTRA; ii >= BINARY_SHIFT; ii--) {
            if (ii == FIRST_UNDERSCORE || ii == SECOND_UNDERSCORE) arr[ii] = '_';
            else {
                if ((lb & 1L) == 0L) arr[ii] = '0';
                else                 arr[ii] = '1';
                lb >>>= 1;
            }
        }
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the bits of a {@code double} in hexadecimal starting with '0x' and ending with 'L'.
     * Underscores are utilized to separate bytes in pairs. For example {@code 1.5d} is transformed into
     * {@code 0x3f_f8_00_00_00_00_00_00L}
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the hexadecimal binary representation of {@code num}.
     */
    public static String toBinaryHexString(final double num) {
        final int  MAIN_SECTION      = Long.SIZE / 4; // Divides the bits into groups of four two transform into hexadecimal
        final int  HEX_SYMBOL_LENGTH = 2;             // +2 for '0x'
        final int  LONG_L_EXTRA      = 1;             // +1 for L at end
        final int  UNDERSCORES       = MAIN_SECTION / 2 - 1;
        final int  LENGTH            = MAIN_SECTION + UNDERSCORES + HEX_SYMBOL_LENGTH + LONG_L_EXTRA;
        final int  MAX_INDEX         = LENGTH - 1;
        final long MASK              = 15L;
        
        final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
                               '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final char[] arr    = new char[LENGTH];
        
        long bits = Double.doubleToLongBits(num);
        
        arr[        0] = '0';
        arr[        1] = 'x';
        arr[MAX_INDEX] = 'L';
        for (int ii = MAX_INDEX - LONG_L_EXTRA; ii >= HEX_SYMBOL_LENGTH; ii--) {
            if (ii % 3 == (HEX_SYMBOL_LENGTH + 2) % 3) arr[ii] = '_';
            else {
                int index = (int) (bits & MASK);
                arr[ii] = digits[index];
                bits >>>= 4;
            }
        }
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the raw bits of a {@code double} starting with '0x' and ending with 'L'. "Raw"
     * means that the different {@code NaN}s's bits are shown. Underscores are utilized to separate bytes in pairs. For
     * example {@code 1.5d} is transformed into {@code 0x3f_f8_00_00_00_00_00_00L}
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the hexadecimal binary representation of {@code num}.
     */
    public static String toRawBinaryHexString(final double num) {
        final int  MAIN_SECTION      = Long.SIZE / 4; // Divides the bits into groups of four two transform into hexadecimal
        final int  HEX_SYMBOL_LENGTH = 2;             // +2 for '0x'
        final int  LONG_L_EXTRA      = 1;             // +1 for L at end
        final int  UNDERSCORES       = MAIN_SECTION / 2 - 1;
        final int  LENGTH            = MAIN_SECTION + UNDERSCORES + HEX_SYMBOL_LENGTH + LONG_L_EXTRA;
        final int  MAX_INDEX         = LENGTH - 1;
        final long MASK              = 15L;
        
        final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final char[] arr    = new char[LENGTH];
        
        long bits = Double.doubleToRawLongBits(num);
        
        arr[        0] = '0';
        arr[        1] = 'x';
        arr[MAX_INDEX] = 'L';
        for (int ii = MAX_INDEX - LONG_L_EXTRA; ii >= HEX_SYMBOL_LENGTH; ii--) {
            if (ii % 3 == (HEX_SYMBOL_LENGTH + 2) % 3) arr[ii] = '_';
            else {
                int index = (int) (bits & MASK);
                arr[ii] = digits[index];
                bits >>>= 4;
            }
        }
        return String.valueOf(arr);
    }
}
