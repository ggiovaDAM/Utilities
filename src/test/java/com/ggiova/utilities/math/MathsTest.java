package com.ggiova.utilities.math;

import com.ggiova.utilities.primitives.Doubles;
import com.ggiova.utilities.primitives.Floats;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link Maths}
 */
@Nested
@DisplayName("Maths Tests")
public class MathsTest {
    @Nested
    @DisplayName("Is Whole?")
    class IsWholeTest {
        @Nested
        @DisplayName("Float")
        class FloatTest {
            @Test
            void number_0() {
                final float NUMBER = 0.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_1() {
                final float NUMBER = 1.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_n1() {
                final float NUMBER = -1.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_2() {
                final float NUMBER = 2.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_0_d_5() {
                final float NUMBER = 0.5f;
                assertFalse(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_n0_d_5() {
                final float NUMBER = -0.5f;
                assertFalse(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_1_d_5() {
                final float NUMBER = 1.5f;
                assertFalse(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_4_503_599_627_370_496() {
                assertTrue(Maths.isWholeNumber(Floats.LOSS_DECIMAL_PRECISION));
            }
            
            @Test
            void number_4_503_599_627_370_496_d_5() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION + 0.5f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_2_251_799_813_685_248() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION / 2.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_2_251_799_813_685_248_d_5() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION / 2.0f + 0.5f;
                assertFalse(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_infinity() {
                assertFalse(Maths.isWholeNumber(Float.POSITIVE_INFINITY));
            }
            
            @Test
            void number_negative_infinity() {
                assertFalse(Maths.isWholeNumber(Float.NEGATIVE_INFINITY));
            }
            
            @Test
            void number_nan() {
                assertFalse(Maths.isWholeNumber(Float.NaN));
            }
            
            @Test
            void number_large_negative() {
                final float NUMBER = -1_000_000.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_large_negative_decimal() {
                final float NUMBER = -1_000_000.1f;
                assertFalse(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_small_decimal() {
                final float NUMBER = 0.1f;
                assertFalse(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_very_small_decimal() {
                final float NUMBER = 0.0001f;
                assertFalse(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_negative_zero() {
                final float NUMBER = -0.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
            
            @Test
            void number_just_below_precision_loss() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION - 1.0f;
                assertTrue(Maths.isWholeNumber(NUMBER));
            }
        }
        
        @Nested
        @DisplayName("Double")
        class DoubleTest {
            @Test
            void number_0() {
                assertTrue(Maths.isWholeNumber(0.0d));
            }
            
            @Test
            void number_1() {
                assertTrue(Maths.isWholeNumber(1.0d));
            }
            
            @Test
            void number_n1() {
                assertTrue(Maths.isWholeNumber(-1.0d));
            }
            
            @Test
            void number_2() {
                assertTrue(Maths.isWholeNumber(2.0d));
            }
            
            @Test
            void number_0_d_5() {
                assertFalse(Maths.isWholeNumber(0.5d));
            }
            
            @Test
            void number_n0_d_5() {
                assertFalse(Maths.isWholeNumber(-0.5d));
            }
            
            @Test
            void number_1_d_5() {
                assertFalse(Maths.isWholeNumber(1.5d));
            }
            
            @Test
            void number_4_503_599_627_370_496() {
                assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION));
            }
            
            @Test
            void number_4_503_599_627_370_496_d_5() {
                assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION + 0.5d));
            }
            
            @Test
            void number_2_251_799_813_685_248() {
                assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION / 2.0d));
            }
            
            @Test
            void number_2_251_799_813_685_248_d_5() {
                assertFalse(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION / 2.0d + 0.5d));
            }
            
            @Test
            void number_infinity() {
                assertFalse(Maths.isWholeNumber(Double.POSITIVE_INFINITY));
            }
            
            @Test
            void number_negative_infinity() {
                assertFalse(Maths.isWholeNumber(Double.NEGATIVE_INFINITY));
            }
            
            @Test
            void number_nan() {
                assertFalse(Maths.isWholeNumber(Double.NaN));
            }
            
            @Test
            void number_large_negative() {
                assertTrue(Maths.isWholeNumber(-1_000_000.0d));
            }
            
            @Test
            void number_large_negative_decimal() {
                assertFalse(Maths.isWholeNumber(-1_000_000.1d));
            }
            
            @Test
            void number_small_decimal() {
                assertFalse(Maths.isWholeNumber(0.1d));
            }
            
            @Test
            void number_very_small_decimal() {
                assertFalse(Maths.isWholeNumber(0.0001d));
            }
            
            @Test
            void number_negative_zero() {
                assertTrue(Maths.isWholeNumber(-0.0d));
            }
            
            @Test
            void number_just_below_precision_loss() {
                assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION - 1));
            }
        }
    }
    
    @Nested
    @DisplayName("Is Even?")
    class IsEvenTests {
        @Nested
        @DisplayName("Integer")
        class IntegerTests {
            @Test
            void number_0() {
                assertTrue(Maths.isEven(0));
            }
            
            @Test
            void number_1() {
                assertFalse(Maths.isEven(1));
            }
            
            @Test
            void number_n1() {
                assertFalse(Maths.isEven(-1));
            }
            
            @Test
            void number_2() {
                assertTrue(Maths.isEven(2));
            }
            
            @Test
            void number_n2() {
                assertTrue(Maths.isEven(-2));
            }
            
            @Test
            void number_1_000_000() {
                assertTrue(Maths.isEven(1_000_000));
            }
            
            @Test
            void number_1_000_001() {
                assertFalse(Maths.isEven(1_000_001));
            }
            
            @Test
            void number_max_value() {
                assertFalse(Maths.isEven(Integer.MAX_VALUE));
            }
            
            @Test
            void number_min_value() {
                assertTrue(Maths.isEven(Integer.MIN_VALUE));
            }
        }
        
        @Nested
        @DisplayName("Long")
        class LongTests {
            @Test
            void number_0() {
                assertTrue(Maths.isEven(0L));
            }
            
            @Test
            void number_1() {
                assertFalse(Maths.isEven(1L));
            }
            
            @Test
            void number_n1() {
                assertFalse(Maths.isEven(-1L));
            }
            
            @Test
            void number_2() {
                assertTrue(Maths.isEven(2L));
            }
            
            @Test
            void number_n2() {
                assertTrue(Maths.isEven(-2L));
            }
            
            @Test
            void number_1_000_000() {
                assertTrue(Maths.isEven(1_000_000L));
            }
            
            @Test
            void number_1_000_001() {
                assertFalse(Maths.isEven(1_000_001L));
            }
            
            @Test
            void number_max_value() {
                assertFalse(Maths.isEven(Long.MAX_VALUE));
            }
            
            @Test
            void number_min_value() {
                assertTrue(Maths.isEven(Long.MIN_VALUE));
            }
        }
        
        @Nested
        @DisplayName("Float")
        class FloatTests {
            @Test
            void number_0() {
                final float NUMBER = 0.0f;
                assertTrue(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_n0() {
                final float NUMBER = -0.0f;
                assertTrue(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_1() {
                final float NUMBER = 1.0f;
                assertFalse(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_n1() {
                final float NUMBER = -1.0f;
                assertFalse(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_2() {
                final float NUMBER = 2.0f;
                assertTrue(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_n2() {
                final float NUMBER = -2.0f;
                assertTrue(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_0_d_5() {
                final float NUMBER = 0.5f;
                assertFalse(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_n0_d_5() {
                final float NUMBER = -0.5f;
                assertFalse(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_4_503_599_627_370_496() {
                assertTrue(Maths.isEven(Floats.LOSS_DECIMAL_PRECISION));
            }
            
            @Test
            void number_4_503_599_627_370_497() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION + 1.0f;
                assertFalse(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_9_007_199_254_740_992() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION * 2;
                assertTrue(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_9_007_199_254_740_993() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION * 2 + 1;
                assertTrue(Maths.isEven(NUMBER));
            }
            
            @Test
            void number_positive_infinity() {
                assertFalse(Maths.isEven(Float.POSITIVE_INFINITY));
            }
            
            @Test
            void number_negative_infinity() {
                assertFalse(Maths.isEven(Float.NEGATIVE_INFINITY));
            }
            
            @Test
            void number_nan() {
                assertFalse(Maths.isEven(Float.NaN));
            }
        }
        
        @Nested
        @DisplayName("Double")
        class DoubleTests {
            @Test
            void number_0() {
                assertTrue(Maths.isEven(0.0d));
            }
            
            @Test
            void number_n0() {
                assertTrue(Maths.isEven(-0.0d));
            }
            
            @Test
            void number_1() {
                assertFalse(Maths.isEven(1.0d));
            }
            
            @Test
            void number_n1() {
                assertFalse(Maths.isEven(-1.0d));
            }
            
            @Test
            void number_2() {
                assertTrue(Maths.isEven(2.0d));
            }
            
            @Test
            void number_n2() {
                assertTrue(Maths.isEven(-2.0d));
            }
            
            @Test
            void number_0_d_5() {
                assertFalse(Maths.isEven(0.5d));
            }
            
            @Test
            void number_n0_d_5() {
                assertFalse(Maths.isEven(-0.5d));
            }
            
            @Test
            void number_4_503_599_627_370_496() {
                assertTrue(Maths.isEven(Doubles.LOSS_DECIMAL_PRECISION));
            }
            
            @Test
            void number_4_503_599_627_370_497() {
                assertFalse(Maths.isEven(Doubles.LOSS_DECIMAL_PRECISION + 1));
            }
            
            @Test
            void number_9_007_199_254_740_992() {
                assertTrue(Maths.isEven(Doubles.LOSS_DECIMAL_PRECISION * 2));
            }
            
            @Test
            void number_9_007_199_254_740_993() {
                assertTrue(Maths.isEven(Doubles.LOSS_DECIMAL_PRECISION * 2 + 1));
            }
            
            @Test
            void number_positive_infinity() {
                assertFalse(Maths.isEven(Double.POSITIVE_INFINITY));
            }
            
            @Test
            void number_negative_infinity() {
                assertFalse(Maths.isEven(Double.NEGATIVE_INFINITY));
            }
            
            @Test
            void number_nan() {
                assertFalse(Maths.isEven(Double.NaN));
            }
        }
        
        @Nested
        @DisplayName("BigInteger")
        class BigIntegerTests {
            @Test
            void number_0() {
                assertTrue(Maths.isEven(BigInteger.ZERO));
            }
            
            @Test
            void number_1() {
                assertFalse(Maths.isEven(BigInteger.ONE));
            }
            
            @Test
            void number_n1() {
                assertFalse(Maths.isEven(BigInteger.valueOf(-1L)));
            }
            
            @Test
            void number_2() {
                assertTrue(Maths.isEven(BigInteger.TWO));
            }
            
            @Test
            void number_n2() {
                assertTrue(Maths.isEven(BigInteger.valueOf(-2L)));
            }
            
            @Test
            void number_1_000_000() {
                assertTrue(Maths.isEven(BigInteger.valueOf(1_000_000L)));
            }
            
            @Test
            void number_1_000_001() {
                assertFalse(Maths.isEven(BigInteger.valueOf(1_000_001L)));
            }
            
            @Test
            void number_null() {
                assertFalse(Maths.isEven(null));
            }
        }
    }
    
    @Nested
    @DisplayName("Is Odd?")
    class IsOddTests {
        @Nested
        @DisplayName("Integer")
        class IntegerTests {
            @Test
            void number_0() {
                assertFalse(Maths.isOdd(0));
            }
            
            @Test
            void number_1() {
                assertTrue(Maths.isOdd(1));
            }
            
            @Test
            void number_n1() {
                assertTrue(Maths.isOdd(-1));
            }
            
            @Test
            void number_2() {
                assertFalse(Maths.isOdd(2));
            }
            
            @Test
            void number_n2() {
                assertFalse(Maths.isOdd(-2));
            }
            
            @Test
            void number_1_000_000() {
                assertFalse(Maths.isOdd(1_000_000));
            }
            
            @Test
            void number_1_000_001() {
                assertTrue(Maths.isOdd(1_000_001));
            }
            
            @Test
            void number_max_value() {
                assertTrue(Maths.isOdd(Integer.MAX_VALUE));
            }
            
            @Test
            void number_min_value() {
                assertFalse(Maths.isOdd(Integer.MIN_VALUE));
            }
        }
        
        @Nested
        @DisplayName("Long")
        class LongTests {
            @Test
            void number_0() {
                assertFalse(Maths.isOdd(0L));
            }
            
            @Test
            void number_1() {
                assertTrue(Maths.isOdd(1L));
            }
            
            @Test
            void number_n1() {
                assertTrue(Maths.isOdd(-1L));
            }
            
            @Test
            void number_2() {
                assertFalse(Maths.isOdd(2L));
            }
            
            @Test
            void number_n2() {
                assertFalse(Maths.isOdd(-2L));
            }
            
            @Test
            void number_1_000_000() {
                assertFalse(Maths.isOdd(1_000_000L));
            }
            
            @Test
            void number_1_000_001() {
                assertTrue(Maths.isOdd(1_000_001L));
            }
            
            @Test
            void number_max_value() {
                assertTrue(Maths.isOdd(Long.MAX_VALUE));
            }
            
            @Test
            void number_min_value() {
                assertFalse(Maths.isOdd(Long.MIN_VALUE));
            }
        }
        
        @Nested
        @DisplayName("Float")
        class FloatTests {
            @Test
            void number_0() {
                final float NUMBER = 0.0f;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_n0() {
                final float NUMBER = -0.0f;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_1() {
                final float NUMBER = 1.0f;
                assertTrue(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_n1() {
                final float NUMBER = -1.0f;
                assertTrue(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_2() {
                final float NUMBER = 2.0f;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_n2() {
                final float NUMBER = -2.0f;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_0_d_5() {
                final float NUMBER = 0.5f;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_n0_d_5() {
                final float NUMBER = -0.5f;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_4_503_599_627_370_496() {
                assertFalse(Maths.isOdd(Floats.LOSS_DECIMAL_PRECISION));
            }
            
            @Test
            void number_4_503_599_627_370_497() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION + 1;
                assertTrue(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_9_007_199_254_740_992() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION * 2;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_9_007_199_254_740_993() {
                final float NUMBER = Floats.LOSS_DECIMAL_PRECISION * 2 + 1;
                assertFalse(Maths.isOdd(NUMBER));
            }
            
            @Test
            void number_positive_infinity() {
                assertFalse(Maths.isOdd(Float.POSITIVE_INFINITY));
            }
            
            @Test
            void number_negative_infinity() {
                assertFalse(Maths.isOdd(Float.NEGATIVE_INFINITY));
            }
            
            @Test
            void number_nan() {
                assertFalse(Maths.isOdd(Float.NaN));
            }
        }
        
        @Nested
        @DisplayName("Double")
        class DoubleTests {
            @Test
            void number_0() {
                assertFalse(Maths.isOdd(0.0d));
            }
            
            @Test
            void number_n0() {
                assertFalse(Maths.isOdd(-0.0d));
            }
            
            @Test
            void number_1() {
                assertTrue(Maths.isOdd(1.0d));
            }
            
            @Test
            void number_n1() {
                assertTrue(Maths.isOdd(-1.0d));
            }
            
            @Test
            void number_2() {
                assertFalse(Maths.isOdd(2.0d));
            }
            
            @Test
            void number_n2() {
                assertFalse(Maths.isOdd(-2.0d));
            }
            
            @Test
            void number_0_d_5() {
                assertFalse(Maths.isOdd(0.5d));
            }
            
            @Test
            void number_n0_d_5() {
                assertFalse(Maths.isOdd(-0.5d));
            }
            
            @Test
            void number_4_503_599_627_370_496() {
                assertFalse(Maths.isOdd(Doubles.LOSS_DECIMAL_PRECISION));
            }
            
            @Test
            void number_4_503_599_627_370_497() {
                assertTrue(Maths.isOdd(Doubles.LOSS_DECIMAL_PRECISION + 1));
            }
            
            @Test
            void number_9_007_199_254_740_992() {
                assertFalse(Maths.isOdd(Doubles.LOSS_DECIMAL_PRECISION * 2));
            }
            
            @Test
            void number_9_007_199_254_740_993() {
                assertFalse(Maths.isOdd(Doubles.LOSS_DECIMAL_PRECISION * 2 + 1));
            }
            
            @Test
            void number_positive_infinity() {
                assertFalse(Maths.isOdd(Double.POSITIVE_INFINITY));
            }
            
            @Test
            void number_negative_infinity() {
                assertFalse(Maths.isOdd(Double.NEGATIVE_INFINITY));
            }
            
            @Test
            void number_nan() {
                assertFalse(Maths.isOdd(Double.NaN));
            }
        }
        
        @Nested
        @DisplayName("BigInteger")
        class BigIntegerTests {
            @Test
            void number_0() {
                assertFalse(Maths.isOdd(BigInteger.ZERO));
            }
            
            @Test
            void number_1() {
                assertTrue(Maths.isOdd(BigInteger.ONE));
            }
            
            @Test
            void number_n1() {
                assertTrue(Maths.isOdd(BigInteger.valueOf(-1L)));
            }
            
            @Test
            void number_2() {
                assertFalse(Maths.isOdd(BigInteger.TWO));
            }
            
            @Test
            void number_n2() {
                assertFalse(Maths.isOdd(BigInteger.valueOf(-2L)));
            }
            
            @Test
            void number_1_000_000() {
                assertFalse(Maths.isOdd(BigInteger.valueOf(1_000_000L)));
            }
            
            @Test
            void number_1_000_001() {
                assertTrue(Maths.isOdd(BigInteger.valueOf(1_000_001L)));
            }
            
            @Test
            void number_null() {
                assertFalse(Maths.isOdd(null));
            }
        }
    }
    
    @Nested
    @DisplayName("-1 ^ n")
    class MinusOnePowTests {
        @Nested
        @DisplayName("Integer")
        class IntegerTests {
            @Test
            void number_0() {
                final int EXPECTED = 1;
                final int TESTED = 0;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_1() {
                final int EXPECTED = -1;
                final int TESTED = 1;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n1() {
                final int EXPECTED = -1;
                final int TESTED = -1;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_2() {
                final int EXPECTED = 1;
                final int TESTED = 2;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n2() {
                final int EXPECTED = 1;
                final int TESTED = -2;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_max_value() {
                final int EXPECTED = -1;
                final int TESTED = Integer.MAX_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_min_value() {
                final int EXPECTED = 1;
                final int TESTED = Integer.MIN_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
        }
        
        @Nested
        @DisplayName("Long")
        class LongTests {
            @Test
            void number_0() {
                final long EXPECTED = 1L;
                final long TESTED = 0L;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_1() {
                final long EXPECTED = -1L;
                final long TESTED = 1L;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n1() {
                final long EXPECTED = -1L;
                final long TESTED = -1L;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_2() {
                final long EXPECTED = 1L;
                final long TESTED = 2L;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n2() {
                final long EXPECTED = 1L;
                final long TESTED = -2L;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_max_value() {
                final long EXPECTED = -1L;
                final long TESTED = Long.MAX_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_min_value() {
                final long EXPECTED = 1L;
                final long TESTED = Long.MIN_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
        }
        
        @Nested
        @DisplayName("Float")
        class FloatTests {
            @Test
            void number_0() {
                final float EXPECTED = 1.0f;
                final float TESTED = 0.0f;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_1() {
                final float EXPECTED = -1.0f;
                final float TESTED = 1.0f;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n1() {
                final float EXPECTED = -1.0f;
                final float TESTED = -1.0f;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_2() {
                final float EXPECTED = 1.0f;
                final float TESTED = 2.0f;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n2() {
                final float EXPECTED = 1.0f;
                final float TESTED = -2.0f;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_0_d_2() {
                final float EXPECTED = Float.NaN;
                final float TESTED = 0.2f;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n1_d_5() {
                final float EXPECTED = Float.NaN;
                final float TESTED = -1.5f;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_decimal_precision() {
                final float EXPECTED = 1.0f;
                final float TESTED = Floats.LOSS_DECIMAL_PRECISION;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_decimal_precision_p_1() {
                final float EXPECTED = -1.0f;
                final float TESTED = Floats.LOSS_DECIMAL_PRECISION + 1;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_two_times_decimal_precision() {
                final float EXPECTED = 1.0f;
                final float TESTED = Floats.LOSS_DECIMAL_PRECISION * 2;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_two_times_decimal_precision_p_1() {
                final float EXPECTED = 1.0f;
                final float TESTED = Floats.LOSS_DECIMAL_PRECISION * 2 + 1;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_positive_infinity() {
                final float EXPECTED = Float.NaN;
                final float TESTED = Float.POSITIVE_INFINITY;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_negative_infinity() {
                final float EXPECTED = Float.NaN;
                final float TESTED = Float.NEGATIVE_INFINITY;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_nan() {
                final float EXPECTED = Float.NaN;
                final float TESTED = Float.NaN;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_max_value() {
                final float EXPECTED = 1.0f;
                final float TESTED = Float.MAX_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_min_value() {
                final float EXPECTED = Float.NaN;
                final float TESTED = Float.MIN_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
        }
        
        @Nested
        @DisplayName("Double")
        class DoubleTests {
            @Test
            void number_0() {
                final double EXPECTED = 1.0d;
                final double TESTED = 0.0d;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_1() {
                final double EXPECTED = -1.0d;
                final double TESTED = 1.0d;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n1() {
                final double EXPECTED = -1.0d;
                final double TESTED = -1.0d;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_2() {
                final double EXPECTED = 1.0d;
                final double TESTED = 2.0d;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n2() {
                final double EXPECTED = 1.0d;
                final double TESTED = -2.0d;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_0_d_2() {
                final double EXPECTED = Double.NaN;
                final double TESTED = 0.2d;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n1_d_5() {
                final double EXPECTED = Double.NaN;
                final double TESTED = -1.5d;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_decimal_precision() {
                final double EXPECTED = 1.0d;
                final double TESTED = Doubles.LOSS_DECIMAL_PRECISION;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_decimal_precision_p_1() {
                final double EXPECTED = -1.0d;
                final double TESTED = Doubles.LOSS_DECIMAL_PRECISION + 1;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_two_times_decimal_precision() {
                final double EXPECTED = 1.0d;
                final double TESTED = Doubles.LOSS_DECIMAL_PRECISION * 2;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_two_times_decimal_precision_p_1() {
                final double EXPECTED = 1.0d;
                final double TESTED = Doubles.LOSS_DECIMAL_PRECISION * 2 + 1;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_positive_infinity() {
                final double EXPECTED = Double.NaN;
                final double TESTED = Double.POSITIVE_INFINITY;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_negative_infinity() {
                final double EXPECTED = Double.NaN;
                final double TESTED = Double.NEGATIVE_INFINITY;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_nan() {
                final double EXPECTED = Double.NaN;
                final double TESTED = Double.NaN;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_max_value() {
                final double EXPECTED = 1.0d;
                final double TESTED = Double.MAX_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_min_value() {
                final double EXPECTED = Double.NaN;
                final double TESTED = Double.MIN_VALUE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
        }
        
        @Nested
        @DisplayName("BigInteger")
        class BigIntegerTests {
            @Test
            void number_0() {
                final BigInteger EXPECTED = BigInteger.ONE;
                final BigInteger TESTED = BigInteger.ZERO;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_1() {
                final BigInteger EXPECTED = Maths.BIG_INTEGER_MINUS_ONE;
                final BigInteger TESTED = BigInteger.ONE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n1() {
                final BigInteger EXPECTED = Maths.BIG_INTEGER_MINUS_ONE;
                final BigInteger TESTED = Maths.BIG_INTEGER_MINUS_ONE;
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_2() {
                final BigInteger EXPECTED = BigInteger.ONE;
                final BigInteger TESTED = BigInteger.valueOf(2L);
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_n2() {
                final BigInteger EXPECTED = BigInteger.ONE;
                final BigInteger TESTED = BigInteger.valueOf(-2L);
                assertEquals(EXPECTED, Maths.minusOnePow(TESTED));
            }
            
            @Test
            void number_null() {
                assertNull(Maths.minusOnePow(null));
            }
        }
    }
    
    @Nested
    @DisplayName("Least Common Multiple (LCM)")
    class LCMTests {
        @Nested
        @DisplayName("Integer")
        class IntegerTests {
            @Test
            void number_0_any() {
                assertEquals(0, Maths.lcm(0, 123));
            }
            
            @Test
            void number_any_0() {
                assertEquals(0, Maths.lcm(123, 0));
            }
            
            @Test
            void number_4_6() {
                assertEquals(12, Maths.lcm(4, 6));
            }
            
            @Test
            void number_6_4() {
                assertEquals(12, Maths.lcm(6, 4));
            }
            
            @Test
            void number_10_10() {
                assertEquals(10, Maths.lcm(10, 10));
            }
            
            @Test
            void number_n9_4() {
                assertEquals(36, Maths.lcm(-9, 4));
            }
            
            @Test
            void number_1_any() {
                assertEquals(123, Maths.lcm(1, 123));
            }
            
            @Test
            void number_2_integer_max() {
                assertThrows(ArithmeticException.class, () -> Maths.lcm(2, Integer.MAX_VALUE));
            }
        }
        
        @Nested
        @DisplayName("Long")
        class LongTests {
            @Test
            void number_0_any() {
                assertEquals(0L, Maths.lcm(0L, 123L));
            }
            
            @Test
            void number_any_0() {
                assertEquals(0L, Maths.lcm(123L, 0L));
            }
            
            @Test
            void number_4_6() {
                assertEquals(12L, Maths.lcm(4L, 6L));
            }
            
            @Test
            void number_6_4() {
                assertEquals(12L, Maths.lcm(6L, 4L));
            }
            
            @Test
            void number_10_10() {
                assertEquals(10L, Maths.lcm(10L, 10L));
            }
            
            @Test
            void number_n9_4() {
                assertEquals(36L, Maths.lcm(-9L, 4L));
            }
            
            @Test
            void number_1_any() {
                assertEquals(123L, Maths.lcm(1L, 123L));
            }
            
            @Test
            void number_2_integer_max() {
                assertThrows(ArithmeticException.class, () -> Maths.lcm(2L, Long.MAX_VALUE));
            }
        }
    }
    
    @Nested
    @DisplayName("Greatest Common Divisor (GCD)")
    class GCDTests {
        @Nested
        @DisplayName("Integer")
        class IntegerTests {
            @Test
            void number_0_any() {
                assertEquals(123, Maths.gcd(0, 123));
            }
            
            @Test
            void number_any_0() {
                assertEquals(123, Maths.gcd(123, 0));
            }
            
            @Test
            void number_48_18() {
                assertEquals(6, Maths.gcd(48, 18));
            }
            
            @Test
            void number_18_48() {
                assertEquals(6, Maths.gcd(18, 48));
            }
            
            @Test
            void number_10_10() {
                assertEquals(10, Maths.gcd(10, 10));
            }
            
            @Test
            void number_n9_4() {
                assertEquals(6, Maths.gcd(-18, 6));
            }
            
            @Test
            void number_1_any() {
                assertEquals(1, Maths.gcd(1, 123));
            }
            
            @Test
            void number_2_max_value_minus_one() {
                assertEquals(2, Maths.gcd(2, Integer.MAX_VALUE - 1));
            }
        }
        
        @Nested
        @DisplayName("Long")
        class LongTests {
            @Test
            void number_0_any() {
                assertEquals(123L, Maths.gcd(0L, 123L));
            }
            
            @Test
            void number_any_0() {
                assertEquals(123L, Maths.gcd(123L, 0L));
            }
            
            @Test
            void number_48_18() {
                assertEquals(6L, Maths.gcd(48L, 18L));
            }
            
            @Test
            void number_18_48() {
                assertEquals(6L, Maths.gcd(18L, 48L));
            }
            
            @Test
            void number_10_10() {
                assertEquals(10L, Maths.gcd(10L, 10L));
            }
            
            @Test
            void number_n9_4() {
                assertEquals(6L, Maths.gcd(-18L, 6L));
            }
            
            @Test
            void number_1_any() {
                assertEquals(1L, Maths.gcd(1L, 123L));
            }
            
            @Test
            void number_2_max_value_minus_one() {
                assertEquals(2L, Maths.gcd(2L, Long.MAX_VALUE - 1));
            }
        }
    }
}
