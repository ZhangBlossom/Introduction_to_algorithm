package com.itheima.datastructure.linkedlist;

/**
 * 删除指定节点
 */
public class Ex1Leetcode237 {
    /**
     * @param node 待删除节点, 题目已说明肯定不是最后一个节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        new Ex1Leetcode237().deleteNode(o3);
        System.out.println(o1);
    }
}
