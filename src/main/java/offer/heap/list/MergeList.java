package offer.heap.list;

/**
 * @author: 张锦标
 * @date: 2023/7/3 9:45
 * MergeList类
 */
public class MergeList {
    //合并两个有序链表方法1
    public ListNode mergeList1(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0, null);
        ListNode pre = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }

    //合并两个有序链表使用递归 方法2
    public ListNode mergeList2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeList2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList2(l1, l2.next);
            return l2;
        }
    }

}
