package com.ds.search;

public class SeperateEvenOdd {

	private static int[] seperate(int[] arr) {

		int low = 0, high = arr.length - 1;

		while (low < high) {

			while (arr[low] % 2 == 0 && low < high) {
				low++;
			}
			while (arr[high] % 2 != 0 && low < high) {
				high--;
			}
			if (low < high) {
				arr[high] = arr[high] + arr[low];
				arr[low] = arr[high] - arr[low];
				arr[high] = arr[high] - arr[low];
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 12, 34, 45, 9, 8, 90, 3 };
		arr = seperate(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
