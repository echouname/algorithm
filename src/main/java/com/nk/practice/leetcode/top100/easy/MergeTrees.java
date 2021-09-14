package com.nk.practice.leetcode.top100.easy;

import com.nk.practice.leetcode.top100.struct.TreeNode;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * @author ningke
 * @date 2021/9/10
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入:
        //	Tree 1                     Tree 2
        //          1                         2
        //         / \                       / \
        //        3   2                     1   3
        //       /                           \   \
        //      5                             4   7
        //输出:
        //合并后的树:
        //	     3
        //	    / \
        //	   4   5
        //	  / \   \
        //	 5   4   7
        //注意: 合并必须从两个树的根节点开始。
    }
}
