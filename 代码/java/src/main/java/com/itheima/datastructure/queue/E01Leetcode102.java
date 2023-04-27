package com.itheima.datastructure.queue;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历
 */
public class E01Leetcode102 {

    /*
        [
            [1]
            [2,3]
            [4,5,6,7]
        ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(); // 保存每一层结果
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }

        return result;
    }

    /*
                  1
                 / \
                2   3
               /\   /\
              4  5 6  7

              头 [] 尾

              1 2 3 4 5 6 7
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        List<List<Integer>> lists = new E01Leetcode102().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        /*LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()) {
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n + " ");
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
        }*/
    }
}
