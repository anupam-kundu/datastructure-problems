package com.ds.graph;

public class GraphAdjMtx {

	private Integer[][] adjMatrix;
	private int vertexCount;
	private boolean isDirected;

	public GraphAdjMtx(int vtxCount) {
		this(vtxCount, false);
	}

	public GraphAdjMtx(int vtxCount, boolean isDirected) {
		vertexCount = vtxCount;
		adjMatrix = new Integer[vertexCount][vertexCount];
		this.isDirected = isDirected;
	}

	public void addEdge(int source, int destination) {
		this.addEdge(source, destination, 1);
	}

	public void addEdge(int source, int destination, int weight) {
		if (source >= 0 && source < vertexCount && destination >= 0 && destination < vertexCount) {
			adjMatrix[source][destination] = weight;
			if (!isDirected)
				adjMatrix[destination][source] = weight;
		}
	}

	public void removeEdge(int source, int destination) {
		if (source >= 0 && source < vertexCount && destination >= 0 && destination < vertexCount) {
			adjMatrix[source][destination] = null;
			if (!isDirected)
				adjMatrix[destination][source] = null;
		}
	}

	public boolean isEdge(int source, int destination) {
		if (source >= 0 && source < vertexCount && destination >= 0 && destination < vertexCount
				&& adjMatrix[source][destination] != null) {
			return true;
		}
		return false;
	}

	public Integer getEdge(int source, int destination) {
		if (source >= 0 && source < vertexCount && destination >= 0 && destination < vertexCount) {
			return adjMatrix[source][destination];
		}
		return null;
	}

	public int getVertexCount() {
		return vertexCount;
	}

}
