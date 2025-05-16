package com.ds.graph;

/**
 * 1. detect cycle in tree (DFS and check if from descendants any pointer present to parent)
 * 2. detect cycle in graph (Topological sort [order != no of vertex] )
 *
 * NODE (ready, wait, done)
 *
 * 1. while DFS done/wait node is referred again
 * 2. Topological sort can detect cycle in DAG
 *
 */
public class CycleDetection {
}
