package tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/4 14:35
 * _617MegerTree类
 */
public class _617MegerTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        TreeNode mergeRoot = new TreeNode(root1.val+ root2.val);
        mergeRoot.left = mergeTrees(root1.left,root2.left);
        mergeRoot.right = mergeTrees(root1.right,root2.right);
        return mergeRoot;
    }
}
