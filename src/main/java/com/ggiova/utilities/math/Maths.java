package com.ggiova.utilities.math;

import com.ggiova.utilities.primitives.Doubles;
import com.ggiova.utilities.primitives.Floats;

import java.math.BigInteger;

/**
 * Utility class providing mathematical operations and predicates for primitive types.
 * <br>
 * This class offers functionality that extends beyond the standard {@link Math} class, with a focus on bit-level
 * operations, floating-point precision handling, and numeric type classification.
 * <br>
 * All methods in this class are static and the class cannot be instantiated.
 *
 * @see Math
 * @see com.ggiova.utilities.primitives.Doubles
 * @see com.ggiova.utilities.primitives.Floats
 */
public final class Maths {
    /**
     * Constructor. Do <u><b>NOT</b></u> use.
     *
     * @throws UnsupportedOperationException If the constructor is used.
     */
    private Maths() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
    
    /**
     * BigInteger constant of {@code -1}.
     */
    public static final BigInteger BIG_INTEGER_MINUS_ONE = BigInteger.valueOf(-1L);
    
    // -------------------------------------- CONSTANTS ----------------------------------------------------------------
    
    /**
     * Closest floating-point number that approximates &pi; (pi). &pi; is the ratio between a disk's circumference to
     * its diameter.
     *
     * <p>&pi; &asymp; 3.141592653589793238462643383279502884
     *
     * @see <a href="https://en.wikipedia.org/wiki/Pi" target="_blank">Wikipedia on Pi</a>
     * @see <a href="https://oeis.org/A000796" target="_blank">OEIS (A000796)</a>
     * @see Math#PI
     */
    public static final double PI = Math.PI;
    
    /**
     * Closest floating-point number that approximates &tau; (tau). &tau; is the ratio between a disk's circumference to
     * its radius. Equal to 2&pi;.
     *
     * <p>&tau; = 2&pi; &asymp; 6.283185307179586476925286766559005768
     *
     * @see <a href="https://oeis.org/A019692" target="_blank">OEIS (A019692)</a>
     * @see Math#TAU
     */
    public static final double TAU = Math.TAU;
    
    /**
     * Closes floating-point number that approximates half of &pi;. It is the ratio between the semi-circumference of a
     * disk to its diameter.
     *
     * <p>&pi;/2 &asymp; 1.570796326794896619231321691639751442
     *
     * @see <a href="https://oeis.org/A019669" target="_blank">OEIS (A019669)</a>
     */
    public static final double PI_HALF = PI / 2.0d;
    
    /**
     * Closest floating-point approximation of a third of &pi;.
     *
     * <p>&pi;/3 &asymp; 1.047197551196597746154214461093167628
     */
    public static final double PI_THIRD = PI / 3.0d;
    
    /**
     * Closest floating-point approximation of a fourth of &pi;.
     *
     * <p>&pi;/4 &asymp; 0.785398163397448309615660845819875721
     *
     * @see <a href="https://oeis.org/A003881" target="_blank">OEIS (A003881)</a>
     */
    public static final double PI_FOURTH = PI / 4.0d;
    
    /**
     * Closest floating-point approximation to &pi; squared.
     *
     * <p>&pi; ^ 2 &asymp; 9.869604401089358618834490999876151135
     *
     * @see <a href="https://oeis.org/A002388" target="_blank">OEIS (A002388)</a>
     */
    public static final double PI_SQUARE = PI * PI;
    
    /**
     * Closest floating-point approximation of the number e. e is the base of natural logarithms, as well as, the limit
     * of (1 + 1/n)^n as n approaches &infin;.
     *
     * <p>e &asymp; 2.718281828459045235360287471352662497
     *
     * @see <a href="https://en.wikipedia.org/wiki/E_(mathematical_constant)" target="_blank">Wikipedia on E</a>
     * @see <a href="https://oeis.org/A001113" target="_blank">OEIS (A001113)</a>
     * @see Math#E
     */
    public static final double E = Math.E;
    
    /**
     * Closest floating-point approximation of the reciprocal of the number e. That is, dividing 1 by e.
     *
     * <p>1/e &asymp; 0.367879441171442321595523770161460867
     *
     * @see <a href="https://oeis.org/A068985" target="_blank">OEIS (A068985)</a>
     */
    public static final double E_RECIPROCAL = 1.0d / E;
    
    /**
     * Closest floating-point approximation to &radic;2 (square root of 2). The square root of 2 is the length of a
     * diagonal across a square with sides of one unit of length.
     *
     * <p>&radic;2 &asymp; 1.414213562373095048801688724209698078
     *
     * @see <a href="https://en.wikipedia.org/wiki/Square_root_of_2" target="_blank">Wikipedia on &radic;2</a>
     * @see <a href="https://oeis.org/A002193" target="_blank">OEIS (A002193)</a>
     */
    public static final double SQUARE_ROOT_TWO = 1.414213562373095048801688724209698078d;
    
    /**
     * Closest floating-point approximation to 1/&radic;2 (reciprocal square root of 2).
     *
     * <p>1 / &radic;2 &asymp; 0.707106781186547524400844362104849039
     *
     * @see <a href="https://oeis.org/A010503" target="_blank">OEIS (A010503)</a>
     */
    public static final double SQUARE_ROOT_TWO_RECIPROCAL = 0.707106781186547524400844362104849039d;
    
    /**
     * Closest floating-point approximation to &radic;3 (square root of 3). The square root of 3 is the height of an
     * equilateral triangle whose sides are of length 2. Also known as Theodorus's constant.
     *
     * <p>&radic;3 &asymp; 1.732050807568877293527446341505872366
     *
     * @see <a href="https://en.wikipedia.org/wiki/Square_root_of_3" target="_blank">Wikipedia on &radic;3</a>
     * @see <a href="https://oeis.org/A002194" target="_blank">OEIS (A002194)</a>
     */
    public static final double SQUARE_ROOT_THREE = 1.732050807568877293527446341505872366d;
    
    /**
     * Closest floating-point approximation to &radic;5 (square root of 5). Equal to the hypotenuse of the rectangle
     * triangle with sides of 1 &amp; 2.
     *
     * <p>&radic;5 &asymp; 2.236067977499789696409173668731276235
     *
     * @see <a href="https://en.wikipedia.org/wiki/Square_root_of_5" target="_blank">Wikipedia on &radic;5</a>
     * @see <a href="https://oeis.org/A002194" target="_blank">OEIS (A002194)</a>
     */
    public static final double SQUARE_ROOT_FIVE = 2.236067977499789696409173668731276235d;
    
    /**
     * Closest floating-point approximation to &radic;6 (square root of 6). Equal to the product of &radic;2 &amp;
     * &radic;3.
     *
     * <p>&radic;6 &asymp; 2.449489742783178098197284074705891391
     *
     * @see <a href="https://en.wikipedia.org/wiki/Square_root_of_6" target="_blank">Wikipedia on &radic;6</a>
     * @see <a href="https://oeis.org/A010464" target="_blank">OEIS (A010464)</a>
     */
    public static final double SQUARE_ROOT_SIX = 2.449489742783178098197284074705891391d;
    
