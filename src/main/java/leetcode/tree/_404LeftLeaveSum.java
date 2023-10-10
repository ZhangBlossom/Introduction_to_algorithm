package leetcode.tree;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/4 17:44
 * _404LeftLeaveSum类
 */
public class _404LeftLeaveSum {
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    private int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
