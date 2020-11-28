package com.ds.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;


public class GraphTraverse {
	@Getter
	@Setter
	@EqualsAndHashCode
	@ToString
	static class Vertex {
		private int index;
		private String label;
		private boolean isVisited;

		public Vertex(int idx, String label) {
			this.index = idx;
			this.label = label;
			isVisited = false;
		}

	}

	private GraphAdjMtx graph;
	private Stack<Vertex> stk;
	private Queue<Vertex> queue;
	private List<Vertex> lstVertexs;

	public GraphTraverse(GraphAdjMtx graph, List<Vertex> lstVertexs) {
		this.graph = graph;
		stk = new Stack<>();
		queue = new LinkedList<>();
		this.lstVertexs = lstVertexs;
	}

	private void dfs() {
		Vertex startVtx = lstVertexs.get(0);
		startVtx.setVisited(true);
		stk.push(startVtx);
		while (!stk.isEmpty()) {
			Vertex temp = stk.pop();
			System.out.println("Processing : " + temp);
			int idx = lstVertexs.indexOf(temp);
			for (int i = 0; i < graph.getVertexCount(); i++) {
				if (graph.isEdge(idx, i) && !lstVertexs.get(i).isVisited()) {
					lstVertexs.get(i).setVisited(true);
					stk.push(lstVertexs.get(i));
				}
			}
		}
	}

	private void bfs() {
		Vertex startVtx = lstVertexs.get(0);
		startVtx.setVisited(true);
		queue.offer(startVtx);
		while (!queue.isEmpty()) {
			Vertex temp = queue.poll();
			System.out.println("Processing : " + temp);
			int idx = lstVertexs.indexOf(temp);
			for (int i = 0; i < graph.getVertexCount(); i++) {
				if (graph.isEdge(idx, i) && !lstVertexs.get(i).isVisited()) {
					lstVertexs.get(i).setVisited(true);
					queue.offer(lstVertexs.get(i));
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

		GraphAdjMtx graphAdjMtx = new GraphAdjMtx(8);

		graphAdjMtx.addEdge(0, 1);
		graphAdjMtx.addEdge(1, 2);
		graphAdjMtx.addEdge(2, 3);
		graphAdjMtx.addEdge(1, 7);
		graphAdjMtx.addEdge(2, 4);

		graphAdjMtx.addEdge(7, 4);
		graphAdjMtx.addEdge(5, 4);
		graphAdjMtx.addEdge(6, 4);

		GraphTraverse obj = new GraphTraverse(graphAdjMtx, lstVertexs);

		System.out.println("DFS   --------");
		obj.dfs();

		for (int i = 0; i < lstVertexs.size(); i++) {
			lstVertexs.get(i).setVisited(false);
		}
		System.out.println("BFS   --------");
		obj.bfs();
	}

}
