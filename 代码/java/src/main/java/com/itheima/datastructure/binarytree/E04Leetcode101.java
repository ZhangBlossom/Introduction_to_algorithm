package com.itheima.datastructure.binarytree;

/**
 * 对称二叉树
 */
public class E04Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // left 和 right 不能同时为 null
        if(right == null || left == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

    // 1,2,2,3,4,4,3,5,6,7,8,8,7,6,5
}
