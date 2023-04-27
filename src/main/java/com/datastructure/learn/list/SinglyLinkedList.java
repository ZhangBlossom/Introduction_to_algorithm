package com.datastructure.learn.list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author: 张锦标
 * @date: 2023/4/26 21:19
 * SinglyLinkedList类
 * 内部类什么时候需要加static？
 * 1：当这个内部类使用了外部类的成员变量时，就不能使用static
 * 2：如果这个内部类没有使用外部类的成员变量，比如这里的Node，
 * 那么就可以直接使用static，推荐是能使用static就加上
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null; //头指针

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Integer next() {
                int value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        //1：链表为空
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        //2：链表非空
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(value, null);
    }

    public void add(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node node = findNode(index - 1);
        if (node == null) {
            throw new RuntimeException("索引不合法");
        }
        node.next = new Node(value, node.next);
    }

    public int removeFirst() {
        if (head == null) {
            throw new RuntimeException("链表为空,不可以删除数据");
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    public int remove(int index) {
        if (index==0){
            return removeFirst();
        }
        Node node = findNode(index - 1);
        if (node == null || node.next == null) {
            throw new RuntimeException("索引不合法");
        }
        int value = node.next.value;
        node.next = node.next.next;
        return value;
    }

    public void loop(Consumer<Integer> consumer) {
        Node temp = head;
        while (temp != null) {
            //System.out.println(temp.value);
            //temp=temp.next;
            consumer.accept(temp.value);
            temp = temp.next;
        }
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p.next != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw new RuntimeException("索引不合法");
        }
        return node.value;
    }

    public void loopFor(Consumer<Integer> consumer) {
        Node temp = head;
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.addLast(5);
        singlyLinkedList.addLast(6);
        singlyLinkedList.addLast(7);
        singlyLinkedList.addLast(8);
        singlyLinkedList.add(2, 123);
        singlyLinkedList.add(0, 123);
        singlyLinkedList.remove(3);
        singlyLinkedList.removeFirst();
        singlyLinkedList.removeFirst();
        singlyLinkedList.removeFirst();
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }
}
