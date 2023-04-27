package com.itheima.datastructure.binarysearchtree;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 判断是否为合法的二叉搜索树
 */
public class E04Leetcode98 {
    // 解法1. 中序遍历非递归实现 1ms
    public boolean isValidBST1(TreeNode node) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE; // 代表上一个值
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
//                System.out.println("compare:" + prev + " " + pop.val);
                if (prev >= pop.val) {
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }

    // 解法2. 中序遍历递归实现(全局变量记录 prev) 0ms
    long prev = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean a = isValidBST2(node.left);
        if (!a) {
            return false;
        }
        if (prev >= node.val) {
            return false;
        }
        prev = node.val;
        return isValidBST2(node.right);
    }

    // 解法3. 中序遍历递归实现(局部变量记录 prev) 0ms
    public boolean isValidBST3(TreeNode node) {
        return doValid3(node, new AtomicLong(Long.MIN_VALUE));
    }
    private boolean doValid3(TreeNode node, AtomicLong prev) {
        if (node == null) {
            return true;
        }
        boolean a = doValid3(node.left, prev);
        if (!a) {
            return false;
        }
        if (prev.get() >= node.val) {
            return false;
        }
        prev.set(node.val);
        return doValid3(node.right, prev);
    }

    /*
         能否只判断父亲比左孩子大，比右孩子小?
                 4
               /   \
              2     6
             / \
            1   3
    */
    /*
              -∞ 4 +∞
               /   \
           -∞ 2  4  6 +∞
                   / \
                4 3 6 7 +∞
     */
    // 解法4. 上下限递归实现 0ms
    public boolean isValidBST(TreeNode node) {
        return doValid4(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValid4(TreeNode node, long min, long max){
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return doValid4(node.left, min, node.val) && doValid4(node.right, node.val, max);
    }


    public static void main(String[] args) {
        /*
                4
               / \
              2   6
             / \
            1   3
        */
        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(new E04Leetcode98().isValidBST(root1));
//        System.out.println("---------------");
        /*
                4
               / \
              2   6
                 / \
                3   7
         */
        TreeNode root2 = new TreeNode(4, new TreeNode(2), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(new E04Leetcode98().isValidBST(root2));
//        System.out.println("---------------");

        /*
               1
              /
             1
         */
        TreeNode root3 = new TreeNode(1, new TreeNode(1), null);
        System.out.println(new E04Leetcode98().isValidBST(root3));
//        System.out.println("---------------");

        /*
              3
               \
                4
               /
              5
         */
        TreeNode root4 = new TreeNode(3, null, new TreeNode(4, new TreeNode(5), null));
        System.out.println(new E04Leetcode98().isValidBST(root4));
    }
}
