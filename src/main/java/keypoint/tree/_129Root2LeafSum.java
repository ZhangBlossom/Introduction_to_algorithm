package keypoint.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/11 11:06
 * _129Root2LeafSum类
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 */
public class _129Root2LeafSum {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int curSum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curSum;
        } else {
            return dfs(root.left,curSum) + dfs(root.right,curSum);
        }
    }
}
