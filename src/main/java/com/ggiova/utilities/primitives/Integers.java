package com.ggiova.utilities.primitives;

/**
 * Utility class for the primitive {@code int}.
 * <br>
 * Contains methods to better read the bits of {@code int}s.
 *
 * @see Integer
 */
public final class Integers {
    /**
     * Creates a String that contains the bits of an {@code int} starting with '0b'. Underscores are utilized to group
     * bits into bytes. For example {@code 100} is transformed into {@code 0b00000000_00000000_00000000_01100100}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toBinaryString(int num) {
        final int BINARY_SHIFT        = 2; // +2 for the '0b'
        final int UNDERSCORE_POSITION = (BINARY_SHIFT - 1) % 9;
        final int UNDERSCORE_SHIFT    = 3; // +3 for the underscores
        final int LENGTH              = Integer.SIZE + UNDERSCORE_SHIFT + BINARY_SHIFT;
        final int MAX_INDEX           = LENGTH - 1;
        final int MASK                = 1;
        
        char[] arr = new char[LENGTH];
        arr[0] = '0';
        arr[1] = 'b';
        for (int ii = MAX_INDEX; ii >= BINARY_SHIFT; ii--) {
            if (ii % 9 == UNDERSCORE_POSITION) arr[ii] = '_';
            else {
                if ((num & MASK) == 0) arr[ii] = '0';
                else                   arr[ii] = '1';
                num >>>= 1;
            }
        }
        
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the bits of an {@code int} in hexadecimal starting with '0x'. Underscores are
     * utilized to separate bytes. For example {@code 100} is transformed into {@code 0x00_00_00_64}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toBinaryHexString(int num) {
        final int HEX_SYMBOL_LENGTH   = 2;                    // +2 for '0x'
        final int UNDERSCORE_POSITION = (HEX_SYMBOL_LENGTH + 2) % 3;
        final int MAIN_SECTION        = Integer.SIZE / 4;     // Divides the bits into groups of four two transform into hexadecimal
        final int UNDERSCORES         = MAIN_SECTION / 2 - 1;
        final int LENGTH              = MAIN_SECTION + UNDERSCORES + HEX_SYMBOL_LENGTH;
        final int MAX_INDEX           = LENGTH - 1;
        final int MASK                = 15;
        
        final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
                               '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final char[] arr    = new char[LENGTH];
        
        arr[0] = '0';
        arr[1] = 'x';
        for (int ii = MAX_INDEX; ii >= HEX_SYMBOL_LENGTH; ii--) {
            if (ii % 3 == UNDERSCORE_POSITION) arr[ii] = '_';
            else {
                int index = num & MASK;
                arr[ii] = digits[index];
                num >>>= 4;
            }
        }
        return String.valueOf(arr);
    }
}
