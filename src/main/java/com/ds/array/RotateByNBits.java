package com.ds.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * rotate an array by N bits 
 * 1. Clockwise
 * 2. Anti clockwise
 * 
 */

public class RotateByNBits {

    public static void main(String[] args) {
        System.out.println("Rorate Array By N bits");
        int[] input1 = new int[] {1,2,3,4,5};
        int[] input2 = Arrays.copyOf(input1, input1.length);
        RotateByNBits obj = new RotateByNBits();
        obj.clockwise(input1, 3);
        obj.antiClockwise(input2, 3);
    }

    private void clockwise(int[] a, int n) {
        int offset = n % a.length;
        int[] prefixArray = Arrays.copyOfRange(a, a.length - offset, a.length);
//        System.out.println(Arrays.stream(prefixArray).boxed().collect(Collectors.toList()));
        int[] suffixArray = Arrays.copyOfRange(a, 0, a.length - offset);
//        System.out.println(Arrays.stream(suffixArray).boxed().collect(Collectors.toList()));
        int[] result = ArrayUtils.addAll(prefixArray, suffixArray);
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    private void antiClockwise(int[] a, int n) {
        int offset = n % a.length;
        int[] prefixArray = Arrays.copyOfRange(a, offset, a.length);
//        System.out.println(Arrays.stream(prefixArray).boxed().collect(Collectors.toList()));
        int[] suffixArray = Arrays.copyOfRange(a, 0, offset);
//        System.out.println(Arrays.stream(suffixArray).boxed().collect(Collectors.toList()));
        int[] result = ArrayUtils.addAll(prefixArray, suffixArray);
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}
