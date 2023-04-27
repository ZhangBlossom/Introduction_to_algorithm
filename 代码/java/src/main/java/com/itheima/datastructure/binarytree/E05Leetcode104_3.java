package com.itheima.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大深度 - 使用层序遍历
 */
public class E05Leetcode104_3 {

    /*
        思路：
        1. 使用层序遍历, 层数即最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
//                System.out.print(poll.val + "\t");
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
//            System.out.println();
            depth ++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),
                        2,
                        new TreeNode(new TreeNode(7), 5, null)
                ),
                1,
                new TreeNode(null, 3, new TreeNode(6)));
        new E05Leetcode104_3().maxDepth(root);
    }
}
