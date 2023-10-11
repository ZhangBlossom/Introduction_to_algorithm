package leetcode75.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/6 11:03
 * LongestZigZag类
 */
public class LongestZigZag {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root.left,1,true);
        dfs(root.right,1,false);
        return max;
    }
    //isLeft表示是否向左
    //如果当前就是向左走 并且参数传递的上一次也是左走
    //那么就需要重新计数 也就是 count=1 否则count+1
    private void dfs(TreeNode root, int count, boolean isLeft) {
        if (root==null){
            return;
        }
        max = Math.max(count,max);
        dfs(root.left,isLeft?1:count+1,true);
        dfs(root.right,!isLeft?1:count+1,false);
    }
}
