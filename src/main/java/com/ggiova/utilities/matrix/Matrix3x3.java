package com.ggiova.utilities.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A specialized 3x3 matrix implementation optimized for performance.
 *
 * <p>This class stores elements as a 1D array. Elements are mutable after construction.
 *
 * <p>Matrix layout:
 * <pre>
 * | e00  e01  e02 |
 * | e10  e11  e12 |
 * | e20  e21  e22 |
 * </pre>
 *
 * <p>Example usage:
 * <pre>{@code
 * Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
 * Integer value = matrix.get(1, 2); // Returns 6
 * }</pre>
 *
 * @param <T> the type of elements stored in this matrix
 */
public final class Matrix3x3<T>
        extends AbstractSquareMatrix<T> {
    @SuppressWarnings("unchecked")
    private final T[] elements = (T[]) new Object[9];
    
    /**
     * Constructs a 3x3 matrix with all elements as {@code null}.
     */
    public Matrix3x3() {
        super(3);
    }
    
    /**
     * Constructs a 3x3 matrix from a list of elements in row-major order.
     *
     * @param list list of exactly 9 elements
     * @throws NullPointerException     if list is {@code null}
     * @throws IllegalArgumentException if list size is not {@code 9}
     */
    public Matrix3x3(List<T> list) {
        super(3);
        if (list == null)
            throw new NullPointerException("Element 'list' cannot be null.");
        if (list.size() != 9)
            throw new IllegalArgumentException("List must contain exactly 9 elements for a 4x4 matrix.");
        
        for (int index = 0; index < 9; index++) {
            this.elements[index] = list.get(index);
        }
    }
    
    /**
     * Constructs a 3x3 matrix from an array of elements in row-major order.
     *
     * @param array array of exactly 9 elements
     * @throws NullPointerException     if array is {@code null}
     * @throws IllegalArgumentException if array length is not {@code 9}
     */
    public Matrix3x3(T[] array) {
        super(3);
        if (array == null)
            throw new NullPointerException("Element 'array' cannot be null.");
        if (array.length != 9)
            throw new IllegalArgumentException("Array must contain exactly 9 elements for a 3x3 matrix.");
        
        System.arraycopy(array, 0, this.elements, 0, 9);
    }
    
    /**
     * Constructs a 3x3 matrix by copying a 2D array.
     *
     * @param matrix a 3x3 2D array
     * @throws NullPointerException     if matrix or any row is {@code null}
     * @throws IllegalArgumentException if matrix is not 3x3
     */
    public Matrix3x3(T[][] matrix) {
        super(2);
        if (matrix == null)
            throw new NullPointerException("Element 'matrix' cannot be null.");
        if (matrix.length != 3)
            throw new IllegalArgumentException("Matrix must be 3x3.");
        if (matrix[0] == null || matrix[1] == null || matrix[2] == null)
            throw new NullPointerException("Matrix rows cannot be null.");
        if (matrix[0].length != 3 || matrix[1].length != 3 || matrix[2].length != 3)
            throw new IllegalArgumentException("Matrix must be 3x3.");
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.elements[row * 3 + col] = matrix[row][col];
            }
        }
    }
    
    @Override
    public int hashCode() {
        int result = this.size;
        for (Object e : this.elements) {
            result = 31 * result + Objects.hashCode(e);
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "Matrix<>[3x3]{{" +
               this.elements[0] + ", " + this.elements[1] + ", " + this.elements[2] + "}, {" +
               this.elements[3] + ", " + this.elements[4] + ", " + this.elements[5] + "}, {" +
               this.elements[6] + ", " + this.elements[7] + ", " + this.elements[8] + "}}";
    }
    
    @Override
    protected void setUnchecked(int row, int col, T value) {
        this.elements[3 * row + col] = value;
    }
    
    @Override
    protected T getUnchecked(int row, int col) {
        return this.elements[3 * row + col];
    }
    
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, 9);
    }
    
    @Override
    public List<T> toList() {
        return List.of(
                this.elements[0], this.elements[1], this.elements[2],
                this.elements[3], this.elements[4], this.elements[5],
                this.elements[6], this.elements[7], this.elements[8]
        );
    }
}
