package leetcode.list;

import leetcode.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/6/18 11:50
 * SwapNode类
 */
public class SwapNode {
    public ListNode swapPairs1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(0, head);
        ListNode temp = preHead;
        while (temp.next != null && temp.next.next != null) { //1 2 3 4
            ListNode node1 = temp.next; //1
            ListNode node2 = temp.next.next; //2
            node1.next = node2.next; //1 3 4
            node2.next = node1; //2 1 3 4
            temp.next = node2; //0 2 1 3 4
            temp = node1; //
        }
        return preHead.next;
    }
    //递归快速解决
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs(three);

        return two;
    }
}
