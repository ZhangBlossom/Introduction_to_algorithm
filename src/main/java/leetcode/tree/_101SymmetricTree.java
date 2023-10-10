package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/2 20:52
 * _101SymmetricTree类
 */
public class _101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left==null && right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return dfs(left.left,right.right) &&
                dfs(left.right,right.left);
    }
}
