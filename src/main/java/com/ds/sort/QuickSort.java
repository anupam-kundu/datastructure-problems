package com.ds.sort;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] arr, int lb, int ub) {
        int up, down, pivot;
        pivot = arr[lb];
        down = lb;
        up = ub;
        while (down < up) {
            while (arr[down] <= pivot && down < ub) {
                down++;
            }
            while (pivot < arr[up]) {
                up--;
            }
            if (down < up) {
                int tmp = arr[up];
                arr[up] = arr[down];
                arr[down] = tmp;
            }
        }
        arr[lb] = arr[up];
        arr[up] = pivot;
        return up;
    }

    private static void sort(int[] arr, int lb, int ub) {
        if (lb >= ub) {
            return;
        }
        int partition = partition(arr, lb, ub);
        sort(arr, lb, partition - 1);
        sort(arr, partition + 1, ub);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 10, 5, 3, 16, -2, -10, 50, 10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
