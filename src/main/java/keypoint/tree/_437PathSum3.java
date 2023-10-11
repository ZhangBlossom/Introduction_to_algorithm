package keypoint.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/11 20:11
 * _437PathSum3类
 */
public class _437PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = rootSum(root,targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }

    private int rootSum(TreeNode root, int targetSum) {
        int res = 0;
        if (root==null){
            return 0;
        }
        if (targetSum == root.val){
            res++;
        }
        res+=rootSum(root.left,targetSum-root.val);
        res+=rootSum(root.right,targetSum-root.val);
        return res;
    }
}
