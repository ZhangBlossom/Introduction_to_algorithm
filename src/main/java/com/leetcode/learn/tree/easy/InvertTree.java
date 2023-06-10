package com.leetcode.learn.tree.easy;


import com.leetcode.learn.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/6/10 11:01
 * InvertTree类
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode leftTemp = null;
        TreeNode rightTemp = null;
        if(root.left!=null){
            leftTemp=root.left;
        }
        if(root.right!=null){
            rightTemp=root.right;
        }
        root.left=rightTemp;
        root.right=leftTemp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
