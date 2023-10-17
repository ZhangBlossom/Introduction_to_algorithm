package leetcode.list;

/**
 * @author: 张锦标
 * @date: 2023/10/17 19:35
 * ListPartition类
 * 链表分区
 * 当前题目要求对一个链表进行分区，要求其实现链表大于某一个数据的值在链表右边，
 * 小于某一给定的值的值在链表的左边。
 * 大概实现方式是：
 * 使用六个指针。然后遍历当前链表。然后判断当前值和给定值的大小，如果小于，那么
 * 就把这个值设定为sH也就是小于头。
 * 如果相等，设定为eH也就是等于头，如果大于，那么就设定为bH也就是大于头。
 * 然后如果后续还继续出现符合的，就用链表的方式连接到对应的头的后面，并且更新对应的尾巴。
 * 最后，只要sT-》eH-》et-》bh就完成了
 * 记住，要进行null的判断。
 */
public class A_ListPartition {
    public static ListNode listPartition(ListNode head, int pivot) {
        //使用六个指针
        ListNode sH = null; //
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode next = null;
        //这里的代码负责完成上面说的得到各个串
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        //如果有小于区域
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT; //下一步，谁去连大于区域的头，谁就变成et
        }
        //上面的if不管有没有执行，都有一个et
        if (eT != null) { //如果小于区域和待遇区域，不是都没有
            eT.next = bH; //链接大于区域
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }
}
