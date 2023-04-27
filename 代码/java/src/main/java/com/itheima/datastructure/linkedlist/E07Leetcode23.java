package com.itheima.datastructure.linkedlist;

/**
 * 合并多个有序链表
 */
public class E07Leetcode23 {
    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p2 == null) {
            return p1;
        }
        if (p1 == null) {
            return p2;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists(p1, p2.next);
            return p2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    // 返回合并后的链表, i, j 代表左右边界
    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) { // 数组内只有一个链表
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left, right);
    }

    /**
     * <h3>Divide and Conquer 分而治之（分、治、合）</h3>
     * <h3>Decrease and Conquer 减而治之</h3>
     */

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
        };
        ListNode m = new E07Leetcode23().mergeKLists(lists);
        System.out.println(m);
    }
}
