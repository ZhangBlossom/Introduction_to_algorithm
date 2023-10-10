package leetcode.tree.offer;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/5 13:27
 * _28IsBalancedTree类
 */
public class _28IsSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isBalanced(root,root);
    }

    public boolean isBalanced(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        return p.val==q.val && isBalanced(p.left,q.right)
                && isBalanced(p.right,q.left);
    }
}
