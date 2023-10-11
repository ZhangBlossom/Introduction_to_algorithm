package keypoint.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/10 22:09
 * _112PathSum类
 * 判断根节点到叶子节点是否存在某一个路径的和等于我们的要求
 */
public class _112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.left==null && root.right==null){
            return root.val==targetSum;
        }
        return findSum(root.left,targetSum-root.val)
                || findSum(root.right,targetSum-root.val);
    }

    private boolean findSum(TreeNode root, int target) {
        if (root==null){
            return false;
        }
        if (root.left==null && root.right==null){
            return root.val==target;
        }else{
            return findSum(root.left,target-root.val) ||
                    findSum(root.right,target-root.val);
        }
    }
}
