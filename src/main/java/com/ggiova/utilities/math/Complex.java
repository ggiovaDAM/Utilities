package com.ggiova.utilities.math;

import java.util.Objects;

/**
 * An immutable representation of a complex number in the form {@code a + bi}, where {@code a} is the real part and
 * {@code b} is the imaginary part.
 * <p>
 * This class provides basic arithmetic operations (addition, subtraction, multiplication, and division) on complex
 * numbers. All operations return new Complex instances, preserving immutability.
 * <p>
 * Example usage:
 * <pre>{@code
 * Complex z1 = new Complex(3, 4);    //  3 + 4i
 * Complex z2 = new Complex(1, 2);    //  1 + 2i
 * Complex sum = z1.add(z2);          //  4 + 6i
 * Complex product = z1.multiply(z2); // -5 + 10i
 * }</pre>
 */
public final class Complex {
    /**
     * Real part of the complex number
     */
    private final double real;
    
    /**
     * Imaginary part of the complex number
     */
    private final double imaginary;
    
    /**
     * The complex number zero {@code 0 + 0i}.
     */
    public static final Complex ZERO = new Complex(0.0d, 0.0d);
    
    /**
     * The complex number one {@code 1 + 0i}.
     */
    public static final Complex ONE = new Complex(1.0d, 0.0d);
    
    /**
     * The imaginary unit {@code 0 + 1i}.
     */
    public static final Complex ONE_I = new Complex(0.0d, 1.0d);
    
    /**
     * The complex number two {@code 2 + 0i}.
     */
    public static final Complex TWO = new Complex(2.0d, 0.0d);
    
    /**
     * Two times the imaginary unit {@code 0 + 2i}.
     */
    public static final Complex TWO_I = new Complex(0.0d, 2.0d);
    