    /**
     * Closest floating-point approximation to &radic;7 (square root of 7).
     *
     * <p>&radic;7 &asymp; 2.645751311064590590501615753639260425
     *
     * @see <a href="https://en.wikipedia.org/wiki/Square_root_of_7" target="_blank">Wikipedia on &radic;7</a>
     * @see <a href="https://oeis.org/A010465" target="_blank">OEIS (A01465)</a>
     */
    public static final double SQUARE_ROOT_SEVEN = 2.645751311064590590501615753639260425d;
    
    /**
     * Closest floating-point approximation of the golden ratio.
     *
     * <p>&phi;=(1 + &radic;5)/2 &approx; 1.61803398874989484820458683436563811772
     *
     * @see <a href="https://oeis.org/A001622" target="_blank">OEIS (A001622)</a>
     */
    public static final double GOLDEN_RATIO = 1.61803398874989484820458683436563811772d;
    
    /**
     * Closest floating-point approximation to &radic;3 / 2 (Half of the square root of 3). Equal to the side opposite
     * to the 60º angle of a 30º-60º-90º-triangle that has the unit length as the hypotenuse.
     *
     * <p>&radic;3  / 2 &asymp; 0.8660254037844386467637231707529361834
     *
     * @see <a href="https://oeis.org/A010527" target="_blank">OEIS (A010527)</a>
     */
    public static final double HALF_SQUARE_ROOT_THREE = SQUARE_ROOT_THREE / 2.0d;
    
    /**
     * Closest floating-point approximation to &radic;&pi; (square root of pi).
     *
     * <p>&radic;&pi; &asymp; 1.77245385090551602729816748334114518279
     *
     * @see <a href="https://oeis.org/A002161">OEIS (A002161)</a>
     */
    public static final double SQUARE_ROOT_PI = 1.77245385090551602729816748334114518279d;
    
    /**
     * Closest floating-point approximation to &radic;&tau; (square root of tau).
     *
     * <p>&radic;&tau; &asymp; 2.50662827463100050241576528481104525300
     *
     * @see <a href="https://oeis.org/A019727" target="_blank">OEIS (A019727)</a>
     */
    public static final double SQUARE_ROOT_TAU = SQUARE_ROOT_PI * SQUARE_ROOT_TWO;
    
    /**
     * Closest floating-point approximation of ln(2) (natural logarithm of 2).
     *
     * <p>ln(2) &asymp; 0.6931471805599453094172321214581765680
     *
     * @see <a href="https://en.wikipedia.org/wiki/Natural_logarithm_of_2" target="_blank">Wikipeida on ln(2)</a>
     * @see <a href="https://oeis.org/A002162" target="_blank">OEIS (A002162)</a>
     */
    public static final double LN2 = 0.6931471805599453094172321214581765680d;
    
    /**
     * Closest floating-point approximation of ln(5) (natural logarithm of 5).
     *
     * <p>ln(5) &asymp; 1.60943791243410037460075933322618763952
     *
     * @see <a href="https://oeis.org/A016628" target="_blank">OEIS (A016628)</a>
     */
    public static final double LN5 = 1.60943791243410037460075933322618763952d;
    
    /**
     * Closest floating-point approximation of ln(10) (natural logarithm of 10).
     *
     * <p>ln(10) &asymp; 2.302585092994045684017991454684364207
     *
     * @see <a href="https://oeis.org/A002392" target="_blank">OEIS (A002392)</a>
     */
    public static final double LN10 = 2.302585092994045684017991454684364207d;
    
    /**
     * Closest floating-point approximation to ln(&tau;)/2.
     *
     * <p>ln(&tau;)/2 = &zeta;'(0) &asymp; 0.91893853320467274178032973640561763986
     *
     * @see <a href="https://oeis.org/A075700" target="_blank">OEIS (A075700)</a>
     */
    public static final double HALF_LN_TAU = 0.91893853320467274178032973640561763986d;
    
    /**
     * Closest floating-point approximation to &gamma; (Euler-Mascheroni constant). It is the difference between the
     * harmonic series and the natural logarithm.
     *
     * <p>&gamma; &asymp; 0.57721566490153286060651209008240243104
     *
     * @see <a href="https://en.wikipedia.org/wiki/Euler%27s_constant" target="_blank">Wikipedia on Eurler-Maschroni
     * constant</a>
     * @see <a href="https://oeis.org/A001620" target="_blank">OEIS (A001620)</a>
     */
    public static final double EULER_MASCHERONI = 0.57721566490153286060651209008240243104d;
    
    /**
     * Closest floating-point approximation to &Omega; also represented as W(1) (Lambert W of 1). This is the solution
     * of <i>&Omega; × e ^ &Omega; = 1 </i>, it is as well, infinite exponentiations of -e, that is
     * <i>W(1) = e ^ -e ^ -e ^ &hellip;</i>.
     *
     * <p>Irrational &amp; Transcendental.
     *
     * <p>&Omega; &asymp; 0.56714329040978387299996866221035554975
     *
     * @see <a href="https://en.wikipedia.org/wiki/Omega_constant" target="_blank">Wikipedia on omega constant</a>
     * @see <a href="https://oeis.org/A030178" target="_blank">OEIS (A030178)</a>
     */
    public static final double OMEGA = 0.56714329040978387299996866221035554975d;
    
    /**
     * Closest floating-point approximation to &zeta;(3) (Apéry's constant). It represents the sum of the reciprocals of
     * the cubes of the natural numbers (excluding 0).
     *
     * <p>Irrational. Unknown if it's transcendental.
     *
     * <p>&zeta;(3) &asymp; 1.20205690315959428539973816151144999076
     *
     * @see <a href="https://en.wikipedia.org/wiki/Apéry's_constant" target="_blank">Wikipedia on Apéry's constant</a>
     * @see <a href="https://oeis.org/A002117" target="_blank">OEIS (A002117)</a>
     */
    public static final double APERY = 1.20205690315959428539973816151144999076d;
    
