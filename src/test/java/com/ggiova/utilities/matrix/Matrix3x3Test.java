package com.ggiova.utilities.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    assertNull(matrix3x3.get(row, col));
                }
            }
        }
        
        @Test
        @DisplayName("Should throw exception for null values")
        void null_values() {
            assertThrows(NullPointerException.class, () -> new Matrix3x3<>((Integer[]) null));
            assertThrows(NullPointerException.class, () -> new Matrix3x3<>((List<Integer>) null));
            assertThrows(NullPointerException.class, () -> new Matrix3x3<>((Integer[][]) null));
        }
        
        @Nested
        @DisplayName("Should throw exception for list without 9 values")
        class NotNineValues {
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
            
            @Test
            @DisplayName("Matrix with null row")
            void matrix_null_row() {
                Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, null};
                assertThrows(NullPointerException.class, () -> new Matrix3x3<>(matrix));
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
        @Test
        @DisplayName("Should set and get elements correctly")
        void test_set_and_get() {
            Matrix3x3<String> matrix = new Matrix3x3<>();
            
            matrix.set(0, 0, "A");
            matrix.set(0, 2, "C");
            matrix.set(1, 1, "E");
            matrix.set(2, 0, "G");
            matrix.set(2, 2, "I");
            
            assertEquals("A", matrix.get(0, 0));
            assertNull(matrix.get(0, 1));
            assertEquals("C", matrix.get(0, 2));
            assertEquals("E", matrix.get(1, 1));
            assertEquals("G", matrix.get(2, 0));
            assertEquals("I", matrix.get(2, 2));
        }
        
        @Test
        @DisplayName("Should throw exception for negative indices")
        void test_negative_indices() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(-1, 0));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, -1));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(-1, 0, 99));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(0, -1, 99));
        }
        
        @Test
        @DisplayName("Should throw exception for out of bounds indices")
        void test_out_of_bounds() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(3, 0));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, 3));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(3, 0, 99));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(0, 3, 99));
        }
        
        @Test
        @DisplayName("Should allow null values")
        void test_null_values() {
            Matrix3x3<String> matrix = new Matrix3x3<>(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"});
            matrix.set(1, 1, null);
            assertNull(matrix.get(1, 1));
            assertEquals("A", matrix.get(0, 0));
        }
        
        @Test
        @DisplayName("Should overwrite existing values")
        void test_overwrite() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            matrix.set(1, 1, 99);
            assertEquals(99, matrix.get(1, 1));
        }
        
        @Test
        @DisplayName("Should handle all positions")
        void test_all_positions() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int expected = row * 3 + col + 1;
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
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            Object[] array = matrix.toArray();
            
            assertEquals(9, array.length);
            assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
        }
        
        @Test
        @DisplayName("Should convert to list correctly")
        void test_to_list() {
            Matrix3x3<String> matrix = new Matrix3x3<>(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"});
            List<String> list = matrix.toList();
            
            assertEquals(9, list.size());
            assertEquals(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I"), list);
        }
        
        @Test
        @DisplayName("Should return immutable list")
        void test_list_is_immutable() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            List<Integer> list = matrix.toList();
            
            assertThrows(UnsupportedOperationException.class, () -> list.add(10));
        }
        
        @Test
        @DisplayName("Array modification doesn't affect matrix")
        void test_array_independence() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
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
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            assertEquals(matrix, matrix);
        }
        
        @Test
        @DisplayName("Should be equal to matrix with same elements")
        void test_equals_with_same_elements() {
            Matrix3x3<Integer> matrix1 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            Matrix3x3<Integer> matrix2 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            
            assertEquals(matrix1, matrix2);
            assertEquals(matrix2, matrix1);
        }
        
        @Test
        @DisplayName("Should not be equal to matrix with different elements")
        void test_not_equals_different_elements() {
            Matrix3x3<Integer> matrix1 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            Matrix3x3<Integer> matrix2 = new Matrix3x3<>(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should be equal to SquareMatrix with same elements")
        void test_equals_with_square_matrix() {
            Matrix3x3<Integer> matrix1 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            
            assertEquals(matrix1, matrix2);
            assertEquals(matrix2, matrix1);
        }
        
        @Test
        @DisplayName("Should not be equal to SquareMatrix with different size")
        void test_not_equals_different_size() {
            Matrix3x3<Integer> matrix1 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(2);
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should not be equal to null")
        void test_not_equals_null() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            assertNotEquals(null, matrix);
        }
        
        @Test
        @DisplayName("Should not be equal to different type")
        void test_not_equals_different_type() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            assertNotEquals("not a matrix", matrix);
        }
        
        @Test
        @DisplayName("Should have same hashCode for equal matrices")
        void test_hash_code_consistency() {
            Matrix3x3<Integer> matrix1 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            Matrix3x3<Integer> matrix2 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
        
        @Test
        @DisplayName("Should have same hashCode as SquareMatrix with same elements")
        void test_hash_code_with_square_matrix() {
            Matrix3x3<Integer> matrix1 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
        
        @Test
        @DisplayName("Should handle null elements in equals")
        void test_equals_with_nulls() {
            Matrix3x3<String> matrix1 = new Matrix3x3<>(new String[]{null, "B", "C", "D", null, "F", "G", "H", null});
            Matrix3x3<String> matrix2 = new Matrix3x3<>(new String[]{null, "B", "C", "D", null, "F", "G", "H", null});
            
            assertEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should handle null elements in hashCode")
        void test_hash_code_with_nulls() {
            Matrix3x3<String> matrix1 = new Matrix3x3<>(new String[]{null, "B", "C", "D", null, "F", "G", "H", null});
            Matrix3x3<String> matrix2 = new Matrix3x3<>(new String[]{null, "B", "C", "D", null, "F", "G", "H", null});
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
    }
    
    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {
        @Test
        @DisplayName("Should produce correct string format")
        void test_to_string_format() {
            Matrix3x3<String> matrix = new Matrix3x3<>(new String[]{"#", "_", "@", "$", "%", "^", "&", "*", "!"});
            String result = matrix.toString();
            
            assertTrue(result.contains("Matrix<>[3x3]"));
            assertTrue(result.contains("#"));
            assertTrue(result.contains("_"));
            assertTrue(result.contains("@"));
            assertTrue(result.contains("$"));
            assertTrue(result.contains("%"));
            assertTrue(result.contains("^"));
            assertTrue(result.contains("&"));
            assertTrue(result.contains("*"));
            assertTrue(result.contains("!"));
        }
        
        @Test
        @DisplayName("Should handle null elements in toString")
        void test_to_string_with_nulls() {
            Matrix3x3<String> matrix = new Matrix3x3<>(new String[]{"A", null, "C", null, "E", null, "G", null, "I"});
            String result = matrix.toString();
            
            assertTrue(result.contains("A"));
            assertTrue(result.contains("null"));
            assertTrue(result.contains("C"));
        }
        
        @Test
        @DisplayName("Should show correct size in toString")
        void test_to_string_shows_size() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            String result = matrix.toString();
            
            assertTrue(result.contains("3x3"));
        }
        
        @Test
        @DisplayName("Should match expected format exactly")
        void test_exact_format() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            String result = matrix.toString();
            
            assertEquals("Matrix<>[3x3]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}", result);
        }
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCaseTests {
        @Test
        @DisplayName("Should handle all null matrix")
        void test_all_nulls() {
            Matrix3x3<String> matrix = new Matrix3x3<>();
            
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    assertNull(matrix.get(row, col));
                }
            }
        }
        
        @Test
        @DisplayName("Should verify size is always 3")
        void test_size_constant() {
            Matrix3x3<Integer> matrix1 = new Matrix3x3<>();
            Matrix3x3<Integer> matrix2 = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            Matrix3x3<Integer> matrix3 = new Matrix3x3<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            
            assertEquals(3, matrix1.size());
            assertEquals(3, matrix2.size());
            assertEquals(3, matrix3.size());
        }
        
        @Test
        @DisplayName("Should handle modification after construction")
        void test_modification() {
            Matrix3x3<Integer> matrix = new Matrix3x3<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
            
            matrix.set(0, 0, 99);
            matrix.set(1, 1, 88);
            matrix.set(2, 2, 77);
            
            assertEquals(99, matrix.get(0, 0));
            assertEquals(88, matrix.get(1, 1));
            assertEquals(77, matrix.get(2, 2));
            assertEquals(2, matrix.get(0, 1));
        }
        
        @Test
        @DisplayName("Should handle corner and center elements")
        void test_corners_and_center() {
            Matrix3x3<String> matrix = new Matrix3x3<>();
            
            matrix.set(0, 0, "TL");  // Top-left
            matrix.set(0, 2, "TR");  // Top-right
            matrix.set(1, 1, "C");   // Center
            matrix.set(2, 0, "BL");  // Bottom-left
            matrix.set(2, 2, "BR");  // Bottom-right
            
            assertEquals("TL", matrix.get(0, 0));
            assertEquals("TR", matrix.get(0, 2));
            assertEquals("C", matrix.get(1, 1));
            assertEquals("BL", matrix.get(2, 0));
            assertEquals("BR", matrix.get(2, 2));
        }
    }
}