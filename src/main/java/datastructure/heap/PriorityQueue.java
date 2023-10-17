package datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
    private List<T> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }


    /**
     * 自底向上的判断节点位置是否合理 是否构成一个小顶堆
     * @param element
     */
    public void offer(T element) {
        heap.add(element);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            //获得当前元素的父节点
            int parentIndex = (currentIndex - 1) / 2;
            //判断后来元素是不是更大
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) >= 0) {
                break;
            }
            // 获取当前插入的元素
            T temp = heap.get(currentIndex);
            //当前元素和父节点交换位置
            heap.set(currentIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            //节点上移
            currentIndex = parentIndex;
        }
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        //获取堆顶 也就是最小值
        T min = heap.get(0);
        //获取堆底，也就是较大值
        T last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            //将较大值覆盖堆顶元素。
            heap.set(0, last);
            int currentIndex = 0;
            int size = heap.size();
            //一直循环直到已经是小顶堆
            while (true) {
                //得到左右孩子的索引
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                //判断左右孩子谁更小 谁更小就保留其索引
                int smallest = currentIndex;
                if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                    smallest = leftChildIndex;
                }
                if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                    smallest = rightChildIndex;
                }
                //如果就是当前头节点最小，那么无需移动 直接返回
                //说明当前已经满足小顶堆特性
                if (smallest == currentIndex) {
                    break;
                }
                // 交换堆顶和最小值节点的值
                T temp = heap.get(currentIndex);
                heap.set(currentIndex, heap.get(smallest));
                heap.set(smallest, temp);
                //节点索引下移，继续一轮循环
                currentIndex = smallest;
            }
        }
        return min;
    }

    /**
     * 返回小顶堆的索引为0的元素
     * 也就是返回最小元素
     * @return
     */
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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
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
