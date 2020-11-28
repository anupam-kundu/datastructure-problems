package com.ds.tree;

/*
 * Two nodes of bst are swapped, find out the swapped node. and Rectify
 */
public class AnomalyInBST {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(50);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(30);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(40);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(20);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(60);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(70);
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setRight(n7);
		System.out.println("BST : " + isBST(Integer.MIN_VALUE, n1, Integer.MAX_VALUE));
		findAnomaly(n1);
		if (first != null && last != null) {
			int temp = first.getData();
			first.setData(last.getData());
			last.setData(temp);
		}
		System.out.println("BST : " + isBST(Integer.MIN_VALUE, n1, Integer.MAX_VALUE));
	}

	static BinaryTreeNode<Integer> first, last, prev;

	// inorder traversal
	public static void findAnomaly(BinaryTreeNode<Integer> root) {
		if(root != null) {
			findAnomaly(root.getLeft());
			if (prev != null && prev.getData() > root.getData()) { // here prev is inorder previous node , which should be
				// less
				if (first == null) { // happened first time
					first = prev;
					last = root;
				} else {
					last = root;
				}
			}
			prev = root;
			findAnomaly(root.getRight());
		}
	}

	public static boolean isBST(int left, BinaryTreeNode<Integer> root, int right) {
		if (root == null) {
			return true;
		}
		if (root.getData() < left || root.getData() > right) {
			return false;
		}
		return isBST(left, root.getLeft(), root.getData()) && isBST(root.getData(), root.getRight(), right);
	}

}