    /**
     * Constructs a complex number with the specified real and imaginary parts.
     *
     * @param real      the real part of the complex number
     * @param imaginary the imaginary part of the complex number
     */
    public Complex(final double real, final double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    /**
     * Constructs a real number (imaginary part is zero).
     *
     * @param real the real part of the complex number
     */
    public Complex(double real) {
        this(real, 0.0d);
    }
    
    /**
     * Constructs the complex number zero {@code 0 + 0i}.
     */
    public Complex() {
        this(0.0d, 0.0d);
    }
    
    /**
     * Returns the real part of this complex number.
     *
     * @return the real part
     */
    public double real() {
        return this.real;
    }
    
    /**
     * Returns the imaginary part of this complex number.
     *
     * @return the imaginary part
     */
    public double imaginary() {
        return this.imaginary;
    }
    
    /**
     * Returns a string representation of this complex number in the form "a + bi".
     * <p>
     * Special cases:
     * <ul>
     *   <li>If the imaginary part is zero, returns just the real part</li>
     *   <li>If the real part is zero, returns just the imaginary part with "i"</li>
     *   <li>If the imaginary part is negative, uses " - " instead of " + "</li>
     * </ul>
     *
     * @return a string representation of this complex number
     */
    @Override
    public String toString() {
        if (this.imaginary == 0) return String.valueOf(this.real);
        if (this.real == 0) return this.imaginary + "i";
        if (this.imaginary < 0) return this.real + " - " + (-this.imaginary) + "i";
        return this.real + " + " + this.imaginary + "i";
    }
    
    /**
     * Compares this complex number to the specified object for equality. Two complex numbers are equal if and only if
     * their real and imaginary parts are equal.
     *
     * @param o the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(real, complex.real) == 0 && Double.compare(imaginary, complex.imaginary) == 0;
    }
    
    /**
     * Returns a hash code for this complex number.
     *
     * @return a hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }
    
    /**
     * Returns the sum of this complex number and the specified complex number.
     * <p>
     * {@code (a + bi) + (c + di) = (a + c) + (b + d)i}
     *
     * @param complex the complex number to add
     * @return a new Complex representing the sum
     */
    public Complex add(final Complex complex) {
        final double newReal = this.real + complex.real;
        final double newImaginary = this.imaginary + complex.imaginary;
        return new Complex(newReal, newImaginary);
    }
    
    /**
     * Returns the sum of this complex number and the specified real and imaginary parts.
     *
     * @param real      the real part to add
     * @param imaginary the imaginary part to add
     * @return a new Complex representing the sum
     */
    public Complex add(final double real, final double imaginary) {
        return new Complex(this.real + real, this.imaginary + imaginary);
    }
    
    /**
     * Returns the sum of this complex number and the specified real number.
     *
     * @param real the real number to add
     * @return a new Complex representing the sum
     */
    public Complex add(final double real) {
        return new Complex(this.real + real, this.imaginary);
    }
    
    /**
     * Returns the difference of this complex number and the specified complex number.
     * <p>
     * {@code (a + bi) - (c + di) = (a - c) + (b - d)i}
     *
     * @param complex the complex number to subtract
     * @return a new Complex representing the difference
     */
    public Complex subtract(final Complex complex) {
        final double newReal = this.real - complex.real;
        final double newImaginary = this.imaginary - complex.imaginary;
        return new Complex(newReal, newImaginary);
    }
    
    /**
     * Returns the difference of this complex number and the specified real and imaginary parts.
     *
     * @param real      the real part to subtract
     * @param imaginary the imaginary part to subtract
     * @return a new Complex representing the difference
     */
    public Complex subtract(final double real, final double imaginary) {
        return new Complex(this.real - real, this.imaginary - imaginary);
    }
    
    /**
     * Returns the difference of this complex number and the specified real number.
     *
     * @param real the real number to subtract
     * @return a new Complex representing the difference
     */
    public Complex subtract(final double real) {
        return new Complex(this.real - real, this.imaginary);
    }
    
    /**
     * Returns the product of this complex number and the specified complex number.
     * <p>
     * {@code (a + bi) × (c + di) = (ac - bd) + (ad + bc)i}
     *
     * @param complex the complex number to multiply by
     * @return a new Complex representing the product
     */
    public Complex multiply(final Complex complex) {
        final double newReal = this.real * complex.real - this.imaginary * complex.imaginary;
        final double newImaginary = this.real * complex.imaginary + this.imaginary * complex.real;
        return new Complex(newReal, newImaginary);
    }
    
    /**
     * Returns the product of this complex number and the specified real and imaginary parts.
     *
     * @param real      the real part to multiply by
     * @param imaginary the imaginary part to multiply by
     * @return a new Complex representing the product
     */
    public Complex multiply(final double real, final double imaginary) {
        return new Complex(this.real * real - this.imaginary * imaginary, this.real * imaginary + this.imaginary * real);
    }
    
    /**
     * Returns the product of this complex number and the specified real number.
     *
     * @param real the real number to multiply by
     * @return a new Complex representing the product
     */
    public Complex multiply(final double real) {
        return new Complex(this.real * real, this.imaginary * real);
    }
    
    /**
     * Returns the quotient of this complex number divided by the specified complex number.
     * <p>
     * {@code (a + bi) / (c + di) = (ac + bd) / (c² + d²) + (bc - ad)i / (c² + d²)}
     *
     * @param complex the complex number to divide by
     * @return a new Complex representing the quotient
     * @throws ArithmeticException if dividing by zero (when complex equals ZERO)
     */
    public Complex divide(final Complex complex) {
        final double divisor = complex.real * complex.real + complex.imaginary * complex.imaginary;
        final double newReal = this.real * complex.real + this.imaginary * complex.imaginary;
        final double newImaginary = this.imaginary * complex.real - this.real * complex.imaginary;
        return new Complex(newReal / divisor, newImaginary / divisor);
    }
    
    /**
     * Returns the quotient of this complex number divided by the specified real and imaginary parts.
     *
     * @param real      the real part to divide by
     * @param imaginary the imaginary part to divide by
     * @return a new Complex representing the quotient
     * @throws ArithmeticException if dividing by zero
     */
    public Complex divide(final double real, final double imaginary) {
        final double divisor = real * real + imaginary * imaginary;
        final double newReal = this.real * real + this.imaginary * imaginary;
        final double newImaginary = this.imaginary * real - this.real * imaginary;
        return new Complex(newReal / divisor, newImaginary / divisor);
    }
    
    /**
     * Returns the quotient of this complex number divided by the specified real number.
     *
     * @param real the real number to divide by
     * @return a new Complex representing the quotient
     * @throws ArithmeticException if dividing by zero
     */
    public Complex divide(final double real) {
        return new Complex(this.real / real, this.imaginary / real);
    }
    
    /**
     * Returns the complex conjugate of {@code this} element.
     *
     * <p>The complex conjugate for {@code a + bi} is {@code a - bi}.
     *
     * @return the complex conjugate.
     */
    public Complex conjugate() {
        return new Complex(this.real, 0.0d - this.imaginary);
    }
    
    public Complex square() {
        return new Complex(
                this.real * this.real - this.imaginary * this.imaginary,
                2 * this.real * this.imaginary
        );
    }
    
    public Complex exp() {
        double exp = Math.exp(this.real);
        double newReal = Math.cos(this.imaginary) * exp;
        double newImaginary = Math.sin(this.imaginary) * exp;
        return new Complex(newReal, newImaginary);
    }
    
    public Complex sin() {
        double expB = Math.exp(this.imaginary);
        double expMB = Math.exp(-this.imaginary);
        double sin = Math.sin(this.real);
        double cos = Math.cos(this.real);
        
        double newReal = 0.5d * sin * (expB + expMB);
        double newImaginary = 0.5d * cos * (expB - expMB);
        return new Complex(newReal, newImaginary);
    }
    
    public Complex cos() {
        double expB = Math.exp(this.imaginary);
        double expMB = Math.exp(-this.imaginary);
        double sin = Math.sin(this.real);
        double cos = Math.cos(this.real);
        
        double newReal = 0.5d * cos * (expMB + expB);
        double newImaginary = 0.5d * sin * (expMB - expB);
        return new Complex(newReal, newImaginary);
    }
}
