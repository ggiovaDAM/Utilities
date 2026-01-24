/**
 * Provides utility classes for working with matrices and matrix operations.
 *
 * <p>This package contains implementations of various matrix data structures and utilities for matrix manipulation.
 * The primary class is {@link com.ggiova.utilities.matrix.SquareMatrix}, which provides a generic implementation of a
 * square matrix where the number of rows equals the number of columns.
 *
 * <p>Key features include:
 * <ul>
 *   <li>Generic type support for storing any type of elements</li>
 *   <li>Multiple constructors for flexible matrix creation</li>
 *   <li>Bounds-checked element access and modification</li>
 *   <li>Conversion utilities to arrays and lists</li>
 *   <li>Proper equals and hashCode implementations</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * // Create a 3x3 integer matrix
 * SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
 * matrix.set(0, 0, 1);
 * matrix.set(1, 1, 5);
 * matrix.set(2, 2, 9);
 *
 * // Create from a list
 * List<String> data = List.of("A", "B", "C", "D");
 * SquareMatrix<String> stringMatrix = new SquareMatrix<>(data);
 * }</pre>
 */
package com.ggiova.utilities.matrix;