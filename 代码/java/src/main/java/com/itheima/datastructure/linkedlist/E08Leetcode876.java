package com.itheima.datastructure.linkedlist;

/**
 * 查找链表中间节点
 */
public class E08Leetcode876 {

    /*
                p1
                        p2
        1   2   3   4   5   null


                    p1
                                p2
        1   2   3   4   5   6   null
     */

    /**
     * @param head 头节点
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(new E08Leetcode876().middleNode(head1));

        ListNode head2 = ListNode.of(1, 2, 3, 4, 5, 6);
        System.out.println(new E08Leetcode876().middleNode(head2));
    }
}
