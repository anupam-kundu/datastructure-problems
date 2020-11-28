package com.ds.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Build max heap operation using array
 *  1. Insertion O(log(n))
 *  2. Delete Element O(log(n))
 *  3. get Max element O(1)
 *
 */
public class BuildHeap {

    private List<Integer> maxHeap;

    public BuildHeap() {
        maxHeap = new ArrayList<>();
    }

    public BuildHeap(int size) {
        maxHeap = new ArrayList<>(size);
    }

    public void insert(int item) {
        maxHeap.add(item);
        reheap(maxHeap.size() - 1);
    }

    public int delete() {
        if (maxHeap.isEmpty()) {
            throw new RuntimeException("no element present");
        }
        int item = maxHeap.get(0);
        swap(0, maxHeap.size() - 1);
        maxHeap.remove(maxHeap.size() - 1);
        prelocateDown(0);
        return item;
    }

    private void reheap(int location) {

        for (int parent = getParent(location); parent >= 0
                && location > 0; location = parent, parent = getParent(location)) {
            if (maxHeap.get(location) > maxHeap.get(parent)) {
                swap(parent, location);
            }
        }
    }

    private void prelocateDown(int location) {
        int leftChild = 2 * location + 1, rightChild = 2 * location + 2;
        int parent = location;
        while (leftChild < maxHeap.size() && rightChild < maxHeap.size()) {
            if (maxHeap.get(leftChild) > maxHeap.get(rightChild)) {
                if (maxHeap.get(parent) > maxHeap.get(leftChild))
                    break;
                swap(parent, leftChild);
                parent = leftChild;
            } else {
                if (maxHeap.get(parent) > maxHeap.get(rightChild))
                    break;
                swap(parent, rightChild);
                parent = rightChild;
            }
            leftChild = 2 * parent + 1;
            rightChild = 2 * parent + 2;
        }
        if (leftChild < maxHeap.size() && maxHeap.get(parent) < maxHeap.get(leftChild)) {
            swap(parent, leftChild);
        }

    }

    // child (2*i+1) & (2*i+2) = parent
    private int getParent(int location) {
        return (location - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, temp);
    }

    public void print() {
        System.out.println();
        maxHeap.forEach(System.out::print);
    }

    public int getMaxElement() {
        return maxHeap.get(0);
    }

    public static void main(String[] args) {
        BuildHeap buildHeap = new BuildHeap();
        for (int i = 10; i < 100; i += 10) {
            buildHeap.insert(i);
            buildHeap.print();
        }
        while (buildHeap.maxHeap.size() > 0) {
            System.out.println();
            System.out.println("deleted : " + buildHeap.delete());
            buildHeap.print();
        }
    }

}
