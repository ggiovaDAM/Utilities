package com.ggiova.utilities.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link Matrix3x3}.
 */
public class Matrix3x3Test {
    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {
        @Test
        @DisplayName("Empty matrix")
        void empty_matrix() {
            Matrix3x3<Integer> matrix3x3 = new Matrix3x3<>();
            assertEquals(3, matrix3x3.size());
        }
        
        @Test
        @DisplayName("Should throw exception for null values")
        void null_values() {
            assertThrows(NullPointerException.class, () -> new Matrix3x3<>((Integer[]) null));
            assertThrows(NullPointerException.class, () -> new Matrix3x3<>((List<Integer>) null));
            assertThrows(NullPointerException.class, () -> new Matrix3x3<>((Integer[][]) null));
        }
        
        @Nested
        @DisplayName("Should throw exception for list without 4 values")
        class NotFourValues {
            @Test
            @DisplayName("Array 8 values")
            void array_8_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}));
            }
            
            @Test
            @DisplayName("Array 10 values")
            void array_10_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
            }
            
            @Test
            @DisplayName("List 8 values")
            void list_8_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix3x3<>(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
            }
            
            @Test
            @DisplayName("List 10 values")
            void list_10_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix3x3<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            }
            
            @Test
            @DisplayName("Matrix 8 values")
            void matrix_8_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix3x3<>(new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8}}));
            }
            
            @Test
            @DisplayName("Matrix 10 values")
            void matrix_10_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix3x3<>(new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10}}));
            }
        }
        
        @Nested
        @DisplayName("Should create matrix")
        class ShouldSuccess {
            @Test
            @DisplayName("Given values as array")
            void given_values_array() {
                Matrix3x3<Integer> matrix3x3 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
                assertEquals(1, matrix3x3.get(0, 0));
                assertEquals(2, matrix3x3.get(0, 1));
                assertEquals(3, matrix3x3.get(0, 2));
                assertEquals(4, matrix3x3.get(1, 0));
                assertEquals(5, matrix3x3.get(1, 1));
                assertEquals(6, matrix3x3.get(1, 2));
                assertEquals(7, matrix3x3.get(2, 0));
                assertEquals(8, matrix3x3.get(2, 1));
                assertEquals(9, matrix3x3.get(2, 2));
            }
            
            @Test
            @DisplayName("Given values as list")
            void given_values_list() {
                Matrix3x3<Integer> matrix3x3 = new Matrix3x3<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
                assertEquals(1, matrix3x3.get(0, 0));
                assertEquals(2, matrix3x3.get(0, 1));
                assertEquals(3, matrix3x3.get(0, 2));
                assertEquals(4, matrix3x3.get(1, 0));
                assertEquals(5, matrix3x3.get(1, 1));
                assertEquals(6, matrix3x3.get(1, 2));
                assertEquals(7, matrix3x3.get(2, 0));
                assertEquals(8, matrix3x3.get(2, 1));
                assertEquals(9, matrix3x3.get(2, 2));
            }
            
            @Test
            @DisplayName("Given values as matrix")
            void given_values_matrix() {
                Matrix3x3<Integer> matrix3x3 = new Matrix3x3<>(new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
                assertEquals(1, matrix3x3.get(0, 0));
                assertEquals(2, matrix3x3.get(0, 1));
                assertEquals(3, matrix3x3.get(0, 2));
                assertEquals(4, matrix3x3.get(1, 0));
                assertEquals(5, matrix3x3.get(1, 1));
                assertEquals(6, matrix3x3.get(1, 2));
                assertEquals(7, matrix3x3.get(2, 0));
                assertEquals(8, matrix3x3.get(2, 1));
                assertEquals(9, matrix3x3.get(2, 2));
            }
        }
    }
    
    @Nested
    @DisplayName("Get and Set Tests")
    class GetSetTests {
    }
    
    @Nested
    @DisplayName("Conversion Tests")
    class ConversionTests {
    }
    
    @Nested
    @DisplayName("Equals and HashCode Tests")
    class EqualsHashCodeTests {
    }
    
    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCaseTests {
    }
}