package com.ds.stack;

import java.util.Stack;

public class SortUsingStack {

	private static void sort(Stack<Integer> stk) {
		if (stk.isEmpty())
			return;
		int item = stk.pop();
		sort(stk);
		insertAtPosition(stk, item);
	}

	private static void insertAtPosition(Stack<Integer> stk, int item) {
		if (stk.isEmpty() || item < stk.peek()) {
			stk.push(item);
		} else {
			int element = stk.pop();
			insertAtPosition(stk, item);
			stk.push(element);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<>();
		stk.push(10);
		stk.push(40);
		stk.push(20);
		stk.push(30);
		stk.push(50);
		stk.push(50);
		stk.push(80);
		stk.push(50);
		sort(stk);
		while (!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}

}
