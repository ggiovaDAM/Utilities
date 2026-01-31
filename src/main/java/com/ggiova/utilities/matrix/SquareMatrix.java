package com.ggiova.utilities.matrix;

import java.util.ArrayList;
import java.util.List;

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
public final class SquareMatrix<T>
        extends AbstractSquareMatrix<T> {
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
        super(size);
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
        
        super(sqrt);
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
        
        super(sqrt);
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
        
        super(matrix.length);
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
    
    /** {@inheritDoc} */
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
    
    /** {@inheritDoc} */
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
    
    /** {@inheritDoc} */
    @Override
    public void setUnchecked(final int row, final int col, final T value) {
        this.matrix[row][col] = value;
    }
    
    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public T getUnchecked(final int row, final int col) {
        return (T) matrix[row][col];
    }
    
    /** {@inheritDoc} */
    @Override
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
    
    /** {@inheritDoc} */
    @Override
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
    
    public Matrix2x2<T> to2x2() {
        if (this.size != 2) throw new MatrixSizeMismatchException(2, this.size);
        return new Matrix2x2<>((T[]) this.toArray());
    }
    
    public Matrix3x3<T> to3x3() {
        if (this.size != 3) throw new MatrixSizeMismatchException(3, this.size);
        return new Matrix3x3<>((T[]) this.toArray());
    }
    
    public Matrix4x4<T> to4x4() {
        if (this.size != 4) throw new MatrixSizeMismatchException(4, this.size);
        return new Matrix4x4<>((T[]) this.toArray());
    }
}
