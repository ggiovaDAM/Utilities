package com.ggiova.utilities.math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Complex class.
 */
@DisplayName("Complex Number Tests")
class ComplexTest {
    private static final double EPSILON = 1e-10;
    
    @Test
    @DisplayName("Constructor with real and imaginary parts")
    void testConstructorWithBothParts() {
        final double REAL = 3.0d;
        final double IMAGINARY = 4.0d;
        Complex c = new Complex(REAL, IMAGINARY);
        assertEquals(REAL, c.real(), EPSILON);
        assertEquals(IMAGINARY, c.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Constructor with only real part")
    void testConstructorWithRealOnly() {
        final double REAL = 5.0d;
        final double EXPECTED = 0.0d;
        Complex c = new Complex(REAL);
        assertEquals(REAL, c.real(), EPSILON);
        assertEquals(EXPECTED, c.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Default constructor creates zero")
    void testDefaultConstructor() {
        final double EXPECTED = 0.0d;
        Complex c = new Complex();
        assertEquals(EXPECTED, c.real(), EPSILON);
        assertEquals(EXPECTED, c.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Constants are initialized correctly")
    void testConstants() {
        assertEquals(0.0, Complex.ZERO.real(), EPSILON);
        assertEquals(0.0, Complex.ZERO.imaginary(), EPSILON);
        
        assertEquals(1.0, Complex.ONE.real(), EPSILON);
        assertEquals(0.0, Complex.ONE.imaginary(), EPSILON);
        
        assertEquals(0.0, Complex.ONE_I.real(), EPSILON);
        assertEquals(1.0, Complex.ONE_I.imaginary(), EPSILON);
        
        assertEquals(2.0, Complex.TWO.real(), EPSILON);
        assertEquals(0.0, Complex.TWO.imaginary(), EPSILON);
        
        assertEquals(0.0, Complex.TWO_I.real(), EPSILON);
        assertEquals(2.0, Complex.TWO_I.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Addition of two complex numbers")
    void testAddComplex() {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(1.0, 2.0);
        Complex result = c1.add(c2);
        
        assertEquals(4.0, result.real(), EPSILON);
        assertEquals(6.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Addition with real and imaginary parts")
    void testAddRealAndImaginary() {
        Complex c = new Complex(3.0, 4.0);
        Complex result = c.add(2.0, 3.0);
        
        assertEquals(5.0, result.real(), EPSILON);
        assertEquals(7.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Addition with real number only")
    void testAddReal() {
        Complex c = new Complex(3.0, 4.0);
        Complex result = c.add(5.0);
        
        assertEquals(8.0, result.real(), EPSILON);
        assertEquals(4.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Subtraction of two complex numbers")
    void testSubtractComplex() {
        Complex c1 = new Complex(5.0, 7.0);
        Complex c2 = new Complex(2.0, 3.0);
        Complex result = c1.subtract(c2);
        
        assertEquals(3.0, result.real(), EPSILON);
        assertEquals(4.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Subtraction with real and imaginary parts")
    void testSubtractRealAndImaginary() {
        Complex c = new Complex(5.0, 7.0);
        Complex result = c.subtract(2.0, 3.0);
        
        assertEquals(3.0, result.real(), EPSILON);
        assertEquals(4.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Subtraction with real number only")
    void testSubtractReal() {
        Complex c = new Complex(5.0, 4.0);
        Complex result = c.subtract(2.0);
        
        assertEquals(3.0, result.real(), EPSILON);
        assertEquals(4.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Multiplication of two complex numbers")
    void testMultiplyComplex() {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(1.0, 2.0);
        Complex result = c1.multiply(c2);
        
        // (3 + 4i) * (1 + 2i) = 3 + 6i + 4i + 8i² = 3 + 10i - 8 = -5 + 10i
        assertEquals(-5.0, result.real(), EPSILON);
        assertEquals(10.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Multiplication with real and imaginary parts")
    void testMultiplyRealAndImaginary() {
        Complex c = new Complex(3.0, 4.0);
        Complex result = c.multiply(1.0, 2.0);
        
        // (3 + 4i) * (1 + 2i) = 3 + 6i + 4i + 8i² = 3 + 10i - 8 = -5 + 10i
        assertEquals(-5.0, result.real(), EPSILON);
        assertEquals(10.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Multiplication with real number only")
    void testMultiplyReal() {
        Complex c = new Complex(3.0, 4.0);
        Complex result = c.multiply(2.0);
        
        assertEquals(6.0, result.real(), EPSILON);
        assertEquals(8.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Multiplication by i gives rotation")
    void testMultiplyByI() {
        Complex c = new Complex(3.0, 4.0);
        Complex result = c.multiply(Complex.ONE_I);
        
        // (3 + 4i) * i = 3i + 4i² = -4 + 3i
        assertEquals(-4.0, result.real(), EPSILON);
        assertEquals(3.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Division of two complex numbers")
    void testDivideComplex() {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(1.0, 2.0);
        Complex result = c1.divide(c2);
        
        // (3 + 4i) / (1 + 2i) = (3 + 4i)(1 - 2i) / (1 + 4) = (3 - 6i + 4i - 8i²) / 5
        // = (3 + 8 - 2i) / 5 = (11 - 2i) / 5 = 2.2 - 0.4i
        assertEquals(2.2, result.real(), EPSILON);
        assertEquals(-0.4, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Division with real and imaginary parts")
    void testDivideRealAndImaginary() {
        Complex c = new Complex(3.0, 4.0);
        Complex result = c.divide(1.0, 2.0);
        
        assertEquals(2.2, result.real(), EPSILON);
        assertEquals(-0.4, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Division with real number only")
    void testDivideReal() {
        Complex c = new Complex(6.0, 8.0);
        Complex result = c.divide(2.0);
        
        assertEquals(3.0, result.real(), EPSILON);
        assertEquals(4.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("Division by ONE returns same number")
    void testDivideByOne() {
        Complex c = new Complex(3.0, 4.0);
        Complex result = c.divide(Complex.ONE);
        
        assertEquals(3.0, result.real(), EPSILON);
        assertEquals(4.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("toString with both parts positive")
    void testToStringBothPositive() {
        Complex c = new Complex(3.0, 4.0);
        assertEquals("3.0 + 4.0i", c.toString());
    }
    
    @Test
    @DisplayName("toString with negative imaginary part")
    void testToStringNegativeImaginary() {
        Complex c = new Complex(3.0, -4.0);
        assertEquals("3.0 - 4.0i", c.toString());
    }
    
    @Test
    @DisplayName("toString with zero imaginary part")
    void testToStringRealOnly() {
        Complex c = new Complex(3.0, 0.0);
        assertEquals("3.0", c.toString());
    }
    
    @Test
    @DisplayName("toString with zero real part")
    void testToStringImaginaryOnly() {
        Complex c = new Complex(0.0, 4.0);
        assertEquals("4.0i", c.toString());
    }
    
    @Test
    @DisplayName("toString for zero")
    void testToStringZero() {
        Complex c = Complex.ZERO;
        assertEquals("0.0", c.toString());
    }
    
    @Test
    @DisplayName("Equals with same values")
    void testEqualsTrue() {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(3.0, 4.0);
        
        assertEquals(c1, c2);
        assertEquals(c2, c1);
    }
    
    @Test
    @DisplayName("Equals with different values")
    void testEqualsFalse() {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(3.0, 5.0);
        Complex c3 = new Complex(4.0, 4.0);
        
        assertNotEquals(c1, c2);
        assertNotEquals(c1, c3);
    }
    
    @Test
    @DisplayName("Equals with null")
    void testEqualsNull() {
        Complex c = new Complex(3.0, 4.0);
        assertNotEquals(null, c);
    }
    
    @Test
    @DisplayName("Equals with different class")
    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    void testEqualsDifferentClass() {
        Complex c = new Complex(3.0, 4.0);
        assertNotEquals("3.0 + 4.0i", c);
    }
    
    @Test
    @DisplayName("Equals with self")
    @SuppressWarnings("EqualsWithItself")
    void testEqualsSelf() {
        Complex c = new Complex(3.0, 4.0);
        assertEquals(c, c);
    }
    
    @Test
    @DisplayName("HashCode consistency")
    void testHashCode() {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(3.0, 4.0);
        
        assertEquals(c1.hashCode(), c2.hashCode());
    }
    
    @Test
    @DisplayName("Immutability - operations don't modify original")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    void testImmutability() {
        final double REAL = 3.0d;
        final double IMAGINARY = 4.0d;
        final double CHANGE = 27182.8182845d;
        Complex c = new Complex(REAL, IMAGINARY);
        Complex original = new Complex(REAL, IMAGINARY);
        
        c.add(CHANGE, CHANGE);
        c.subtract(CHANGE, CHANGE);
        c.multiply(CHANGE, CHANGE);
        c.divide(CHANGE, CHANGE);
        
        assertEquals(original, c);
    }
    
    @Test
    @DisplayName("Chaining operations")
    void testChaining() {
        Complex c = new Complex(1.0, 0.0);
        Complex result = c.add(1.0).multiply(2.0).subtract(1.0);
        
        // ((1 + 1) * 2) - 1 = 3
        assertEquals(3.0, result.real(), EPSILON);
        assertEquals(0.0, result.imaginary(), EPSILON);
    }
    
    @Test
    @DisplayName("i squared equals -1")
    void testISquared() {
        Complex i = Complex.ONE_I;
        Complex result = i.multiply(i);
        
        assertEquals(-1.0, result.real(), EPSILON);
        assertEquals(0.0, result.imaginary(), EPSILON);
    }
}