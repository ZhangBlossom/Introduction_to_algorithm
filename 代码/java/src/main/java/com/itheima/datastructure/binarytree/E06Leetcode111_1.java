package com.itheima.datastructure.binarytree;

/**
 * 二叉树最小深度 - 后序遍历实现
 */
public class E06Leetcode111_1 {

    /*
           深度2
            1
           /
          2
     */
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int d1 = minDepth(node.left); // 1
        int d2 = minDepth(node.right); // 0
        if (d2 == 0) { // 当右子树为null
            return d1 + 1; // 返回左子树深度+1
        }
        if (d1 == 0) { // 当左子树为null
            return d2 + 1; // 返回右子树深度+1
        }
        return Integer.min(d1, d2) + 1;
    }
}