    // -------------------------------------- WHOLE NUMBER -------------------------------------------------------------
    /**
     * Determines if {@code number} is a whole number. A whole number (Z) is a number in the set {@code N ∪ {0} ∪ -N}
     * or, more simply, any number in the set: {@code {…, -3, -2, -1, 0, 1, 2, 3, …}}.
     *
     * <p>Since {@code float}s have a wide range of number representation, some especial cases pop up:
     * <ul>
     *     <li>If {@code number} is {@link Float#NaN NaN}, returns {@code false}.</li>
     *     <li>If {@code number} is infinite, either {@link Float#POSITIVE_INFINITY positive} or
     *     {@link Float#NEGATIVE_INFINITY negative} it returns {@code false}.</li>
     *     <li>If the absolute value of {@code number} is more than or equal to <i>2<sup>23</sup></i> or
     *     <i>8_388_608.0</i> then it returns {@code true} since, due to loss of precision, all numbers above
     *     it will be whole numbers.</li>
     * </ul>
     * As stated before, all numbers bigger than or equal to <i>2<sup>23</sup></i> will always be whole numbers, this is
     * due to the length of the mantissa. The mantissa of a {@code float} can only store 23 bits, meaning that if a
     * {@code float} stores a number with an {@link Floats#LOSS_DECIMAL_PRECISION exponent (base 2) of 23}, then,
     * the least-significant bit of the mantissa will store the unit bit (a one). This implies that there is no space
     * for decimals.
     *
     * @param number Value that will be checked.
     * @return {@code true} if {@code number} is an integer, {@code false} otherwise.
     * @see <a href="https://en.wikipedia.org/wiki/Integer" target="_blank">Integer Wikipedia Page</a>
     */
    public static boolean isWholeNumber(final float number) {
        // Takes the number's bits removing the sign.
        int unsignedBits = Float.floatToIntBits(number) & ~Floats.SIGN_MASK;
        // If zero, return true.
        if (unsignedBits == 0) return true;
        // If bigger than exponent mask return false. This rules out NaNs and Infinities.
        if (unsignedBits >= Floats.EXPONENT_MASK) return false;
        // If the number is bigger than or equal to LOSS_DECIMAL_PRECISION then it's always a whole number.
        if (unsignedBits >= Floats.LOSS_DECIMAL_PRECISION_MASK) return true;
        // Gets the exponent and removes the bias.
        int exp = (unsignedBits >>> Floats.MANTISSA_LENGTH) - Floats.EXPONENT_BIAS;
        // If the number is smaller than 1, return false.
        if (exp < 0) return false;
        // Mask for the binary decimals (mantissa) to check whether it has more decimals past the limit or not. Also
        // used to check if the number itself is odd or even.
        int mask = 1 << Floats.MANTISSA_LENGTH - exp;
        // If unsignedBits & -mask [simplified from ~(mask - 1)] equals unsignedBits, it means that there are no bits
        // after the unit value.
        // Example 15 & 15.1:
        // 15   --> 0_10000000010_1110000000000000000000000000000000000000000000000000
        // The exponent is 3, so we need to check after the next three bits if there are any one's.
        // In this case there aren't, so 15's bits masked equals 15's bits.
        // 15.1 --> 0_10000000010_1110001100110011001100110011001100110011001100110011
        // The exponent is also 3, so we need to check after the next three bits if there are any one's.
        // There are, so this number is not an integer, because 15.1's bits masked are not equal 15.1's bits.
        return (unsignedBits & -mask) == unsignedBits;
    }
    
    /**
     * Determines if {@code number} is a whole number. A whole number (Z) is a number in the set {@code N ∪ {0} ∪ -N}
     * or, more simply, any number in the set: {@code {…, -3, -2, -1, 0, 1, 2, 3, …}}.
     *
     * <p>Since {@code double}s have a wide range of number representation, some especial cases pop up:
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
        // If zero, return true.
        if (unsignedBits == 0L) return true;
        // If bigger than exponent mask return false. This rules out NaNs and Infinities.
        if (unsignedBits >= Doubles.EXPONENT_MASK) return false;
        // If the number is bigger than or equal to LOSS_DECIMAL_PRECISION then it's always a whole number.
        if (unsignedBits >= Doubles.LOSS_DECIMAL_PRECISION_MASK) return true;
        // Gets the exponent and removes the bias.
        int exp = (int) (unsignedBits >>> Doubles.MANTISSA_LENGTH) - Doubles.EXPONENT_BIAS;
        // If the number is smaller than 1, return false.
        if (exp < 0) return false;
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
        return  (unsignedBits & -mask) == unsignedBits;
    }
    
    // -------------------------------------- EVEN-NESS ----------------------------------------------------------------
    /**
     * Returns {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd. A number is even if
     * it can be expressed as {@code number = 2×k, k ∈ ℤ}.
     *
     * <p>Binary-wise, the least-significant digit indicates if a number is even or odd. So, if it is {@code 0} then
     * it's even and if it is {@code 1} then is odd.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd.
     */
    public static boolean isEven(final int number) {
        // Checks if the least-significant bit is a one or a zero. All even numbers have a zero as their
        // least-significant bit.
        return (number & 0b1) == 0b0;
    }
    
    /**
     * Returns {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd. A number is even if
     * it can be expressed as {@code number = 2×k, k ∈ ℤ}.
     *
     * <p>Binary-wise, the least-significant digit indicates if a number is even or odd. So, if it is {@code 0} then
     * it's even and if it is {@code 1} then is odd.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd.
     */
    public static boolean isEven(final long number) {
        // Checks if the least-significant bit is a one or a zero. All even numbers have a zero as their
        // least-significant bit.
        return (number & 0b1L) == 0b0L;
    }
    
