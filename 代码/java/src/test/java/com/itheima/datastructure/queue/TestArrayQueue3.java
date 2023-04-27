package com.itheima.datastructure.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayQueue3 {

    /*@Test
    public void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayQueue3<>(3));
    }*/

    @Test
    public void generic() {
        ArrayQueue3<String> queue =
                new ArrayQueue3<>(4);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        assertFalse(queue.offer("e"));

        assertIterableEquals(List.of("a", "b", "c", "d"), queue);
    }

    @Test
    public void offerLimit() {
        ArrayQueue3<Integer> queue =
                new ArrayQueue3<>(4);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        assertFalse(queue.offer(5));

        assertIterableEquals(List.of(1, 2, 3, 4), queue);
    }

    @Test
    @DisplayName("测试删除只剩一个节点时")
    public void poll1() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
        queue.offer(1);
        assertEquals(1, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void offer() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        assertIterableEquals(List.of(1, 2, 3, 4, 5), queue);
    }

    @Test
    public void peek() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
        assertNull(queue.peek());
        queue.offer(1);
        assertEquals(1, queue.peek());
        queue.offer(2);
        assertEquals(1, queue.peek());
    }

    @Test
    public void poll() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertNull(queue.poll());

        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        assertIterableEquals(List.of(4, 5, 6), queue);
    }

    @Test
    public void boundary() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(16);
        //           2147483647 正整数的最大值 int
        queue.head = 2147483640;
        queue.tail = queue.head;

        for (int i = 0; i < 16; i++) {
//            System.out.println(queue.tail + " " + Integer.toUnsignedLong(queue.tail) + " " + Integer.toUnsignedLong(queue.tail) % 8);
//            queue.tail++;
            queue.offer(i);
        }

        assertIterableEquals(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), queue);
    }

    @Test
    public void test2() {
        int head = 2147483640;
        int tail = 2147483647;
        tail += 5;
        System.out.println(tail);
        System.out.println(tail - head);
    }
}
