package com.ds.linkedList;

public class ReverseRecursion {
	static class LLNode {
		int data;
		LLNode link = null;
	}
	static LLNode globalhead;
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
		LLNode tail = reverse2(newHead);
		tail.link = null;
		display(globalhead);
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


	public static LLNode reverse2(LLNode head) {
		if(head.link == null) {
			globalhead = head;
			return head;
		}

		LLNode rHead = reverse2(head.link);
		rHead.link = head;
		return head;
	}

}
