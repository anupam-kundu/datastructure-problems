package com.ds.string;

public class Permutation {

	private static void permutation(String prefix, String str) {
		int len = str.length();
		if (len == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
		}
	}

	public static void main(String[] args) {
		permutation("", "abc");
	}
}
