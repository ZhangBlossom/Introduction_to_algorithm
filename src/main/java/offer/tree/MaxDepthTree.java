package offer.tree;

/**
 * @author: 张锦标
 * @date: 2023/7/4 12:54
 * MaxDepthTree类
 */
public class MaxDepthTree {
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
