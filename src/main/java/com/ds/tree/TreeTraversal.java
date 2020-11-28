package com.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	private BinaryTreeNode<Integer> tree;

	private List<Integer> nodeList;

	public TreeTraversal(BinaryTreeNode<Integer> tree) {
		nodeList = new ArrayList<>();
		this.tree = tree;
	}

	private void print() {
		System.out.println();
		System.out.println(nodeList);
		System.out.println();
	}

	private void clean() {
		nodeList.clear();
	}

	private void preorderRecursive(BinaryTreeNode<Integer> root) {
		if (root != null) {
			nodeList.add(root.getData());
			preorderRecursive(root.getLeft());
			preorderRecursive(root.getRight());
		}
	}

	private void inorderRecursive(BinaryTreeNode<Integer> root) {
		if (root != null) {
			inorderRecursive(root.getLeft());
			nodeList.add(root.getData());
			inorderRecursive(root.getRight());
		}
	}

	private void postorderRecursive(BinaryTreeNode<Integer> root) {
		if (root != null) {
			postorderRecursive(root.getLeft());
			postorderRecursive(root.getRight());
			nodeList.add(root.getData());
		}
	}

	// move the pointer with stack data ---> right insert first then left
	private void preorderIterative(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> stk = new Stack<>();
		if (root == null) {
			return;
		}

		stk.push(root);
		while (!stk.isEmpty()) {
			BinaryTreeNode<Integer> item = stk.pop();
			nodeList.add(item.getData());
			if (item.getRight() != null) {
				stk.push(item.getRight());
			}
			if (item.getLeft() != null) {
				stk.push(item.getLeft());
			}
		}
	}

	// move the pointer with current node and find the parent using stack
	private void inorderIterative(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> stk = new Stack<>();
		if (root == null) {
			return;
		}
		stk.push(root);
		BinaryTreeNode<Integer> currentNode = null, prev = null;

		while (!stk.isEmpty()) {
			currentNode = stk.peek();

			if (prev == null || prev.getLeft() == currentNode || prev.getRight() == currentNode) {
				// traverse from top to buttom
				if (currentNode.getLeft() != null) {
					stk.push(currentNode.getLeft());
				}
				// else if (currentNode.getRight() != null) {
				// stk.push(currentNode.getRight());
				// }
			} else { // coming back from child so process the current node and add right if any
				nodeList.add(currentNode.getData());
				stk.pop();
				if (currentNode.getRight() != null) {
					stk.push(currentNode.getRight());
				}
			}

			prev = currentNode;
		}
	}

	// move the pointer with current node, prev node and find the parent using stack
	private void postorderIterative(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> stk = new Stack<>();
		if (root == null) {
			return;
		}
		stk.push(root);
		BinaryTreeNode<Integer> currentNode = null, prev = null;
		while (!stk.isEmpty()) {
			currentNode = stk.peek();
			if (prev == null || prev.getLeft() == currentNode || prev.getRight() == currentNode) {
				// traverse from top to buttom
				if (currentNode.getLeft() != null) {
					stk.push(currentNode.getLeft());
				} else if (currentNode.getRight() != null) {
					stk.push(currentNode.getRight());
				}
			} else if (currentNode.getLeft() == prev) { // coming back from left child sub tree need to visit right now
				if (currentNode.getRight() != null) {
					stk.push(currentNode.getRight());
				}
			} else { // coming back from right child sub tree need to process the current node now
				nodeList.add(currentNode.getData());
				stk.pop();
			}

			prev = currentNode;
		}

	}

	public static void main(String[] args) {
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

		TreeTraversal traversal = new TreeTraversal(n1);
		traversal.inorderRecursive(traversal.getTree());
		traversal.print();
		traversal.clean();
		traversal.inorderIterative(traversal.getTree());
		traversal.print();
		traversal.clean();
		traversal.preorderRecursive(traversal.getTree());
		traversal.print();
		traversal.clean();
		traversal.preorderIterative(traversal.getTree());
		traversal.print();
		traversal.clean();
		traversal.postorderRecursive(traversal.getTree());
		traversal.print();
		traversal.clean();
		traversal.postorderIterative(traversal.getTree());
		traversal.print();

	}

	public BinaryTreeNode<Integer> getTree() {
		return tree;
	}

}
