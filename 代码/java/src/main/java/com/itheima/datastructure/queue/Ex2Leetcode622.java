package com.itheima.datastructure.queue;

/**
 * 实现队列,基于数组
 */
public class Ex2Leetcode622 {

    public static void main(String[] args) {
        Ex2Leetcode622 queue = new Ex2Leetcode622(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.Rear());
    }

    private int head = 0;
    private int tail = 0;
    private final int[] array;
    private final int length;

    public Ex2Leetcode622(int capacity) {
        length = capacity + 1;
        array = new int[length];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(tail - 1 + length) % length];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % length == head;
    }
}
