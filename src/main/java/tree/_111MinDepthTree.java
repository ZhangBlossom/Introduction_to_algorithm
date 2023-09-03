package tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/3 16:20
 * _111MinDepthTree类
 */
public class _111MinDepthTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        //+1是因为要算上根节点
        return min_depth + 1;
    }
}
