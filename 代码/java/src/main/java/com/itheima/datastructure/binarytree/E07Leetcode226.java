package com.itheima.datastructure.binarytree;

/**
 * 翻转二叉树
 */
public class E07Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    private static void fn(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;

        fn(node.left);
        fn(node.right);
    }
}
