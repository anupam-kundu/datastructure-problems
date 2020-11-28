package com.ds.search;

public class Seperate012 {

	private static void seperate(int[] arr) {
		int left = 0, mid = 0, right = arr.length - 1;
		while (mid < right) {
			switch (arr[mid]) {
			case 0:
				arr[left] = arr[left] + arr[mid];
				arr[mid] = arr[left] - arr[mid];
				arr[left] = arr[left] - arr[mid];
				left++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				arr[right] = arr[right] + arr[mid];
				arr[mid] = arr[right] - arr[mid];
				arr[right] = arr[right] - arr[mid];
				right--;
				break;
			}
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2,1,0, 0, 1, 2, 1, 0, 2, 1, 1, 1, 2, 2, 0, 0 };
		seperate(arr);
	}

}
