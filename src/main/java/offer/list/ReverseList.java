package offer.list;

/**
 * @author: 张锦标
 * @date: 2023/7/3 9:23
 * ReverseList类
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
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

}
