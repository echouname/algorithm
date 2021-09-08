package com.nk.practice.leetcode.top100.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 左 中 右
 *
 * @author ningke
 * @date 2021/9/7
 */
public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        midTravel(root, nodeList);
        return nodeList;
    }

    private static void midTravel(TreeNode root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            midTravel(root.left, nodeList);
        }
        nodeList.add(root.val);
        if (root.right != null) {
            midTravel(root.right, nodeList);
        }
    }

    public static List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                nodeList.add(node.val);
                curr = node.right;
            }
        }
        return nodeList;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        List<Integer> integers = inorderTraversal(root);
    }
}
