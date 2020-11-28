package com.ds.tree;

/**
 * 1. Convert sorted linked list to BST
 * 2. Convert sorted array to BST
 */
public class SortedListToBST {

    // call arrayToBST(a,0,a.length-1)
    private static BinaryTreeNode<Integer> arrayToBST(int[] a, int left, int right) {
        if (left > right) {
            return null;
        }
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>();
        int mid = left + (right - left) / 2;
        newNode.setData(a[mid]);
        newNode.setLeft(arrayToBST(a, left, mid - 1));
        newNode.setRight(arrayToBST(a, mid + 1, right));
        return newNode;
    }

    static class LLNode {
        int data;
        LLNode link;
    }

    // call listToBST(head, 0, len-1);
    private static BinaryTreeNode<Integer> listToBST(LLNode head, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        BinaryTreeNode<Integer> left = listToBST(head, start, mid - 1);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(head.data);
        root.setLeft(left);
        if (head.link != null) { // root is assigned to head , so moving head pointer to next element
            head.data = head.link.data;
            head.link = head.link.link;
        }
        root.setRight(listToBST(head, mid + 1, end));
        return root;
    }
}
