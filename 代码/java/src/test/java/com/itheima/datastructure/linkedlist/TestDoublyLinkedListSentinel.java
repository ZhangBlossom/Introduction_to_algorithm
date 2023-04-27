package com.itheima.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestDoublyLinkedListSentinel {

    @Test
    void addFirst() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertIterableEquals(List.of(4, 3, 2, 1), list);
    }

    @Test
    void removeFirst() {
        DoublyLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(4), list);
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    void addLast() {
        DoublyLinkedListSentinel list = getList();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    private DoublyLinkedListSentinel getList() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    void removeLast() {
        DoublyLinkedListSentinel list = getList();
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

    @Test
    void insert() {
        DoublyLinkedListSentinel list = getList();
        list.insert(2, 5);
        assertIterableEquals(List.of(1, 2, 5, 3, 4), list);
        list.insert(5, 6);
        assertIterableEquals(List.of(1, 2, 5, 3, 4, 6), list);
        assertThrows(IllegalArgumentException.class, () -> list.insert(7, 7));
    }

    @Test
    void remove() {
        DoublyLinkedListSentinel list = getList();
        list.remove(2);
        assertIterableEquals(List.of(1, 2, 4), list);
        assertThrows(IllegalArgumentException.class, () -> list.remove(10));

        DoublyLinkedListSentinel list2 = new DoublyLinkedListSentinel();
        assertThrows(IllegalArgumentException.class, () -> list2.remove(0));
    }
}