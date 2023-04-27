package com.itheima.temp.recursion;

public class ReversePrintNumber {
    public static int f(int n, int s) {
        if (n == 0) {
            System.out.println(s);
            return s;
        }
        int low = f(n / 10, s / 10);
        int high = n % 10 * s;
        int r = low + high;
        if (s != 0 && high / s != (n % 10) ||
                low >= 0 && high >= 0 && r < 0 ||
                low < 0 && high < 0 && r >= 0) {
            return 0;
        }
        return r;
    }

    public static void main(String[] args) {
//        int n = -2147483412;
        //      -2147483648
        //      -2143847412
//        int n = -2147483648;
//        int n = 0;
        int n = 0;
        System.out.println(Math.log10(0));
        System.out.println(factor(0));

        System.out.println(f(n, factor(n)));
    }

    public static int factor(int num) {
        if (num == 0) {
            return 0;
        }
        int i = 1;
        while (true) {
            num /= 10;
            if (num == 0) {
                break;
            }
            i *= 10;
        }
        return i;
    }
}
