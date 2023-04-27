package com.itheima.datastructure.deque;

/**
 * 双端队列接口
 * @param <E> 队列中元素类型
 */
public interface Deque<E> {

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
