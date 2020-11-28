package com.ds.divideAndConquer;

public class EggDrop {

	private static int eggDrop(int numOfEgg, int numOfFloors) {
		if (numOfFloors == 0 || numOfFloors == 1 || numOfEgg == 1) {
			return numOfFloors;
		}

		int min = Integer.MAX_VALUE, result;
		for (int x = 1; x < numOfFloors; x++) {
			result = Math.max(eggDrop(numOfEgg - 1, numOfFloors - 1), eggDrop(numOfEgg, numOfFloors - x));
			min = Math.min(result, min);
		}
		return min + 1;
	}
}
