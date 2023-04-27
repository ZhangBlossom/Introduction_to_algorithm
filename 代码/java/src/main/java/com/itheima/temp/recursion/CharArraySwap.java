package com.itheima.temp.recursion;

import java.util.Arrays;

public class CharArraySwap {
    public static void main(String[] args) {
        char[] array = "abcde".toCharArray();
        recursion(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void recursion(char[] array, int i, int j) {
        if (i >= j) {
            return;
        }
        swap(array, i, j);
        recursion(array, ++i, --j);
    }

    public static void swap(char[] array, int i, int j) {
        char c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}
