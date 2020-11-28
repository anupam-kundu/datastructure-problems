package com.ds.string;

import java.util.Arrays;

/**
 * ABCCBCBA -> ABBCBA -> ACBA
 */
public class RemoveAdjChars {
    private static char[] removeChar(char[] chArr) {
        int i = 0, j = 1;
        while (j < chArr.length) {
            while (chArr[i] == chArr[j] && i >= 0) {
                j++;
                i--;
            }
            i++;
            chArr[i]=chArr[j];
            j++;
        }
        return Arrays.copyOfRange(chArr, 0, i);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeChar("ABCCBCBA".toCharArray())));
    }
}
