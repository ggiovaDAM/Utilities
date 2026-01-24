package com.ggiova.utilities.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A generic square matrix implementation that stores elements in a two-dimensional grid where the number of rows equals
 * the number of columns.
 *
 * <p>This class provides various constructors to create square matrices from different data sources including arrays,
 * lists, and 2D arrays. Elements are stored and accessed using zero-based row and column indices.
 *
 * <p>Example usage:
 * <pre>{@code
 * // Create a 3x3 matrix
 * SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
 * matrix.set(0, 0, 5);
 * matrix.set(1, 1, 10);
 *
 * // Create from a list
 * List<String> elements = List.of("A", "B", "C", "D");
 * SquareMatrix<String> matrix2 = new SquareMatrix<>(elements); // 2x2 matrix
 * }</pre>
 *
 * @param <T> the type of elements stored in this matrix
 */
public class SquareMatrix<T> {
    /**
     * The length of each side of this square matrix (number of rows and columns).
     */
    private final int size;
    
    /**
     * The internal two-dimensional array storing the matrix elements.
     */
    private final Object[][] matrix;
    
    /**
     * Constructs an empty square matrix of side length {@code size}.
     *
     * @param size amount of rows and columns
     * @throws IllegalArgumentException if {@code size} is less than 1.
     */
    public SquareMatrix(final int size) {
        if (size <= 0) throw new IllegalArgumentException("Size length must be at least 1.");
        this.size = size;
        this.matrix = new Object[size][size];
    }
    
    /**
     * Constructs a square matrix from the given list of elements, filled in row-major order.
     *
     * @param list elements of the matrix
     * @throws NullPointerException     if list is null
     * @throws IllegalArgumentException if list.size() is not a perfect square
     */
    public SquareMatrix(final List<T> list) {
        if (list == null)
            throw new NullPointerException("Element 'list' cannot be null.");
        
        int size = list.size();
        if (size == 0)
            throw new IllegalArgumentException("Matrix must have at least one row.");
        
        int sqrt = (int) Math.sqrt(size);
        if (sqrt * sqrt != size)
            throw new IllegalArgumentException("Cannot form a square matrix with the given elements");
        
        this.size = sqrt;
        this.matrix = new Object[sqrt][sqrt];
        
        for (int index = 0; index < size; index++) {
            int row = index / sqrt;
            int col = index % sqrt;
            this.matrix[row][col] = list.get(index);
        }
    }
    
    /**
     * Constructs a square matrix from the given array of elements, filled in row-major order.
     *
     * @param array elements of the matrix
     * @throws NullPointerException     if array is null
     * @throws IllegalArgumentException if array.length is not a perfect square
     */
    public SquareMatrix(final T[] array) {
        if (array == null)
            throw new NullPointerException("Element 'array' cannot be null.");
        
        int size = array.length;
        if (size == 0)
            throw new IllegalArgumentException("Matrix must have at least one row.");
        
        int sqrt = (int) Math.sqrt(size);
        if (sqrt * sqrt != size)
            throw new IllegalArgumentException("Cannot form a square matrix with the given elements");
        
        this.size = sqrt;
        this.matrix = new Object[sqrt][sqrt];
        
        for (int index = 0; index < size; index++) {
            int row = index / sqrt;
            int col = index % sqrt;
            this.matrix[row][col] = array[index];
        }
    }
    
