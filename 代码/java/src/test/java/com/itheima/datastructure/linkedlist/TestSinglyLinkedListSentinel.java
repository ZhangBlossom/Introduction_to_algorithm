package com.itheima.datastructure.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSinglyLinkedListSentinel {


    @Test
    @DisplayName("测试 addFirst")
    public void test1() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertIterableEquals(List.of(4, 3, 2, 1), list);
    }

    @Test
    @DisplayName("测试 addLast")
    public void test2() {
        SinglyLinkedListSentinel list = getLinkedList();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    @DisplayName("测试 get")
    public void test3() {
        SinglyLinkedListSentinel list = getLinkedList();

        assertEquals(3, list.get(2));
        assertThrows(IllegalArgumentException.class, () -> list.get(10));

    }

    @Test
    @DisplayName("测试 insert")
    public void test4() {
        SinglyLinkedListSentinel list = getLinkedList();
        list.insert(0, 5);
        assertIterableEquals(List.of(5, 1, 2, 3, 4), list);

        list = getLinkedList();
        list.insert(2, 5);
        assertIterableEquals(List.of(1, 2, 5, 3, 4), list);

        list = getLinkedList();
        list.insert(4, 5);
        assertIterableEquals(List.of(1, 2, 3, 4, 5), list);

        assertThrows(IllegalArgumentException.class,
                () -> getLinkedList().insert(5, 5));

        list = getLinkedList();
        list.addFirst(5);
        assertIterableEquals(List.of(5, 1, 2, 3, 4), list);

        SinglyLinkedListSentinel list2 = new SinglyLinkedListSentinel();
        list2.addFirst(1);
        assertIterableEquals(List.of(1), list2);
    }

    private SinglyLinkedListSentinel getLinkedList() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    @DisplayName("测试 removeFirst")
    public void test5() {
        SinglyLinkedListSentinel list = getLinkedList();

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
    @DisplayName("测试 remove")
    public void test6() {
        SinglyLinkedListSentinel list1 = getLinkedList();
        list1.remove(2);
        assertIterableEquals(List.of(1, 2, 4), list1);


        SinglyLinkedListSentinel list2 = getLinkedList();
        list2.remove(0);
        assertIterableEquals(List.of(2, 3, 4), list2);

        SinglyLinkedListSentinel list3 = getLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list3.remove(5));

        SinglyLinkedListSentinel list4 = getLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list4.remove(4));
    }
}
