package com.ggiova.utilities.primitives;

/**
 * Utility class for the primitive {@code float}.
 * <br>
 * The constants introduced are a supplement to the constants in {@link Float}. They are intended to be utilized with
 * functions that convert from one primitive type to another such as {@link Float#floatToIntBits(float)} &amp;
 * {@link Float#intBitsToFloat(int)}.
 * <br>
 * Contains methods to better read the bits of {@code float}s.
 *
 * @see Float
 */
public class Floats {
    /**
     * Displays the bits that represent {@code 0.0f}.
     */
    public static final int ZERO_BITS = Float.floatToIntBits(0.0f);
    
    /**
     * Displays the bits that represent {@code -0.0f}.
     */
    public static final int NEGATIVE_ZERO_BITS = Float.floatToIntBits(-0.0f);
    
    /**
     * Displays the bit layout that represents positive infinity.
     */
    public static final int POSITIVE_INFINITY_BITS = Float.floatToIntBits(Float.POSITIVE_INFINITY);
    
    /**
     * Displays the bit layout that represents negative infinity.
     */
    public static final int NEGATIVE_INFINITY_BITS = Float.floatToIntBits(Float.NEGATIVE_INFINITY);
    
    /**
     * Amount of bits that represent the sign of a {@code float}.
     */
    public static final int SIGN_LENGTH = 1;
    
    /**
     * Amount of bits that represent the exponent of a {@code float}.
     */
    public static final int EXPONENT_LENGTH = 8;
    
    /**
     * Amount of bits that represent the mantissa of a {@code float}. Also used for bit shifting to reach the exponent
     * section of a number.
     */
    public static final int MANTISSA_LENGTH = 23;
    
    /**
     * Mask for {@code float}'s sign bit. To be used in conjunction with {@link Float#floatToIntBits(float)}.
     */
    public static final int SIGN_MASK = 1 << (Float.SIZE - 1);
    
    /**
     * Mask for {@code float}'s mantissa bits. There are 23 bits that represent the mantissa. To be used in conjunction
     * with {@link Float#floatToIntBits(float)}.
     */
    public static final int MANTISSA_MASK = (1 << MANTISSA_LENGTH) - 1;
    
    /**
     * Mask for {@code float}'s exponent bits. There's a total of 8 bits that represent the exponent. To be used in
     * conjunction with {@link Float#floatToIntBits(float)}.
     */
    public static final int EXPONENT_MASK = ((1 << EXPONENT_LENGTH) - 1) << MANTISSA_LENGTH;
    
    /**
     * Smallest exponent that is not zero.
     */
    public static final int TINY_EXPONENT = 1 << MANTISSA_LENGTH;
    
    /**
     * Mask for the {@code float}'s exponent bits that represents the highest exponent for a number without turning
     * into {@link Float#POSITIVE_INFINITY Infinity} nor {@link Float#NaN NaN}. <u><b>Not</b> to be confused</u> with
     * {@link Floats#EXPONENT_MASK}.
     */
    public static final int MAX_EXPONENT_MASK = EXPONENT_MASK - TINY_EXPONENT;
    
    /**
     * Is by how much the exponent is shifted when stored. The exponent is stored as {@code 2048} and shifted down by
     * {@code 1023} to represent both a positive and a negative exponent.
     */
    public static final int EXPONENT_BIAS = Float.MAX_EXPONENT;
    
    /**
     * Exponent that represents the unit ({@code 1.0f}). Intended, but not limited, to be used when masking and
     * retaining only the mantissa ({@link Floats#MANTISSA_MASK}).
     */
    public static final int UNIT_EXPONENT_MASK = (EXPONENT_MASK >>> 1) & EXPONENT_MASK;
    
    /**
     * Represents the biggest exponent (unbiased) that still has decimal precision.
     */
    public static final int LOSS_DECIMAL_PRECISION_EXPONENT = MANTISSA_LENGTH;
    
    /**
     * Upper bound of {@code float} floating-point numbers where they lose all decimal precision. This is due to the
     * fact that the decimal part is stored in {@code 23} bits which means that any number that is more than or equal to
     * 2<sup>23</sup> has no decimal part.
     * <br>
     * Computable as:
     * {@code
     *     Float.intBitsToFloat(LOSS_DECIMAL_PRECISION_MASK)
     * }
     */
    public static final float LOSS_DECIMAL_PRECISION = 0x1.0p23f;
    
