package com.ds.divideAndConquer;


/**
 * You are given n identical eggs and you have access to a k-floored building from 1 to k.
 *
 * There exists a floor f where 0 <= f <= k such that any egg dropped from a floor higher than f will break, and any egg dropped from or below floor f will not break. There are a few rules given below:
 *
 * An egg that survives a fall can be used again.
 * A broken egg must be discarded.
 * The effect of a fall is the same for all eggs.
 * If the egg doesn’t break at a certain floor, it will not break at any floor below.
 * If the egg breaks on a certain floor, it will break on any floor above.
 *
 * dp[k][n] = minimum number of attempts needed with k eggs and n floors
 *
 * dp[k][n] = 1 + min ( max (dp[k-1][n-1], dp[k][n-x]))
 *
 * dp[k-1][n-1] = egg breaks
 * dp[k][n-x] = egg does not break
 * take worst case scenario [max]
 * find the minimum try [min]
 *
 *
 */
public class EggDrop {

	private static int eggDrop(int numOfEgg, int numOfFloors) {
		if (numOfFloors == 0 || numOfFloors == 1 || numOfEgg == 1) {
			return numOfFloors;
		}

		int min = Integer.MAX_VALUE, result;
		for (int x = 1; x < numOfFloors; x++) {
			result = 1 /* current move/floor */ + Math.max(eggDrop(numOfEgg - 1, numOfFloors - 1) /* egg breaks */,
					eggDrop(numOfEgg, numOfFloors - x) /* egg does not break */);
			min = Math.min(result, min);
		}
		return min;
	}

	// Function to find minimum number of attempts
	// needed in order to find the critical floor
	static int eggDropDp(int n, int k) {

		// create a 2D table to store the results
		int[][] dp = new int[k + 1][n + 1];

		// to count the number of moves
		int cnt = 0;

		// while the number of floors is less than k
		while (dp[cnt][n] < k) {
			cnt++;

			// for each egg
			for (int i = 1; i <= n; i++) {
				dp[cnt][i] = 1 + dp[cnt - 1][i - 1] + dp[cnt - 1][i];
			}
		}
		return cnt;
	}

}
