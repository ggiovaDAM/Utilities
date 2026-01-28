/**
 * Provides graph data structure implementations.
 * <p>
 * This package contains various graph implementations for modeling relationships between vertices. Currently
 * supported:
 * <ul>
 *     <li>{@link com.ggiova.utilities.graph.DirectionalSimpleGraph}: A directed graph that stores vertices directly and
 *     supports basic graph operations</li>
 * </ul>
 * <p>
 * Example usage:
 * <pre>{@code
 * DirectionalSimpleGraph<String> graph = new DirectionalSimpleGraph<>();
 * graph.addVertex("A")
 *      .addVertex("B")
 *      .addVertex("C")
 *      .connect("A", "B")
 *      .connect("B", "C");
 *
 * boolean hasPath = graph.hasEdge("A", "B"); // true
 * Set<String> neighbors = graph.neighborsOf("B"); // contains "C"
 * }</pre>
 */
package com.ggiova.utilities.graph;