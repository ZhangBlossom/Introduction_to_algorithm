package com.itheima.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h3>数据流的中位数</h3>
 */
public class E04Leetcode295_2 {

    /**
     * 为了保证两边数据量的平衡
     * <ul>
     * <li>两边个数一样时,左边个数加一</li>
     * <li>两边个数不一样时,右边个数加一</li>
     * </ul>
     * 但是, 随便一个数能直接加入吗?
     * <ul>
     * <li>左边个数加一时, 把新元素加在右边，弹出右边最小的加入左边</li>
     * <li>右边个数加一时, 把新元素加在左边，弹出左边最小的加入右边</li>
     * </ul>
     */
    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    /**
     * <ul>
     *     <li>两边数据一致, 左右各取堆顶元素求平均</li>
     *     <li>左边多一个, 取左边堆顶元素</li>
     * </ul>
     */
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    // 大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a) //
    );

    // 小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>(
            (a, b) -> Integer.compare(a, b) //
    );

    public static void main(String[] args) {
        /*E04Leetcode295_2 test = new E04Leetcode295_2();
        test.addNum(1);
        test.addNum(2);
        test.addNum(3);
        test.addNum(7);
        test.addNum(8);
        test.addNum(9);
        System.out.println(test.findMedian());
        test.addNum(10);
        System.out.println(test.findMedian());
        test.addNum(4);
        System.out.println(test.findMedian());*/

        // 以上浮为例, 大概的实现逻辑
//        Comparator<Integer> cmp = (a, b) -> Integer.compare(a, b); // 小顶堆比较器 compare -1 a<b, 0 a==b, 1 a>b
        Comparator<Integer> cmp = (a, b) -> Integer.compare(b, a); // 大顶堆比较器 compare -1 b<a, 0 b==a, 1 b>a
        int a = 10; // 父元素值
        int b = 20; // 新增元素值
        if (cmp.compare(a, b) > 0) {
            System.out.println("上浮");
        } else {
            System.out.println("停止上浮");
        }

    }

}
