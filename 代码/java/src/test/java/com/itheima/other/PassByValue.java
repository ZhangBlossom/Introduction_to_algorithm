package com.itheima.other;

public class PassByValue {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        foo(a, b);
        System.out.println("a:" + a + " b:" + b);
    }

    static void foo(Integer c, Integer d) {
        Integer t = c;
        c = d;
        d = t;
    }
}
