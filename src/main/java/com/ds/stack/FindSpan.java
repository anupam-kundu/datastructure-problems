package com.ds.stack;

import java.util.Stack;

/**
 * Find span in stock trading system
 * <p>
 * Given an array of Price/Values find max span for a specific date/index
 */
public class FindSpan {
    private static int[] getSpan(int[] price) {
        Stack<Integer> stk = new Stack<>();
        int[] span = new int[price.length];
        int position = 0;
        for (int idx = 0; idx < price.length; idx++) {
            while (!stk.empty() && price[idx] > price[stk.peek()]) {
                stk.pop();
            }
            position = stk.empty() ? -1 : stk.peek();
            span[idx] = idx - position;
            stk.push(idx);
        }
        return span;
    }
}
