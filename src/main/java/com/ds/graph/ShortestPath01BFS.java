package com.ds.graph;


/**
 * 0-1 BFS (Shortest Path in a Binary Weight Graph)
 *
 * Given an undirected graph where every edge has a weight as either 0 or 1.
 * The task is to find the shortest path from the source vertex to all other vertices in the graph.
 *
 * [Naive Approach] Using Dijkstra Algorithm - O(E * log (V)) Time and O(V) Space
 *
 * [Expected Approach] Using Deque - O(V + E) time and O(V + E) space
 *
 *
 * Step by step approach:
 *
 * Initialize distances array with infinity for all vertices except source.
 * Use a deque to process vertices in order of increasing distance.
 * For each vertex, examine all adjacent vertices. If the new distance of vertex is less than current distance, then
 * If edge weight is 0, add adjacent vertex to front of deque (priority).
 * If edge weight is 1, add adjacent vertex to back of deque.
 *
 */
public class ShortestPath01BFS {
}
