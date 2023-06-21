package com.leetcode.learn.list.middle;

import com.leetcode.learn.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/6/20 10:24
 * ReverseBetween类
 */
public class ReverseBetweenList {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode pre = dummyNode;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }
        //left的前一个节点
        ListNode preLeftNode = pre;
        for(int i=0;i<right-left+1;i++){
            pre = pre.next;
        }
        //得到right节点
        ListNode rightNode = pre;

        ListNode rightNodeNext = rightNode.next;
        ListNode leftNode = preLeftNode.next;
        preLeftNode.next = null;
        rightNode.next=null;
        ListNode reverseListHead = reverseList(leftNode);

        preLeftNode.next=reverseListHead;
        leftNode.next = rightNodeNext;
        return dummyNode.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        reverseBetween(head,2,4);
    }
}
