package com.ggiova.utilities.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DirectionalSimpleGraph<T> {
    private final Map<T, Set<T>> adjacency;
    
    public DirectionalSimpleGraph() {
        this.adjacency = new HashMap<>();
    }
    
    public DirectionalSimpleGraph<T> addVertex(T vertex) {
        if (vertex == null) throw new IllegalArgumentException("Vertex cannot be null!");
        if (adjacency.containsKey(vertex)) return this;
        adjacency.put(vertex, new HashSet<>());
        return this;
    }
    
    public DirectionalSimpleGraph<T> removeVertex(T vertex) {
        if (! adjacency.containsKey(vertex)) return this;
        adjacency.remove(vertex);
        adjacency.forEach((_, neighbours) -> neighbours.remove(vertex));
        return this;
    }
    
    public DirectionalSimpleGraph<T> connect(T from, T to) {
        if (! adjacency.containsKey(from)) throw new IllegalArgumentException("Vertex 'from' is not in this graph!");
        if (! adjacency.containsKey(to  )) throw new IllegalArgumentException("Vertex 'to' is not in this graph!");
        adjacency.get(from).add(to);
        return this;
    }
    
    public boolean hasVertex(T vertex) {
        return adjacency.containsKey(vertex);
    }
    
    public boolean hasEdge(T from, T to) {
        return adjacency.containsKey(from) &&
               adjacency.get(from).contains(to);
    }
    
    public Set<T> vertices() {
        return Set.copyOf(adjacency.keySet());
    }
    
    public Set<T> neighborsOf(T v) {
        return Set.copyOf(adjacency.getOrDefault(v, Set.of()));
    }
}
