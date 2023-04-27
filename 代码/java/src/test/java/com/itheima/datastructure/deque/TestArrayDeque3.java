package com.itheima.datastructure.deque;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayDeque3 {

    @Test
    public void offer() {
        ArrayDeque3<Integer> deque = new ArrayDeque3<>(4);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        assertFalse(deque.offerLast(4));
        assertIterableEquals(List.of(2, 1, 3), deque);
    }

    @Test
    public void poll() {
        ArrayDeque3<Integer> deque = new ArrayDeque3<>(8);
        assertTrue(deque.isEmpty());
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerFirst(6);
        deque.offerFirst(7);
        assertIterableEquals(List.of(7, 6, 5, 4, 1, 2, 3), deque);
        assertTrue(deque.isFull());

        assertEquals(7, deque.pollFirst());
        assertEquals(6, deque.pollFirst());
        assertEquals(3, deque.pollLast());
        assertEquals(2, deque.pollLast());
        assertEquals(1, deque.pollLast());
        assertEquals(4, deque.pollLast());
        assertEquals(5, deque.pollLast());
        assertNull(deque.pollLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void peek(){
        ArrayDeque3<Integer> deque = new ArrayDeque3<>(8);
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        assertEquals(4, deque.peekLast());
        assertEquals(3, deque.peekFirst());
    }
}
