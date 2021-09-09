package com.nk.practice.leetcode.top100.easy;

/**
 * 翻转一棵二叉树。
 *
 * @author ningke
 * @date 2021/9/9
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }

    //
}
