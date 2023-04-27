package com.itheima.temp.list;

import com.itheima.datastructure.linkedlist.ListNode;

public class Test {


    /*
        head(1) > 2 > 3 > 4 > 5 > null
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            newHead = new ListNode(p.val, newHead);
            p = p.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(n1);
        ListNode newHead = reverseList(n1);
        System.out.println(newHead);
    }
}
