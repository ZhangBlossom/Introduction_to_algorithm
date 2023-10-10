package leetcode.tree.offer;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/4 15:13
 * _Of27MirrorTree类
 * 镜像二叉树 其实就只需要吧左右子树都反转一下就好
 */
public class _27MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
