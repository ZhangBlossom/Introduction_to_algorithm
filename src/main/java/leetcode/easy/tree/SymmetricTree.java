package leetcode.easy.tree;


/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/23 14:05
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 101对称二叉树
 */
public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public static void main(String[] args) {

    }
}
