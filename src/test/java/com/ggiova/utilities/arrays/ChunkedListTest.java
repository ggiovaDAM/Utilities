package com.ggiova.utilities.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link ChunkedList}
 */
public class ChunkedListTest {
    @Test
    void length_reading_when_empty() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        assertEquals(0, integerChunkedList.length());
    }
    
    @Test
    void chunk_count_when_empty() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        assertEquals(1, integerChunkedList.chunkCount());
    }
    
    @Test
    void length_reading_after_adding() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        integerChunkedList.add(1);
        assertEquals(1, integerChunkedList.length());
    }
    
    @Test
    void chunk_count_after_adding() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        integerChunkedList.add(1);
        assertEquals(1, integerChunkedList.chunkCount());
    }
    
    @Test
    void length_reading_after_adding_17_elements() {
        final int TOTAL_TO_ADD = 17;
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        for (int ii = 0; ii < TOTAL_TO_ADD; ii++) {
            integerChunkedList.add(ii);
        }
        assertEquals(TOTAL_TO_ADD, integerChunkedList.length());
    }
    
    @Test
    void chunk_count_after_adding_17_elements() {
        final int TOTAL_TO_ADD = 17;
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        for (int ii = 0; ii < TOTAL_TO_ADD; ii++) {
            integerChunkedList.add(ii);
        }
        assertEquals(2, integerChunkedList.chunkCount());
    }
    
    @Test
    void value_test_after_getting_from_index() {
        final String EXPECTED = "EXPECTED VALUE";
        ChunkedList<String> stringChunkedList = new ChunkedList<>();
        stringChunkedList.add(EXPECTED);
        String result = stringChunkedList.get(0);
        assertEquals(EXPECTED, result);
    }
    
    @Test
    void value_test_out_of_bounds() {
        final int INDEX = 999;
        ChunkedList<String> stringChunkedList = new ChunkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> stringChunkedList.get(INDEX));
    }
    
    @Test
    void value_test_out_of_bounds_edge() {
        final int INDEX = 0;
        ChunkedList<String> stringChunkedList = new ChunkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> stringChunkedList.get(INDEX));
    }
    
    @Test
    void value_test_out_of_bounds_negative() {
        final int INDEX = -10;
        ChunkedList<String> stringChunkedList = new ChunkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> stringChunkedList.get(INDEX));
    }
    
    @Test
    void length_reading_after_subtracting_from_index_after_adding() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        integerChunkedList.add(1);
        integerChunkedList.remove(0);
        assertEquals(0, integerChunkedList.length());
    }
    
    @Test
    void chunk_count_after_subtracting_from_index_after_adding() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        integerChunkedList.add(1);
        integerChunkedList.remove(0);
        assertEquals(1, integerChunkedList.chunkCount());
    }
    
    @Test
    void length_reading_after_adding_1_after_removing_1() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        integerChunkedList.add(1);
        integerChunkedList.remove(0);
        integerChunkedList.add(2);
        assertEquals(1, integerChunkedList.length);
    }
    
    @Test
    void remove_shifts_elements_left() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        
        integerChunkedList.add(1);
        integerChunkedList.add(2);
        integerChunkedList.add(3);
        
        integerChunkedList.remove(1);
        
        assertEquals(2, integerChunkedList.length());
        assertEquals(3, integerChunkedList.get(1));
    }
    
    @Test
    void remove_element_from_middle_chunk() {
        ChunkedList<Integer> integerChunkedList = new ChunkedList<>();
        
        for (int i = 0; i < 20; i++) {
            integerChunkedList.add(i);
        }
        
        integerChunkedList.remove(10);
        
        assertEquals(19, integerChunkedList.length());
        assertEquals(11, integerChunkedList.get(10));
    }
    
    
    @Nested
    @DisplayName("Getters")
    class GetTests {
        @Nested
        @DisplayName("First")
        class GetFirstTests {
            @Test
            void get_first() {
                String firstElement = "First element";
                ChunkedList<String> stringChunkedList = new ChunkedList<>();
                stringChunkedList.add(firstElement);
                assertEquals(firstElement, stringChunkedList.getFirst());
            }
            
            @Test
            void get_first_exception() {
                ChunkedList<String> stringChunkedList = new ChunkedList<>();
                assertThrows(NoSuchElementException.class, stringChunkedList::getFirst);
            }
        }
    }
}
