package com.ggiova.utilities.math;

import com.ggiova.utilities.primitives.Doubles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link Maths}
 */
public class MathsTest {
    @Nested
    @DisplayName("isDoubleWholeNumber()")
    class IsDoubleWholeNumberTest {
        @Test
        void double_whole_number_0() {
            assertTrue(Maths.isWholeNumber(0.0d));
        }
        
        @Test
        void double_whole_number_1() {
            assertTrue(Maths.isWholeNumber(1.0d));
        }
        
        @Test
        void double_whole_number_n1() {
            assertTrue(Maths.isWholeNumber(-1.0d));
        }
        
        @Test
        void double_whole_number_2() {
            assertTrue(Maths.isWholeNumber(2.0d));
        }
        
        @Test
        void double_whole_number_0_d_5() {
            assertFalse(Maths.isWholeNumber(0.5d));
        }
        
        @Test
        void double_whole_number_n0_d_5() {
            assertFalse(Maths.isWholeNumber(-0.5d));
        }
        
        @Test
        void double_whole_number_1_d_5() {
            assertFalse(Maths.isWholeNumber(1.5d));
        }
        
        @Test
        void double_whole_number_4_503_599_627_370_496() {
            assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION));
        }
        
        @Test
        void double_whole_number_4_503_599_627_370_496_d_5() {
            assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION + 0.5d));
        }
        
        @Test
        void double_whole_number_2_251_799_813_685_248() {
            assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION / 2.0d));
        }
        
        @Test
        void double_whole_number_2_251_799_813_685_248_d_5() {
            assertFalse(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION / 2.0d + 0.5d));
        }
        
        @Test
        void double_whole_number_infinity() {
            assertFalse(Maths.isWholeNumber(Double.POSITIVE_INFINITY));
        }
        
        @Test
        void double_whole_number_negative_infinity() {
            assertFalse(Maths.isWholeNumber(Double.NEGATIVE_INFINITY));
        }
        
        @Test
        void double_whole_number_nan() {
            assertFalse(Maths.isWholeNumber(Double.NaN));
        }
        
        @Test
        void double_whole_number_large_negative() {
            assertTrue(Maths.isWholeNumber(-1_000_000.0d));
        }
        
        @Test
        void double_whole_number_large_negative_decimal() {
            assertFalse(Maths.isWholeNumber(-1_000_000.1d));
        }
        
        @Test
        void double_whole_number_small_decimal() {
            assertFalse(Maths.isWholeNumber(0.1d));
        }
        
        @Test
        void double_whole_number_very_small_decimal() {
            assertFalse(Maths.isWholeNumber(0.0001d));
        }
        
        @Test
        void double_whole_number_negative_zero() {
            assertTrue(Maths.isWholeNumber(-0.0d));
        }
        
        @Test
        void double_whole_number_just_below_precision_loss() {
            assertTrue(Maths.isWholeNumber(Doubles.LOSS_DECIMAL_PRECISION - 1));
        }
    }
    
    @Nested
    @DisplayName("isEven()")
    class IsEvenTests {
        @Nested
        @DisplayName("integerTests()")
        class IntTests {
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
        @DisplayName("longTests()")
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
        @DisplayName("doubleTests()")
        class DoubleTests {
            @Test
            void number_0() {
                assertTrue(Maths.isEven(0.0d));
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
    }
}
