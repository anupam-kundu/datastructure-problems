package com.ds.linkedList;

import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * a linked list having one next pointer and a random pointer
 *      next pointer points to the next element of the list
 *      random pointer can point any node in the list and may contain null
 *
 * Clone the list to a new list with O(n) time O(n) space
 * Clone the list to a new list with O(n) time O(1) space
 *
 */
public class CloneLinkedListWithRandomPointer {

    @EqualsAndHashCode
    static class LLNode {
        int data;

        @EqualsAndHashCode.Exclude
        LLNode next;
        @EqualsAndHashCode.Exclude
        LLNode random;
    }

    private LLNode cloneList(LLNode head) { // with order of n space
        if(head == null || head.next == null) {
            return head;
        }
        Map<LLNode,LLNode> mapNodes = new HashMap<>();
        LLNode oldList = head;
        while (oldList!=null) {
            LLNode newList = new LLNode();
            newList.data = oldList.data;
            mapNodes.put(oldList,newList);
            oldList = oldList.next;
        }
        for(Map.Entry<LLNode,LLNode> entry : mapNodes.entrySet()){
            entry.getValue().next = mapNodes.get(entry.getKey().next);
            entry.getValue().random = mapNodes.get(entry.getKey().random);
        }
        return mapNodes.get(head);
    }

}
