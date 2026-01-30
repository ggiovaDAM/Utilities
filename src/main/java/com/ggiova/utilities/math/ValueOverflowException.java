package com.ggiova.utilities.math;

import java.io.Serial;

/**
 * Exception thrown when a numeric value exceeds the capacity of its target type.
 *
 * <p>This exception is typically thrown when attempting to convert a large Fibonacci number (or other mathematical
 * value) to a primitive type that cannot represent its magnitude.
 */
public class ValueOverflowException extends ArithmeticException {
    @Serial
    private static final long serialVersionUID = -573313716165313218L;
    
    private final Class<?> targetType;
    
    /**
     * Constructs a ValueOverflowException for the specified target type.
     *
     * @param targetType the type that the value was being converted to
     */
    public ValueOverflowException(Class<?> targetType) {
        super(String.format("Value too large to fit in %s", targetType.getSimpleName()));
        this.targetType = targetType;
    }
    
    /**
     * Constructs a ValueOverflowException with a custom message.
     *
     * @param message    the detail message
     * @param targetType the type that the value was being converted to
     */
    public ValueOverflowException(String message, Class<?> targetType) {
        super(message);
        this.targetType = targetType;
    }
    
    /**
     * Returns the target type that caused the overflow.
     *
     * @return the target type
     */
    public Class<?> getTargetType() {
        return targetType;
    }
}