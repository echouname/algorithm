package com.nk.practice.leetcode.top100.easy;

import com.nk.practice.leetcode.top100.struct.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * @author ningke
 * @date 2021/9/10
 */
public class DiameterOfBinaryTree {

    int max = 0;

    /**
     * 关键是最长路径不一定是经过根节点的！！！
     * 考虑用dfs或者bfs
     */
    public int diameterOfBinaryTree(TreeNode root) {
        //分别计算左右俩节点深度值+1
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 求深度时顺便保存下直径
        int rightDepth = getDepth(node.right);
        int leftDepth = getDepth(node.left);
        max = Math.max(max, rightDepth + leftDepth);
        int depth = 1 + Math.max(rightDepth ,leftDepth);
        return depth;
    }

    public static void main(String[] args) {
        //示例 :
        //给定二叉树
        //
        //          1
        //         / \
        //        2   3
        //       / \
        //      4   5
        //       \
        //        5
        //返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
        //注意：两结点之间的路径长度是以它们之间边的数目表示
    }
}
