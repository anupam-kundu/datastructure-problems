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
            if(stk.isEmpty() || histogram[idx] >= histogram[stk.peek()]){ // as long as area increasing , add index to stack
                stk.push(idx);
                idx++;
            }else { // calculation start to find maxArea
                int top = stk.pop(); // height of the max histogram present till top index
                maxArea = Math.max(maxArea, histogram[top] *
                        (stk.isEmpty() ? idx : idx - stk.peek() - 1));
                // if current histogram is short then check what gives max area ?
                // previous calculated maxArea or new max area considering previous tall histogram [previous idx present in stack]
                // if stack is empty then consider current index [idx staarts with 0 and currently at next to high index]
                // if not then current idx - previously calculated mav histogram idx -1 [because idx is in the next position] (difference)

                // area calculation is from idx to stack bottom index one by one
                // area calculation is backtracking from current idx to idx-stk.top()
            }
        }

        while(!stk.isEmpty()){ // do the area calculation till stack is not empty
            int top = stk.pop();
            maxArea = Math.max(maxArea, histogram[top] *
                    (stk.isEmpty() ? idx : idx - stk.peek() - 1));
        }
        return maxArea;
    }
}
