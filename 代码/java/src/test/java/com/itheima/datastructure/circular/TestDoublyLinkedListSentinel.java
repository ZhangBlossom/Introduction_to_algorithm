package com.itheima.datastructure.circular;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestDoublyLinkedListSentinel {

    @Test
    public void addFirst() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        assertIterableEquals(List.of(5, 4, 3, 2, 1), list);
    }

    @Test
    public void addLast() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        assertIterableEquals(List.of(1, 2, 3, 4, 5), list);
    }

    @Test
    public void removeFirst() {
        DoublyLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(5), list);
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    public void removeLast() {
        DoublyLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3), list);
        list.removeLast();
        assertIterableEquals(List.of(1, 2), list);
        list.removeLast();
        assertIterableEquals(List.of(1), list);
        list.removeLast();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    private DoublyLinkedListSentinel getList() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        return list;
    }

    @Test
    public void removeByValue() {
        DoublyLinkedListSentinel list = getList();
        list.removeByValue(1);
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeByValue(2);
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeByValue(3);
        assertIterableEquals(List.of(4, 5), list);
        list.removeByValue(4);
        assertIterableEquals(List.of(5), list);
        list.removeByValue(5);
        assertIterableEquals(List.of(), list);
    }

}