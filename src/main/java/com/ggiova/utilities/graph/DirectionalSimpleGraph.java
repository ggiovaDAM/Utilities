package com.ggiova.utilities.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A directional simple graph implementation that stores vertices of type {@code T}.
 * <p>
 * This graph supports basic operations such as adding/removing vertices, connecting/disconnecting vertices with
 * directed edges, and querying the graph structure. All vertices must be non-null and are stored using their natural
 * equality.
 *
 * @param <T> the type of vertices in this graph
 */
public final class DirectionalSimpleGraph<T> {
    private final Map<T, Set<T>> adjacency;
    
    /**
     * Creates an empty graph.
     */
    public DirectionalSimpleGraph() {
        this.adjacency = new HashMap<>();
    }
    
    /**
     * Adds a given vertex to the graph. If the vertex already exists in the graph, this operation has no effect.
     *
     * @param vertex vertex to be added
     * @return {@code this}
     * @throws IllegalArgumentException if {@code vertex} is {@code null}
     */
    public DirectionalSimpleGraph<T> addVertex(T vertex) {
        if (vertex == null) throw new IllegalArgumentException("Vertex cannot be null!");
        if (adjacency.containsKey(vertex)) return this;
        adjacency.put(vertex, new HashSet<>());
        return this;
    }
    
    /**
     * Adds the given vertices to the graph if they don't exist, then creates a directed edge from {@code from} to
     * {@code to}.
     *
     * @param from origin vertex
     * @param to   destination vertex
     * @return {@code this}
     * @throws IllegalArgumentException if {@code from} or {@code to} are {@code null}
     */
    public DirectionalSimpleGraph<T> addAndConnect(T from, T to) {
        if (from == null) throw new IllegalArgumentException("Vertex 'from' cannot be null!");
        if (to   == null) throw new IllegalArgumentException("Vertex 'to' cannot be null!");
        
        addVertex(from);
        addVertex(to);
        adjacency.get(from).add(to);
        
        return this;
    }
    
    /**
     * Removes the given vertex from the graph and all edges connected to it. This includes both outgoing edges from
     * this vertex and incoming edges to this vertex. If the vertex does not exist in the graph, this operation has no
     * effect.
     *
     * @param vertex vertex to be removed from the graph
     * @return {@code this}
     * @throws IllegalArgumentException if {@code vertex} is {@code null}
     */
    public DirectionalSimpleGraph<T> removeVertex(T vertex) {
        if (vertex == null) throw new IllegalArgumentException("Vertex 'vertex' cannot be null!");
        if (! adjacency.containsKey(vertex)) return this;
        adjacency.remove(vertex);
        adjacency.forEach((_, neighbours) -> neighbours.remove(vertex));
        return this;
    }
    
    /**
     * Connects two vertices with a directed edge from {@code from} to {@code to}. If the edge already exists, this
     * operation has no effect.
     *
     * @param from origin vertex
     * @param to   destination vertex
     * @return {@code this}
     * @throws IllegalArgumentException if {@code from} or {@code to} are {@code null}, or if either vertex is not in
     *                                  the graph
     */
    public DirectionalSimpleGraph<T> connect(T from, T to) {
        if (from == null) throw new IllegalArgumentException("Vertex 'from' cannot be null!");
        if (to   == null) throw new IllegalArgumentException("Vertex 'to' cannot be null!");
        if (! adjacency.containsKey(from)) throw new IllegalArgumentException("Vertex 'from' is not in this graph!");
        if (! adjacency.containsKey(to  )) throw new IllegalArgumentException("Vertex 'to' is not in this graph!");
        adjacency.get(from).add(to);
        return this;
    }
    
    /**
     * Removes a directed edge from {@code from} to {@code to}.
     * If the edge does not exist, this operation has no effect.
     *
     * @param from origin vertex
     * @param to   destination vertex
     * @return {@code this}
     * @throws IllegalArgumentException if {@code from} or {@code to} are {@code null}, or if either vertex is not in
     *                                  the graph
     */
    public DirectionalSimpleGraph<T> disconnect(T from, T to) {
        if (from == null) throw new IllegalArgumentException("Vertex 'from' cannot be null!");
        if (to   == null) throw new IllegalArgumentException("Vertex 'to' cannot be null!");
        if (! adjacency.containsKey(from)) throw new IllegalArgumentException("Vertex 'from' is not in this graph!");
        if (! adjacency.containsKey(to  )) throw new IllegalArgumentException("Vertex 'to' is not in this graph!");
        
        adjacency.get(from).remove(to);
        return this;
    }
    
    /**
     * Checks whether the given vertex exists in the graph.
     *
     * @param vertex the vertex to check
     * @return {@code true} if the vertex exists in the graph, {@code false} otherwise
     * @throws IllegalArgumentException if {@code vertex} is {@code null}
     */
    public boolean hasVertex(T vertex) {
        if (vertex == null) throw new IllegalArgumentException("Vertex 'vertex' cannot be null!");
        return adjacency.containsKey(vertex);
    }
    
    /**
     * Checks whether a directed edge exists from {@code from} to {@code to}.
     *
     * @param from origin vertex
     * @param to   destination vertex
     * @return {@code true} if an edge exists from {@code from} to {@code to}, {@code false} otherwise
     * @throws IllegalArgumentException if {@code from} or {@code to} are {@code null}, or if either vertex is not in
     *                                  the graph
     */
    public boolean hasEdge(T from, T to) {
        if (from == null) throw new IllegalArgumentException("Vertex 'from' cannot be null!");
        if (to   == null) throw new IllegalArgumentException("Vertex 'to' cannot be null!");
        if (! adjacency.containsKey(from)) throw new IllegalArgumentException("Vertex 'from' is not in this graph!");
        if (! adjacency.containsKey(to  )) throw new IllegalArgumentException("Vertex 'to' is not in this graph!");
        
        return adjacency.get(from).contains(to);
    }
    
    /**
     * Returns an unmodifiable set of all vertices in the graph.
     *
     * @return an unmodifiable set containing all vertices
     */
    public Set<T> vertices() {
        return Set.copyOf(adjacency.keySet());
    }
    
    /**
     * Returns an unmodifiable set of all neighbors of the given vertex. Neighbors are vertices that have a directed
     * edge from {@code vertex} to them. If the vertex does not exist in the graph, returns an empty set.
     *
     * @param vertex the vertex whose neighbors to retrieve
     * @return an unmodifiable set containing all neighbors of {@code vertex}
     * @throws IllegalArgumentException if {@code vertex} is {@code null}
     */
    public Set<T> neighborsOf(T vertex) {
        if (vertex == null) throw new IllegalArgumentException("Vertex 'vertex' cannot be null!");
        return Set.copyOf(adjacency.getOrDefault(vertex, Set.of()));
    }
}
