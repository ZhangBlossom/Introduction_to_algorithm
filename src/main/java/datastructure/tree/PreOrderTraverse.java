package datastructure.tree;

import leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/10/19 9:19
 * PreOrderTraverse类
 */
public class PreOrderTraverse {
    public static void inOrderRecur(TreeNode head){
        if (head==null){
            return;
        }
        inOrderUnRecur(head.left);
        System.out.println(head.val);
        inOrderUnRecur(head.right);
    }
    //中续遍历：左根右
    //整棵树左边界进栈
    //然后依次弹出节点的过程中，打印
    //对弹出节点的右树重复
    public static void inOrderUnRecur(TreeNode head) {
        if (head!=null){
            Stack<TreeNode> stack =  new Stack<>();
            while (!stack.isEmpty() || head!=null){
                if (head!=null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.val+" ");
                    head = head.right;
                }
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
