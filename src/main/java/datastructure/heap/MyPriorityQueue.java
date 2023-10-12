package datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueue<T extends Comparable<T>> {
    private List<T> heap;

    public MyPriorityQueue() {
        heap = new ArrayList<>();
    }

    public void offer(T element) {
        heap.add(element);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) >= 0) {
                break; // Heap property is satisfied
            }
            // Swap the current element with its parent
            T temp = heap.get(currentIndex);
            heap.set(currentIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            currentIndex = parentIndex;
        }
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            int currentIndex = 0;
            int size = heap.size();
            while (true) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                int smallest = currentIndex;
                if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                    smallest = leftChildIndex;
                }
                if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                    smallest = rightChildIndex;
                }
                if (smallest == currentIndex) {
                    break; // Heap property is satisfied
                }
                // Swap the current element with the smallest child
                T temp = heap.get(currentIndex);
                heap.set(currentIndex, heap.get(smallest));
                heap.set(smallest, temp);
                currentIndex = smallest;
            }
        }
        return min;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> minHeap = new MyPriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(7);
        minHeap.offer(1);

        System.out.println("Size: " + minHeap.size());
        System.out.println("Peek: " + minHeap.peek());

        while (!minHeap.isEmpty()) {
            System.out.println("Poll: " + minHeap.poll());
        }
    }
}
