package com.ds.stack;

import java.util.Stack;

public class FindMaxRectangleInHistogram {

    private int find(int[] histogram) {
        if(histogram == null || histogram.length==0){
            return 0;
        }
        int maxArea = 0, idx = 0;
        Stack<Integer> stk = new Stack<>();

        while(idx < histogram.length){
            if(stk.isEmpty() || histogram[idx] >= histogram[stk.peek()]){
                stk.push(idx);
                idx++;
            }else {
                int top = stk.pop();
                maxArea = Math.max(maxArea, histogram[top] *
                        (stk.isEmpty() ? idx : idx - stk.peek() - 1));
            }
        }

        while(!stk.isEmpty()){
            int top = stk.pop();
            maxArea = Math.max(maxArea, histogram[top] *
                    (stk.isEmpty() ? idx : idx - stk.peek() - 1));
        }
        return maxArea;
    }
}
