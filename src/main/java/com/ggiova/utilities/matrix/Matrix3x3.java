package com.ggiova.utilities.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Matrix3x3<T>
        extends AbstractSquareMatrix<T> {
    @SuppressWarnings("unchecked")
    private final T[] elements = (T[]) new Object[9];
    
    public Matrix3x3() {
        super(3);
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