    /**
     * Returns {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd. A number is even if
     * it can be expressed as {@code number = 2×k, k ∈ ℤ}.
     *
     * <p>
     * Since {@code float}s can still represent whole numbers there are a few edge-cases to contemplate:
     * <ul>
     *     <li>If {@code number} is {@link Float#NaN NaN}, returns {@code false}.</li>
     *     <li>If {@code number} is infinite, either {@link Float#POSITIVE_INFINITY positive} or
     *     {@link Float#NEGATIVE_INFINITY negative} it returns {@code false}.</li>
     *     <li>If {@code number} is a decimal number, then it returns {@code false}.</li>
     *     <li>If the absolute value of {@code number} is more than or equal to <i>2<sup>24</sup></i> or
     *     {@code 16_777_216.0} then it returns {@code true} since, due to loss of precision, all numbers above it will
     *     be multiples of two, and therefore, even.</li>
     * </ul>
     * While for {@code int} and {@code long}, a number that is even is not odd and a number that is odd is not even,
     * for {@code float} it does not always happen. Since {@code float} can have {@link Float#NaN NaN}, infinities, and
     * decimals, a number can sometimes be neither even nor odd.
     *
     * <p>
     * As stated before, all numbers bigger than or equal to <i>2<sup>24</sup></i> will always be even, this is due to
     * the length of the mantissa. The mantissa of a {@code float} can only store 23 bits, meaning that if a
     * {@code float} stores a number with an {@link Floats#LOSS_DECIMAL_PRECISION exponent (base 2) of 23}, then, the
     * least-significant bit of the mantissa will store the unit bit (a one). This implies that if a number is twice
     * <i>2<sup>23</sup></i> (exponent of 23+1), then it is always going to be even, since there are no unit bits.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is even &amp; {@code false} otherwise.
     * @see Floats#LOSS_DECIMAL_PRECISION
     */
    public static boolean isEven(final float number) {
        // Takes the number's bits removing the sign.
        int unsignedBits = Float.floatToIntBits(number) & ~Floats.SIGN_MASK;
        // If zero, return true.
        if (unsignedBits == 0) return true;
        // If bigger than exponent mask return false. This rules out NaNs and Infinities.
        if (unsignedBits >= Floats.EXPONENT_MASK) return false;
        // If the number is bigger than 2 * LOSS_DECIMAL_PRECISION then it's always even.
        // Since exponents add, we can use LOSS_DECIMAL_PRECISION_MASK (23) and add TINY_EXPONENT (1)
        if (unsignedBits >= Floats.LOSS_DECIMAL_PRECISION_MASK + Floats.TINY_EXPONENT) return true;
        // Gets the exponent and removes the bias.
        int exp = (unsignedBits >>> Floats.MANTISSA_LENGTH) - Floats.EXPONENT_BIAS;
        // If the number is smaller than 1, return false.
        if (exp < 0) return false;
        // Mask for the binary decimals (mantissa) to check whether it has more decimals past the limit or not. Also
        // used to check if the number itself is odd or even.
        int mask = 1 << Floats.MANTISSA_LENGTH - exp;
        // If unsignedBits & -mask [simplified from ~(mask - 1)] equals unsignedBits, it means that there are no bits
        // after the unit value.
        // Example 15 & 15.1:
        // 15   --> 0_10000010_11100000000000000000000
        // The exponent is 3, so we need to check after the next three bits if there are any one's.
        // In this case there aren't, so 15's bits masked are equals 15's bits.
        // 15.1 --> 0_10000010_11100011001100110011010
        // The exponent is also 3, so we need to check after the next three bits if there are any one's.
        // There are, so this number is not an integer, because 15.1's bits masked are not equal 15.1's bits.
        if ((unsignedBits & -mask) != unsignedBits) return false;
        // If the bit in the mantissa is 0, then it is even.
        // Example 15 & 14:
        // 15   --> 0_10000010_11100000000000000000000
        // The exponent is 3, so we need to check the third bit.
        // It is a one (1), so 15 is odd.
        // 14   --> 0_10000010_11000000000000000000000
        // The exponent is also 3, so we need to check the third bit.
        // It is a zero (0), so 14 is even.
        // PS: This test unsets all the bits before where the exponent aims, maintaining only the one bit it is
        // checking.
        return (unsignedBits & mask) == 0;
    }
    
    /**
     * Returns {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd. A number is even if
     * it can be expressed as {@code number = 2×k, k ∈ ℤ}.
     *
     * <p>Since {@code double}s can still represent whole numbers there are a few edge-cases to contemplate:
     * <ul>
     *     <li>If {@code number} is {@link Double#NaN NaN}, returns {@code false}.</li>
     *     <li>If {@code number} is infinite, either {@link Double#POSITIVE_INFINITY positive} or
     *     {@link Double#NEGATIVE_INFINITY negative} it returns {@code false}.</li>
     *     <li>If {@code number} is a decimal number, then it returns {@code false}.</li>
     *     <li>If the absolute value of {@code number} is more than or equal to <i>2<sup>53</sup></i> or
     *     {@code 9_007_199_254_740_992.0} then it returns {@code true} since, due to loss of precision, all numbers
     *     above it will be multiples of two, and therefore, even.</li>
     * </ul>
     * While for {@code int} and {@code long}, a number that is even is not odd and a number that is odd is
     * not even, for {@code double} it does not always happen. Since {@code double} can have {@link Double#NaN NaN},
     * infinities, and decimals, a number can sometimes be neither even nor odd.
     *
     * <p>As stated before, all numbers bigger than or equal to <i>2<sup>53</sup></i> will always be even, this is due
     * to the length of the mantissa. The mantissa of a {@code double} can only store 52 bits, meaning that if a
     * {@code double} stores a number with an
     * {@link Doubles#LOSS_DECIMAL_PRECISION exponent (base 2) of 52}, then, the least-significant bit of
     * the mantissa will store the unit bit (a one). This implies that if a number is twice <i>2<sup>52</sup></i>
     * (exponent of 52+1), then it is always going to be even, since there are no unit bits.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is even &amp; {@code false} otherwise.
     * @see Doubles#LOSS_DECIMAL_PRECISION
     */
    public static boolean isEven(final double number) {
        // Takes the number's bits removing the sign.
        long unsignedBits = Double.doubleToLongBits(number) & ~Doubles.SIGN_MASK;
        // If zero, return true.
        if (unsignedBits == 0L) return true;
        // If bigger than exponent mask return false. This rules out NaNs and Infinities.
        if (unsignedBits >= Doubles.EXPONENT_MASK) return false;
        // If the number is bigger than 2 * LOSS_DECIMAL_PRECISION then it's always even.
        // Since exponents add, we can use LOSS_DECIMAL_PRECISION_MASK (52) and add TINY_EXPONENT (1)
        if (unsignedBits >= Doubles.LOSS_DECIMAL_PRECISION_MASK + Doubles.TINY_EXPONENT) return true;
        // Gets the exponent and removes the bias.
        int exp = (int) (unsignedBits >>> Doubles.MANTISSA_LENGTH) - Doubles.EXPONENT_BIAS;
        // If the number is smaller than 1, return false.
        if (exp < 0) return false;
        // Mask for the binary decimals (mantissa) to check whether it has more decimals past the limit or not. Also
        // used to check if the number itself is odd or even.
        long mask = 1L << Doubles.MANTISSA_LENGTH - exp;
        // If unsignedBits & -mask [simplified from ~(mask - 1)] equals unsignedBits, it means that there are no bits
        // after the unit value.
        // Example 15 & 15.1:
        // 15   --> 0b0_10000000010_1110000000000000000000000000000000000000000000000000L
        // The exponent is 3, so we need to check after the next three bits if there are any one's.
        // In this case there aren't, so 15's bits masked are equals 15's bits.
        // 15.1 --> 0b0_10000000010_1110001100110011001100110011001100110011001100110011L
        // The exponent is also 3, so we need to check after the next three bits if there are any one's.
        // There are, so this number is not an integer, because 15.1's bits masked are not equal 15.1's bits.
        if ((unsignedBits & -mask) != unsignedBits) return false;
        // If the bit in the mantissa is 0, then it is even.
        // Example 15 & 14:
        // 15   --> 0b0_10000000010_1110000000000000000000000000000000000000000000000000L
        // The exponent is 3, so we need to check the third bit.
        // It is a one (1), so 15 is odd.
        // 14   --> 0b0_10000000010_1100000000000000000000000000000000000000000000000000L
        // The exponent is also 3, so we need to check the third bit.
        // It is a zero (0), so 14 is even.
        // PS: This test unsets all the bits before where the exponent aims, maintaining only the one bit it is
        // checking.
        return  (unsignedBits & mask) == 0L;
    }
    
