package com.ggiova.utilities.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link Matrix2x2}.
 */
public class Matrix2x2Test {
    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {
        @Test
        @DisplayName("Empty matrix")
        void empty_matrix() {
            Matrix2x2<Integer> matrix2x2 = new Matrix2x2<>();
            assertEquals(2, matrix2x2.size());
        }
        
        @Test
        @DisplayName("Should throw exception for null values")
        void null_values() {
            assertThrows(NullPointerException.class, () -> new Matrix2x2<>((Integer[]) null));
            assertThrows(NullPointerException.class, () -> new Matrix2x2<>((List<Integer>) null));
            assertThrows(NullPointerException.class, () -> new Matrix2x2<>((Integer[][]) null));
        }
        
        @Nested
        @DisplayName("Should throw exception for list without 4 values")
        class NotFourValues {
            @Test
            @DisplayName("Array 3 values")
            void array_3_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix2x2<>(new Integer[]{1, 2, 3}));
            }
            
            @Test
            @DisplayName("Array 5 values")
            void array_5_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix2x2<>(new Integer[]{1, 2, 3, 4, 5}));
            }
            
            @Test
            @DisplayName("List 3 values")
            void list_3_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix2x2<>(List.of(1, 2, 3)));
            }
            
            @Test
            @DisplayName("List 5 values")
            void list_5_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix2x2<>(List.of(1, 2, 3, 4, 5)));
            }
            
            @Test
            @DisplayName("Matrix 3 values")
            void matrix_3_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix2x2<>(new Integer[][]{{1, 2}, {3}}));
            }
            
            @Test
            @DisplayName("Matrix 5 values")
            void matrix_5_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix2x2<>(new Integer[][]{{1, 2}, {3, 4}, {5}}));
            }
        }
        
        @Nested
        @DisplayName("Should create matrix")
        class ShouldSuccess {
            @Test
            @DisplayName("Given values separate")
            void given_values_separate() {
                Matrix2x2<Integer> matrix2x2 = new Matrix2x2<>(1, 2, 3, 4);
                assertEquals(1, matrix2x2.get(0, 0));
                assertEquals(2, matrix2x2.get(0, 1));
                assertEquals(3, matrix2x2.get(1, 0));
                assertEquals(4, matrix2x2.get(1, 1));
            }
            
            @Test
            @DisplayName("Given values as array")
            void given_values_array() {
                Matrix2x2<Integer> matrix2x2 = new Matrix2x2<>(new Integer[]{1, 2, 3, 4});
                assertEquals(1, matrix2x2.get(0, 0));
                assertEquals(2, matrix2x2.get(0, 1));
                assertEquals(3, matrix2x2.get(1, 0));
                assertEquals(4, matrix2x2.get(1, 1));
            }
            
            @Test
            @DisplayName("Given values as list")
            void given_values_list() {
                Matrix2x2<Integer> matrix2x2 = new Matrix2x2<>(List.of(1, 2, 3, 4));
                assertEquals(1, matrix2x2.get(0, 0));
                assertEquals(2, matrix2x2.get(0, 1));
                assertEquals(3, matrix2x2.get(1, 0));
                assertEquals(4, matrix2x2.get(1, 1));
            }
            
            @Test
            @DisplayName("Given values as matrix")
            void given_values_matrix() {
                Matrix2x2<Integer> matrix2x2 = new Matrix2x2<>(new Integer[][]{{1, 2}, {3, 4}});
                assertEquals(1, matrix2x2.get(0, 0));
                assertEquals(2, matrix2x2.get(0, 1));
                assertEquals(3, matrix2x2.get(1, 0));
                assertEquals(4, matrix2x2.get(1, 1));
            }
        }
    }
    
    @Nested
    @DisplayName("Get and Set Tests")
    class GetSetTests {}
    
    @Nested
    @DisplayName("Conversion Tests")
    class ConversionTests {}
    
    @Nested
    @DisplayName("Equals and HashCode Tests")
    class EqualsHashCodeTests {}
    
    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {}
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCaseTests {}
}