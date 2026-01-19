package com.ggiova.utilities.math;

import com.ggiova.utilities.primitives.Doubles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link Maths}
 */
public class MathsTest {
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
