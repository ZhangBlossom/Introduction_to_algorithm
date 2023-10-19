package datastructure.tree;

import leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/10/19 9:19
 * postOrderTraverse类
 */
public class PostOrderTraverse {
    public static void postOrderRecur(TreeNode head){
        if (head==null){
            return;
        }
        postOrderUnRecur(head.left);
        postOrderUnRecur(head.right);
        System.out.println(head.val);
    }
    //后续遍历：左右根 所以对于使用栈这种结构
    //应该先把根压进去 ，然后压右，最后压左。
    //此时输出的就是左右根
    //非递归方法需要用到两个栈
    public static void postOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>(); //用来存放位置
        Stack<TreeNode> stack2 = new Stack<>(); //用来输出
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left!=null){
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
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
        postOrderUnRecur(head);
        postOrderRecur(head);
    }
}
