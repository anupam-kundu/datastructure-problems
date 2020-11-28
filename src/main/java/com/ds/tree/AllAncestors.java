package com.ds.tree;

/*
 * given a node print all its ancestor
 */

public class AllAncestors {

	private boolean isAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> key) {
		if (root == null) {
			return false;
		}
		if (root.getData() == key.getData() || isAncestor(root.getLeft(), key) || isAncestor(root.getRight(), key)) {
			System.out.println("Ancestor : " + root.getData());
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		AllAncestors ancestors = new AllAncestors();
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

		ancestors.isAncestor(n1, n7);
	}
}
