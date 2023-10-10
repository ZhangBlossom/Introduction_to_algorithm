package keypoint.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/10 19:25
 * IsBST类
 * 验证一个二叉树是否是BST二叉搜索树
 */
public class _98IsBST {
    public boolean isValidBST(TreeNode root){
        if (root==null){
            return true;
        }
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,int low,int high){
        if (root==null){
            return true;
        }
        if (root.val>=high || root.val<=low){
            return false;
        }
        return isValidBST(root.left,low,root.val) &&
                isValidBST(root.right,root.val,high);
    }
}

