package com.ds.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Three number sum equal to specific number or zero in an array
 * complexity O(n^2)
 */
public class TripleteSum {

    private void findTripleteSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length - 1; i++) {
            Set<Integer> elementTraversed = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int key = sum - (arr[i] + arr[j]);
                if (elementTraversed.contains(key)) {
                    System.out.println("Found : " + arr[i] + " " + arr[j] + " " + key);
                    return;
                } else {
                    elementTraversed.add(arr[j]);
                }
            }
        }
    }
}
