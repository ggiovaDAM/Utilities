package com.ggiova.utilities.matrix;

import java.io.Serial;

/**
 * Thrown to indicate that a matrix has been accessed with an illegal index.
 *
 * <p>This exception is thrown when attempting to access or modify a matrix element
 * using row or column indices that are outside the valid bounds of the matrix. Valid indices are in the range
 * {@code [0, size)} where {@code size} is the dimension of the square matrix.
 *
 * <p>Example scenarios that throw this exception:
 * <ul>
 *   <li>Accessing a negative row or column index</li>
 *   <li>Accessing a row or column index greater than or equal to the matrix size</li>
 *   <li>Any combination of out-of-bounds row and column values</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * SquareMatrix<Integer> matrix = new SquareMatrix<>(3); // 3x3 matrix
 * matrix.get(5, 2); // Throws MatrixIndexOutOfBoundsException
 * matrix.set(-1, 0, 42); // Throws MatrixIndexOutOfBoundsException
 * }</pre>
 *
 * @see SquareMatrix
 * @see IndexOutOfBoundsException
 */
public class MatrixIndexOutOfBoundsException
        extends IndexOutOfBoundsException {
    @Serial
    private static final long serialVersionUID = -9031521377953945752L;
    
    /**
     * Constructs a {@code MatrixIndexOutOfBoundsException} with no detail message.
     */
    public MatrixIndexOutOfBoundsException() {
        super();
    }
    
    /**
     * Constructs a {@code MatrixIndexOutOfBoundsException} with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public MatrixIndexOutOfBoundsException(String message) {
        super(message);
    }
    
    /**
     * Constructs a {@code MatrixIndexOutOfBoundsException} with a detail message indicating the specific row and column
     * indices that were out of bounds.
     *
     * <p>The generated message will be in the format:
     * {@code "Index out of range for row [row] and column [col]"}
     *
     * @param row the row index that was out of bounds
     * @param col the column index that was out of bounds
     */
    public MatrixIndexOutOfBoundsException(int row, int col) {
        super("Index out of range for row " + row + " and column " + col);
    }
    
    /**
     * Constructs a {@code MatrixIndexOutOfBoundsException} with a detail message indicating the specific row and column
     * indices that were out of bounds, along with the valid bounds.
     *
     * <p>The generated message will be in the format:
     * {@code "Index out of range row [row] and/or column [col] for bounds [0; [size])"}
     *
     * @param row the row index that was out of bounds
     * @param col the column index that was out of bounds
     * @param size the size of the matrix (valid indices are in the range [0, size))
     */
    public MatrixIndexOutOfBoundsException(int row, int col, int size) {
        super("Index out of range row " + row + " and/or column " + col + " for bounds [0; " + size + ")");
    }
}