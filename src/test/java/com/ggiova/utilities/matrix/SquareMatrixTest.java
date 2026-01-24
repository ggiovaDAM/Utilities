package com.ggiova.utilities.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link SquareMatrix}.
 */
class SquareMatrixTest {
    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {
        @Test
        @DisplayName("Should create empty matrix with valid size")
        void testConstructorWithSize() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
            assertEquals(3, matrix.size());
            assertNull(matrix.get(0, 0));
            assertNull(matrix.get(2, 2));
        }
        
        @Test
        @DisplayName("Should throw exception for size less than 1")
        void testConstructorWithInvalidSize() {
            assertThrows(IllegalArgumentException.class, () -> new SquareMatrix<>(0));
            assertThrows(IllegalArgumentException.class, () -> new SquareMatrix<>(-1));
        }
        
        @Test
        @DisplayName("Should create matrix from list")
        void testConstructorWithList() {
            List<String> list = List.of("A", "B", "C", "D");
            SquareMatrix<String> matrix = new SquareMatrix<>(list);
            
            assertEquals(2, matrix.size());
            assertEquals("A", matrix.get(0, 0));
            assertEquals("B", matrix.get(0, 1));
            assertEquals("C", matrix.get(1, 0));
            assertEquals("D", matrix.get(1, 1));
        }
        
        @Test
        @DisplayName("Should throw exception for null list")
        void testConstructorWithNullList() {
            assertThrows(NullPointerException.class, () -> new SquareMatrix<>((List<Integer>) null));
        }
        
        @Test
        @DisplayName("Should throw exception for non-square list size")
        void testConstructorWithNonSquareList() {
            List<Integer> list = List.of(1, 2, 3);
            assertThrows(IllegalArgumentException.class, () -> new SquareMatrix<>(list));
        }
        
        @Test
        @DisplayName("Should create matrix from array")
        void testConstructorWithArray() {
            Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            SquareMatrix<Integer> matrix = new SquareMatrix<>(array);
            
            assertEquals(3, matrix.size());
            assertEquals(1, matrix.get(0, 0));
            assertEquals(5, matrix.get(1, 1));
            assertEquals(9, matrix.get(2, 2));
        }
        
        @Test
        @DisplayName("Should throw exception for null array")
        void testConstructorWithNullArray() {
            assertThrows(NullPointerException.class, () -> new SquareMatrix<>((Integer[]) null));
        }
        
        @Test
        @DisplayName("Should throw exception for non-square array size")
        void testConstructorWithNonSquareArray() {
            Integer[] array = {1, 2, 3, 4, 5};
            assertThrows(IllegalArgumentException.class, () -> new SquareMatrix<>(array));
        }
        
        @Test
        @DisplayName("Should create matrix from 2D array")
        void testConstructorWith2DArray() {
            String[][] array = {
                    {"A", "B", "C"},
                    {"D", "E", "F"},
                    {"G", "H", "I"}
            };
            SquareMatrix<String> matrix = new SquareMatrix<>(array);
            
            assertEquals(3, matrix.size());
            assertEquals("A", matrix.get(0, 0));
            assertEquals("E", matrix.get(1, 1));
            assertEquals("I", matrix.get(2, 2));
        }
        
        @Test
        @DisplayName("Should throw exception for null 2D array")
        void testConstructorWithNull2DArray() {
            assertThrows(NullPointerException.class, () -> new SquareMatrix<>((Integer[][]) null));
        }
        
        @Test
        @DisplayName("Should throw exception for non-square 2D array")
        void testConstructorWithNonSquare2DArray() {
            Integer[][] array = {
                    {1, 2, 3},
                    {4, 5}
            };
            assertThrows(IllegalArgumentException.class, () -> new SquareMatrix<>(array));
        }
        