    /**
     * Returns {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd. A number is even if
     * it can be expressed as {@code number = 2×k, k ∈ ℤ}.
     *
     * <p>If {@code number} is {@code null} then it returns {@code false}.
     *
     * <p>Binary-wise, the least-significant digit indicates if a number is even or odd. So, if it is {@code 0} then
     * it's even and if it is {@code 1} then is odd.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is even &amp; {@code false} if {@code number} is odd.
     * @see BigInteger
     */
    public static boolean isEven(final BigInteger number) {
        if (number == null) return false;
        // Checks if the least-significant bit is a one or a zero. All even numbers have a zero as their
        // least-significant bit.
        return number.mod(BigInteger.TWO).equals(BigInteger.ZERO);
    }
    
    // -------------------------------------- ODD-NESS -----------------------------------------------------------------
    /**
     * Returns {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even. A number is odd if
     * it can be expressed as {@code number = 2×k+1, k ∈ ℤ}.
     *
     * <p>Binary-wise, the least-significant digit indicates if a number is even or odd. So, if it is {@code 0} then
     * it's even and if it is {@code 1} then is odd.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even.
     */
    public static boolean isOdd(final int number) {
        // Checks if the least-significant bit is a one or a one. All odd numbers have a one as their least-significant
        // bit.
        return (number & 0b1) == 0b1;
    }
    
    /**
     * Returns {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even. A number is odd if
     * it can be expressed as {@code number = 2×k+1, k ∈ ℤ}.
     *
     * <p>Binary-wise, the least-significant digit indicates if a number is even or odd. So, if it is {@code 0} then
     * it's even and if it is {@code 1} then is odd.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even.
     */
    public static boolean isOdd(final long number) {
        // Checks if the least-significant bit is a one or a one. All odd numbers have a one as their least-significant
        // bit.
        return (number & 0b1L) == 0b1L;
    }
    
    /**
     * Returns {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even. A number is odd if
     * it can be expressed as {@code number = 2×k+1, k ∈ ℤ}.
     *
     * <p>
     * Since {@code float}s can still represent whole numbers there are a few edge-cases to contemplate:
     * <ul>
     *     <li>If {@code number} is {@link Float#NaN NaN}, returns {@code false}.</li>
     *     <li>If {@code number} is infinite, either {@link Float#POSITIVE_INFINITY positive} or
     *     {@link Float#NEGATIVE_INFINITY negative} it returns {@code false}.</li>
     *     <li>If {@code number} is a decimal number, then it returns {@code false}.</li>
     *     <li>If the absolute value of {@code number} is more than or equal to <i>2<sup>24</sup></i> or
     *     {@code 16_777_216.0} then it returns {@code false} since, due to loss of precision, all numbers above it will
     *     be multiples of two, and therefore, not odd.</li>
     * </ul>
     * While for {@code int} and {@code long}, a number that is even is not odd and a number that is odd is not even,
     * for {@code float} it does not always happen. Since {@code float} can have {@link Float#NaN NaN}, infinities, and
     * decimals, a number can sometimes be neither even nor odd.
     *
     * <p>
     * As stated before, all numbers bigger than or equal to <i>2<sup>24</sup></i> will always be even, this is due to
     * the length of the mantissa. The mantissa of a {@code float} can only store 23 bits, meaning that if a
     * {@code float} stores a number with an {@link Floats#LOSS_DECIMAL_PRECISION exponent (base 2) of 23}, then, the
     * least-significant bit of the mantissa will store the unit bit (a one). This implies that if a number is twice
     * <i>2<sup>23</sup></i> (exponent of 23+1), then it is always going to be even, since there are no unit bits.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is odd &amp; {@code false} otherwise.
     * @see Floats#LOSS_DECIMAL_PRECISION
     */
    public static boolean isOdd(final float number) {
        // Takes the number's bits removing the sign.
        int unsignedBits = Float.floatToIntBits(number) & ~Floats.SIGN_MASK;
        // If zero, return false is not needed.
        // if (unsignedBits == 0) return false;
        // If bigger than exponent mask return false. This rules out NaNs and Infinities.
        if (unsignedBits >= Floats.EXPONENT_MASK) return false;
        // If the number is bigger than 2 * LOSS_DECIMAL_PRECISION then it's always even.
        // Since exponents add, we can use LOSS_DECIMAL_PRECISION_MASK (23) and add TINY_EXPONENT (1)
        if (unsignedBits >= Floats.LOSS_DECIMAL_PRECISION_MASK + Floats.TINY_EXPONENT) return false;
        // Gets the exponent and removes the bias.
        int exp = (unsignedBits >>> Floats.MANTISSA_LENGTH) - Floats.EXPONENT_BIAS;
        // If the number is smaller than 1, return false.
        if (exp < 0) return false;
        // Mask for the binary decimals (mantissa) to check whether it has more decimals past the limit or not. Also
        // used to check if the number itself is odd or even.
        int mask = 1 << Floats.MANTISSA_LENGTH - exp;
        // If unsignedBits & -mask [simplified from ~(mask - 1)] equals unsignedBits, it means that there are no bits
        // after the unit value.
        // Example 15 & 15.1:
        // 15   --> 0_10000010_11100000000000000000000
        // The exponent is 3, so we need to check after the next three bits if there are any one's.
        // In this case there aren't, so 15's bits masked are equals 15's bits.
        // 15.1 --> 0_10000010_11100011001100110011010
        // The exponent is also 3, so we need to check after the next three bits if there are any one's.
        // There are, so this number is not an integer, because 15.1's bits masked are not equal 15.1's bits.
        if ((unsignedBits & -mask) != unsignedBits) return false;
        // If the bit in the mantissa is 0, then it is even.
        // Example 15 & 14:
        // 15   --> 0_10000010_11100000000000000000000
        // The exponent is 3, so we need to check the third bit.
        // It is a one (1), so 15 is odd.
        // 14   --> 0_10000010_11000000000000000000000
        // The exponent is also 3, so we need to check the third bit.
        // It is a zero (0), so 14 is even.
        // PS: This test unsets all the bits before where the exponent aims, maintaining only the one bit it is
        // checking.
        return (unsignedBits & mask) != 0;
    }
    
