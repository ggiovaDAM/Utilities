package com.ggiova.utilities.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
