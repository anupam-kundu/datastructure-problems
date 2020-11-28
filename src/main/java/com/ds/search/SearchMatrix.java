package com.ds.search;

/**
 * elements of rows are in ascending order and
 * elements of columns are in ascending order
 * <p>
 * start from top right
 * 1. if data > arr[][] move to next row and skip current row
 * 2. if data < arr[][] move to previous column and skip current column
 */
public class SearchMatrix {

    private static void find(int[][] arr, int data) {
        int i = 0, j = arr[0].length - 1;
        while (i <= arr.length - 1 && j >= 0) {
            if (arr[i][j] == data) {
                System.out.println("Found at i = " + i + " , j = " + j);
                return;
            } else if (data > arr[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(" Not Found !");
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {10, 20, 30, 40, 50},
                {11, 21, 31, 41, 51},
                {12, 22, 32, 42, 52},
                {13, 23, 33, 43, 53},
                {14, 24, 34, 44, 54},
                {15, 25, 35, 45, 55}
        };
        find(arr, 7);
        find(arr, 33);
        find(arr, 38);
        find(arr, 11);
        find(arr, 45);
    }
}
