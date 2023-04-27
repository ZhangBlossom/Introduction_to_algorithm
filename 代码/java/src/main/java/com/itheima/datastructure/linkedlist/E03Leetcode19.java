package com.itheima.datastructure.linkedlist;

/**
 * 删除倒数节点
 */
public class E03Leetcode19 {
    /*
    recursion(ListNode p=1, int n=2) {
        recursion(ListNode p=2, int n=2) {
            recursion(ListNode p=3, int n=2) {
                recursion(ListNode p=4, int n=2) {
                    recursion(ListNode p=5, int n=2) {
                        recursion(ListNode p=null, int n=2) {
                            return 0;
                        }
                        return 1;
                    }
                    return 2;
                }
                if(返回值 == n == 2) {
                    删除
                }
                return 3;
            }
            return 4;
        }
        return 5;
    }
    */
    // 方法1
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursion(s, n);
        return s.next;
    }

    private int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n); // 下一个节点的倒数位置
        if (nth == n) {
            // p=3  p.next=4 p.next.next=5
            p.next = p.next.next;
        }
        return nth + 1;
    }

    /*
        n=2
        p1
        p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                  p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                       p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
     */
    // 方法2
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
//        ListNode head = ListNode.of(1,2);
        System.out.println(head);
        System.out.println(new E03Leetcode19()
                .removeNthFromEnd(head, 5));
    }
}
