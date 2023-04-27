package com.itheima.datastructure.deque;

import java.util.Iterator;

/**
 * 基于循环数组实现, 特点
 * <ul>
 *     <li>容量是2的幂</li>
 *     <li>head 停下来的位置不存储, 会浪费一个位置</li>
 * </ul>
 *
 * @param <E> 元素类型
 */
public class ArrayDeque2<E> implements Deque<E>, Iterable<E> {

    E[] array;
    int head;
    int tail;

    @SuppressWarnings("all")
    public ArrayDeque2(int capacity) {
        if ((capacity & capacity - 1) != 0) {
            throw new IllegalArgumentException("capacity 必须是2的幂");
        }
        array = (E[]) new Object[capacity];
    }

    /*
                                h
                            t
        0   1   2   3   4   5   6   7
        0   1   2   3   4   5      -1

                h
        0   1   2   3
        1           2
     */

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        array[head-- & array.length - 1] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        array[++tail & array.length - 1] = e;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        int idx = ++head & array.length - 1;
        E e = array[idx];
        array[idx] = null; // help GC
        return e;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        int idx = tail-- & array.length - 1;
        E e = array[idx];
        array[idx] = null; // help GC
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head + 1 & array.length - 1];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[tail & array.length - 1];
    }

    @Override
    public boolean isEmpty() {
        return tail - head == 0;
    }

    /*
        head=-4

        0   1   2   3
        a   d   c   b
     */
    @Override
    public boolean isFull() {
        return tail - head == array.length - 1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                return array[++p & array.length - 1];
            }
        };
    }
}
