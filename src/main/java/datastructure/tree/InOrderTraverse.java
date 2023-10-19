package datastructure.tree;

import leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/10/19 9:19
 * inOrderTraverse类
 */
public class InOrderTraverse {
    public static void inOrderRecur(TreeNode head){
        if (head==null){
            return;
        }
        inOrderUnRecur(head.left);
        System.out.println(head.val);
        inOrderUnRecur(head.right);
    }
    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            System.out.println(node.val);
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }
    //1
    //2 3
    //4   4
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        inOrderUnRecur(head);
        inOrderRecur(head);
    }
}
