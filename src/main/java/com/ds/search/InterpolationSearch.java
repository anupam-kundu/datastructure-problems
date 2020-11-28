package com.ds.search;

public class InterpolationSearch {

    // log(log(n))
    private int searchArray(int[] arr, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        int searchIndex = left + (key - arr[left]) * ((right - left) / (arr[right] - arr[left]));
        if (arr[searchIndex] == key) {
            return searchIndex;
        }
        return arr[searchIndex] < key ?
                searchArray(arr, searchIndex + 1, right, key) :
                searchArray(arr, left, searchIndex - 1, key);
    }
}
