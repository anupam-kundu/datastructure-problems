package com.ds.string;

public class Combination {

	private static void combination(String prefix, String str) {
		System.out.println(prefix);
		for (int i = 0; i < str.length(); i++) {
			combination(prefix + str.charAt(i), str.substring(i + 1));
		}
	}

	public static void main(String[] args) {
		combination("", "abc");
	}
}
