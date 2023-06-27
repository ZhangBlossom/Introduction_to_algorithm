package leetcode.list.easy;

import leetcode.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/6/20 13:47
 * MergeSortedList类
 */
public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    public static void  inorderTraverseList(ListNode head){
        if (head==null){
            return ;
        }
        inorderTraverseList(head.next);
        System.out.println(head.val);
    }
    public static void main(String[] args) {
        //mergeTwoLists2(new ListNode(1,new ListNode(2,new ListNode(5,null))),
        //        new ListNode(2,new ListNode(4,new ListNode(5,null))) );
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(5, null)));
        inorderTraverseList(head);
    }
}
