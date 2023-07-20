package offer.heap.list;

/**
 * @author: 张锦标
 * @date: 2023/7/4 12:33
 * TwinbownSum类
 */
public class _TwinbownSum {
    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //----反转链表----重点部分------
        //后半段节点的头节点 last
        ListNode last = slow.next;
        //while (last.next != null) {
        //    ListNode cur = last.next; //5
        //    last.next = cur.next;//4->6
        //    cur.next = slow.next;//5->4
        //    slow.next = cur; //3->5->4->6
        //}
        last = reverseList(last);
        slow.next = last;
        int ans = 0;
        ListNode x = head;
        ListNode y = slow.next;
        while (y != null) {
            ans = Math.max(ans, x.val + y.val);
            x = x.next;
            y = y.next;
        }
        return ans;

    }

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode temp = head;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        pairSum(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
                new ListNode(6, null)))))));
    }
}
