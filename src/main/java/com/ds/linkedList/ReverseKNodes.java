package com.ds.linkedList;

/*
 * K=3
 * ll = 1,2,3,4,5,6,7,8,9
 * result = 3,2,1 -> 6,5,4 -> 9,8,7
 * 
 */
public class ReverseKNodes {

	static class LLNode {
		int data;
		LLNode link = null;
	}

	public static void main(String[] args) {
		LLNode head = null, temp = null;
		for (int i = 1; i <= 9; i++) {
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
		display(reverse(head, 5));
	}

	public static void display(LLNode head) {
		System.out.println();
		while (head != null) {
			System.out.print(" " + head.data);
			head = head.link;
		}
		System.out.println();
	}

	public static LLNode reverse(LLNode head, int k) {
		if (head == null || head.link == null) {
			return head;
		}
		if (head.link.link == null) {
			LLNode temp = head.link;
			temp.link = head;
			head.link = null;
			return temp;
		}

		LLNode prev, curr, next;
		prev = head;
		curr = prev.link;
		next = curr.link;

		for (int i = 0; i < k - 2 && next != null; i++) {
			curr.link = prev;
			prev = curr;
			curr = next;
			next = next.link;
		}
		curr.link = prev;
		if (next == null) {
			head.link = null;
			return curr;
		}

		head.link = reverse(next, k);
		return curr;
	}

}
