package keypoint.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/11 10:11
 * _124MaxPathSum类
 */
public class _124MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);//huauri
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);
        int curMaxSum = leftGain+rightGain+root.val;
        maxSum = Math.max(maxSum,curMaxSum);
        return root.val+ Math.max(leftGain,rightGain);
    }

}
