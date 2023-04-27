package com.itheima.algorithm.recursion_multi;

import org.springframework.util.StopWatch;

import java.util.LinkedList;

/**
 * 递归汉诺塔
 */
public class E02HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    /**
     * <h3>移动圆盘</h3>
     *
     * @param n 圆盘个数
     * @param a 由
     * @param b 借
     * @param c 至
     */
    static void move(int n, LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b);   // 把 n-1 个盘子由a,借c,移至b
        c.addLast(a.removeLast()); // 把最后的盘子由 a 移至 c
//        print();
        move(n - 1, b, a, c);   // 把 n-1 个盘子由b,借a,移至c
    }

    // T(n) = 2T(n-1) + c,  O(2^64)


    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        int n = 1;
        init(n);
        print();
        sw.start("n=1");
        move(n, a, b, c);
        sw.stop();
        print();
        System.out.println(sw.prettyPrint());
    }

    private static void print() {
        System.out.println("----------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
