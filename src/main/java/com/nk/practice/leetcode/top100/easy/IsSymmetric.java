package com.nk.practice.leetcode.top100.easy;

import com.nk.practice.leetcode.top100.struct.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author ningke
 * @date 2021/9/8
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        // root 1 和roo2 对称  root1.right 应该和root2.left 对称 然后继续往下比较
        // 1.root1 和roo2的值
        // 2.root1.left 和roo2.right
        // 3.root1.right 和roo2.left
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public static void main(String[] args) {

        //给定一个二叉树，检查它是否是镜像对称的。
        //
        // 
        //
        //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
        //
        //           1
        //        /     \
        //       2       2
        //      / \     /  \
        //     3   4   4    3
        //    / \ / \ / \  / \
        //      7 6 5 5 6 7
        //但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
        //
        //    1
        //   / \
        //  2   2
        //   \   \
        //   3    3
        // 
        //
        //进阶：
        //
        //你可以运用递归和迭代两种方法解决这个问题吗？
    }
}
