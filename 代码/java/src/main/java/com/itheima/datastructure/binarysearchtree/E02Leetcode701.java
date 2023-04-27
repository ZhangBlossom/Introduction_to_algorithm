package com.itheima.datastructure.binarysearchtree;

/**
 * 新增节点 (题目前提：val 一定与树中节点不同)
 */
public class E02Leetcode701 {

    /*
            val=1

            5
           / \
          2   6
           \
            3
     */
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insertIntoBST(node.left, val);
        } else if (node.val < val) {
            node.right = insertIntoBST(node.right, val);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2, null, new TreeNode(3)), new TreeNode(6));
        new E02Leetcode701().insertIntoBST(root, 1);
    }
}
