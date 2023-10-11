package offer.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/7/4 20:19
 * LongestStaggeredPath类
 * 1372
 */
public class LongestStaggeredPath {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,0,true);
        dfs(root,0,false);
        return max;
    }

    /**
     *
     * @param root
     * @param count
     * @param turnLeft 表示应该跳转的方向 true为应该向左
     *                 false为应该向右
     *                 如果为true但是左节点为空，那么count=1
     *                 如果true但是左节点不为空，那么count=count+1
     */
    public void dfs(TreeNode root,int count,boolean turnLeft){
        max = Math.max(count,max);
        if (!turnLeft){ //应该向左
            if (root.left!=null){
                //左不为空 向左长度+1 并且设定turnLeft为向右 表示下一次应该向右
                dfs(root.left,count+1,true);
            }
            if (root.right!=null){
                dfs(root.right,1,false);
            }
        }else{ //应该向右
            if (root.left!=null){
                dfs(root.left,1,true);
            }
            if (root.right!=null){
                dfs(root.right,count+1,false);
            }
        }
    }
}
