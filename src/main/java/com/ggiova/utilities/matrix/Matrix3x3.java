package com.ggiova.utilities.matrix;

import java.util.List;

public final class Matrix3x3<T>
    extends AbstractSquareMatrix<T>{
    
    public Matrix3x3() {
        super(3);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "";
    }
    
    @Override
    protected void setUnchecked(int row, int col, T value) {
    
    }
    
    @Override
    protected T getUnchecked(int row, int col) {
        return null;
    }
    
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    
    @Override
    public List<T> toList() {
        return List.of();
    }
}
