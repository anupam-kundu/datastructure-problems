package com.ds.linkedList;

import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU cache of constant size n
 *
 * using combination of HashMap and doubly link list
 *
 * time complexity O(1)
 * space complexity O(n)
 *
 * map will tell if element is present or not , link-list will hold elements in order of access
 * remove element from front of the list
 * add or move element to the rear of the list if it is accessed
 */
public class LRUCache {
    private final int SIZE = 5;
    @EqualsAndHashCode
    private class DLLNode {
        int data;

        @EqualsAndHashCode.Exclude
        DLLNode prev;
        @EqualsAndHashCode.Exclude
        DLLNode next;
    }

    private Map<Integer, DLLNode> lruMap = new HashMap<>();
    private DLLNode head, tail;

    private int getData(int key) {
        if(lruMap.containsKey(key)){
            updateAccess(key);
        } else {
            addData(key);
        }
        return key;
    }

    private void addData(int key) {
        if(lruMap.size() >= SIZE) {
            lruMap.remove(head.data);
            head.next.prev = null;
            head = head.next;
        }
        DLLNode temp = new DLLNode();
        temp.data = key;
        temp.prev = tail;
        tail = temp;
        lruMap.put(key, temp);
    }

    private void updateAccess(int key) {
        DLLNode temp = lruMap.get(key);
        if(temp.prev == null) {
            head = temp.next;
            head.prev = null;
            tail.next = temp;
            temp.prev = tail;
            temp.next = null;
            tail = temp;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.prev = tail;
            tail.next = temp;
            temp.next = null;
            tail = temp;
        }
    }
}
