package com.itheima.datastructure.array;

import org.springframework.util.StopWatch;

public class TestCacheLine {

    public static void ij(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void ji(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    /*
        CPU      缓存     内存
        皮秒              纳秒
                 64字节
                 缓存行 cache line

                 空间局部性
     */

    public static void main(String[] args) {
        int rows = 1_000_000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch sw = new StopWatch();

        sw.start("ij");
        ij(a, rows, columns);
        sw.stop();

        sw.start("ji");
        ji(a, rows, columns);
        sw.stop();

        System.out.println(sw.prettyPrint());
    }
}
