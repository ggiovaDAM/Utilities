package com.ggiova.utilities.matrix;

import java.util.List;

public final class Matrix4x4<T>
        extends AbstractSquareMatrix<T> {
    
    public Matrix4x4() {
        super(4);
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
