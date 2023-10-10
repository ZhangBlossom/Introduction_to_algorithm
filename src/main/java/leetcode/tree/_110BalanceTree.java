package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/3 14:44
 * _110BalanceTree类
 * 判断二叉树是否是平衡二叉树
 */
public class _110BalanceTree {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }else{
            return Math.abs(height(root.left)-height(root.right))<=1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root==null){
            return 0;
        }else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
}
