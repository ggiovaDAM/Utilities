package com.ggiova.utilities.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            
            @Test
            @DisplayName("Matrix with null row")
            void matrix_null_row() {
                Integer[][] matrix = {{1, 2}, null};
                assertThrows(NullPointerException.class, () -> new Matrix2x2<>(matrix));
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
    class GetSetTests {
        @Test
        @DisplayName("Should set and get elements correctly")
        void test_set_and_get() {
            Matrix2x2<String> matrix = new Matrix2x2<>();
            
            matrix.set(0, 0, "A");
            matrix.set(0, 1, "B");
            matrix.set(1, 0, "C");
            matrix.set(1, 1, "D");
            
            assertEquals("A", matrix.get(0, 0));
            assertEquals("B", matrix.get(0, 1));
            assertEquals("C", matrix.get(1, 0));
            assertEquals("D", matrix.get(1, 1));
        }
        
        @Test
        @DisplayName("Should throw exception for negative indices")
        void test_negative_indices() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(-1, 0));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, -1));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(-1, 0, 99));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(0, -1, 99));
        }
        
        @Test
        @DisplayName("Should throw exception for out of bounds indices")
        void test_out_of_bounds() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(2, 0));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, 2));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(2, 0, 99));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(0, 2, 99));
        }
        
        @Test
        @DisplayName("Should allow null values")
        void test_null_values() {
            Matrix2x2<String> matrix = new Matrix2x2<>("A", "B", "C", "D");
            matrix.set(0, 0, null);
            assertNull(matrix.get(0, 0));
            assertEquals("B", matrix.get(0, 1));
        }
        
        @Test
        @DisplayName("Should overwrite existing values")
        void test_overwrite() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            matrix.set(1, 1, 99);
            assertEquals(99, matrix.get(1, 1));
        }
    }
    
    @Nested
    @DisplayName("Conversion Tests")
    class ConversionTests {
        @Test
        @DisplayName("Should convert to array correctly")
        void test_to_array() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            Object[] array = matrix.toArray();
            
            assertEquals(4, array.length);
            assertArrayEquals(new Object[]{1, 2, 3, 4}, array);
        }
        
        @Test
        @DisplayName("Should convert to list correctly")
        void test_to_list() {
            Matrix2x2<String> matrix = new Matrix2x2<>("A", "B", "C", "D");
            List<String> list = matrix.toList();
            
            assertEquals(4, list.size());
            assertEquals(List.of("A", "B", "C", "D"), list);
        }
        
        @Test
        @DisplayName("Should return immutable list")
        void test_list_is_immutable() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            List<Integer> list = matrix.toList();
            
            assertThrows(UnsupportedOperationException.class, () -> list.add(5));
        }
    }
    
    @Nested
    @DisplayName("Equals and HashCode Tests")
    class EqualsHashCodeTests {
        @Test
        @DisplayName("Should be equal to itself")
        void test_equals_reflexive() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            assertEquals(matrix, matrix);
        }
        
        @Test
        @DisplayName("Should be equal to matrix with same elements")
        void test_equals_with_same_elements() {
            Matrix2x2<Integer> matrix1 = new Matrix2x2<>(1, 2, 3, 4);
            Matrix2x2<Integer> matrix2 = new Matrix2x2<>(1, 2, 3, 4);
            
            assertEquals(matrix1, matrix2);
            assertEquals(matrix2, matrix1);
        }
        
        @Test
        @DisplayName("Should not be equal to matrix with different elements")
        void test_not_equals_different_elements() {
            Matrix2x2<Integer> matrix1 = new Matrix2x2<>(1, 2, 3, 4);
            Matrix2x2<Integer> matrix2 = new Matrix2x2<>(5, 6, 7, 8);
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should be equal to SquareMatrix with same elements")
        void test_equals_with_square_matrix() {
            Matrix2x2<Integer> matrix1 = new Matrix2x2<>(1, 2, 3, 4);
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4));
            
            assertEquals(matrix1, matrix2);
            assertEquals(matrix2, matrix1);
        }
        
        @Test
        @DisplayName("Should not be equal to SquareMatrix with different size")
        void test_not_equals_different_size() {
            Matrix2x2<Integer> matrix1 = new Matrix2x2<>(1, 2, 3, 4);
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(3);
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should not be equal to null")
        void test_not_equals_null() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            assertNotEquals(null, matrix);
        }
        
        @Test
        @DisplayName("Should not be equal to different type")
        void test_not_equals_different_type() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            assertNotEquals("not a matrix", matrix);
        }
        
        @Test
        @DisplayName("Should have same hashCode for equal matrices")
        void test_hash_code_consistency() {
            Matrix2x2<Integer> matrix1 = new Matrix2x2<>(1, 2, 3, 4);
            Matrix2x2<Integer> matrix2 = new Matrix2x2<>(1, 2, 3, 4);
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
        
        @Test
        @DisplayName("Should have same hashCode as SquareMatrix with same elements")
        void test_hash_code_with_square_matrix() {
            Matrix2x2<Integer> matrix1 = new Matrix2x2<>(1, 2, 3, 4);
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4));
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
        
        @Test
        @DisplayName("Should handle null elements in equals")
        void test_equals_with_nulls() {
            Matrix2x2<String> matrix1 = new Matrix2x2<>(null, "B", "C", null);
            Matrix2x2<String> matrix2 = new Matrix2x2<>(null, "B", "C", null);
            
            assertEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should handle null elements in hashCode")
        void test_hash_code_with_nulls() {
            Matrix2x2<String> matrix1 = new Matrix2x2<>(null, "B", "C", null);
            Matrix2x2<String> matrix2 = new Matrix2x2<>(null, "B", "C", null);
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
    }
    
    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {
        @Test
        @DisplayName("Should produce correct string format")
        void test_to_string_format() {
            Matrix2x2<String> matrix = new Matrix2x2<>("#", "_", "@", "$");
            String result = matrix.toString();
            
            assertTrue(result.contains("Matrix<>[2x2]"));
            assertTrue(result.contains("#"));
            assertTrue(result.contains("_"));
            assertTrue(result.contains("@"));
            assertTrue(result.contains("$"));
        }
        
        @Test
        @DisplayName("Should handle null elements in toString")
        void test_to_string_with_nulls() {
            Matrix2x2<String> matrix = new Matrix2x2<>("A", null, "C", null);
            String result = matrix.toString();
            
            assertTrue(result.contains("A"));
            assertTrue(result.contains("null"));
            assertTrue(result.contains("C"));
        }
        
        @Test
        @DisplayName("Should show correct size in toString")
        void test_to_string_shows_size() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            String result = matrix.toString();
            
            assertTrue(result.contains("2x2"));
        }
        
        @Test
        @DisplayName("Should match expected format exactly")
        void test_exact_format() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            String result = matrix.toString();
            
            assertEquals("Matrix<>[2x2]{{1, 2}, {3, 4}}", result);
        }
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCaseTests {
        @Test
        @DisplayName("Should handle all null matrix")
        void test_all_nulls() {
            Matrix2x2<String> matrix = new Matrix2x2<>();
            
            assertNull(matrix.get(0, 0));
            assertNull(matrix.get(0, 1));
            assertNull(matrix.get(1, 0));
            assertNull(matrix.get(1, 1));
        }
        
        @Test
        @DisplayName("Should handle mixed null and non-null")
        void test_mixed_nulls() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, null, null, 4);
            
            assertEquals(1, matrix.get(0, 0));
            assertNull(matrix.get(0, 1));
            assertNull(matrix.get(1, 0));
            assertEquals(4, matrix.get(1, 1));
        }
        
        @Test
        @DisplayName("Should verify size is always 2")
        void test_size_constant() {
            Matrix2x2<Integer> matrix1 = new Matrix2x2<>();
            Matrix2x2<Integer> matrix2 = new Matrix2x2<>(1, 2, 3, 4);
            Matrix2x2<Integer> matrix3 = new Matrix2x2<>(List.of(5, 6, 7, 8));
            
            assertEquals(2, matrix1.size());
            assertEquals(2, matrix2.size());
            assertEquals(2, matrix3.size());
        }
        
        @Test
        @DisplayName("Should handle modification after construction")
        void test_modification() {
            Matrix2x2<Integer> matrix = new Matrix2x2<>(1, 2, 3, 4);
            
            matrix.set(0, 0, 99);
            matrix.set(1, 1, 88);
            
            assertEquals(99, matrix.get(0, 0));
            assertEquals(2, matrix.get(0, 1));
            assertEquals(3, matrix.get(1, 0));
            assertEquals(88, matrix.get(1, 1));
        }
    }
}