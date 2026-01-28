package com.ggiova.utilities.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link Matrix4x4}.
 */
public class Matrix4x4Test {
    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {
        @Test
        @DisplayName("Empty matrix")
        void empty_matrix() {
            Matrix4x4<Integer> matrix4x4 = new Matrix4x4<>();
            assertEquals(4, matrix4x4.size());
        }
        
        @Test
        @DisplayName("Should throw exception for null values")
        void null_values() {
            assertThrows(NullPointerException.class, () -> new Matrix4x4<>((Integer[]) null));
            assertThrows(NullPointerException.class, () -> new Matrix4x4<>((List<Integer>) null));
            assertThrows(NullPointerException.class, () -> new Matrix4x4<>((Integer[][]) null));
        }
        
        @Nested
        @DisplayName("Should throw exception for list without 4 values")
        class NotFourValues {
            @Test
            @DisplayName("Array 15 values")
            void array_15_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
            }
            
            @Test
            @DisplayName("Array 17 values")
            void array_17_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}));
            }
            
            @Test
            @DisplayName("List 15 values")
            void list_15_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix4x4<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)));
            }
            
            @Test
            @DisplayName("List 17 values")
            void list_17_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix4x4<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)));
            }
            
            @Test
            @DisplayName("Matrix 15 values")
            void matrix_15_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix4x4<>(new Integer[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15}}));
            }
            
            @Test
            @DisplayName("Matrix 17 values")
            void matrix_17_values() {
                assertThrows(IllegalArgumentException.class, () -> new Matrix4x4<>(new Integer[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17}}));
            }
        }
        
        @Nested
        @DisplayName("Should create matrix")
        class ShouldSuccess {
            @Test
            @DisplayName("Given values as array")
            void given_values_array() {
                Matrix4x4<Integer> matrix4x4 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
                assertEquals(1, matrix4x4.get(0, 0));
                assertEquals(2, matrix4x4.get(0, 1));
                assertEquals(3, matrix4x4.get(0, 2));
                assertEquals(4, matrix4x4.get(0, 3));
                assertEquals(5, matrix4x4.get(1, 0));
                assertEquals(6, matrix4x4.get(1, 1));
                assertEquals(7, matrix4x4.get(1, 2));
                assertEquals(8, matrix4x4.get(1, 3));
                assertEquals(9, matrix4x4.get(2, 0));
                assertEquals(10, matrix4x4.get(2, 1));
                assertEquals(11, matrix4x4.get(2, 2));
                assertEquals(12, matrix4x4.get(2, 3));
                assertEquals(13, matrix4x4.get(3, 0));
                assertEquals(14, matrix4x4.get(3, 1));
                assertEquals(15, matrix4x4.get(3, 2));
                assertEquals(16, matrix4x4.get(3, 3));
            }
            
            @Test
            @DisplayName("Given values as list")
            void given_values_list() {
                Matrix4x4<Integer> matrix4x4 = new Matrix4x4<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
                assertEquals(1, matrix4x4.get(0, 0));
                assertEquals(2, matrix4x4.get(0, 1));
                assertEquals(3, matrix4x4.get(0, 2));
                assertEquals(4, matrix4x4.get(0, 3));
                assertEquals(5, matrix4x4.get(1, 0));
                assertEquals(6, matrix4x4.get(1, 1));
                assertEquals(7, matrix4x4.get(1, 2));
                assertEquals(8, matrix4x4.get(1, 3));
                assertEquals(9, matrix4x4.get(2, 0));
                assertEquals(10, matrix4x4.get(2, 1));
                assertEquals(11, matrix4x4.get(2, 2));
                assertEquals(12, matrix4x4.get(2, 3));
                assertEquals(13, matrix4x4.get(3, 0));
                assertEquals(14, matrix4x4.get(3, 1));
                assertEquals(15, matrix4x4.get(3, 2));
                assertEquals(16, matrix4x4.get(3, 3));
            }
            
            @Test
            @DisplayName("Given values as matrix")
            void given_values_matrix() {
                Matrix4x4<Integer> matrix4x4 = new Matrix4x4<>(new Integer[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
                assertEquals(1, matrix4x4.get(0, 0));
                assertEquals(2, matrix4x4.get(0, 1));
                assertEquals(3, matrix4x4.get(0, 2));
                assertEquals(4, matrix4x4.get(0, 3));
                assertEquals(5, matrix4x4.get(1, 0));
                assertEquals(6, matrix4x4.get(1, 1));
                assertEquals(7, matrix4x4.get(1, 2));
                assertEquals(8, matrix4x4.get(1, 3));
                assertEquals(9, matrix4x4.get(2, 0));
                assertEquals(10, matrix4x4.get(2, 1));
                assertEquals(11, matrix4x4.get(2, 2));
                assertEquals(12, matrix4x4.get(2, 3));
                assertEquals(13, matrix4x4.get(3, 0));
                assertEquals(14, matrix4x4.get(3, 1));
                assertEquals(15, matrix4x4.get(3, 2));
                assertEquals(16, matrix4x4.get(3, 3));
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