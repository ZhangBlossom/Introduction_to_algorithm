package com.itheima.algorithm.recursion_single;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.itheima.algorithm.recursion_single.E03BinarySearch.search;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestE03BinarySearch {

    @Test
    @DisplayName("测试递归二分查找")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, search(a, 7));
        assertEquals(1, search(a, 13));
        assertEquals(2, search(a, 21));
        assertEquals(3, search(a, 30));
        assertEquals(4, search(a, 38));
        assertEquals(5, search(a, 44));
        assertEquals(6, search(a, 52));
        assertEquals(7, search(a, 53));

        assertEquals(-1, search(a, 0));
        assertEquals(-1, search(a, 15));
        assertEquals(-1, search(a, 60));
    }
}
