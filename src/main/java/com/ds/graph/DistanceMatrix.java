package com.ds.graph;

import java.util.ArrayList;
import java.util.List;


public class DistanceMatrix {

    static class Vertex implements Comparable<Vertex> { // as we want to put this
// vertex into priority
// queue

        private String lebel;
        private int index;

        public String getLebel() {
            return lebel;
        }

        public void setLebel(String lebel) {
            this.lebel = lebel;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + index;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (index != other.index)
                return false;
            return true;
        }

        @Override
        public int compareTo(Vertex o) {
            return DistanceMatrix.getInstance().getDistance(this).compareTo(DistanceMatrix.getInstance().getDistance(o));
        }

        @Override
        public String toString() {
            return "Vertex [ " + lebel + " ]";
        }

    }

    private static final DistanceMatrix INSTANCE = new DistanceMatrix();

    public static DistanceMatrix getInstance() {
        return INSTANCE;
    }

    private class Element {

        public Element(Vertex currVtx, Integer distance, Vertex prevVtx) {
            super();
            this.currVtx = currVtx;
            this.distance = distance;
            this.prevVtx = prevVtx;
        }

        Vertex currVtx;
        Integer distance;
        Vertex prevVtx;
    }

    private List<Element> lstVtx;

    private DistanceMatrix() {
        lstVtx = new ArrayList<>();
    }

    public void addNewEntry(Vertex v) {
        lstVtx.add(v.getIndex(), new Element(v, -1, null));
    }

    public Integer getDistance(Vertex v) {
        return lstVtx.get(v.getIndex()).distance;
    }

    public Vertex getPrevVtx(Vertex v) {
        return lstVtx.get(v.getIndex()).prevVtx;
    }

    public void setDistance(Vertex v, Integer w) {
        lstVtx.get(v.getIndex()).distance = w;
    }

    public void setPrevVtx(Vertex v, Vertex prev) {
        lstVtx.get(v.getIndex()).prevVtx = prev;
    }

    public List<Vertex> getVertexList() {
        List<Vertex> tempList = new ArrayList<>();
        lstVtx.forEach((e) -> tempList.add(e.currVtx));
        return tempList;
    }

    public Vertex getVertexFromIndex(int index) {
        return lstVtx.get(index).currVtx;
    }

}
