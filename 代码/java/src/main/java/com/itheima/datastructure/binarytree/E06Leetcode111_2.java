package com.itheima.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小深度 - 层序遍历实现
 *
 *
 */
public class E06Leetcode111_2 {
    /*
        层序遍历，遇到的第一个叶子节点所在层就是最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth ++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
