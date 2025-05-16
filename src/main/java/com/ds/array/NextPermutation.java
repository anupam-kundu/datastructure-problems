package com.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * <p>
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * <p>
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * <p>
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * <p>
 * <p>
 * https://www.geeksforgeeks.org/next-permutation/
 * <p>
 * 1. find pivot : scan from right if a[i] < a[i+1] = i is pivot
 * 2. if no pivot found then its the last sequence, so reverse entire array
 * 3. next scan from right and find a[pivot] < a[i] = swap the numbers
 * 4. reverse the sub array from pivot+1 to end
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] input = new int[]{4, 2, 3, 1};
        System.out.println("Next Permutation");
        nextPermutation.nextPermutation(input);
        System.out.println(Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList()));

        System.out.println("All Permutation");
        nextPermutation.allPermutation(new ArrayList<>(), Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList()));
    }

    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for(int i= nums.length-1; i > pivot; i--){
            if(nums[pivot] < nums[i]){
                swap(nums , pivot, i);
                reverse(nums, pivot+1, nums.length-1);
                return;
            }
        }

    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void allPermutation(ArrayList<Integer> prefix, List<Integer> nums) {
        if (nums.size() == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            prefix.add(nums.remove(i));
            int prefixIdx = prefix.size() - 1;
            allPermutation(prefix, nums);
            nums.add(i, prefix.remove(prefixIdx));
        }
    }

}
