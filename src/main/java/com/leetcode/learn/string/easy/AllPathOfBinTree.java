//package com.leetcode.learn.string.easy;
//
//
//import javax.swing.tree.TreeNode;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * @author: 张锦标
// * @date: 2023/5/14 12:37
// * AllPathOfBinTree类
// */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//public class AllPathOfBinTree {
//    public List<String> binaryTreePathsBFS(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        dfs(root, "", res);
//        return res;
//    }
//
//    private void dfs(TreeNode root, String path, List<String> res) {
//        //如果为空，直接返回
//        if (root == null) {
//            return;
//        }
//        //如果是叶子节点，说明找到了一条路径，把它加入到res中
//        if (root.left == null && root.right == null) {
//            res.add(path + root.val);
//            return;
//        }
//        //如果不是叶子节点，在分别遍历他的左右子节点
//        dfs(root.left, path + root.val + "->", res);
//        dfs(root.right, path + root.val + "->", res);
//    }
//
//
//    public List<String> binaryTreePathsDFS(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        //栈中节点和路径都是成对出现的，路径表示的是从根节点到当前
//        //节点的路径，如果到达根节点，说明找到了一条完整的路径
//        Stack<Object> stack = new Stack<>();
//        //当前节点和路径同时入栈
//        stack.push(root);
//        stack.push(root.val + "");
//        while (!stack.isEmpty()) {
//            //节点和路径同时出栈
//            String path = (String) stack.pop();
//            TreeNode node = (TreeNode) stack.pop();
//            //如果是根节点，说明找到了一条完整路径，把它加入到集合中
//            if (node.left == null && node.right == null) {
//                res.add(path);
//            }
//            //右子节点不为空就把右子节点和路径压栈
//            if (node.right != null) {
//                stack.push(node.right);
//                stack.push(path + "->" + node.right.val);
//            }
//            //左子节点不为空就把左子节点和路径压栈
//            if (node.left != null) {
//                stack.push(node.left);
//                stack.push(path + "->" + node.left.val);
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
