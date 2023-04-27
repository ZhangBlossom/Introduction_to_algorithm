package com.itheima.temp.list;

import java.util.Iterator;
import java.util.function.Consumer;

public class NodeListSentinel implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node curr = head.next;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Integer next() {
                int value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    private Node head = new Node(Integer.MIN_VALUE, null);

    public void addFirst(int value) {
//        this.head.next = new Node(value, this.head.next);
        insert(0, value);
    }

    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    private Node findLast() {
        Node curr;
        for (curr = this.head; curr.next != null; ) {
            curr = curr.next;
        }
        return curr;
    }

    public void addLast(int first, int... rest) {
        Node sublist = new Node(first, null);
        Node curr = sublist;
        for (int value : rest) {
            curr.next = new Node(value, null);
            curr = curr.next;
        }
        Node last = findLast();
        last.next = sublist;
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node != null) {
            return node.value;
        }
        throw illegalIndex(index);
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev != null) {
            prev.next = new Node(value, prev.next);
        } else {
            throw illegalIndex(index);
        }
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node curr = this.head; curr != null; curr = curr.next, i++) {
            if (i == index) {
                return curr;
            }
        }
        return null;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        Node curr;
        if (prev != null && (curr = prev.next) != null) {
            prev.next = curr.next;
        } else {
            throw illegalIndex(index);
        }
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    /*
        Before: head.next --> first.next --> second
        After:  head.next --> second
     */
    private Node removeFirst() {
        Node first = head.next;
        if (first != null) {
            head.next = first.next;
            return first;
        }
        return null;
    }

    /*
       Before: head.next --> oldFirst
       After:  head.next --> first.next --> oldFirst
     */
    private void addFirst(Node first) {
        first.next = this.head.next;
        this.head.next = first;
    }

    public void reverse1() {
        NodeListSentinel list = new NodeListSentinel();
        Node first;
        while ((first = removeFirst()) != null) {
            list.addFirst(first);
        }
        this.head = list.head;
    }

    /*
                    p1  p2
            head    1   2   3   4

                    p1              p2(2)
            head    1   3   4

                    p1              p2(2)-->p1
            head    1   3   4

                    p2   p1
            head    2    1   3   4

                         p1  p2
            head    2    1   3   4
         */
    public void reverse3() {
        Node p1 = this.head.next;
        Node p2;
        if (p1 == null || (p2 = p1.next) == null) {
            return;
        }
        while (p2 != null) {
            p1.next = p2.next;
            p2.next = this.head.next;
            this.head.next = p2;

            p2 = p1.next;
        }
    }

    public void reverse4() {
        Node p0 = null;
        Node p1 = this.head.next;
        Node p2;
        if (p1 == null || (p2 = p1.next) == null) {
            return;
        }
        while (true) {
            p1.next = p0;
            if (p2 == null) {
                break;
            }

            p0 = p1;
            p1 = p2;
            p2 = p2.next;
        }
        this.head.next = p1;
    }

    private Node recursion(Node curr) {
        if (curr.next == null) {
            return curr;
        }
        Node last = recursion(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return last;
    }

    public void reverse2() {
        head.next = recursion(head.next);
    }

    public void loop(Consumer<Integer> consumer) {
        recursion(this.head.next, consumer);
    }

    private void recursion(Node node, Consumer<Integer> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.value);
        recursion(node.next, consumer);
        consumer.accept(node.value);
    }

    public static void main(String[] args) {
        NodeListSentinel list = new NodeListSentinel();
//        list.addFirst(1);
        list.addLast(1, 2, 3, 4, 5);

//        list.addLast(1);
//        list.addFirst(0);
//        list.insert(1, 7);
//        list.insert(0, 7);
//        list.remove(4);
//        System.out.println(list.prev(2).value);
//        System.out.println(list.get(3));
//        list.reverse3();
        list.reverse4();
//        System.out.println(list.recursion(list.head.next));
        System.out.println("---------------------");
        for (Integer x : list) {
            System.out.println(x);
        }

//        list.loop(System.out::println);

    }

}
