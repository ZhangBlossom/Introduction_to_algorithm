package leetcode.easy.tree;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/22 18:44
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 100
 */
public class SameTree {
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


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }


    public static void main(String[] args) {

    }
}
