package leetcode.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/5 13:18
 * _700BinTreeSearch类
 * 搜索二叉树中等于当前val值的节点 返回该节典
 */
public class _700BinTreeSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val<val){
            return searchBST(root.right,val);
        }else if(root.val>val){
            return searchBST(root.left,val);
        }else{
            return root;
        }
    }
}
