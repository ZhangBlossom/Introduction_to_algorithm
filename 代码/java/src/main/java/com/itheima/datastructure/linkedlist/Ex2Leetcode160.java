package com.itheima.datastructure.linkedlist;

public class Ex2Leetcode160 {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = b;
        while (true) {
            if (p1 == p2) {
                return p1;
            }
            if (p1 == null) {
                p1 = b;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = a;
            } else {
                p2 = p2.next;
            }
        }
    }

    public static void main(String[] args) {
//        ListNode c = ListNode.of(4, 5);
//        ListNode a = ListNode.of(1, 2).append(c);
//        ListNode b = ListNode.of(3).append(c);

        ListNode c = ListNode.of(1);
        ListNode a = c;
        ListNode b = c;

        System.out.println(new Ex2Leetcode160().getIntersectionNode(a, b));
    }
}
