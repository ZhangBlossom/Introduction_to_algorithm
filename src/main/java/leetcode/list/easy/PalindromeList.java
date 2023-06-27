package leetcode.list.easy;

import leetcode.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/6/10 11:15
 * PalindromeList类
 */
public class PalindromeList {

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }


    //public boolean isPalindrome(ListNode head){
    //    StringBuilder sb = new StringBuilder();
    //    ListNode temp = head;
    //    while(temp!=null){
    //        sb.append(temp.val);
    //        temp=temp.next;
    //    }
    //    return sb.toString().equals(sb.reverse().toString());
    //}

    public void reverseList(ListNode head){
        if(head!=null){
            reverseList(head.next);
            System.out.println(head.val);
        }
    }
}

