package com.itheima.algorithm.binarysearch;

public class LinearSearch {
    /**
     * <h3>线性查找</h3>
     *
     * @param a      待查找的升序数组 (可以不是有序数组)
     * @param target 待查找的目标值
     * @return <p>找到则返回索引</p>
     * <p>找不到返回 -1</p>
     */
    public static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 1. 最差的执行情况
    // 2. 假设每行语句执行时间一样 t
    /*
        数据元素个数 n
        int i = 0;          1
        i < a.length;       n+1
        i++                 n
        a[i] == target      n
        return -1;          1

        算法运行语句总次数：3*n + 3

        3*4 + 3 = 15*t
        3*1024 + 3 = 3075*t
     */

}
