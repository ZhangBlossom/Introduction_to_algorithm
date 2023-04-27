package com.itheima.datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.itheima.datastructure.binarytree.E01Leetcode144.colorPrintln;

/**
 * 二叉树后序遍历(左,右,值)
 */
public class E03Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                    pop = stack.pop();
                    result.add(pop.val);
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                    result.add(pop.val);
                }
                // 待处理右子树
                else {
                    curr = peek.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(5)),
                1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7))
        );
//        System.out.println(new E03Leetcode145().postorderTraversal(root));
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; // 代表当前节点
        TreeNode pop = null; // 最近一次弹栈的元素
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                // 待处理左子树
                colorPrintln("前:" + curr.val, 31);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    colorPrintln("中:" + peek.val, 36);
                    pop = stack.pop();
//                    colorPrintln("后:" + pop.val, 34);
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
//                    colorPrintln("后:" + pop.val, 34);
                }
                // 待处理右子树
                else {
                    colorPrintln("中:" + peek.val, 36);
                    curr = peek.right;
                }
            }
        }
    }
}
