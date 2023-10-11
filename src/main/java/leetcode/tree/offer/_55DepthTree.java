package leetcode.tree.offer;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/5 13:46
 * _55DepthTree类
 * 求二叉树的最大深度
 */
public class _55DepthTree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return depth(root);
    }
    public int depth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }

}
