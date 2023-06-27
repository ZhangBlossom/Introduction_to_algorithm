package leetcode.easy.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/2/27 8:43
 * CycleList类
 */
public class CycleList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
