package com.ds.stack;

import java.util.Stack;

public class StackReverse {

	public void reverse(Stack<Integer> stk) {

		if (stk.isEmpty()) {
			return;
		}
		int item = stk.pop();
		reverse(stk);
		insertAtBottom(stk, item);
	}

	private void insertAtBottom(Stack<Integer> stk, int item) {
		if (stk.isEmpty()) {
			stk.push(item);
			return;
		}
		int element = stk.pop();
		insertAtBottom(stk, item);
		stk.push(element);
	}

	public static void main(String[] args) {
		StackReverse reverse = new StackReverse();
		Stack<Integer> stk = new Stack<>();
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		reverse.reverse(stk);
		while (!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}
}
