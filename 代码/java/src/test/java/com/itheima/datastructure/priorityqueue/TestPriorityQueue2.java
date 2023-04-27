package com.itheima.datastructure.priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestPriorityQueue2 {

    @Test
    public void poll() {
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);
        queue.offer(new Entry("task1", 4));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 1));
        assertFalse(queue.offer(new Entry("task6", 7)));

        assertEquals("task4", queue.peek().value);
        assertEquals("task4", queue.poll().value);
        assertEquals("task1", queue.poll().value);
        assertEquals("task2", queue.poll().value);
        assertEquals("task3", queue.poll().value);
        assertEquals("task5", queue.poll().value);
    }
}
