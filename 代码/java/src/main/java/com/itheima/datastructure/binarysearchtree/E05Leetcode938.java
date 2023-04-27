package com.itheima.datastructure.binarysearchtree;

import java.util.LinkedList;

/**
 * 求范围和
 */
public class E05Leetcode938 {
    // 解法2. 上下限递归 0ms
    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        }
        if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        }
        // 在范围内
        return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
    }

    // 解法1. 中序遍历非递归实现 4ms
    public int rangeSumBST1(TreeNode node, int low, int high) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while(p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
                if (pop.val > high) {
                    break;
                }
                if (pop.val >= low) {
                    sum += pop.val;
                }
                p = pop.right;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        /*
                 10
                /  \
               5    15
              / \    \
             3   7    18        low=7  high=15
         */
        TreeNode n1 = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        TreeNode n2 = new TreeNode(15, null, new TreeNode(18));
        TreeNode root = new TreeNode(10, n1, n2);

        int sum = new E05Leetcode938().rangeSumBST(root, 7, 15);
        System.out.println(sum); // 应为 32
    }
}
