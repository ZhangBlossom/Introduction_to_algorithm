package tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/8 9:29
 * InvertTree类
 * 翻转二叉树
 */
public class _226InvertTree {
    public TreeNode invertTree(TreeNode root){
        if (root==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
