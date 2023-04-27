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
 *
 * 带哨兵节点的链表,这个链表就不再需要判断是否是空了
 * 因为哨兵节点本身就不是空的
 */

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表(带哨兵)
 */
public class SentinelLinkedList implements Iterable<Integer> { // 整体
    private Node head = new Node(666, null); // 头指针

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类 -> 带名字内部类
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() { // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值, 并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     *
     * @param value 待添加值
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     * 遍历链表1
     *
     * @param consumer 要执行的操作
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历链表2
     *
     * @param consumer 要执行的操作
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    private Node findLast() {
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    /**
     * 向链表尾部添加
     *
     * @param value 待添加值
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null; // 没找到
    }

    /**
     * 根据索引查找
     *
     * @param index 索引
     * @return 找到, 返回该索引位置节点的值
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public int get(int index) throws IllegalArgumentException {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    /**
     * 向索引位置插入
     *
     * @param index 索引
     * @param value 待插入值
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public void insert(int index, int value) throws IllegalArgumentException {
        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) { // 找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    /**
     * 删除第一个
     *
     * @throws IllegalArgumentException - 如果不存在, 抛出 index 非法异常
     */
    public void removeFirst() throws IllegalArgumentException {
        remove(0);
    }

    /**
     * 从索引位置删除
     *
     * @param index 索引
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public void remove(int index) throws IllegalArgumentException {
        Node prev = findNode(index - 1); // 上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next; // 被删除的节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }
}













