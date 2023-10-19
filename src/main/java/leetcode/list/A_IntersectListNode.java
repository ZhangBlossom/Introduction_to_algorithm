package leetcode.list;

/**
 * @author: 张锦标
 * @date: 2023/10/17 21:03
 * A_IntersectListNode类
 */
public class A_IntersectListNode {
    /**
     * 解决链表有无环的问题，有两种方式，一种是用set集合去存储节点
     * 那么只要存储节点放入节点失败的时候，就说明出现了重复的值，此时就是环
     * 第二种方式使用快慢指针，比较难。
     * 大概思路是，快指针每次跳两步，慢指针每次一步。
     * 在有限次数的机会里，如果有环，快慢指针最终一定会相遇，如果没有，快指针最终指向null。
     * 并且，在他们相遇之后，让快指针回到头节点并且每次都只走一步，慢指针也是一样，之后
     * 他们两个再次相遇的时候，就说明当前节点就是那个产生环的节点了。
     *
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; //slow
        Node n2 = head.next.next; //fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                //说明无环直接返回
                return null;
            }
            //否则每次都快慢指针走法
            n2 = n2.next.next;
            n1 = n1.next;
            //只要n1！=n2说明还没有相遇
            while (n1 != n2) {
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        return n1;//最终相遇的节点就是环
    }

    /**
     * 对于两个相交的链表 链表末尾位置的节点一定相等
     * 所以可以遍历一下两个链表得到长度
     * 比如第一个100，第二个80
     * 那么可以让第一个先走20步，那么只要这两个链表最终相交，
     * 两个节点一定可以相遇
     *
     * @param head1
     * @param head2
     * @return
     */
    //如果两个链表都无环 返回第一个相交节点 如果不相交 直接返回null
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //两个节点都走到末尾后不相等 说明无公共节点
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2; //谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1; //谁短，谁的头变成cur2
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //不存在一个有环一个无环
    //两个有环链表 有三种情况
    //1：都不相交 那么直接两者在循环找到自己之后 不会相遇
    //2：相交且共用环 那么按照上面无环的情况进行操作即可
    //一直循环，直到遇到

    /**
     * @param head1
     * @param loop1 链表1第一个入环节点
     * @param head2
     * @param loop2 链表2第一个入环节点
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static Node getIntersectNode(Node head1,Node head2){
        if (head1==null || head2==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1==null && loop2==null){
            return noLoop(head1,head2);
        }
        if (loop1!=null && loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }
    public static void main(String[] args) {
    }
}