    /**
     * Mask that represents the upper bound of {@code float} floating-point numbers where they lose all decimal
     * precision. This is due to the fact that the decimal part is stored in {@code 23} bits which means that any number
     * that is more than or equal to 2<sup>23</sup> has no decimal part.
     */
    public static final int LOSS_DECIMAL_PRECISION_MASK = (EXPONENT_BIAS + LOSS_DECIMAL_PRECISION_EXPONENT) << LOSS_DECIMAL_PRECISION_EXPONENT;
    
    /**
     * Closest floating-point approximation of the square root of the upper limit of {@link Float#MAX_VALUE}.
     * Note that this value squared will not be equal to {@link Float#MAX_VALUE} due to precision loss.
     */
    public static final float SQUARE_ROOT_MAX_VALUE = (float) Math.sqrt(Float.MAX_VALUE);
    
    static {
        assert (SIGN_LENGTH + EXPONENT_LENGTH + MANTISSA_LENGTH == Float.SIZE) : "ERROR WHILE DEFINING SIZES!";
        
        assert Integer.bitCount(SIGN_MASK | EXPONENT_MASK | MANTISSA_MASK) == Float.SIZE
                : "ERROR: bit masks do not cover entire 32-bit range!";
        
        assert (SIGN_MASK     & EXPONENT_MASK) == 0L &&
               (EXPONENT_MASK & MANTISSA_MASK) == 0L &&
               (SIGN_MASK     & MANTISSA_MASK) == 0L  : "ERROR: overlapping mask bits!";
        
        assert (ZERO_BITS)              == 0L                          : "ERROR WHILE DEFINING ZERO";
        assert (NEGATIVE_ZERO_BITS)     == SIGN_MASK                   : "ERROR WHILE DEFINING NEGATIVE ZERO";
        assert (POSITIVE_INFINITY_BITS) == EXPONENT_MASK               : "ERROR WHILE DEFINING POSITIVE INFINITY";
        assert (NEGATIVE_INFINITY_BITS) == (EXPONENT_MASK | SIGN_MASK) : "ERROR WHILE DEFINING POSITIVE INFINITY";
        
        assert LOSS_DECIMAL_PRECISION + 0.5f == LOSS_DECIMAL_PRECISION : "ERROR CHECKING DECIMAL PRECISION LOSS!";
        assert (Float.floatToIntBits(1.0f) & EXPONENT_MASK) == UNIT_EXPONENT_MASK : "MAJOR ERROR OCCURRED!";
    }
    
