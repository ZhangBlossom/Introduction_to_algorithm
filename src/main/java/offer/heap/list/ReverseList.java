package offer.heap.list;

/**
 * @author: 张锦标
 * @date: 2023/7/3 9:23
 * ReverseList类
 */
public class ReverseList {
    //这种反转链表是通过返回新的节点的方式来得到反转后的链表的
    //因此需要使用的是返回值
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
