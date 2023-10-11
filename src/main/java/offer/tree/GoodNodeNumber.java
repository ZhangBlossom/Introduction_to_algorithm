package offer.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/7/4 13:34
 * GoodNodeNumber类
 * 1448
 */
public class GoodNodeNumber {
    int goodNum = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return goodNum;
        }
        dfs(root, root.val);
        return goodNum;
    }

    public void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            goodNum++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
