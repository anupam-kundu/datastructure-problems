package com.ds.tree;

import java.util.SortedMap;
import java.util.TreeMap;

/*
 * Top View
 * 
 * Left View
 * 
 * Bottom View
 * 
 * Right View
 * 
 */
public class BoundaryTraversalTree {

	SortedMap<Integer, BinaryTreeNode<Integer>> distanceNodeMap = new TreeMap<>();

	private void topView(BinaryTreeNode<Integer> root, Integer hDistance) {
		if (root == null) {
			return;
		}
		if (distanceNodeMap.get(hDistance) == null) {
			distanceNodeMap.put(hDistance, root);
		}
		topView(root.getLeft(), hDistance - 1);
		topView(root.getRight(), hDistance + 1);
	}

	private void leftView(BinaryTreeNode<Integer> root, Integer vDistance) {
		if (root == null) {
			return;
		}
		if (distanceNodeMap.get(vDistance) == null) {
			distanceNodeMap.put(vDistance, root);
		}
		leftView(root.getLeft(), vDistance + 1);
		leftView(root.getRight(), vDistance + 1);
	}

	private void rightView(BinaryTreeNode<Integer> root, Integer vDistance) {
		if (root == null) {
			return;
		}
		distanceNodeMap.put(vDistance, root);
		rightView(root.getLeft(), vDistance + 1);
		rightView(root.getRight(), vDistance + 1);
	}

	private void bottomView(BinaryTreeNode<Integer> root, Integer hDistance) {
		if (root == null) {
			return;
		}
		distanceNodeMap.put(hDistance, root);
		bottomView(root.getLeft(), hDistance - 1);
		bottomView(root.getRight(), hDistance + 1);
	}

	public static void main(String[] args) {
		BoundaryTraversalTree obj = new BoundaryTraversalTree();
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

		obj.topView(n1, 0);
		System.out.println("Top view : " + obj.distanceNodeMap);
		obj.distanceNodeMap.clear();

		obj.bottomView(n1, 0);
		System.out.println("Bottom view : " + obj.distanceNodeMap);
		obj.distanceNodeMap.clear();

		obj.leftView(n1, 0);
		System.out.println("Left view : " + obj.distanceNodeMap);
		obj.distanceNodeMap.clear();

		obj.rightView(n1, 0);
		System.out.println("Right view : " + obj.distanceNodeMap);
		obj.distanceNodeMap.clear();
	}
}
