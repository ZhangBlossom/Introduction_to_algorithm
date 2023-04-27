package com.itheima.datastructure.linkedlist;

/**
 * 有序链表去重
 */
public class E05Leetcode82 {

    // 方法1
    public ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return deleteDuplicates1(x); // x 就是与 p 取值不同的节点
        } else {
            p.next = deleteDuplicates1(p.next);
            return p;
        }
    }

    /*
        p1 p2 p3
        s, 1, 1, 1, 2, 3, null

        p1 p2    p3
        s, 1, 1, 1, 2, 3, null

        p1 p2       p3
        s, 1, 1, 1, 2, 3, null

        p1 p3
        s, 2, 3, null

        p1 p2 p3
        s, 2, 3, null

           p1 p2 p3
        s, 2, 3, null
     */
    // 方法2
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null
                && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null
                        && p3.val == p2.val) {
                }
                // p3 找到了不重复的值
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 3, 4, 4, 5);
//        ListNode head = ListNode.of(1, 1, 1, 2, 3);
        System.out.println(head);
        System.out.println(new E05Leetcode82().deleteDuplicates(head));
    }
}
