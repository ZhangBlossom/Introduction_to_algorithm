package leetcode75.tree;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/6 11:11
 * PathSum3类
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return 0;
        }
        int ret=dfs(root,targetSum);
        ret+=pathSum(root.left,targetSum);
        ret+=pathSum(root.right,targetSum);
        return ret;
    }

    private int dfs(TreeNode root, long targetSum) {
        int ret = 0;
        if (root==null){
            return 0;
        }
        int val = root.val;
        if (val==targetSum){
            ret++;
        }
        ret+=dfs(root.left,targetSum-val);
        ret+=dfs(root.right,targetSum-val);
        return ret;
    }
}
