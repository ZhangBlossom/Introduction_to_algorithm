package com.itheima.algorithm.recursion_single;

/**
 * 递归插入排序
 * <ul>
 *     <li>将数组分为两部分 [0 .. low-1]  [low .. a.length-1]</li>
 *     <li>左边 [0 .. low-1] 是已排序部分</li>
 *     <li>右边 [low .. a.length-1] 是未排序部分</li>
 *     <li>每次从未排序区域取出 low 位置的元素, 插入到已排序区域</li>
 * </ul>
 */
public class E05InsertionSort {
    public static void sort(int[] a) {
        insertion2(a, 1);
    }

    /**
     * <h3>递归函数 将 low 位置的元素插入至 [0..low-1] 的已排序区域</h3>
     *
     * @param a   数组
     * @param low 未排序区域的左边界
     */
    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }

        int t = a[low];
        int i = low - 1; // 已排序区域指针

        while (i >= 0 && t < a[i]) { // 没有找到插入位置
            a[i + 1] = a[i]; // 空出插入位置
            i--;
        }

        // 找到插入位置
        if (i + 1 != low) {
            a[i + 1] = t;
        }

        insertion(a, low + 1);
    }

    // 另一种插入排序的实现,缺点: 赋值次数较多
    private static void insertion2(int[] a, int low) {
        if (low == a.length) {
            return;
        }

        int i = low - 1;
        while (i >= 0 && a[i] > a[i + 1]) {
            int t = a[i];
            a[i] = a[i + 1];
            a[i + 1] = t;

            i--;
        }

        insertion(a, low + 1);
    }
}
