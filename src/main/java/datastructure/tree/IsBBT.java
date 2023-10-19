package datastructure.tree;

import leetcode.tree.TreeNode;
import sun.reflect.generics.tree.ReturnType;

/**
 * @author: 张锦标
 * @date: 2023/10/19 15:58
 * IsBBT类
 * 是否是平衡二叉树
 */
public class IsBBT {
    /**
     * 1：左子树是平衡二叉树
     * 2：右子树是平衡二叉树
     * 3：左右子树高度差绝对不不大于1
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public static boolean  isBalancedX(TreeNode head){
        return ReturnType.process(head).isBalanced;
    }

    public static void main(String[] args) {
        System.out.println(isBalancedX(TreeNode.getBBT()));
        System.out.println(isBalanced(TreeNode.getBBT() ));
    }
    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int hei) {
            isBalanced = isB;
            height = hei;
        }

        public static ReturnType process(TreeNode head) {
            if (head == null) {
                return new ReturnType(true, 0);
            }
            ReturnType leftData = process(head.left);
            ReturnType rightData = process(head.right);
            int height = Math.max(leftData.height, rightData.height) + 1;
            boolean isBalanced =
                    leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
            return new ReturnType(isBalanced, height);
        }
    }
}
