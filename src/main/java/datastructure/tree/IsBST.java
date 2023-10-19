package datastructure.tree;

import leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/10/19 14:53
 * IsBST类
 */
public class IsBST {

    /**
     * leetcode写法判断是否是二哈搜索树
     *
     * @param head
     * @return
     */
    public static boolean isBST(TreeNode head) {
        return isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(TreeNode head, int low, int high) {
        if (head == null) {
            return true;
        }
        if (head.val > high || head.val < low) {
            return false;
        }
        return isBST(head.left, low, head.val) && isBST(head.right, head.val, high);
    }

    /**
     * 基于中序遍历的判断是否是二叉搜索树
     */
    static int preVal = 0;

    public static boolean isBstX(TreeNode head) {
        if (head == null) {
            return true;
        }
        boolean leftBST = isBstX(head.left);
        if (!leftBST) {
            return false;
        }
        if (preVal >= head.val) {
            return false;
        } else {
            preVal = head.val;
        }
        return isBstX(head.right);
    }


    public static boolean isBstNoRecur(TreeNode head) {
        if (head == null) {
            return true;
        }
        int pre = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre >= head.val) {
                    return false;
                } else {
                    pre = head.val;
                }
                head = head.right;
            }
        }
        return true;
    }

    //5
    //4 6
    //3   7
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(4);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(3);
        head.right.right = new TreeNode(123);
        System.out.println(isBstX(head));
        System.out.println(isBST(head));
        System.out.println(isBstNoRecur(head));
    }
}
