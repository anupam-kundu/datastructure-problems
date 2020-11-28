package com.ds.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * BST should support another function called random node
 * which will return one random node with equal probability
 */

@Getter
@Setter
class TreeNode {
    private final int data;
    private TreeNode left;
    private TreeNode right;
    private int size;

    public TreeNode(int data) {
        this.data = data;
        size = 1;
    }
}

public class RandomNodeBST {

    private boolean find(TreeNode root, int key) {
        return root == null ? false
                : root.getData() == key ? true
                : root.getData() > key ? find(root.getLeft(), key)
                : find(root.getRight(), key);
    }

    private void insertInOrder(TreeNode root, int item) {
        if (item < root.getData()) {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode(item));
            } else {
                insertInOrder(root.getLeft(), item);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new TreeNode(item));
            } else {
                insertInOrder(root.getRight(), item);
            }
        }
        root.setSize(root.getSize() + 1);
    }

    private TreeNode getRandom(TreeNode root) {
        int randomProbability = new Random().nextInt(root.getSize());

        int leftSize = root.getLeft() == null ? 0 : root.getLeft().getSize();

        if (randomProbability < leftSize) {
            return getRandom(root.getLeft());
        } else if (randomProbability == leftSize) {
            return root;
        } else {
            return getRandom(root.getRight());
        }
    }
}
