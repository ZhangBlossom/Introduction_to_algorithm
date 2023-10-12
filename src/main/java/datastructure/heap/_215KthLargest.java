package datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: 张锦标
 * @date: 2023/10/12 17:07
 * _215KthLargest类
 * 使用优先队列的方式筛选所有数据中的topK个数据
 * TODO：如何自己实现一个优先队列呢？手写一个PriorityQueue
 */
public class _215KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            Integer minTop = minHeap.peek();
            if (nums[i] > minTop) {
                //出堆 移除最小元素
                minHeap.poll();
                //放入一个元素 并且再次排序
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
