package com.ds.string;

public class PatternMatchingKMP {

	private int[] prefix;

	private void buildPrefix(String pattern) {
		if (pattern.length() <= 1) {
			prefix = new int[] { 0 };
			return;
		}

		int j = 0, i = 1;
		prefix = new int[pattern.length()];
		prefix[0] = 0;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				prefix[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = prefix[j - 1];
			} else {
				prefix[i] = 0;
				i++;
			}
		}
	}

	private int matchStr(String pattern, String text) {

		int i = 0, j = 0;

		while (i < text.length()) {
			if (j == pattern.length()) {
				return i - j;
			}
			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			} else if (j > 0) {
				j = prefix[j - 1];
			} else {
				i++;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		String pattern = "abababaabababababab";
		String text = "abcdabagababdc";
		PatternMatchingKMP kmp = new PatternMatchingKMP();
		kmp.buildPrefix(pattern);
		for (int i : kmp.prefix) {
			System.out.println(i);
		}

		System.out.println(kmp.matchStr(pattern, text));
	}
}
