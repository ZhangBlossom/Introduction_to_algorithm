package leetcode.list;

import leetcode.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/6/10 11:15
 * PalindromeList类
 */
public class PalindromeList {
    /**
     * 这种判断回文的方式比较装B，其实现方式为：
     * 先使用快慢指针的方式，得到链表中间和末尾。
     * 然后让末尾指针去反转链表节点，如下
     * 1-》2-》3《-2《-1
     * 然后再次让末尾指针和头指针从新遍历，判断值是否相等
     * 其他方法当然也可以判断，这种主要是面试为了，
     * 这是一种原地算法，不需要额外空间。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        //寻找中间节点
        while (n2.next != null && n2.next.next != null) {
            n1=n1.next; //n1-->mid
            n2=n2.next.next; //n2-->end
        }
        n2 = n1.next; //n2-->right part first node
        n1.next = null; //mid.next=null
        ListNode n3 = null;
        while (n2!=null){ //right part convert
            n3 = n2.next; //n3->save next node
            n2.next = n1; //next of right node convert
            n1 = n2; //n1 move
            n2 = n3; //n2 move
        }
        n3 = n1;//n3->save last node
        n2 = head; //n2->left first node
        boolean res = true;
        while(n1!=null && n2!=null){ //check palindrome
            if (n1.val!=n2.val){
                res= false;
                break;
            }
            n1 = n1.next; //left to mid
            n2 = n2.next; // right to mid
        }
        //返回之前逆序回来
        n1 = n3.next;
        n3.next = null;
        while (n1!=null){ //recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }


    // ---------------------以下是简单版本的代码------------------------
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

    public boolean isPalindromeX(ListNode head) {
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


    //从后往前输出
    public void reverseList(ListNode head) {
        if (head != null) {
            reverseList(head.next);
            System.out.println(head.val);
        }
    }
}

