package leetcode.list;

import leetcode.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/7/24 13:33
 * MergeKLists类
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeList(res, lists[i]);
        }
        return res;
    }

    private ListNode mergeList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode pa = a;
        ListNode pb = b;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
                tail.next = pa;
                pa = pa.next;
            } else {
                tail.next = pb;
                pb = pb.next;
            }
            tail=tail.next;
        }
        tail.next = pa == null ? pb : pa;
        return head.next;
    }
}
