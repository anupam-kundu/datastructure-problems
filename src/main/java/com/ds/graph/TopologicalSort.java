package com.ds.graph;

/*
 *
 * Callculating inDegree
 *
 */

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    static class Vertex {
        final int index;
        final String label;
        int inDegree;
        int topologicalSortIdx;
    }

    private GraphAdjMtx graph;
    private List<Vertex> lstVertex;

    private void topologicalSort() {
        calculateInDegree();
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex v : lstVertex) {
            if (v.getInDegree() == 0) {
                queue.offer(v);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            v.setTopologicalSortIdx(count++);
            for (int i = 0; i < graph.getVertexCount(); i++) {
                if(graph.isEdge(v.getIndex(),i)){
                    Vertex childNode = lstVertex.get(i);
                    childNode.setInDegree(childNode.getInDegree() - 1);
                    if(childNode.getInDegree() == 0){
                        queue.offer(childNode);
                    }
                }
            }
        }
        
        if(count != graph.getVertexCount()) {
            System.out.println(" graph has a cycle !");
        }
        
    }

    private void calculateInDegree() {
        for (Vertex v : lstVertex) {
            int destIdx = v.getIndex();
            for (int i = 0; i < graph.getVertexCount(); i++) {
                if (graph.isEdge(i, destIdx)) {
                    v.setInDegree(v.getInDegree() + 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        List<Vertex> lstVertexs = new ArrayList<>();
        lstVertexs.add(0, new Vertex(0, "A"));
        lstVertexs.add(1, new Vertex(1, "B"));
        lstVertexs.add(2, new Vertex(2, "C"));
        lstVertexs.add(3, new Vertex(3, "D"));
        lstVertexs.add(4, new Vertex(4, "E"));
        lstVertexs.add(5, new Vertex(5, "F"));
        lstVertexs.add(6, new Vertex(6, "G"));
        lstVertexs.add(7, new Vertex(7, "H"));

        GraphAdjMtx graphAdjMtx = new GraphAdjMtx(8, true);

        graphAdjMtx.addEdge(0, 1);
        graphAdjMtx.addEdge(1, 2);
        graphAdjMtx.addEdge(2, 3);
        graphAdjMtx.addEdge(1, 7);
        graphAdjMtx.addEdge(2, 4);

        graphAdjMtx.addEdge(7, 4);
        graphAdjMtx.addEdge(5, 4);
        graphAdjMtx.addEdge(6, 4);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.lstVertex = lstVertexs;
        topologicalSort.graph = graphAdjMtx;

        System.out.println("Before Sort : ");
        topologicalSort.lstVertex.forEach(System.out::println);
        topologicalSort.topologicalSort();

        System.out.println("After Sort : ");
        topologicalSort.lstVertex.forEach(System.out::println);
    }
}
