package com.ds.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	public static void main(String[] args) {
		double arr[] = { 0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434 };

		bucketSort(arr, arr.length);

		System.out.println("Sorted array is \n");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	static void bucketSort(double arr[], int n) {
		// 1) Create n empty buckets
		ArrayList<Double>[] b = new ArrayList[n];

		// 2) Put array elements in different buckets
		for (int i = 0; i < n; i++) {
			int bi = (int) ((int) n * arr[i]); // Index in bucket
			if (b[bi] == null)
				b[bi] = new ArrayList<>();
			b[bi].add(arr[i]);
		}

		// 3) Sort individual buckets
		for (int i = 0; i < n; i++)
			if (b[i] != null)
				Collections.sort(b[i]);
		// sort(b[i].begin(), b[i].end());

		// 4) Concatenate all buckets into arr[]
		int index = 0;
		for (int i = 0; i < n; i++)
			if (b[i] != null)
				for (int j = 0; j < b[i].size(); j++)
					arr[index++] = b[i].get(j);
	}
}
