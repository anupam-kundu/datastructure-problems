package com.ds.linkedList;

public class ReverseRecursion {
	static class LLNode {
		int data;
		LLNode link = null;
	}

	public static void main(String[] args) {
		LLNode head = null, temp = null;
		for (int i = 1; i <= 40; i++) {
			LLNode node = new LLNode();
			node.data = i;
			if (i == 1) {
				head = temp = node;
			} else {
				temp.link = node;
				temp = temp.link;
			}

		}
		display(head);
		LLNode newHead = reverse(head);
		head.link = null;
		display(newHead);
	}

	public static void display(LLNode head) {
		System.out.println();
		while (head != null) {
			System.out.print(" " + head.data);
			head = head.link;
		}
		System.out.println();
	}

	public static LLNode reverse(LLNode head) {
		if (head.link == null) {
			return head;
		}

		LLNode curr = head.link;

		LLNode rHead = reverse(curr);

		curr.link = head;
		return rHead;
	}

}
