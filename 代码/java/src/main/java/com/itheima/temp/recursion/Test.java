package com.itheima.temp.recursion;

// 约瑟夫问题
public class Test {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>();
        int n = 41;
        int m = 3;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        System.out.println(list);
        int i = 0;
        while (list.size()>1)
        {
            i=(i+m-1)%(list.size());
            list.remove(i);
            System.out.println(list);
        }*/

        // 30 , 16

        for (int i = 1; i < 20; i++) {
            System.out.println(i + " " + (recursion(i, 3)));

        }
    }

    public static int recursion(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (recursion(n - 1, m) + m) % n;
    }
}
