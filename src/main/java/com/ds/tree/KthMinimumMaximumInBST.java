package com.ds.tree;

public class KthMinimumMaximumInBST {

    private static int maxCount = 0;

    // search reverse inorder
    private static void printKthMax(BinaryTreeNode<Integer> root, int k) {
        if(root!=null){
            printKthMax(root.getRight(),k);
            if(++maxCount == k){
                System.out.println(root.getData());
            }
            printKthMax(root.getLeft(),k);
        }
    }

    private static int minCount = 0;

    // search forward inorder
    private static void printKthMin(BinaryTreeNode<Integer> root, int k) {
        if(root != null){
            printKthMin(root.getLeft(),k);
            if(++minCount == k){
                System.out.println(root.getData());
            }
            printKthMin(root.getRight(),k);
        }
    }

    private static void inorderRecursive(BinaryTreeNode<Integer> root) {
        if (root != null) {
            inorderRecursive(root.getLeft());
            System.out.println(root.getData());
            inorderRecursive(root.getRight());
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(30);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(40);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(35);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(45);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        System.out.println("inorder ");
        inorderRecursive(n1);
        System.out.println(" Kth Maximum : " );
        printKthMax(n1, 5);
        System.out.println(" Kth Minimum : " );
        printKthMin(n1, 2);

    }
}