        @Test
        @DisplayName("Should throw exception for 2D array with null row")
        void testConstructorWith2DArrayNullRow() {
            Integer[][] array = {
                    {1, 2},
                    null
            };
            assertThrows(NullPointerException.class, () -> new SquareMatrix<>(array));
        }
    }
    
    @Nested
    @DisplayName("Get and Set Tests")
    class GetSetTests {
        @Test
        @DisplayName("Should set and get elements correctly")
        void testSetAndGet() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
            
            matrix.set(0, 0, 10);
            matrix.set(1, 1, 20);
            matrix.set(2, 2, 30);
            
            assertEquals(10, matrix.get(0, 0));
            assertEquals(20, matrix.get(1, 1));
            assertEquals(30, matrix.get(2, 2));
        }
        
        @Test
        @DisplayName("Should throw exception for negative row index")
        void testGetWithNegativeRow() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(-1, 0));
        }
        
        @Test
        @DisplayName("Should throw exception for negative column index")
        void testGetWithNegativeCol() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, -1));
        }
        
        @Test
        @DisplayName("Should throw exception for row index out of bounds")
        void testGetWithRowOutOfBounds() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(3, 0));
        }
        
        @Test
        @DisplayName("Should throw exception for column index out of bounds")
        void testGetWithColOutOfBounds() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.get(0, 3));
        }
        
        @Test
        @DisplayName("Should throw exception when setting out of bounds")
        void testSetOutOfBounds() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(2);
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(2, 0, 10));
            assertThrows(MatrixIndexOutOfBoundsException.class, () -> matrix.set(0, 2, 10));
        }
        
        @Test
        @DisplayName("Should allow null values")
        void testSetNull() {
            SquareMatrix<String> matrix = new SquareMatrix<>(2);
            matrix.set(0, 0, null);
            assertNull(matrix.get(0, 0));
        }
    }
    
    @Nested
    @DisplayName("Conversion Tests")
    class ConversionTests {
        @Test
        @DisplayName("Should convert to array correctly")
        void testToArray() {
            List<Integer> list = List.of(1, 2, 3, 4);
            SquareMatrix<Integer> matrix = new SquareMatrix<>(list);
            
            Object[] array = matrix.toArray();
            
            assertEquals(4, array.length);
            assertArrayEquals(new Object[]{1, 2, 3, 4}, array);
        }
        
        @Test
        @DisplayName("Should convert to list correctly")
        void testToList() {
            Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            SquareMatrix<Integer> matrix = new SquareMatrix<>(array);
            
            List<Integer> list = matrix.toList();
            
            assertEquals(9, list.size());
            assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), list);
        }
        
        @Test
        @DisplayName("Should return immutable list")
        void testToListIsImmutable() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(List.of(1, 2, 3, 4));
            List<Integer> list = matrix.toList();
            
            assertThrows(UnsupportedOperationException.class, () -> list.add(5));
        }
    }
    
    @Nested
    @DisplayName("Equals and HashCode Tests")
    class EqualsHashCodeTests {
        @Test
        @DisplayName("Should be equal to itself")
        void testEqualsReflexive() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(List.of(1, 2, 3, 4));
            assertEquals(matrix, matrix);
        }
        
        @Test
        @DisplayName("Should be equal to matrix with same elements")
        void testEqualsWithSameElements() {
            SquareMatrix<Integer> matrix1 = new SquareMatrix<>(List.of(1, 2, 3, 4));
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4));
            
            assertEquals(matrix1, matrix2);
            assertEquals(matrix2, matrix1);
        }
        
        @Test
        @DisplayName("Should not be equal to matrix with different elements")
        void testNotEqualsWithDifferentElements() {
            SquareMatrix<Integer> matrix1 = new SquareMatrix<>(List.of(1, 2, 3, 4));
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(5, 6, 7, 8));
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should not be equal to matrix with different size")
        void testNotEqualsWithDifferentSize() {
            SquareMatrix<Integer> matrix1 = new SquareMatrix<>(2);
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(3);
            
            assertNotEquals(matrix1, matrix2);
        }
        
        @Test
        @DisplayName("Should not be equal to null")
        void testNotEqualsToNull() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(2);
            assertNotEquals(null, matrix);
        }
        
        @Test
        @DisplayName("Should not be equal to different type")
        void testNotEqualsToDifferentType() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(2);
            assertNotEquals("not a matrix", matrix);
        }
        
        @Test
        @DisplayName("Should have same hashCode for equal matrices")
        void testHashCodeConsistency() {
            SquareMatrix<Integer> matrix1 = new SquareMatrix<>(List.of(1, 2, 3, 4));
            SquareMatrix<Integer> matrix2 = new SquareMatrix<>(List.of(1, 2, 3, 4));
            
            assertEquals(matrix1.hashCode(), matrix2.hashCode());
        }
        
        @Test
        @DisplayName("Should handle null elements in equals")
        void testEqualsWithNullElements() {
            SquareMatrix<String> matrix1 = new SquareMatrix<>(2);
            SquareMatrix<String> matrix2 = new SquareMatrix<>(2);
            
            matrix1.set(0, 0, null);
            matrix2.set(0, 0, null);
            
            assertEquals(matrix1, matrix2);
        }
    }
    
    @Nested
    @DisplayName("ToString Tests")
    class ToStringTests {
        @Test
        @DisplayName("Should produce correct string format")
        void testToString() {
            SquareMatrix<String> matrix = new SquareMatrix<>(List.of("#", "_", "@", "$"));
            String result = matrix.toString();
            
            assertTrue(result.contains("Matrix<>[2x2]"));
            assertTrue(result.contains("#"));
            assertTrue(result.contains("_"));
            assertTrue(result.contains("@"));
            assertTrue(result.contains("$"));
        }
        
        @Test
        @DisplayName("Should handle null elements in toString")
        void testToStringWithNull() {
            SquareMatrix<String> matrix = new SquareMatrix<>(2);
            matrix.set(0, 0, "A");
            
            String result = matrix.toString();
            assertTrue(result.contains("A"));
            assertTrue(result.contains("null"));
        }
        
        @Test
        @DisplayName("Should show correct size in toString")
        void testToStringSize() {
            SquareMatrix<Integer> matrix = new SquareMatrix<>(3);
            String result = matrix.toString();
            
            assertTrue(result.contains("3x3"));
        }
    }
    
    @Nested
    @DisplayName("Edge Cases")
    class EdgeCaseTests {
        @Test
        @DisplayName("Should handle 1x1 matrix")
        void testSingleElementMatrix() {
            SquareMatrix<String> matrix = new SquareMatrix<>(List.of("X"));
            
            assertEquals(1, matrix.size());
            assertEquals("X", matrix.get(0, 0));
        }
        
        @Test
        @DisplayName("Should handle large matrix")
        void testLargeMatrix() {
            final int SIZE = 100;
            final int INDEX = SIZE - 1;
            final int BIG = 9999;
            SquareMatrix<Integer> matrix = new SquareMatrix<>(SIZE);
            
            assertEquals(SIZE, matrix.size());
            matrix.set(INDEX, INDEX, BIG);
            assertEquals(BIG, matrix.get(INDEX, INDEX));
        }
        
        @Test
        @DisplayName("Should handle matrix with all null values")
        void testAllNullMatrix() {
            SquareMatrix<String> matrix = new SquareMatrix<>(2);
            
            assertNull(matrix.get(0, 0));
            assertNull(matrix.get(0, 1));
            assertNull(matrix.get(1, 0));
            assertNull(matrix.get(1, 1));
        }
    }
}