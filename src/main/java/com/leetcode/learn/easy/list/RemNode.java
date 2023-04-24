package main.java.com.leetcode.learn.easy.list;

/**
 * @author: 张锦标
 * @date: 2023/2/27 8:19
 * RemNode类
 */
public class RemNode {

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
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {//必须得temp.next.val==val
            //因为如果使用temp。val的方式去判断
            //那么就得保存一个temp的前置节点pre
            //使得pre。next=temp。next。next；
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
