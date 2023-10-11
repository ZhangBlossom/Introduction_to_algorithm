package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/10/11 11:23
 * _235LowestCommonAncestor类
 */
public class _235LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //都不为空或者都为空
        return root;
    }
}
