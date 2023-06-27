package leetcode.list.middle;

import leetcode.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/6/20 11:07
 * ReverseList类
 */
public class ReverseList {
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
}