    /**
     * Returns {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even. A number is odd if
     * it can be expressed as {@code number = 2×k+1, k ∈ ℤ}.
     *
     * <p>Since {@code double}s can still represent whole numbers there are a few edge-cases to contemplate:
     * <ul>
     *     <li>If {@code number} is {@link Double#NaN NaN}, returns {@code false}.</li>
     *     <li>If {@code number} is infinite, either {@link Double#POSITIVE_INFINITY positive} or
     *     {@link Double#NEGATIVE_INFINITY negative} it returns {@code false}.</li>
     *     <li>If {@code number} is a decimal number, then it returns {@code false}.</li>
     *     <li>If the absolute value of {@code number} is more than or equal to <i>2<sup>53</sup></i> or
     *     {@code 9_007_199_254_740_992.0} then it returns {@code false} since, due to loss of precision, all numbers
     *     above it will be multiples of two, and therefore, not odd.</li>
     * </ul>
     * While for {@code int} and {@code long}, a number that is even is not odd and a number that is odd is
     * not even, for {@code double} it does not always happen. Since {@code double} can have {@link Double#NaN NaN},
     * infinities, and decimals, a number can sometimes be neither even nor odd.
     *
     * <p>As stated before, all numbers bigger than or equal to <i>2<sup>53</sup></i> will always be even, this is due
     * to the length of the mantissa. The mantissa of a {@code double} can only store 52 bits, meaning that if a
     * {@code double} stores a number with an
     * {@link Doubles#LOSS_DECIMAL_PRECISION exponent (base 2) of 52}, then, the least-significant bit of
     * the mantissa will store the unit bit (a one). This implies that if a number is twice <i>2<sup>52</sup></i>
     * (exponent of 52+1), then it is always going to be even, since there are no unit bits.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is odd &amp; {@code false} otherwise.
     * @see Doubles#LOSS_DECIMAL_PRECISION
     */
    public static boolean isOdd(final double number) {
        // Takes the number's bits removing the sign.
        long unsignedBits = Double.doubleToLongBits(number) & ~Doubles.SIGN_MASK;
        // If zero, return true is not needed.
        // if (unsignedBits == 0L) return true;
        // If bigger than exponent mask return false. This rules out NaNs and Infinities.
        if (unsignedBits >= Doubles.EXPONENT_MASK) return false;
        // If the number is bigger than 2 * LOSS_DECIMAL_PRECISION then it's always even.
        // Since exponents add, we can use LOSS_DECIMAL_PRECISION_MASK (52) and add TINY_EXPONENT (1)
        if (unsignedBits >= Doubles.LOSS_DECIMAL_PRECISION_MASK + Doubles.TINY_EXPONENT) return false;
        // Gets the exponent and removes the bias.
        int exp = (int) (unsignedBits >>> Doubles.MANTISSA_LENGTH) - Doubles.EXPONENT_BIAS;
        // If the number is smaller than 1, return false.
        if (exp < 0) return false;
        // Mask for the binary decimals (mantissa) to check whether it has more decimals past the limit or not. Also
        // used to check if the number itself is odd or even.
        long mask = 1L << Doubles.MANTISSA_LENGTH - exp;
        // If unsignedBits & -mask [simplified from ~(mask - 1)] equals unsignedBits, it means that there are no bits
        // after the unit value.
        // Example 15 & 15.1:
        // 15   --> 0b0_10000000010_1110000000000000000000000000000000000000000000000000L
        // The exponent is 3, so we need to check after the next three bits if there are any one's.
        // In this case there aren't, so 15's bits masked are equals 15's bits.
        // 15.1 --> 0b0_10000000010_1110001100110011001100110011001100110011001100110011L
        // The exponent is also 3, so we need to check after the next three bits if there are any one's.
        // There are, so this number is not an integer, because 15.1's bits masked are not equal 15.1's bits.
        if ((unsignedBits & -mask) != unsignedBits) return false;
        // If the bit in the mantissa is 0, then it is even.
        // Example 15 & 14:
        // 15   --> 0b0_10000000010_1110000000000000000000000000000000000000000000000000L
        // The exponent is 3, so we need to check the third bit.
        // It is a one (1), so 15 is odd.
        // 14   --> 0b0_10000000010_1100000000000000000000000000000000000000000000000000L
        // The exponent is also 3, so we need to check the third bit.
        // It is a zero (0), so 14 is even.
        // PS: This test unsets all the bits before where the exponent aims, maintaining only the one bit it is
        // checking.
        return (unsignedBits & mask) != 0L;
    }
    
    /**
     * Returns {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even. A number is odd if
     * it can be expressed as {@code number = 2×k+1, k ∈ ℤ}.
     *
     * <p>If {@code number} is {@code null} then it returns {@code false}.
     *
     * <p>Binary-wise, the least-significant digit indicates if a number is even or odd. So, if it is {@code 0} then
     * it's even and if it is {@code 1} then is odd.
     *
     * @param number Number that will be checked.
     * @return {@code true} if {@code number} is odd &amp; {@code false} if {@code number} is even.
     * @see BigInteger
     */
    public static boolean isOdd(final BigInteger number) {
        if (number == null) return false;
        // Checks if the least-significant bit is a one or a zero. All even numbers have a zero as their
        // least-significant bit.
        return number.mod(BigInteger.TWO).equals(BigInteger.ONE);
    }
    
    //  ---------------------------------- MINUS ONE POW ---------------------------------------------------------------
    /**
     * Calculates the {@code n}th power of {@code -1}. If {@code n} is even then it returns {@code 1} and if it is odd,
     * it returns {@code -1}.
     *
     * @param n Power of {@code -1}.
     * @return The {@code n}th power of {@code -1}.
     * @see Maths#isEven(int)
     */
    public static int minusOnePow(final int n) {
        return isEven(n) ? 1 : -1;
    }
    
    /**
     * Calculates the {@code n}th power of {@code -1}. If {@code n} is even then it returns {@code 1} and if it is odd,
     * it returns {@code -1}.
     *
     * @param n Power of {@code -1}.
     * @return The {@code n}th power of {@code -1}.
     * @see Maths#isEven(long)
     */
    public static long minusOnePow(final long n) {
        return isEven(n) ? 1L : -1L;
    }
    
    /**
     * Calculates the {@code n}th the power of {@code -1.0f}. Since the exponent can have a myriad of possible values,
     * some cases need to be addressed:
     * <ul>
     *     <li>If {@code n} is {@link Float#NaN NaN} or infinite, either {@link Float#POSITIVE_INFINITY positive} or
     *     {@link Float#NEGATIVE_INFINITY negative}, the result will be {@link Float#NaN NaN}.</li>
     *     <li>If the absolute value of {@code n} is greater than or equal to <u>twice
     *     {@link Floats#LOSS_DECIMAL_PRECISION}</u>, then the result will be {@code 1.0f} since all those numbers are
     *     even.</li>
     *     <li>If {@code n} has a decimal part, then, the result will be {@link Float#NaN NaN}.</li>
     * </ul>
     * Otherwise, if the number is even, it returns {@code 1.0f}, if it's odd, it returns {@code -1.0f}.
     *
     * @param n Power of {@code -1.0f}.
     * @return The {@code n}th power of {@code -1.0f}.
     * @see Maths#isEven(float)
     */
    public static float minusOnePow(final float n) {
        if (isWholeNumber(n)) {
            return isEven(n) ? 1.0f : -1.0f;
        }
        return Float.NaN;
    }
    
