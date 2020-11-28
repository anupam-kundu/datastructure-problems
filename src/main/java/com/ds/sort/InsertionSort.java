package com.ds.sort;

import java.util.Arrays;

/**
 * Used for almost sorted arrays
 */
public class InsertionSort {

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pivot = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > pivot; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = pivot;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 10, 5, 3, 16, -2, -10, 50, 10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
