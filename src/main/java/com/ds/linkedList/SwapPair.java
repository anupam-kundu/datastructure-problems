package com.ds.linkedList;

/**
 * pair wise reverse a linked list
 * input : 1,2,3,4,5,6,7
 * output : 2,1,4,5,7,6
 */
public class SwapPair {
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
        LLNode newHead = reversePairWise(head);
        display(newHead);
    }

    private static LLNode reversePairWise(LLNode head) {
        if(head == null || head.link == null){
            return head;
        }
        LLNode mainHead = head.link;
        LLNode prev = null;
        while (head != null && head.link != null) {
            LLNode n1 = head;
            LLNode n2 = head.link;

            n1.link = n2.link;
            n2.link = n1;

            if(prev == null){
                prev = n1;
            } else {
                prev.link = n2;
                prev = n1;
            }

            head = n1.link;
        }
        return mainHead;
    }

    public static void display(LLNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(" " + head.data);
            head = head.link;
        }
        System.out.println();
    }
}
