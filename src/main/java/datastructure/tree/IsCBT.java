package datastructure.tree;

import leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * @author: 张锦标
 * @date: 2023/10/19 15:32
 * IsCompleteBT类
 */
public class IsCBT {
    /*
    两种情况：
    1：如果有右无左false
    2：不违反1，但是遇到第一个左右子节点不全，
    后续皆为叶子节点
     */
    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        //是否遇到过左右两个孩子不双全的节点
        //遇到之后永远为true
        boolean leaf = false;
        TreeNode left = null;
        TreeNode right = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if (
                //已经遇到了一个非双全的节点，并且当前节点不是叶子节点 也直接返回false
                    (leaf && (left != null || right != null)) ||
                            //有有孩子没有左孩子 直接返回false
                            (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            //遇到了叶子节点 那么leaf事件设定为true
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
