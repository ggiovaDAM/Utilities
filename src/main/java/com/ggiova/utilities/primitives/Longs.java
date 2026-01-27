package com.ggiova.utilities.primitives;

/**
 * Utility class for the primitive {@code long}.
 *
 * <p>Contains methods to better read the bits of {@code long}s.
 *
 * @see Long
 */
public final class Longs {
    /**
     * Creates a String that contains the bits of a {@code long} starting with '0b' and ending with 'L'. Underscores
     * are utilized to group bits into bytes. For example {@code 50_948_326L} is transformed into
     * {@code 0b00000000_00000000_00000000_00000000_00000011_00001001_01101000_11100110L}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toBinaryString(long num) {
        final int  BINARY_SHIFT        = 2; // +2 for the '0b'
        final int  UNDERSCORE_POSITION = (BINARY_SHIFT - 1) % 9;
        final int  UNDERSCORE_SHIFT    = 7; // +7 for the underscores
        final int  ENDING_L            = 1; // +1 for the 'L'
        final int  LENGTH              = Long.SIZE + UNDERSCORE_SHIFT + BINARY_SHIFT + ENDING_L;
        final int  MAX_INDEX           = LENGTH - 1 - ENDING_L;
        final long MASK                = 1L;
        
        char[] arr = new char[LENGTH];
        arr[         0] = '0';
        arr[         1] = 'b';
        arr[LENGTH - 1] = 'L';
        for (int ii = MAX_INDEX; ii >= BINARY_SHIFT; ii--) {
            if (ii % 9 == UNDERSCORE_POSITION) arr[ii] = '_';
            else {
                if ((num & MASK) == 0L) arr[ii] = '0';
                else                    arr[ii] = '1';
                num >>>= 1;
            }
        }
        
        return String.valueOf(arr);
    }
    
    /**
     * Creates a String that contains the bits of a {@code long} in hexadecimal starting with '0x' and ending with 'L'.
     * Underscores are utilized to separate bytes. For example {@code 50_948_326L} is transformed into
     * {@code 0x00_00_00_00_03_09_68_e6L}.
     *
     * @param num Number whose bits will be formatted.
     * @return A String of the binary representation of {@code num}.
     */
    public static String toBinaryHexString(long num) {
        final int  HEX_SYMBOL_LENGTH   = 2;                // +2 for '0x'
        final int  UNDERSCORE_POSITION = (HEX_SYMBOL_LENGTH + 2) % 3;
        final int  MAIN_SECTION        = Long.SIZE / 4;    // Divides the bits into groups of four two transform into hexadecimal
        final int  UNDERSCORES         = MAIN_SECTION / 2 - 1;
        final int  ENDING_L            = 1;                // +1 for the 'L'
        final int  LENGTH              = MAIN_SECTION + UNDERSCORES + HEX_SYMBOL_LENGTH + ENDING_L;
        final int  MAX_INDEX           = LENGTH - 1 - ENDING_L;
        final long MASK                = 15L;
        
        final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
                               '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final char[] arr    = new char[LENGTH];
        
        arr[         0] = '0';
        arr[         1] = 'x';
        arr[LENGTH - 1] = 'L';
        for (int ii = MAX_INDEX; ii >= HEX_SYMBOL_LENGTH; ii--) {
            if (ii % 3 == UNDERSCORE_POSITION) arr[ii] = '_';
            else {
                int index = (int) (num & MASK);
                arr[ii] = digits[index];
                num >>>= 4;
            }
        }
        return String.valueOf(arr);
    }
}