    /**
     * Constructs a square matrix by copying the given 2D array.
     *
     * @param matrix a square 2D array
     * @throws NullPointerException     if matrix or any row is null
     * @throws IllegalArgumentException if matrix is not square
     */
    public SquareMatrix(final T[][] matrix) {
        if (matrix == null)
            throw new NullPointerException("Element 'matrix' cannot be null.");
        
        this.size = matrix.length;
        if (this.size == 0)
            throw new IllegalArgumentException("Matrix must have at least one row.");
        
        for (int row = 0; row < this.size; row++) {
            if (matrix[row] == null)
                throw new NullPointerException("Row " + row + " is null");
            if (matrix[row].length != this.size)
                throw new IllegalArgumentException("The matrix given is not square");
        }
        
        this.matrix = new Object[this.size][this.size];
        
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.matrix[row][col] = matrix[row][col];
            }
        }
    }
    
    /**
     * Gets the size of the matrix. The size is the number of rows and columns.
     *
     * @return the matrix's size
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Compares this matrix to another object for equality.
     *
     * <p>Two matrices are considered equal if they have the same dimensions and all corresponding elements are equal
     * according to {@link Objects#equals(Object, Object)}.
     *
     * @param o the object to compare with
     * @return {@code true} if the matrices are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SquareMatrix<?> m)) return false;
        if (this.size != m.size) return false;
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (!Objects.equals(this.matrix[row][col], m.matrix[row][col])) return false;
            }
        }
        return true;
    }
    
    /**
     * Returns a hash code value for this matrix.
     *
     * <p>The hash code is computed based on the matrix dimensions and all contained elements.
     *
     * @return a hash code value for this matrix
     */
    @Override
    public int hashCode() {
        int currentHash = this.size;
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                Object obj = this.matrix[row][col];
                currentHash = 31 * currentHash + (obj == null ? 0 : obj.hashCode());
            }
        }
        return currentHash;
    }
    
    /**
     * Returns a string representation of this matrix.
     *
     * <p>The string representation shows the matrix dimensions followed by all elements
     * in row-major order. Each element is enclosed in single quotes, and rows are represented as nested braces.
     *
     * <p>Format: {@code Matrix<>[NxN]{{e11, e12, ...}, {e21, e22, ...}, ...}}
     *
     * <p>Example for a 2x2 matrix:
     * <pre>{@code
     * Matrix<>[2x2]{{A, B}, {C, D}}
     * }</pre>
     *
     * @return a string representation of this matrix
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Matrix<>[")
                .append(this.size)
                .append("x")
                .append(this.size)
                .append("]{");
        final int maxIndex = this.size - 1;
        for (int row = 0; row < this.size; row++) {
            stringBuilder.append('{');
            for (int col = 0; col < this.size; col++) {
                stringBuilder.append(this.matrix[row][col]);
                if (col < maxIndex) stringBuilder.append(", ");
            }
            stringBuilder.append('}');
            if (row < maxIndex) stringBuilder.append(", ");
        }
        return stringBuilder.append('}').toString();
    }
    
    /**
     * Verifies that the given {@code row} and {@code col} are inside the bounds of the matrix.
     *
     * @param row row index (0-based)
     * @param col column index (0-based)
     * @throws MatrixIndexOutOfBoundsException if either {@code row} or {@code col} is smaller than {@code 0} or bigger
     *                                         or equal to {@code this.size}
     */
    private void verifyBounds(final int row, final int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size)
            throw new MatrixIndexOutOfBoundsException(row, col, this.size);
    }
    
    /**
     * Sets an element into the specified position.
     *
     * @param row   row index (0-based)
     * @param col   column index (0-based)
     * @param value element that will be placed at (row, col)
     * @throws MatrixIndexOutOfBoundsException if row or column are outside the range {@code [0, size)}
     */
    public void set(final int row, final int col, final T value) {
        verifyBounds(row, col);
        this.matrix[row][col] = value;
    }
    
    /**
     * Returns the element at the specified position.
     *
     * @param row row index (0-based)
     * @param col column index (0-based)
     * @return the element at (row, col)
     * @throws MatrixIndexOutOfBoundsException if row or column are outside the range {@code [0, size)}
     */
    @SuppressWarnings("unchecked")
    public T get(final int row, final int col) {
        verifyBounds(row, col);
        return (T) matrix[row][col];
    }
    
    /**
     * Converts this matrix to a one-dimensional array in row-major order.
     *
     * <p>The returned array contains all elements of the matrix, reading from left to right, top to bottom.
     *
     * @return an array containing all matrix elements in row-major order
     */
    public Object[] toArray() {
        Object[] array = new Object[this.size * this.size];
        int index = 0;
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++, index++) {
                array[index] = this.matrix[row][col];
            }
        }
        return array;
    }
    
    /**
     * Converts this matrix to an immutable list in row-major order.
     *
     * <p>The returned list contains all elements of the matrix, reading from left to right, top to bottom. The list is
     * unmodifiable.
     *
     * @return an immutable list containing all matrix elements in row-major order
     */
    @SuppressWarnings("unchecked")
    public List<T> toList() {
        List<T> list = new ArrayList<>(size * size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                T value = (T) matrix[row][col];
                list.add(value);
            }
        }
        return List.copyOf(list);
    }
}
