package com.ggiova.utilities.arrays;

/**
 * A Linked List that contains equally sized arrays of 16 spaces each. Hybrid between an {@code ArrayList<E>} and a
 * {@code LinkedList<E>}.
 *
 * @param <E> the type of elements in this list
 */
public final class ChunkedList<E> {
    static final int CHUNK_EXP = 4;
    
    static final int CHUNK_SIZE = 1 << CHUNK_EXP;
    
    transient int length = 0;
    
    transient int chunks;
    
    transient int capacity;
    
    transient Chunk<E> first;
    
    /**
     * Creates a new empty ChunkedList. By default, it has one empty chunk.
     */
    public ChunkedList() {
        this.first = new Chunk<>();
        this.chunks = 1;
        this.capacity = CHUNK_SIZE;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ChunkedList[");
        sb.append(this.length).append("](");
        Chunk<E> chunk = this.first;
        for (int ii = 0; ii < this.chunks; ii++) {
            sb.append("\n    C").append(ii + 1).append(chunk);
            if (ii < this.chunks - 1) sb.append(',');
            chunk = chunk.next;
        }
        return sb.append("\n)").toString();
    }
    
    private void verifyBounds(int index) throws IndexOutOfBoundsException {
        if (index <  0          ) throw new IndexOutOfBoundsException("Index " + index + " too small.");
        if (index >= this.length) throw new IndexOutOfBoundsException("Index " + index + " too big.");
    }
    
    @SuppressWarnings("unchecked")
    private E getUnchecked(int chunk, int subIndex) {
        Chunk<E> current = getChunk(chunk);
        return (E) current.item[subIndex];
    }
    
    private Chunk<E> getChunk(int chunk) {
        int loop = chunk - 1;
        Chunk<E> current = this.first;
        int ii = 0;
        while (ii <= loop) {
            current = current.next;
            ii++;
        }
        return current;
    }
    
    private Chunk<E> getFirstNonEmptyChunk() {
        Chunk<E> current = this.first;
        while (!current.hasAvailable()) {
            if (current.next == null) {
                return addChunk();
            } else current = current.next;
        }
        return current;
    }
    
    private Chunk<E> addChunk() {
        Chunk<E> newLast = new Chunk<>();
        Chunk<E> chunk = this.first;
        while (chunk.hasNext()) chunk = chunk.next;
        chunk.next = newLast;
        this.chunks++;
        this.capacity += CHUNK_SIZE;
        return newLast;
    }
    
    private void removeEmptyChunks() {
        if (this.chunks == 1) return;
        int lastChunk = 1;
        Chunk<E> current = this.first;
        for (; current.hasNext(); lastChunk++) {
            if (current.next.isEmpty()) {
                current.next = null;
                break;
            } else current = current.next;
        }
        this.chunks = lastChunk;
    }
    
    /**
     * Returns the total length of the ChunkList
     *
     * @return the total length of the ChunkedList
     */
    public int length() {
        return this.length;
    }
    
    /**
     * Returns the amount of chunks in the ChunkList
     *
     * @return the amount of chunks in the ChunkedList
     */
    public int chunkCount() {
        return this.chunks;
    }
    
    /**
     * Returns the element at the given {@code index}. Throws {@code IndexOutOfBoundsException} if out of bounds.
     *
     * @param index position of the element needed.
     * @return the object at position {@code index}.
     * @throws IndexOutOfBoundsException if {@code index} is out of bounds.
     */
    public E get(int index) throws IndexOutOfBoundsException {
        verifyBounds(index);
        
        final int chunk = index / CHUNK_SIZE;
        final int subIndex = index % CHUNK_SIZE;
        
        return getUnchecked(chunk, subIndex);
    }
    
    /**
     * Adds an element to the end of the list.
     *
     * @param element Element to be added.
     */
    public void add(E element) {
        Chunk<E> nonEmpty = this.getFirstNonEmptyChunk();
        nonEmpty.item[nonEmpty.used] = element;
        nonEmpty.used++;
        this.length++;
    }
    
    /**
     * Removes an element at {@code index}, shifts the rest of the chunks' values.
     *
     * @param index position of the element to be removed.
     * @return the removed object.
     * @throws IndexOutOfBoundsException if {@code index} is out of bounds.
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        verifyBounds(index);
        
        final int chunk = index / CHUNK_SIZE;
        final int subIndex = index % CHUNK_SIZE;
        
        E chosen = getUnchecked(chunk, subIndex);
        Chunk<E> current = getChunk(chunk);
        
        current.shiftLeft(subIndex);
        while (current.hasNext()) {
            if (!current.next.isEmpty()) {
                current.item[CHUNK_SIZE - 1] = current.next.item[0];
                current.used++;
                current.next.shiftLeft();
                current = current.next;
            } else break;
        }
        
        removeEmptyChunks();
        
        this.length--;
        return chosen;
    }
    
    private static class Chunk<E> {
        Object[] item;
        
        int used;
        
        Chunk<E> next;
        
        Chunk() {
            this(new Object[CHUNK_SIZE], null, 0);
        }
        
        Chunk(Object[] arr) {
            this(arr, null, arr.length);
        }
        
        Chunk(Object[] arr, Chunk<E> next, int used) {
            this.item = arr;
            this.next = next;
            this.used = used;
        }
        
        boolean hasNext() {
            return this.next != null;
        }
        
        boolean hasAvailable() {
            return this.used != CHUNK_SIZE;
        }
        
        boolean isEmpty() {
            return this.used == 0;
        }
        
        void shiftLeft() {
            shiftLeft(0);
        }
        
        void shiftLeft(int start) {
            this.used--;
            for (int ii = start; ii < this.used; ii++)
                this.item[ii] = this.item[ii + 1];
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[').append(this.used).append("]{");
            for (int ii = 0; ii < this.used; ii++) {
                sb.append(this.item[ii]);
                if (ii < this.used - 1) sb.append(", ");
            }
            return sb.append('}').toString();
        }
    }
}
