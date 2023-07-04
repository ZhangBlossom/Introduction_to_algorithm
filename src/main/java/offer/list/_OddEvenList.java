package offer.list;

/**
 * @author: 张锦标
 * @date: 2023/7/4 9:24
 * OddEvenList类
 */
public class _OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head; //1 2 3 4 5 6 7
        ListNode evenList = null;
        ListNode evenListTemp = null;
        ListNode oddListTail = null;
        while (temp != null) {
            ListNode next = temp.next;
            if (evenList == null) {
                evenList = next;
                evenListTemp = evenList;
            } else if (evenList != null) {
                evenListTemp.next = next;
                evenListTemp = evenListTemp.next;
            }
            if (next != null) {
                temp.next = next.next;
            }
            if (temp.next == null) {
                oddListTail = temp;
            }
            temp = temp.next;
        }
        oddListTail.next = evenList;
        return head;
    }

    public static void main(String[] args) {
        oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6,new ListNode(7,null))))))));
    }
}
