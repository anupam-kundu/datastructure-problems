package com.ds.tree;

public class NumberOfPathsWithSum {

    // complexity O(N*log(N))

    private int getNumberOfPaths(BinaryTreeNode<Integer> root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int totalPathWithRoot = getNumberOfPathsWithRoot(root, 0, targetSum);
        int totalPathFromLeft = getNumberOfPaths(root.getLeft(), targetSum);
        int totalPathFromRight = getNumberOfPaths(root.getRight(), targetSum);

        return totalPathWithRoot + totalPathFromLeft + totalPathFromRight;
    }

    private int getNumberOfPathsWithRoot(BinaryTreeNode<Integer> root, int currentSum, int targetSum) {
        if (root == null) {
            return 0;
        }
        currentSum += root.getData();
        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }
        totalPaths += getNumberOfPathsWithRoot(root.getLeft(), currentSum, targetSum);
        totalPaths += getNumberOfPathsWithRoot(root.getRight(), currentSum, targetSum);
        return totalPaths;
    }
}
