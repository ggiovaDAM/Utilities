package com.ggiova.utilities.matrix;

import java.io.Serial;

public class MatrixSizeMismatchException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7246593879261776389L;
    
    public MatrixSizeMismatchException(int desired, int actual) {
        super("Cannot convert matrix of size " + actual + " to size " + desired);
    }
}
