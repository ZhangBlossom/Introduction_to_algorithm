package com.itheima.datastructure.queue;

/**
 * 实现队列,基于数组(未考虑正整数越界)
 */
public class Ex3Leetcode622 {
    public static void main(String[] args) {
        Ex3Leetcode622 queue = new Ex3Leetcode622(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.Front());
        queue.deQueue();
        System.out.println(queue.Front());
        System.out.println(queue.Rear());
    }

    private int head = 0;
    private int tail = 0;
    private final int[] array;
    private final int capacity;

    public Ex3Leetcode622(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[tail++ % capacity] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[head % capacity];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(tail - 1) % capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == capacity;
    }
}
