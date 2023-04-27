package com.itheima.algorithm.recursion_multi;

import java.util.Arrays;

/**
 * 递归杨辉三角(Pascal三角)
 */
public class E03PascalTriangle {

    /**
     * <h3>直接递归(未优化)</h3>
     *
     * @param i 行坐标
     * @param j 列坐标
     * @return 该坐标元素值
     */
    private static int element(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        return element(i - 1, j - 1) + element(i - 1, j);
    }

    private static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
//            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        System.out.println(element(4, 2));
        print2(6);
    }

    /*
        1
        1   1
        1   2   1
        1   3   3   1
        1   4   6   4   1
        1   5   10  10  5   1
     */

    /**
     * <h3>优化1 - 使用二维数组记忆法</h3>
     *
     * @param triangle 二维数组
     * @param i        行坐标
     * @param j        列坐标
     * @return 该坐标元素值
     */
    private static int element1(int[][] triangle, int i, int j) {
        if (triangle[i][j] > 0) {
            return triangle[i][j];
        }

        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = element1(triangle, i - 1, j - 1) + element1(triangle, i - 1, j);
        return triangle[i][j];
    }

    public static void print1(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) { // 行
            triangle[i] = new int[i + 1];
//            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element1(triangle, i, j));
            }
            System.out.println();
        }
    }

    /**
     * <h3>优化2 - 使用一维数组记忆法</h3>
     */
    /*
        0   0   0   0   0   0   初始状态
        1   0   0   0   0   0   i=0
        1   1   0   0   0   0   i=1
        1   2   1   0   0   0   i=2
        1   3   3   1   0   0   i=3
        1   4   6   4   1   0   i=4 *
     */
    private static void createRow(int[] row, int i) {
        if (i == 0) {
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j] + row[j - 1];
        }
    }

    public static void print2(int n) {
        int[] row = new int[n];
        for (int i = 0; i < n; i++) { // 行
            createRow(row, i);
//            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", row[j]);
            }
            System.out.println();
        }
    }

}
