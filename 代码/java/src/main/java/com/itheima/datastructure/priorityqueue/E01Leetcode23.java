package com.itheima.datastructure.priorityqueue;

import com.itheima.datastructure.linkedlist.ListNode;

/**
 * 合并多个有序链表
 */
public class E01Leetcode23 {
    public ListNode mergeKLists2(ListNode[] lists) {
        MinHeap heap = new MinHeap(100);
        // 1. 将链表的所有节点加入小顶堆
        for (ListNode p : lists) {
            while (p != null) {
                heap.offer(p);
                p = p.next;
            }
        }
        // 2. 不断从堆顶移除最小元素, 加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while(!heap.isEmpty()) {
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            t.next = null; // 保证尾部节点指向 null
        }
        return s.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        // 1. 将链表的头节点加入小顶堆
        for (ListNode h : lists) {
            if(h != null) {
                heap.offer(h);
            }
        }
        // 2. 不断从堆顶移除最小元素, 加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while(!heap.isEmpty()) {
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            // 将最小元素的下一个节点加入到堆
            if(min.next != null) {
                heap.offer(min.next);
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null,
        };
        ListNode m = new E01Leetcode23().mergeKLists2(lists);
        System.out.println(m);
    }
}
