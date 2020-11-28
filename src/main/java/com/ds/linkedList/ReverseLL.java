package com.ds.linkedList;

public class ReverseLL {
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
        if (head == null || head.link == null) { // no nodes or one nodes
            return head;
        }
        if(head.link.link == null) { // two nodes
            LLNode temp = head.link;
            head.link = null;
            temp.link = head;
            return temp;
        }

        LLNode prev , curr, next;
        prev = head;
        curr = prev.link;
        next = curr.link;
        prev.link=null;

        while (next != null){
            curr.link = prev;
            prev = curr;
            curr = next;
            next = next.link;
        }
        curr.link = prev;
        return curr;
    }
}
