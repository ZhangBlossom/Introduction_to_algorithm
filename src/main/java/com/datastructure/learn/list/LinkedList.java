package com.datastructure.learn.list;

/**
 * @author: 张锦标
 * @date: 2023/4/26 17:21
 * LinkedList类
 */
public class LinkedList<E>{
    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E>{
        E item;
        Node<E> pre;
        Node<E> next;
    }

    public static void main(String[] args) {

    }
}