    /**
     * Calculates the {@code n}th the power of {@code -1.0d}. Since the exponent can have a myriad of possible values,
     * some cases need to be addressed:
     * <ul>
     *     <li>If {@code n} is {@link Double#NaN NaN} or infinite, either {@link Double#POSITIVE_INFINITY positive} or
     *     {@link Double#NEGATIVE_INFINITY negative}, the result will be {@link Double#NaN NaN}.</li>
     *     <li>If the absolute value of {@code n} is greater than or equal to twice
     *     {@link Doubles#LOSS_DECIMAL_PRECISION}, then the result will be {@code 1.0d} since all those numbers are
     *     even.</li>
     *     <li>If {@code n} has a decimal part, then, the result will be {@link Double#NaN NaN}.</li>
     * </ul>
     * Otherwise, if the number is even, it returns {@code 1.0d}, if it's odd, it returns {@code -1.0d}.
     *
     * @param n Power of {@code -1.0d}.
     * @return The {@code n}th power of {@code -1.0d}.
     * @see Maths#isEven(double)
     */
    public static double minusOnePow(final double n) {
        if (isWholeNumber(n)) {
            return isEven(n) ? 1.0d : -1.0d;
        }
        return Double.NaN;
    }
    
    /**
     * Calculates the {@code n}th power of {@code -1}. If {@code n} is even then it returns {@code 1} and if it is odd,
     * it returns {@code -1}.
     *
     * <p>If {@code n} is {@code null}, then it returns {@code null}.
     *
     * @param n Power of {@code -1}.
     * @return The {@code n}th power of {@code -1}.
     * @see BigInteger
     * @see Maths#BIG_INTEGER_MINUS_ONE
     */
    public static BigInteger minusOnePow(final BigInteger n) {
        if (n == null) return null;
        return isEven(n) ? BigInteger.ONE : BIG_INTEGER_MINUS_ONE;
    }
    
    //  ----------------------------------- FRACTIONS ------------------------------------------------------------------
    /**
     * Calculates the
     * <a href="https://en.wikipedia.org/wiki/Least_common_multiple" target="_blank">least common multiple</a> of
     * {@code a} &amp; {@code b}. That is, the smallest positive integer that is divisible by both {@code a} &amp;
     * {@code b}. If either {@code a} or {@code b} are equal to {@code 0}, then the resulting number is {@code 0}.
     *
     * <p>All the results will be bound by: {@code [0; 2_147_483_647]}
     *
     * @param a First parameter.
     * @param b Second Parameter.
     * @return The least common multiple of {@code a} &amp; {@code b}.
     * @throws ArithmeticException If the result overflows into the negatives.
     * @see <a href="https://en.wikipedia.org/wiki/Least_common_multiple" target="_blank">Least Common Multiple</a>
     */
    public static int lcm(final int a, final int b) throws ArithmeticException {
        if (a == 0 || b == 0) return 0;
        int aAbs = Math.abs(a);
        int bAbs = Math.abs(b);
        if (aAbs        == bAbs) return aAbs;
        if (aAbs % bAbs ==    0) return aAbs;
        if (bAbs % aAbs ==    0) return bAbs;
        int result = aAbs * bAbs / gcdLoop(aAbs, bAbs);
        if (result < 1)
            throw new ArithmeticException("LCM overflow");
        return result;
    }
    
    /**
     * Calculates the
     * <a href="https://en.wikipedia.org/wiki/Least_common_multiple" target="_blank">least common multiple</a> of
     * {@code a} &amp; {@code b}. That is, the smallest positive integer that is divisible by both {@code a} &amp;
     * {@code b}. If either {@code a} or {@code b} are equal to {@code 0}, then the resulting number is {@code 0}.
     *
     * <p>All the results will be bound by: {@code [0; 9_223_372_036_854_775_807L]}
     *
     * @param a First parameter.
     * @param b Second Parameter.
     * @return The least common multiple of {@code a} &amp; {@code b}.
     * @throws ArithmeticException If the result overflows into the negatives.
     * @see <a href="https://en.wikipedia.org/wiki/Least_common_multiple" target="_blank">Least Common Multiple</a>
     */
    public static long lcm(final long a, final long b) throws ArithmeticException {
        if (a == 0L || b == 0L) return 0L;
        long aAbs = Math.abs(a);
        long bAbs = Math.abs(b);
        if (aAbs        == bAbs) return aAbs;
        if (aAbs % bAbs ==   0L) return aAbs;
        if (bAbs % aAbs ==   0L) return bAbs;
        long result = aAbs * bAbs / gcdLoop(aAbs, bAbs);
        if (result < 1L)
            throw new ArithmeticException("LCM overflow");
        return result;
    }
    
    /**
     * Calculates the
     * <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor" target="_blank">greatest common divisor</a> of
     * {@code a} &amp; {@code b}. That is, the largest positive integer that is divides both of the integers {@code a}
     * &amp; {@code b}. If either {@code a} or {@code b} are equal to {@code 0}, then the resulting number is the other one.
     *
     * <p>All the results will be bound by: {@code [1; 2_147_483_647]}
     *
     * @param a First parameter.
     * @param b Second Parameter.
     * @return The greatest common divisor of {@code a} &amp; {@code b}.
     * @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor" target="_blank">Greatest Common Divisor</a>
     */
    public static int gcd(final int a, final int b) {
        if (a == 0 && b == 0) return 1;
        int aAbs = Math.abs(a);
        int bAbs = Math.abs(b);
        if (aAbs        ==    0) return bAbs;
        if (bAbs        ==    0) return aAbs;
        if (aAbs        == bAbs) return aAbs;
        if (aAbs % bAbs ==    0) return bAbs;
        if (bAbs % aAbs ==    0) return aAbs;
        return gcdLoop(aAbs, bAbs);
    }
    
    /**
     * Calculates the
     * <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor" target="_blank">greatest common divisor</a> of
     * {@code a} &amp; {@code b}. That is, the largest positive integer that is divides both of the integers {@code a}
     * &amp; {@code b}. If either {@code a} or {@code b} are equal to {@code 0}, then the resulting number is the other
     * one.
     *
     * <p>All the results will be bound by: {@code [1; 9_223_372_036_854_775_807L]}
     *
     * @param a First parameter.
     * @param b Second Parameter.
     * @return The greatest common divisor of {@code a} &amp; {@code b}.
     * @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor" target="_blank">Greatest Common Divisor</a>
     */
    public static long gcd(final long a, final long b) {
        if (a == 0L && b == 0L) return 1L;
        long aAbs = Math.abs(a);
        long bAbs = Math.abs(b);
        if (aAbs        ==   0L) return bAbs;
        if (bAbs        ==   0L) return aAbs;
        if (aAbs        == bAbs) return aAbs;
        if (aAbs % bAbs ==   0L) return bAbs;
        if (bAbs % aAbs ==   0L) return aAbs;
        return gcdLoop(aAbs, bAbs);
    }
    
