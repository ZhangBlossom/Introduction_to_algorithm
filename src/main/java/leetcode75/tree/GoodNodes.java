package leetcode75.tree;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/6 11:22
 * GoodNodes类
 */
public class GoodNodes {

    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root,int pathMax) {
        if (root==null){
            return 0;
        }
        int res = 0;
        if (root.val>=pathMax){
            res++;
            pathMax = root.val;
        }
        res+=dfs(root.left,pathMax)+dfs(root.right,pathMax);
        return res;
    }
}
