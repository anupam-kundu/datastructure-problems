package com.ds.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagTreeTraversal {

	private boolean isReverse = false;

	private Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

	private void printZigzag(BinaryTreeNode<Integer> root) {

		Deque<BinaryTreeNode<Integer>> tempQueue = new LinkedList<>();

		if (root == null) {
			return;
		}

		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.poll();
			if (temp != null) {
				tempQueue.addLast(temp);
				if (temp.getLeft() != null) {
					queue.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.offer(temp.getRight());
				}
			} else {
				if (isReverse) {
					while (!tempQueue.isEmpty()) {
						System.out.print(" " + tempQueue.removeLast());
					}
				} else {
					while (!tempQueue.isEmpty()) {
						System.out.print(" " + tempQueue.removeFirst());
					}
				}
				isReverse = !isReverse;
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
	}

	public static void main(String[] args) {
		ZigzagTreeTraversal obj = new ZigzagTreeTraversal();
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

		obj.printZigzag(n1);
	}

}
