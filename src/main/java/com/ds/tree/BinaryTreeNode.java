package com.ds.tree;

public class BinaryTreeNode<T> {
	private BinaryTreeNode<T> left;
	private T data;
	private BinaryTreeNode<T> right;

	public BinaryTreeNode() {
	}

	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
