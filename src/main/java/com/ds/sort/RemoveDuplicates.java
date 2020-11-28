package com.ds.sort;

import java.util.Arrays;

public class RemoveDuplicates {

    private static int[] removeDuplicates(int [] arr){
        int i = 0;
        for(int j=1;j < arr.length;j++){
            if(arr[i] != arr[j]){
                arr[++i] = arr[j];
            }
        }
        return Arrays.copyOf(arr, i+1);
    }
}
