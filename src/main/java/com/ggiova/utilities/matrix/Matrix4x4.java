package com.ggiova.utilities.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A specialized 4x4 matrix implementation optimized for performance.
 *
 * <p>This class stores elements in a 1D array of {@code 16} elements allowing for faster access and optimized
 * operations. Elements are mutable after construction.
 *
 * <p>Matrix layout:
 * <pre>
 * | e00  e01  e02  e03 |
 * | e10  e11  e12  e13 |
 * | e20  e21  e22  e23 |
 * | e30  e31  e32  e33 |
 * </pre>
 *
 * <p>Example usage:
 * <pre>{@code
 * Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
 * Integer value = matrix.get(3, 2); // Returns 15
 * }</pre>
 *
 * @param <T> the type of elements stored in this matrix
 */
public final class Matrix4x4<T>
        extends AbstractSquareMatrix<T> {
    private final int area = 16;
    
    @SuppressWarnings("unchecked")
    private final T[] elements = (T[]) new Object[area];
    
    /**
     * Constructs a 4x4 matrix with all elements as {@code null}.
     */
    public Matrix4x4() {
        super(4);
    }
    
    /**
     * Constructs a 4x4 matrix from a list of elements in row-major order.
     *
     * @param list list of exactly 9 elements
     * @throws NullPointerException     if list is {@code null}
     * @throws IllegalArgumentException if list size is not {@code 16}
     */
    public Matrix4x4(List<T> list) {
        super(4);
        if (list == null)
            throw new NullPointerException("Element 'list' cannot be null.");
        if (list.size() != 16)
            throw new IllegalArgumentException("List must contain exactly 16 elements for a 4x4 matrix.");
        
        for (int index = 0; index < 16; index++) {
            this.elements[index] = list.get(index);
        }
    }
    
    /**
     * Constructs a 4x4 matrix from an array of elements in row-major order.
     *
     * @param array array of exactly 16 elements
     * @throws NullPointerException     if array is {@code null}
     * @throws IllegalArgumentException if array length is not {@code 16}
     */
    public Matrix4x4(T[] array) {
        super(4);
        if (array == null)
            throw new NullPointerException("Element 'array' cannot be null.");
        if (array.length != 16)
            throw new IllegalArgumentException("Array must contain exactly 16 elements for a 3x3 matrix.");
        
        System.arraycopy(array, 0, this.elements, 0, 16);
    }
    
    /**
     * Constructs a 4x4 matrix by copying a 2D array.
     *
     * @param matrix a 4x4 2D array
     * @throws NullPointerException     if matrix or any row is {@code null}
     * @throws IllegalArgumentException if matrix is not 4x4
     */
    public Matrix4x4(T[][] matrix) {
        super(4);
        if (matrix == null)
            throw new NullPointerException("Element 'matrix' cannot be null.");
        if (matrix.length != 4)
            throw new IllegalArgumentException("Matrix must be 4x4.");
        if (matrix[0] == null ||
            matrix[1] == null ||
            matrix[2] == null ||
            matrix[3] == null
        ) throw new NullPointerException("Matrix rows cannot be null.");
        if (matrix[0].length != 4 ||
            matrix[1].length != 4 ||
            matrix[2].length != 4 ||
            matrix[3].length != 4
        ) throw new IllegalArgumentException("Matrix must be 4x4.");
        
        for (int row = 0; row < 4; row++) {
            //noinspection ManualArrayCopy
            for (int col = 0; col < 4; col++) {
                this.elements[row * 4 + col] = matrix[row][col];
            }
        }
    }
    
    @Override
    public int hashCode() {
        int result = this.size;
        for (T element : elements)
            result = 31 * result + element.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Matrix<>[4x4]{");
        for (int row = 0; row < 4; row++) {                         // this.size
            stringBuilder.append("{");
            for (int col = 0; col < 4; col++) {                     // this.size
                stringBuilder.append(this.elements[row * 4 + col]); // this.size
                if (col < 3) stringBuilder.append(", ");            // this.size - 1
            }
            stringBuilder.append('}');
            if (row < 3) stringBuilder.append(", ");                // this.size - 1
        }
        return stringBuilder.append('}').toString();
    }
    
    @Override
    protected void setUnchecked(int row, int col, T value) {
        this.elements[row * 4 + col] = value;                       // this.size
    }
    
    @Override
    protected T getUnchecked(int row, int col) {
        return this.elements[row * 4 + col];                        // this.size
    }
    
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, area);                  // this.size * this.size
    }
    
    @Override
    public List<T> toList() {
        List<T> data = new ArrayList<>(area);                       // this.size * this.size
        data.addAll(Arrays.asList(this.elements).subList(0, area));
        return List.copyOf(data);
    }
}
