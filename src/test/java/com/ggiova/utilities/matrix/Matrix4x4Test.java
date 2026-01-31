package com.ggiova.utilities.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    assertNull(matrix4x4.get(row, col));
                }
            }
        }
        
        @Test
        @DisplayName("Should throw exception for null values")
        void null_values() {
            assertThrows(NullPointerException.class, () -> new Matrix4x4<>((Integer[]) null));
            assertThrows(NullPointerException.class, () -> new Matrix4x4<>((List<Integer>) null));
            assertThrows(NullPointerException.class, () -> new Matrix4x4<>((Integer[][]) null));
        }
        
        @Nested
        @DisplayName("Should throw exception for list without 16 values")
        class NotSixteenValues {
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
            
            @Test
            @DisplayName("Matrix with null row")
            void matrix_null_row() {
                Integer[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, null};
                assertThrows(NullPointerException.class, () -> new Matrix4x4<>(matrix));
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
        @Test
        @DisplayName("Should set and get elements correctly")
        void test_set_and_get() {
            Matrix4x4<String> matrix = new Matrix4x4<>();
            
            matrix.set(0, 0, "A");
            matrix.set(0, 3, "D");
            matrix.set(1, 2, "G");
            matrix.set(2, 1, "J");
            matrix.set(3, 3, "P");
            
            assertEquals("A", matrix.get(0, 0));
            assertNull(matrix.get(0, 1));
            assertEquals("D", matrix.get(0, 3));
            assertEquals("G", matrix.get(1, 2));
            assertEquals("J", matrix.get(2, 1));
            assertEquals("P", matrix.get(3, 3));
        }
        
        @Test
        @DisplayName("Should throw exception for negative indices")
        void test_negative_indices() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(-1, 0));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, -1));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(-1, 0, 99));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(0, -1, 99));
        }
        
        @Test
        @DisplayName("Should throw exception for out of bounds indices")
        void test_out_of_bounds() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(4, 0));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, 4));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(4, 0, 99));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(0, 4, 99));
        }
        
        @Test
        @DisplayName("Should allow null values")
        void test_null_values() {
            Matrix4x4<String> matrix = new Matrix4x4<>(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"});
            matrix.set(2, 2, null);
            assertNull(matrix.get(2, 2));
            assertEquals("A", matrix.get(0, 0));
        }
        
        @Test
        @DisplayName("Should overwrite existing values")
        void test_overwrite() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            matrix.set(2, 2, 99);
            assertEquals(99, matrix.get(2, 2));
        }
        
        @Test
        @DisplayName("Should handle all positions")
        void test_all_positions() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    int expected = row * 4 + col + 1;
                    assertEquals(expected, matrix.get(row, col));
                }
            }
        }
    }
    
    @Nested
    @DisplayName("Conversion Tests")
    class ConversionTests {
        @Test
        @DisplayName("Should convert to array correctly")
        void test_to_array() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            Object[] array = matrix.toArray();
            
            assertEquals(16, array.length);
            assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, array);
        }
        
        @Test
        @DisplayName("Should convert to list correctly")
        void test_to_list() {
            Matrix4x4<String> matrix = new Matrix4x4<>(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"});
            List<String> list = matrix.toList();
            
            assertEquals(16, list.size());
            assertEquals(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"), list);
        }
        
        @Test
        @DisplayName("Should return immutable list")
        void test_list_is_immutable() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            List<Integer> list = matrix.toList();
            
            assertThrows(UnsupportedOperationException.class, () -> list.add(17));
        }
        
        @Test
        @DisplayName("Array modification doesn't affect matrix")
        void test_array_independence() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            Object[] array = matrix.toArray();
            array[0] = 999;
            
            assertEquals(1, matrix.get(0, 0));
        }
    }
    
    @Nested
    @DisplayName("Equals and HashCode Tests")
    class EqualsHashCodeTests {
        @Test
        @DisplayName("Should be equal to itself")
        void test_equals_reflexive() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            assertEquals(matrix, matrix);
        }
        
        @Test
        @DisplayName("Should be equal to matrix with same elements")
        void test_equals_with_same_elements() {
            Matrix4x4<Integer> matrix1 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            Matrix4x4<Integer> matrix2 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            
            assertEquals(matrix1, matrix2);
            assertEquals(matrix2, matrix1);
        }
        
        @Test
        @DisplayName("Should not be equal to matrix with different elements")
        void test_not_equals_different_elements() {
            Matrix4x4<Integer> matrix1 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            Matrix4x4<Integer> matrix2 = new Matrix4x4<>(new Integer[]{16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should be equal to SquareMatrix with same elements")
        void test_equals_with_square_matrix() {
            Matrix4x4<Integer> matrix1 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            
            assertEquals(matrix1, matrix2);
            assertEquals(matrix2, matrix1);
        }
        
        @Test
        @DisplayName("Should not be equal to SquareMatrix with different size")
        void test_not_equals_different_size() {
            Matrix4x4<Integer> matrix1 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(5);
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should not be equal to null")
        void test_not_equals_null() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            assertNotEquals(null, matrix);
        }
        
        @Test
        @DisplayName("Should not be equal to different type")
        void test_not_equals_different_type() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            assertNotEquals("not a matrix", matrix);
        }
        
        @Test
        @DisplayName("Should have same hashCode for equal matrices")
        void test_hash_code_consistency() {
            Matrix4x4<Integer> matrix1 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            Matrix4x4<Integer> matrix2 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
        
        @Test
        @DisplayName("Should have same hashCode as SquareMatrix with same elements")
        void test_hash_code_with_square_matrix() {
            Matrix4x4<Integer> matrix1 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
        
        @Test
        @DisplayName("Should handle null elements in equals")
        void test_equals_with_nulls() {
            Matrix4x4<String> matrix1 = new Matrix4x4<>(new String[]{null, "B", "C", null, "E", "F", "G", null, "I", "J", "K", "L", null, "N", "O", null});
            Matrix4x4<String> matrix2 = new Matrix4x4<>(new String[]{null, "B", "C", null, "E", "F", "G", null, "I", "J", "K", "L", null, "N", "O", null});
            
            assertEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should handle null elements in hashCode")
        void test_hash_code_with_nulls() {
            Matrix4x4<String> matrix1 = new Matrix4x4<>(new String[]{null, "B", "C", null, "E", "F", "G", null, "I", "J", "K", "L", null, "N", "O", null});
            Matrix4x4<String> matrix2 = new Matrix4x4<>(new String[]{null, "B", "C", null, "E", "F", "G", null, "I", "J", "K", "L", null, "N", "O", null});
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
    }
    
    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {
        @Test
        @DisplayName("Should produce correct string format")
        void test_to_string_format() {
            Matrix4x4<String> matrix = new Matrix4x4<>(new String[]{"#", "_", "@", "$", "%", "^", "&", "*", "!", "~", "+", "=", "|", "/", "?", ">"});
            String result = matrix.toString();
            
            assertTrue(result.contains("Matrix<>[4x4]"));
            assertTrue(result.contains("#"));
            assertTrue(result.contains("_"));
            assertTrue(result.contains("@"));
            assertTrue(result.contains("$"));
            assertTrue(result.contains("%"));
            assertTrue(result.contains("^"));
            assertTrue(result.contains("&"));
            assertTrue(result.contains("*"));
        }
        
        @Test
        @DisplayName("Should handle null elements in toString")
        void test_to_string_with_nulls() {
            Matrix4x4<String> matrix = new Matrix4x4<>(new String[]{"A", null, "C", null, "E", null, "G", null, "I", null, "K", null, "M", null, "O", null});
            String result = matrix.toString();
            
            assertTrue(result.contains("A"));
            assertTrue(result.contains("null"));
            assertTrue(result.contains("C"));
        }
        
        @Test
        @DisplayName("Should show correct size in toString")
        void test_to_string_shows_size() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            String result = matrix.toString();
            
            assertTrue(result.contains("4x4"));
        }
        
        @Test
        @DisplayName("Should match expected format exactly")
        void test_exact_format() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            String result = matrix.toString();
            
            assertEquals("Matrix<>[4x4]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}", result);
        }
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCaseTests {
        @Test
        @DisplayName("Should handle all null matrix")
        void test_all_nulls() {
            Matrix4x4<String> matrix = new Matrix4x4<>();
            
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    assertNull(matrix.get(row, col));
                }
            }
        }
        
        @Test
        @DisplayName("Should verify size is always 4")
        void test_size_constant() {
            Matrix4x4<Integer> matrix1 = new Matrix4x4<>();
            Matrix4x4<Integer> matrix2 = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            Matrix4x4<Integer> matrix3 = new Matrix4x4<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            
            assertEquals(4, matrix1.size());
            assertEquals(4, matrix2.size());
            assertEquals(4, matrix3.size());
        }
        
        @Test
        @DisplayName("Should handle modification after construction")
        void test_modification() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            
            matrix.set(0, 0, 99);
            matrix.set(1, 1, 88);
            matrix.set(2, 2, 77);
            matrix.set(3, 3, 66);
            
            assertEquals(99, matrix.get(0, 0));
            assertEquals(88, matrix.get(1, 1));
            assertEquals(77, matrix.get(2, 2));
            assertEquals(66, matrix.get(3, 3));
            assertEquals(2, matrix.get(0, 1));
        }
        
        @Test
        @DisplayName("Should handle corner and center elements")
        void test_corners_and_center() {
            Matrix4x4<String> matrix = new Matrix4x4<>();
            
            matrix.set(0, 0, "TL");   // Top-left
            matrix.set(0, 3, "TR");   // Top-right
            matrix.set(1, 1, "C1");   // Center-ish
            matrix.set(2, 2, "C2");   // Center-ish
            matrix.set(3, 0, "BL");   // Bottom-left
            matrix.set(3, 3, "BR");   // Bottom-right
            
            assertEquals("TL", matrix.get(0, 0));
            assertEquals("TR", matrix.get(0, 3));
            assertEquals("C1", matrix.get(1, 1));
            assertEquals("C2", matrix.get(2, 2));
            assertEquals("BL", matrix.get(3, 0));
            assertEquals("BR", matrix.get(3, 3));
        }
        
        @Test
        @DisplayName("Should handle diagonal elements")
        void test_diagonal() {
            Matrix4x4<Integer> matrix = new Matrix4x4<>();
            
            matrix.set(0, 0, 1);
            matrix.set(1, 1, 2);
            matrix.set(2, 2, 3);
            matrix.set(3, 3, 4);
            
            assertEquals(1, matrix.get(0, 0));
            assertEquals(2, matrix.get(1, 1));
            assertEquals(3, matrix.get(2, 2));
            assertEquals(4, matrix.get(3, 3));
            
            // Off-diagonal should be null
            assertNull(matrix.get(0, 1));
            assertNull(matrix.get(1, 0));
        }
    }
}