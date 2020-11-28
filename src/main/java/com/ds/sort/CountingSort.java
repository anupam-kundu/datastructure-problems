package com.ds.sort;

public class CountingSort {

	private int[] doCountingSort(int[] a, int k) {

		int[] b, c;
		b = new int[a.length];
		c = new int[k];
		for (int i = 0; i < k; i++) {
			c[i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			c[a[i]] = c[a[i]] + 1;
		}
		for (int i = 1; i < k; i++) {
			c[i] += c[i - 1];
		}
		for (int i = a.length - 1; i >= 0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]] -= 1;
		}
		return b;
	}

	public static void main(String[] args) {
		int[] sortedArr = (new CountingSort()).doCountingSort(new int[] { 2, 2, 0, 0, 0, 1, 1, 2, 0, 2, 1 }, 3);

		System.out.println();
		for (int i : sortedArr) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
}
