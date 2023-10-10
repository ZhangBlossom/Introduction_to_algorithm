package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/2 17:50
 * _98ValidBinTree类
 *  5
 *  4  6
 *    3 7
 */
public class _98ValidBinTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root ,long lower,long upper) {
        if (root==null){
            return true;
        }
        if (root.val>=upper || root.val<=lower){
            return false;
        }
        return isValidBST(root.left,lower,root.val)
                && isValidBST(root.right,root.val,upper);
    }

}
