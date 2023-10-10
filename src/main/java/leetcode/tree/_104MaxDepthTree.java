package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/2 21:19
 * _104MaxDepthTree类
 * 二叉树的最大深度
 */
public class _104MaxDepthTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

