package com.ds.tree;

public class LeastCommonAncestor {

    private BinaryTreeNode<Integer> getCommonAncestor(BinaryTreeNode<Integer> root,
                                                      BinaryTreeNode<Integer> n1,
                                                      BinaryTreeNode<Integer> n2) {
        if (root == null || root.getData() == n1.getData() || root.getData() == n2.getData()) {
            return root;
        }
        BinaryTreeNode<Integer> leftSide = getCommonAncestor(root.getLeft(), n1, n2);
        BinaryTreeNode<Integer> rightSide = getCommonAncestor(root.getRight(), n1, n2);
        if (leftSide != null && rightSide != null) {
            return root;
        }
        return leftSide != null ? leftSide : rightSide;
    }

    public static void main(String[] args) {
        LeastCommonAncestor ancestor = new LeastCommonAncestor();
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);

        System.out.println(ancestor.getCommonAncestor(n1, n4, n7));
    }


}
