package keypoint.tree.traverse;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/11 17:15
 * RecDFS类
 * 基于递归实现DFS
 */
public class RecDFS {
    public void recDFS(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root.val);
        recDFS(root.left);
        recDFS(root.right);
    }
}