    /**
     * Creates a String that contains all the bits of a {@code float} starting with '0b'. Underscores are utilized to
     * separate the sign from the exponent and the exponent from the mantissa. For example {@code 1.5f} is transformed
     * into {@code 0b0_01111111_10000000000000000000000}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toBinaryString(final float num) {
        final int BINARY_SHIFT      = 2; // +2 for the '0b'
        final int UNDERSCORE_SHIFT  = 2; // +2 for the underscores
        final int LENGTH            = Integer.SIZE + UNDERSCORE_SHIFT + BINARY_SHIFT;
        final int MAX_INDEX         = LENGTH - 1;
        final int FIRST_UNDERSCORE  = SIGN_LENGTH + BINARY_SHIFT;
        final int SECOND_UNDERSCORE = FIRST_UNDERSCORE + EXPONENT_LENGTH + 1; // +1 for the first underscore shifting
        
        int bits = Float.floatToIntBits(num);
        
        char[] arr = new char[LENGTH];
        arr[0] = '0';
        arr[1] = 'b';
        for (int ii = MAX_INDEX; ii >= BINARY_SHIFT; ii--) {
            if (ii == FIRST_UNDERSCORE || ii == SECOND_UNDERSCORE) arr[ii] = '_';
            else {
                if ((bits & 1L) == 0L) arr[ii] = '0';
                else                   arr[ii] = '1';
                bits >>>= 1;
            }
        }
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the raw bits of a {@code float} starting with '0b'. "Raw" means that the different
     * {@code NaN}s's bits are shown. Underscores are utilized to separate the sign from the exponent and the exponent
     * from the mantissa. For example {@code 1.5f} is transformed into {@code 0b0_01111111_10000000000000000000000}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toRawBinaryString(final float num) {
        final int BINARY_SHIFT      = 2; // +2 for the '0b'
        final int UNDERSCORE_SHIFT  = 2; // +2 for the underscores
        final int LENGTH            = Integer.SIZE + UNDERSCORE_SHIFT + BINARY_SHIFT;
        final int MAX_INDEX         = LENGTH - 1;
        final int FIRST_UNDERSCORE  = SIGN_LENGTH + BINARY_SHIFT;
        final int SECOND_UNDERSCORE = FIRST_UNDERSCORE + EXPONENT_LENGTH + 1; // +1 for the first underscore shifting
        
        int bits = Float.floatToRawIntBits(num);
        
        char[] arr = new char[LENGTH];
        arr[0] = '0';
        arr[1] = 'b';
        for (int ii = MAX_INDEX; ii >= BINARY_SHIFT; ii--) {
            if (ii == FIRST_UNDERSCORE || ii == SECOND_UNDERSCORE) arr[ii] = '_';
            else {
                if ((bits & 1L) == 0L) arr[ii] = '0';
                else                   arr[ii] = '1';
                bits >>>= 1;
            }
        }
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the bits of a {@code float} in hexadecimal starting with '0x'. Underscores are
     * utilized to separate bytes in pairs. For example {@code 1.5f} is transformed into {@code 0x3f_c0_00_00}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the hexadecimal binary representation of {@code num}.
     */
    public static String toBinaryHexString(final float num) {
        final int MAIN_SECTION      = Integer.SIZE / 4; // Divides the bits into groups of four two transform into hexadecimal
        final int HEX_SYMBOL_LENGTH = 2;             // +2 for '0x'
        final int UNDERSCORES       = MAIN_SECTION / 2 - 1;
        final int LENGTH            = MAIN_SECTION + UNDERSCORES + HEX_SYMBOL_LENGTH;
        final int MAX_INDEX         = LENGTH - 1;
        final int MASK              = 15;
        
        final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
                               '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final char[] arr    = new char[LENGTH];
        
        int bits = Float.floatToIntBits(num);
        
        arr[0] = '0';
        arr[1] = 'x';
        for (int ii = MAX_INDEX; ii >= HEX_SYMBOL_LENGTH; ii--) {
            if (ii % 3 == (HEX_SYMBOL_LENGTH + 2) % 3) arr[ii] = '_';
            else {
                int index = bits & MASK;
                arr[ii] = digits[index];
                bits >>>= 4;
            }
        }
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the raw bits of a {@code float} starting with '0x'. "Raw" means that the different
     * {@code NaN}s's bits are shown. Underscores are utilized to separate bytes in pairs. For example {@code 1.5f} is
     * transformed into {@code 0x3f_c0_00_00}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the hexadecimal binary representation of {@code num}.
     */
    public static String toRawBinaryHexString(final float num) {
        final int MAIN_SECTION      = Integer.SIZE / 4; // Divides the bits into groups of four two transform into hexadecimal
        final int HEX_SYMBOL_LENGTH = 2;                // +2 for '0x'
        final int UNDERSCORES       = MAIN_SECTION / 2 - 1;
        final int LENGTH            = MAIN_SECTION + UNDERSCORES + HEX_SYMBOL_LENGTH;
        final int MAX_INDEX         = LENGTH - 1;
        final int MASK              = 15;
        
        final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
                               '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final char[] arr    = new char[LENGTH];
        
        int bits = Float.floatToRawIntBits(num);
        
        arr[0] = '0';
        arr[1] = 'x';
        for (int ii = MAX_INDEX; ii >= HEX_SYMBOL_LENGTH; ii--) {
            if (ii % 3 == (HEX_SYMBOL_LENGTH + 2) % 3) arr[ii] = '_';
            else {
                int index = bits & MASK;
                arr[ii] = digits[index];
                bits >>>= 4;
            }
        }
        return String.valueOf(arr);
    }
}
