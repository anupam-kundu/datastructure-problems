package com.ds.string;

import java.util.Arrays;

public class RemoveSpaces {
	public static void main(String[] args) {
		String str = "abc def ert jkl";
		char[] arr = str.toCharArray();
		int i = 0, j = 0;
		while (j < str.length()) {
			arr[i] = arr[j];
			if (arr[j] == ' ') {
				j++;
			} else {
				i++;
				j++;
			}
		}
		arr = Arrays.copyOfRange(arr, 0, i);
		System.out.println(new String(arr));
	}
}
