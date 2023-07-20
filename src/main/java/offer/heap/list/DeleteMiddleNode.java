package offer.heap.list;

/**
 * @author: 张锦标
 * @date: 2023/7/3 9:55
 * DeleteMiddleNode类
 */
public class DeleteMiddleNode {
    //快慢指针删除中间节点
    //快指针一次性移动两个位置
    //慢指针一次一个位置
    public ListNode deleteMiddle1(ListNode head) {
        ListNode myHeader = new ListNode(0, head); // 哨兵
        ListNode p1 = myHeader;
        ListNode p2 = myHeader.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p1.next = p1.next.next;
        return myHeader.next;
    }
    //暴力
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = head;
        int length = getLength(dummyNode) / 2;
        if (length==0){
            return null;
        }
        while (--length > 0) { //1 2 3 4 5
            dummyNode = dummyNode.next;
        }
        if (dummyNode.next != null) {
            dummyNode.next = dummyNode.next.next;
        }
        return head;
    }

    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
