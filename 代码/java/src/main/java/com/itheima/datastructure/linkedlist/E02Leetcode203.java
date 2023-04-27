package com.itheima.datastructure.linkedlist;

/**
 * 根据值删除节点
 */
public class E02Leetcode203 {
    /**
     * 方法1
     *
     * @param head 链表头
     * @param val  目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                // 删除, p2 向后平移
                p1.next = p2.next;
            } else {
                // p1 p2 向后平移
                p1 = p1.next;
            }
        }
        return s.next;
    }

    /**
     * 方法2
     *
     * @param p   链表头
     * @param val 目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements(ListNode p, int val) {
        if (p == null) {
            return null;
        }
        if (p.val == val) {
            return removeElements(p.next, val);
        } else {
            p.next = removeElements(p.next, val);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 6);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new E02Leetcode203()
                .removeElements(head, 6));
    }
}
