package leetcode75.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/6 11:01
 * LowestCommonAncestor类
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //p q 其中一个是根节点那么直接返回root
        if (root==null || root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        return root;
    }
}
