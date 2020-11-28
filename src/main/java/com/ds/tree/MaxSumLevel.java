package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * get the level having maximum sum
 * 
 * level order search and find max level
 */
public class MaxSumLevel {

	int level = 0;
	int maxSum = Integer.MIN_VALUE;
	Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

	private void getMaxSumLvl(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		int currentSum = 0, currentLevel = 1;
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.poll();
			if (temp != null) {
				currentSum += temp.getData();
				if (temp.getLeft() != null) {
					queue.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.offer(temp.getRight());
				}
			} else {
				if (currentSum > maxSum) {
					maxSum = currentSum;
					level = currentLevel;
				}
				if (!queue.isEmpty()) {
					currentSum = 0;
					currentLevel++;
					queue.offer(null);
				}
			}
		}
	}

	public static void main(String[] args) {
		MaxSumLevel maxlevel = new MaxSumLevel();
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

		maxlevel.getMaxSumLvl(n1);
		System.out.println("level : " + maxlevel.level);
		System.out.println("sum : " + maxlevel.maxSum);
	}
}
