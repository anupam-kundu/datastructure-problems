package com.ds.tree;

/**
 * Given a number and a BST
 * FloorExist, CeilingExist
 * FindFloor, FindCeiling
 */
public class FloorCeilingInBST {

    // search reverse inorder as we hv to find out maximum element which is lower than key
    private static void findFloor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> prev, int key) {
        if (root != null) {
            findFloor(root.getRight(), prev, key);
            if (prev != null && key <= prev.getData() && key > root.getData()) {
                System.out.println("Floor value of : " + key + " is : " + root.getData());
            }
            prev = root;
            findFloor(root.getLeft(), prev, key);
        }
    }

    // search inorder as we have to find out minimum element which is greater than key
    private static void findCeiling(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> prev, int key) {
        if (root != null) {
            findCeiling(root.getLeft(), prev, key);
            if (prev != null && key > prev.getData() && key <= root.getData()) {
                System.out.println("Ceiling value of : " + key + " is : " + root.getData());
            }
            prev = root;
            findCeiling(root.getRight(), prev, key);
        }
    }
}
