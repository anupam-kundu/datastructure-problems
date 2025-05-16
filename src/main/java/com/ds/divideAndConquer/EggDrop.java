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
 */
public class EggDrop {

	private static int eggDrop(int numOfEgg, int numOfFloors) {
		if (numOfFloors == 0 || numOfFloors == 1 || numOfEgg == 1) {
			return numOfFloors;
		}

		int min = Integer.MAX_VALUE, result;
		for (int x = 1; x < numOfFloors; x++) {
			result = 1 /* current move */ + Math.max(eggDrop(numOfEgg - 1, numOfFloors - 1) /* egg breaks */,
					eggDrop(numOfEgg, numOfFloors - x) /* egg does not break */);
			min = Math.min(result, min);
		}
		return min;
	}
}
