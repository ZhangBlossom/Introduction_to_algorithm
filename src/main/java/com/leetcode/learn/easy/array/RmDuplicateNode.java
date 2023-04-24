package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/20 22:14
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class RmDuplicateNode {
    static class ListNode {
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
//
//    public static ListNode deleteDuplicates(ListNode head) {
//        ListNode headResult = head;
//        ListNode temp = head;
//        boolean flag = false;
//        while (head.next != null) {
//            flag = false;
//            int cur = temp.val;
//            for (; temp.val == cur; temp = temp.next) {
//                flag = true;
//            }
//            if (flag) {
//                head.next = temp;
//            }
//            head = head.next;
//        }
//        return headResult;
//    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //如果出现的值重复了 那么直接把这个值用其后面的值覆盖他就行
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(3, null))));
    }
}
