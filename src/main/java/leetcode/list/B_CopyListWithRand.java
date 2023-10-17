package leetcode.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @author: 张锦标
 * @date: 2023/10/17 19:53
 * B_CopyListWithRand类
 * 当前类提供一个Node，这个Node有一个rand区域。
 * 现在要求你克隆一下这个Node节点，并返回head。
 */
public class B_CopyListWithRand {
    //这种无需额外空间的实现方式是通过位置关系解决的
    //也就是1后面就是1的克隆节点，以此类推，只需要通过遍历的方式就可以解决问题
    public static Node copyListWithRandX(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        //copy node and link to every node
        //1->2
        //1->1'->2
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //set copy node rand
        //1->1'->2->2'
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
        }
        Node res = head.next;
        cur = head;
        //split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }


    //当前方法需要使用额外空间
    public static Node copyListWithRand(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Node {
    int val;
    Node next;
    Node rand;

    public Node(int val) {
        this.val = val;
    }
}
