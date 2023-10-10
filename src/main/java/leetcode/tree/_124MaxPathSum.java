package leetcode.tree;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/4 17:55
 * _124MaxPathSum类
 */
public class _124MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归计算左右子节点的最大贡献值
        //只有最大贡献值大于0才被选取
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        //节点的最大路径取决于左右子树的和+当前节点的和
        int curPathMaxSum = leftGain + rightGain + root.val;
        //更新答案
        maxSum = Math.max(curPathMaxSum, maxSum);
        //返回节点的最大贡献值
        return root.val + Math.max(leftGain, rightGain);
    }
}
