package tree;

import leetcode.list.ListNode;
import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/3 14:31
 * _109ListToTree类
 */
public class _109ListToTree {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left==right){
            return null;
        }
        ListNode mid = getMid(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left,mid);
        root.right = buildTree(mid.next,right);
        return root;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while(fast!=right && fast.next!=right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
