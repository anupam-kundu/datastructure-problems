package com.ds.string;

/**
 * 
 * String matcher with ? and *
 * 
 * ? -> any single character
 * 
 * * -> any number of characters including length zero
 * 
 * @author Anupam
 *
 */
public class WildCard {

	private static boolean match(String text, String pattern) {
		if ((pattern.length() == 1 && pattern.charAt(0) == '*')) {
			return true;
		}
		int i = 0;
		while (i < text.length()) {
			if (i >= pattern.length()) {
				return false;
			} else if (text.charAt(i) == pattern.charAt(i) || pattern.charAt(i) == '?') {
				i++;
			} else if (pattern.charAt(i) == '*') {
				return match(text.substring(i), pattern.substring(i + 1))  // * zero char in text but one in pattern
						|| match(text.substring(i + 1), pattern.substring(i))  // * one char in text but zero in pattern
						|| match(text.substring(i + 1), pattern.substring(i + 1)); // one char in text and one in pattern
			} else {
				return false;
			}
		}
		if (i == text.length() && i == pattern.length()) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(match("aa", "aa"));
		System.out.println(match("aaa", "aa"));
		System.out.println(match("aa", "*a"));
		System.out.println(match("aa", "a*"));
		System.out.println(match("ab", "?*"));
		System.out.println(match("aab", "c*a*b"));
		System.out.println(match("aab", "a*b"));
		System.out.println(match("aab", "a?b"));
		System.out.println(match("aab", "*a*b"));
	}

}
