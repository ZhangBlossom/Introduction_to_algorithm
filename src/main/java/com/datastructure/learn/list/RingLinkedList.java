package com.datastructure.learn.list;

import java.util.Iterator;

/**
 * @author: 张锦标
 * @date: 2023/4/27 16:07
 * RingLinkedList类
 */
public class RingLinkedList implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node {
        Node prev; // 上一个节点指针
        int value; // 值
        Node next; // 下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null); //哨兵头节点

    public RingLinkedList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        a.prev = added;
    }

    public void addLast(int value) {
        Node a = sentinel.prev; //最后一个节点
        Node b = sentinel; //插入节点的后一个节点
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void removeFirst() {
        Node removed = sentinel.next; //获取到第一个节点
        if (removed == sentinel) {
            throw new RuntimeException("当前链表为空，不能删除数据");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next=b;
        b.prev=a;
    }

    public void removeLast() {
        Node removed = sentinel.prev;//获取到最后一个节点
        if (removed==sentinel){
            throw new RuntimeException("当前链表为空，不能删除数据");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }
    public void removeByValue(int value){
        Node removed = findByValue(value);
        if (removed==null){
            return ;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }
    private Node findByValue(int value){
        Node p = sentinel.next;
        while (p!=sentinel){
            if (p.value == value){
                return p;
            }
            p=p.next;
        }
        return null;
    }
    public static void main(String[] args) {
        RingLinkedList rll = new RingLinkedList();
        rll.addFirst(1);
        rll.addFirst(2);
        rll.addFirst(3);
        //rll.removeFirst();
        rll.removeLast();
        //rll.removeByValue(3);
        for (Integer integer : rll) {
            System.out.println(integer);
        }
    }
}
