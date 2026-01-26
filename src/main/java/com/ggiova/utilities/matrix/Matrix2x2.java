package com.ggiova.utilities.matrix;

import java.util.List;
import java.util.Objects;

/**
 * A specialized 2x2 matrix implementation optimized for performance.
 *
 * <p>This class stores elements directly as fields rather than in an array, allowing for faster access and optimized
 * operations. Elements are mutable after construction.
 *
 * <p>Matrix layout:
 * <pre>
 * | e00  e01 |
 * | e10  e11 |
 * </pre>
 *
 * <p>Example usage:
 * <pre>{@code
 * Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
 * Integer value = matrix.get(0, 1); // Returns 2
 * }</pre>
 *
 * @param <T> the type of elements stored in this matrix
 */
public final class Matrix2x2<T>
        extends AbstractSquareMatrix<T> {
    /**
     * Matrix elements stored as individual fields.
     * <p>e00 = row 0, col 0
     * <p>e01 = row 0, col 1
     * <p>e10 = row 1, col 0
     * <p>e11 = row 1, col 1
     */
    private T e00, e01, e10, e11;
    
    /**
     * Constructs a 2x2 matrix with all elements as {@code null}.
     */
    public Matrix2x2() {
        super(2);
        this.e00 = null;
        this.e01 = null;
        this.e10 = null;
        this.e11 = null;
    }
    
    /**
     * Constructs a 2x2 matrix with the specified elements.
     *
     * <p>Elements are provided in row-major order:
     * <pre>
     * | e00  e01 |
     * | e10  e11 |
     * </pre>
     *
     * @param e00 element at position (0, 0)
     * @param e01 element at position (0, 1)
     * @param e10 element at position (1, 0)
     * @param e11 element at position (1, 1)
     */
    public Matrix2x2(T e00, T e01, T e10, T e11) {
        super(2);
        this.e00 = e00;
        this.e01 = e01;
        this.e10 = e10;
        this.e11 = e11;
    }
    
    /**
     * Constructs a 2x2 matrix from a list of elements in row-major order.
     *
     * @param list list of exactly 4 elements
     * @throws NullPointerException     if list is {@code null}
     * @throws IllegalArgumentException if list size is not {@code 4}
     */
    public Matrix2x2(List<T> list) {
        if (list == null)
            throw new NullPointerException("Element 'list' cannot be null.");
        if (list.size() != 4)
            throw new IllegalArgumentException("List must contain exactly 4 elements for a 2x2 matrix.");
        super(2);
        
        this.e00 = list.get(0);
        this.e01 = list.get(1);
        this.e10 = list.get(2);
        this.e11 = list.get(3);
    }
    
    /**
     * Constructs a 2x2 matrix from an array of elements in row-major order.
     *
     * @param array array of exactly 4 elements
     * @throws NullPointerException     if array is {@code null}
     * @throws IllegalArgumentException if array length is not {@code 4}
     */
    public Matrix2x2(T[] array) {
        if (array == null)
            throw new NullPointerException("Element 'array' cannot be null.");
        if (array.length != 4)
            throw new IllegalArgumentException("Array must contain exactly 4 elements for a 2x2 matrix.");
        super(2);
        
        this.e00 = array[0];
        this.e01 = array[1];
        this.e10 = array[2];
        this.e11 = array[3];
    }
    
    /**
     * Constructs a 2x2 matrix by copying a 2D array.
     *
     * @param matrix a 2x2 2D array
     * @throws NullPointerException     if matrix or any row is {@code null}
     * @throws IllegalArgumentException if matrix is not 2x2
     */
    public Matrix2x2(T[][] matrix) {
        if (matrix == null)
            throw new NullPointerException("Element 'matrix' cannot be null.");
        if (matrix.length != 2)
            throw new IllegalArgumentException("Matrix must be 2x2.");
        if (matrix[0] == null || matrix[1] == null)
            throw new NullPointerException("Matrix rows cannot be null.");
        if (matrix[0].length != 2 || matrix[1].length != 2)
            throw new IllegalArgumentException("Matrix must be 2x2.");
        super(2);
        
        this.e00 = matrix[0][0];
        this.e01 = matrix[0][1];
        this.e10 = matrix[1][0];
        this.e11 = matrix[1][1];
    }
    
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        int    result = 2;
               result = 31 * result + Objects.hashCode(this.e00);
               result = 31 * result + Objects.hashCode(this.e01);
               result = 31 * result + Objects.hashCode(this.e10);
               result = 31 * result + Objects.hashCode(this.e11);
        return result;
    }
    
    /**
     * Returns a string representation of this matrix.
     *
     * <p>Format: {@code Matrix<>[2x2]{{e00, e01}, {e10, e11}}}
     *
     * @return a string representation of this matrix
     */
    @Override
    public String toString() {
        return "Matrix<>[2x2]{{" + this.e00 + ", " + this.e01 + "}, {" + this.e10 + ", " + this.e11 + "}}";
    }
    
    /** {@inheritDoc} */
    @Override
    protected void setUnchecked(int row, int col, T value) {
        if (row == 0) {
            if (col == 0) this.e00 = value;
            else this.e01 = value;
        } else {
            if (col == 0) this.e10 = value;
            else this.e11 = value;
        }
    }
    
    /** {@inheritDoc} */
    @Override
    protected T getUnchecked(int row, int col) {
        if (row == 0) return col == 0 ? e00 : e01;
        else return col == 0 ? e10 : e11;
    }
    
    /** {@inheritDoc} */
    @Override
    public Object[] toArray() {
        return new Object[]{this.e00, this.e01, this.e10, this.e11};
    }
    
    /** {@inheritDoc} */
    @Override
    public List<T> toList() {
        return List.of(this.e00, this.e01, this.e10, this.e11);
    }
}