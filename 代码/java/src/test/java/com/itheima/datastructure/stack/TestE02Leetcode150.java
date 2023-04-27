package com.itheima.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestE02Leetcode150 {

    private final E02Leetcode150 e02 = new E02Leetcode150();

    @Test
    public void test1() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(22, e02.evalRPN(tokens));
    }

    @Test
    public void test2() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        assertEquals(9, e02.evalRPN(tokens));
    }

    @Test
    public void test3() {
        String[] tokens = {"2", "1", "-"};
        assertEquals(1, e02.evalRPN(tokens));
    }

}