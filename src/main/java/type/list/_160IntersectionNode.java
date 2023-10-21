package type.list;

import leetcode.list.ListNode;

/**
 * @author: 张锦标
 * @date: 2023/10/21 17:12
 * IntersectionNode类
 * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。
 * 这个位置只能是较短链表的头结点位置。 为此，我们必须消除两个链表的长度差
 *
 * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
 * 如果 pA 到了末尾，则 pA = headB 继续遍历
 * 如果 pB 到了末尾，则 pB = headA 继续遍历
 * 比较长的链表指针指向较短链表head时，长度差就消除了
 * 如此，只需要将最短链表遍历两次即可找到位置
 *
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/10774/tu-jie-xiang-jiao-lian-biao-by
 */
public class _160IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==null || headB==null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa!=pb){
            pa = pa==null?headB:pa.next;
            pb = pb==null?headA:pb.next;
        }
        return pa;
    }
}
