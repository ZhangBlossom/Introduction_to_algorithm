package com.itheima.datastructure.heap;

/**
 * <h3>求数据流中第 K 大的元素</h3>
 */
public class E03Leetcode703 {

    private MinHeap heap;

    public E03Leetcode703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    // 此方法会被不断调用, 模拟数据流中新来的元素
    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        E03Leetcode703 test = new E03Leetcode703(3,
                new int[]{});

        System.out.println(test.add(3)); // [3] 3
        System.out.println(test.add(5)); // [3 5] 3
        System.out.println(test.add(10));
        System.out.println(test.add(9));
        System.out.println(test.add(4));
    }
}
