package com.ggiova.utilities.matrix;

import java.util.List;
import java.util.Objects;

/**
 * Base class for square matrix implementations with fixed dimensions.
 *
 * <p>An {@code AbstractSquareMatrix} represents a {@code size × size} matrix whose
 * number of rows and columns is fixed at construction time. Indices are zero-based and valid in the range
 * {@code [0, size)}.
 *
 * <p>This class provides:
 * <ul>
 *   <li>Storage of the matrix dimension</li>
 *   <li>Bounds verification utilities</li>
 *   <li>A value-based {@link #equals(Object)} contract</li>
 * </ul>
 *
 * <p>Concrete subclasses are responsible for:
 * <ul>
 *   <li>Element storage strategy</li>
 *   <li>Implementing {@link #get(int, int)} and {@link #set(int, int, Object)}</li>
 *   <li>Providing consistent {@link #hashCode()} and {@link #toString()} implementations</li>
 * </ul>
 *
 * <h2>Equality Contract</h2>
 * <p>Two matrices are considered equal if:
 * <ul>
 *   <li>They have the same {@linkplain #size() size}</li>
 *   <li>All corresponding elements are equal according to
 *       {@link Objects#equals(Object, Object)}</li>
 * </ul>
 *
 * <p>Subclasses must ensure that {@link #hashCode()} is consistent with this definition.
 *
 * <h2>Iteration Order</h2>
 * <p>Unless otherwise specified, matrix elements are processed in
 * <em>row-major order</em> (left to right, top to bottom).
 *
 * @param <T> the type of elements stored in the matrix
 * @see SquareMatrix
 */
abstract sealed class AbstractSquareMatrix<T>
        permits Matrix2x2, Matrix4x4, SquareMatrix {
    /**
     * The length of each side of this square matrix (number of rows and columns).
     */
    protected final int size;
    
    /**
     * Constructs an empty square matrix of side length {@code size}.
     *
     * @param size amount of rows and columns
     * @throws IllegalArgumentException if {@code size} is less than 1.
     */
    protected AbstractSquareMatrix(final int size) {
        if (size <= 0) throw new IllegalArgumentException("Size length must be at least 1.");
        this.size = size;
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
        if (this == o) return true;
        if (!(o instanceof AbstractSquareMatrix<?> m)) return false;
        if (this.size != m.size) return false;
        
        // No bounds checking needed: we know the sizes match
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (!Objects.equals(this.getUnchecked(row, col), m.getUnchecked(row, col))) {
                    return false;
                }
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
    public abstract int hashCode();
    
    /**
     * Returns a string representation of this matrix.
     *
     * <p>The string representation shows the matrix dimensions followed by all elements in row-major order. Rows are
     * represented as nested braces.
     *
     * <p>Format: {@code Matrix<>[NxN]{{e00, e01, ...}, {e10, e11, ...}, ...}}
     *
     * <p>Example for a 2x2 matrix:
     * <pre>{@code
     * Matrix<>[2x2]{{A, B}, {C, D}}
     * }</pre>
     *
     * @return a string representation of this matrix
     */
    public abstract String toString();
    
    /**
     * Verifies that the given {@code row} and {@code col} are inside the bounds of the matrix.
     *
     * @param row row index (0-based)
     * @param col column index (0-based)
     * @throws MatrixIndexOutOfBoundsException if either {@code row} or {@code col} is smaller than {@code 0} or bigger
     *                                         or equal to {@code this.size}
     */
    protected final void verifyBounds(final int row, final int col) {
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
    public final void set(final int row, final int col, final T value) {
        verifyBounds(row, col);
        setUnchecked(row, col, value);
    }
    
    protected abstract void setUnchecked(final int row, final int col, final T value);
    
    /**
     * Returns the element at the specified position.
     *
     * @param row row index (0-based)
     * @param col column index (0-based)
     * @return the element at (row, col)
     * @throws MatrixIndexOutOfBoundsException if row or column are outside the range {@code [0, size)}
     */
    public final T get(final int row, final int col) {
        verifyBounds(row, col);
        return getUnchecked(row, col);
    }
    
    /**
     * Returns the element at the specified position without bounds checking.
     *
     * <p>This method is intended for internal use where bounds are already verified.
     * Using this method with invalid indices results in undefined behavior.
     *
     * @param row row index (0-based)
     * @param col column index (0-based)
     * @return the element at (row, col)
     */
    protected abstract T getUnchecked(int row, int col);
    
    /**
     * Converts this matrix to a one-dimensional array in row-major order.
     *
     * <p>The returned array contains all elements of the matrix, reading from left to right, top to bottom.
     *
     * @return an array containing all matrix elements in row-major order
     */
    public abstract Object[] toArray();
    
    /**
     * Converts this matrix to an immutable list in row-major order.
     *
     * <p>The returned list contains all elements of the matrix, reading from left to right, top to bottom. The list is
     * unmodifiable.
     *
     * @return an immutable list containing all matrix elements in row-major order
     */
    public abstract List<T> toList();
}
