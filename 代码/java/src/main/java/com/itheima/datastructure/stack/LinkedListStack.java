package com.itheima.datastructure.stack;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {

    private int capacity = Integer.MAX_VALUE;
    private int size;
    private final Node<E> head = new Node<>(null, null);

    public LinkedListStack() {
    }

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    /*
        head -> 2 -> 1 -> null
     */
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    /*
        head -> 2 -> 1 -> null
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (E e : this) {
            sj.add(e.toString());
        }
        return sj.toString();
    }
}
