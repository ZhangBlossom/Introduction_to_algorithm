package com.itheima.datastructure.binarytree;

import com.itheima.datastructure.stack.LinkedListStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.itheima.datastructure.binarytree.E01Leetcode144.colorPrintln;

/**
 * 二叉树中序遍历(左,值,右)
 */
public class E02Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; // 代表当前节点
        TreeNode pop = null; // 最近一次弹栈的元素

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                // 待处理左子树
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    result.add(peek.val);
                    pop = stack.pop();
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                }
                // 待处理右子树
                else {
                    result.add(peek.val);
                    curr = peek.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        System.out.println(new E02Leetcode94().inorderTraversal(root));

        LinkedListStack<TreeNode> stack = new LinkedListStack<>();

        TreeNode curr = root; // 代表当前节点
        while (curr != null || !stack.isEmpty()) {
            if(curr != null) {
//                colorPrintln("去: " + curr.val,31);
                stack.push(curr); // 压入栈，为了记住回来的路
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                colorPrintln("回: " + pop.val,34);
                curr = pop.right;
            }
        }
    }
}
