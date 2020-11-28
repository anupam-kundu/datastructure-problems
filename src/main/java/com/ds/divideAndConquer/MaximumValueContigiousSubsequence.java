package com.ds.divideAndConquer;

/**
 * Divide the array into half
 * 1. left side has the max subsequence
 * 2. right side has max subsequence
 * 3. left mid to right mid both has to be considered
 */
public class MaximumValueContigiousSubsequence {

    private int getMaxSubsequence(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftMaxSum = getMaxSubsequence(arr, left, mid);
        int rightMaxSum = getMaxSubsequence(arr, mid + 1, right);
        int sum = 0, leftMidSum = Integer.MIN_VALUE, rightMidSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftMidSum = Math.max(leftMidSum, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            rightMidSum = Math.max(rightMidSum, sum);
        }
        return Math.max(Math.max(leftMaxSum, rightMaxSum), (leftMidSum + rightMidSum));
    }

    public static void main(String[] args) {
        MaximumValueContigiousSubsequence obj = new MaximumValueContigiousSubsequence();
        System.out.println(obj.getMaxSubsequence(new int[]{-2, 11, -4, 13, -5, 2}, 0, 5));
    }
}
