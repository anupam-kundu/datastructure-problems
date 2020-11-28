package com.ds.tree;

public class DeleteNodeInBST {

    private static BinaryTreeNode<Integer> deleteNodeBST(BinaryTreeNode<Integer> root, int key) {
        if (root == null) {
            System.out.println(" Key not found in the BST !");
            return null;
        }
        if (key < root.getData()) {
            root.setLeft(deleteNodeBST(root.getLeft(), key));
        } else if (key > root.getData()) {
            root.setRight(deleteNodeBST(root.getRight(), key));
        } else {
            // found the element
            if (root.getLeft() != null && root.getRight() != null) { // both child
                BinaryTreeNode<Integer> leftMaxNode = findMax(root.getLeft());
                root.setData(leftMaxNode.getData());
                root.setLeft(deleteNodeBST(leftMaxNode, leftMaxNode.getData()));
            } else if (root.getLeft() != null || root.getRight() != null) { // single child
                root = root.getLeft() == null ? root.getRight() : root.getLeft();
            } else { // leaf node
                return null;
            }
        }
        return root;
    }

    private static BinaryTreeNode<Integer> findMax(BinaryTreeNode<Integer> root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

}
