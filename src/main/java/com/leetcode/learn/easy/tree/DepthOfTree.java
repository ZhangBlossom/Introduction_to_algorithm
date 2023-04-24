package main.java.com.leetcode.learn.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/24 9:23
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class DepthOfTree {
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
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepthDFS(root.left);
            int rightHeight = maxDepthDFS(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int maxDepth(TreeNode root) { //广度优先遍历
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
