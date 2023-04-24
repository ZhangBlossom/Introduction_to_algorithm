package main.java.com.leetcode.learn.easy.list;

/**
 * @author: 张锦标
 * @date: 2023/2/27 10:12
 * Zhongjianjiedian类
 */
public class Zhongjianjiedian {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
