package com.nk.practice.leetcode.top100.easy;

import com.nk.practice.leetcode.top100.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ningke
 * @date 2021/9/8
 */
public class MaxDepth {

    /**
     * node节点的最大深度 == 1+ max(node.left,node.right)
     * 什么时候停止呢 node == null
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 一层一层往下遍历，直到走到最后一层，每次走完一层层数+1
     */
    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 取出这一层所有的节点
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i--);
        //给定一个二叉树，找出其最大深度。
        //
        //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        //
        //说明: 叶子节点是指没有子节点的节点。
        //
        //示例：
        //给定二叉树 [3,9,20,null,null,15,7]，
        //
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        //返回它的最大深度 3 。
    }
}