    /**
     * Calculates the greatest common divisor of {@code a} &amp; {@code b} using Euclid's Algorithm.
     *
     * @param a First parameter.
     * @param b Second Parameter.
     * @return The greatest common divisor of {@code a} &amp; {@code b}.
     * @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor#Euclid's_algorithm" target="_blank">Euclid's Algorithm</a>
     */
    private static int gcdLoop(int a, int b) {
        while (a != 0 && b != 0) {
            if (a < b) b = b % a;
            else       a = a % b;
        }
        return a == 0 ? b : a;
    }
    
    /**
     * Calculates the greatest common divisor of {@code a} &amp; {@code b} using Euclid's Algorithm.
     *
     * @param a First parameter.
     * @param b Second Parameter.
     * @return The greatest common divisor of {@code a} &amp; {@code b}.
     * @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor#Euclid's_algorithm" target="_blank">Euclid's Algorithm</a>
     */
    private static long gcdLoop(long a, long b) {
        while (a != 0L && b != 0L) {
            if (a < b) b = b % a;
            else       a = a % b;
        }
        return a == 0L ? b : a;
    }
    
    //  ----------------------------------- SEQUENCES ------------------------------------------------------------------
    //  ----------------------------------- FIBONACCI ------------------------------------------------------------------
    /**
     * Calculates the {@code index}th Fibonacci Number. The Fibonacci sequence is a sequence in which each number is the
     * sum of the two preceding numbers. The common notation is <i><b>F</b><sub>{@code index}</sub></i>. This sequence
     * requires two values to be determined, usually in the indices {@code 0} &amp; {@code 1}. For the Fibonacci
     * sequence, these are: <i><b>F</b><sub>0</sub>=0</i> &amp; <i><b>F</b><sub>1</sub>=1</i>. With this two values, and
     * the recurrence relation implied: (<i><b>F</b><sub>n</sub>=<b>F</b><sub>n-1</sub>+<b>F</b><sub>n-2</sub></i>) all
     * indices can be computed.
     *
     * <p>Furthermore, with the recurrence relation, one can compute negative indices
     * (<i><b>F</b><sub>n</sub>=<b>F</b><sub>n+2</sub>-<b>F</b><sub>n+1</sub></i>), this can be transformed into:
     * <i><b>F</b><sub>-n</sub>=(-1)<sup>n</sup>×<b>F</b><sub>n</sub></i>.
     *
     * <p>Since {@code int}'s {@link Integer#SIZE size is 32 bits}, the biggest index of a Fibonacci number without
     * overflow is {@code 46} equaling {@code 1_836_311_903}, and, in consequence, the negative limit is {@code -46}
     * equaling {@code -1_836_311_903}.
     *
     * @param index Index of the Fibonacci Number.
     * @return The {@code index}th Fibonacci Number.
     * @throws ValueOverflowException if the value exceeds the int range
     * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_sequence" target="_blank">Fibonacci Sequence</a>
     * @see <a href="https://en.wikipedia.org/wiki/Generalizations_of_Fibonacci_numbers" target="_blank">Generalizations
     * of Fibonacci numbers</a>
     */
    public static int fibonacciInt(final int index) {
        return Fibonacci.of(index).toInt();
    }
    
    /**
     * Calculates the {@code index}th Fibonacci Number. The Fibonacci sequence is a sequence in which each number is the
     * sum of the two preceding numbers. The common notation is <i><b>F</b><sub>{@code index}</sub></i>. This sequence
     * requires two values to be determined, usually in the indices {@code 0} &amp; {@code 1}. For the Fibonacci
     * sequence, these are: <i><b>F</b><sub>0</sub>=0</i> &amp; <i><b>F</b><sub>1</sub>=1</i>. With this two values, and
     * the recurrence relation implied: (<i><b>F</b><sub>n</sub>=<b>F</b><sub>n-1</sub>+<b>F</b><sub>n-2</sub></i>) all
     * indices can be computed.
     *
     * <p>Furthermore, with the recurrence relation, one can compute negative indices
     * (<i><b>F</b><sub>n</sub>=<b>F</b><sub>n+2</sub>-<b>F</b><sub>n+1</sub></i>), this can be transformed into:
     * <i><b>F</b><sub>-n</sub>=(-1)<sup>n</sup>×<b>F</b><sub>n</sub></i>.
     *
     * <p>Since {@code long}'s {@link Long#SIZE size is 64 bits}, the biggest index of a Fibonacci number without
     * overflow is {@code 92} equaling {@code 7_540_113_804_746_346_429L}, and, in consequence, the negative limit is
     * {@code -92} equaling {@code -7_540_113_804_746_346_429L}.
     *
     * @param index Index of the Fibonacci Number.
     * @return The {@code index}th Fibonacci Number.
     * @throws ValueOverflowException if the value exceeds the long range
     * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_sequence" target="_blank">Fibonacci Sequence</a>
     * @see <a href="https://en.wikipedia.org/wiki/Generalizations_of_Fibonacci_numbers" target="_blank">Generalizations
     * of Fibonacci numbers</a>
     */
    public static long fibonacciLong(final int index) {
        return Fibonacci.of(index).toLong();
    }
    
    /**
     * Calculates the {@code index}th Fibonacci Number. The Fibonacci sequence is a sequence in which each number is the
     * sum of the two preceding numbers. The common notation is <i><b>F</b><sub>{@code index}</sub></i>. This sequence
     * requires two values to be determined, usually in the indices {@code 0} &amp; {@code 1}. For the Fibonacci
     * sequence, these are: <i><b>F</b><sub>0</sub>=0</i> &amp; <i><b>F</b><sub>1</sub>=1</i>. With this two values, and
     * the recurrence relation implied: (<i><b>F</b><sub>n</sub>=<b>F</b><sub>n-1</sub>+<b>F</b><sub>n-2</sub></i>) all
     * indices can be computed.
     *
     * <p>Furthermore, with the recurrence relation, one can compute negative indices
     * (<i><b>F</b><sub>n</sub>=<b>F</b><sub>n+2</sub>-<b>F</b><sub>n+1</sub></i>), this can be transformed into:
     * <i><b>F</b><sub>-n</sub>=(-1)<sup>n</sup>×<b>F</b><sub>n</sub></i>.
     *
     * <p>If {@code index} is {@code null}, then it returns {@code null}.
     *
     * @param index Index of the Fibonacci Number.
     * @return The {@code index}th Fibonacci Number.
     * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_sequence" target="_blank">Fibonacci Sequence</a>
     * @see <a href="https://en.wikipedia.org/wiki/Generalizations_of_Fibonacci_numbers" target="_blank">Generalizations
     * of Fibonacci numbers</a>
     */
    public static BigInteger fibonacciBigInteger(final int index) {
        return Fibonacci.of(index).toBigInteger();
    }
}
