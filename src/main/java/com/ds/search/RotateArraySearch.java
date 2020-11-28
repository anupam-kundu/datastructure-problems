package com.ds.search;

/**
 * 
 * Search an element from and array which is rotated unknown number of times
 * 
 * @author Anupam
 *
 */
public class RotateArraySearch {

	public int pivotBinarySearch(int arr[], int left, int right, int item) {

		int pivot = findPivot(arr, left, right);
		if (pivot == -1) {
			return binarySearch(arr, left, right, item);
		} else {
			if (item == arr[pivot])
				return pivot;
			if (arr[0] < item) {
				return binarySearch(arr, left, pivot - 1, item);
			} else {
				return binarySearch(arr, pivot + 1, right, item);
			}
		}
	}

	public int binarySearch(int arr[], int left, int right, int item) {

		if (left > right)
			return -1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			return item == arr[mid] ? mid
					: item < arr[mid] ? binarySearch(arr, left, mid - 1, item)
							: binarySearch(arr, mid + 1, right, item);
		}
		return -1;
	}

	public int findPivot(int[] arr, int left, int right) {

		if (left > right) {
			return -1;
		}
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}
			if (arr[left] < arr[mid]) { // left is sorted
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 40, 50, 60, 70, 80, 90, 100, 10, 20, 30 };

		RotateArraySearch search = new RotateArraySearch();
		// System.out.println(search.pivotBinarySearch(arr, 0, arr.length - 1, 30));
		// System.out.println(search.pivotBinarySearch(arr, 0, arr.length - 1, -10));
		// System.out.println(search.pivotBinarySearch(arr, 0, arr.length - 1, -30));
		// System.out.println(search.pivotBinarySearch(arr, 0, arr.length - 1, -20));

		System.out.println(search.singlePassBS(arr, 0, arr.length - 1, 30));
		System.out.println(search.singlePassBS(arr, 0, arr.length - 1, -10));
		System.out.println(search.singlePassBS(arr, 0, arr.length - 1, -30));
		System.out.println(search.singlePassBS(arr, 0, arr.length - 1, 20));
	}

	public int singlePassBS(int[] arr, int left, int right, int item) {
		if (left > right)
			return -1;
		int mid = left + (right - left) / 2;
		if (arr[mid] == item) {
			return mid;
		}

		if (arr[left] < arr[mid]) {
			if (arr[left] < item && item < arr[mid]) {
				return singlePassBS(arr, left, mid - 1, item);
			}
			return singlePassBS(arr, mid + 1, right, item);
		} else if (arr[mid] < arr[right]) {
			if (arr[mid] < item && item < arr[right]) {
				return singlePassBS(arr, mid + 1, right, item);
			}
			return singlePassBS(arr, left, mid - 1, item);
		}
		return -1;
	}

}
