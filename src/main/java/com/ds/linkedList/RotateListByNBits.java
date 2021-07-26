package com.ds.linkedList;

/**
 * Rotate List to right by K places
 * k=2
 * 1,2,3,4,5
 * 4,5,1,2,3
 * <p>
 * Rotate List left by K places
 * k=2
 * 1,2,3,4,5
 * 3,4,5,1,2
 */
public class RotateListByNBits {
    static class LLNode {
        int data;
        LLNode link = null;
    }

    public static void display(LLNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(" " + head.data);
            head = head.link;
        }
        System.out.println();
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
        int k = 5;
        LLNode newHead = rotateRight(head, k);
        display(newHead);

        newHead = rotateLeft(head, k);
        display(newHead);
    }

    private static LLNode rotateRight(LLNode head, int k) {
        LLNode first, last;
        first = last = head;
        for (int i = 0; i < k; i++) {
            if (last.link == null) {
                last = head;
            } else {
                last = last.link;
            }
        }
        if (first == last) {
            return head;
        }
        while (last.link != null) {
            first = first.link;
            last = last.link;
        }
        LLNode newHead = first.link;
        first.link = null;
        last.link = head;

        return newHead;
    }

    private static LLNode rotateLeft(LLNode head, int k) {

        LLNode ptr = head;
        for (int i = 0; i < k; i++) {
            if (ptr.link == null) {
                ptr = head;
            } else {
                ptr = ptr.link;
            }
        }
        if (head == ptr) {
            return head;
        }
        LLNode newHead = ptr.link;
        ptr.link = null;

        while (ptr.link != null) {
            ptr = ptr.link;
        }

        ptr.link = head;

        return newHead;
    }
}
