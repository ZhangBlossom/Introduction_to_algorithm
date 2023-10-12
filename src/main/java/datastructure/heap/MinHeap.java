package datastructure.heap;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;       // 存储堆元素的数组
    private int size;         // 堆中元素的数量
    private int capacity;     // 堆的容量（数组的最大大小）

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;  // 返回父节点的索引
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;    // 返回左子节点的索引
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;    // 返回右子节点的索引
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[index] < heap[getParentIndex(index)]) {
            // 如果当前元素小于其父节点，交换它们
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int index) {
        int minChildIndex;
        while (getLeftChildIndex(index) < size) {
            minChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && heap[getRightChildIndex(index)] < heap[minChildIndex]) {
                minChildIndex = getRightChildIndex(index);
            }
            if (heap[index] <= heap[minChildIndex]) {
                break;
            }
            swap(index, minChildIndex);
            index = minChildIndex;
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);  // 上浮新插入的元素以维护堆性质
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        int min = heap[0];       // 最小元素是堆的根节点
        heap[0] = heap[size - 1]; // 将最后一个元素移到根节点
        size--;
        heapifyDown(0);          // 下沉根节点以维护堆性质
        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(1);

        minHeap.printHeap(); // 输出：[1, 3, 5, 7]

        int min = minHeap.extractMin();
        System.out.println("Min Element: " + min); // 输出：Min Element: 1
        minHeap.printHeap(); // 输出：[3, 5, 7]
    }
}
