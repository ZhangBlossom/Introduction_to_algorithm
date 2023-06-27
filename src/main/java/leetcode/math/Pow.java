package leetcode.math;

/**
 * @author: 张锦标
 * @date: 2023/6/19 9:10
 * Pow类
 */
public class Pow {
    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double v = quickMul(x, N / 2);
        return N % 2 == 0 ? v * v : 1.0 / x * v * v;

    }

    public static void main(String[] args) {
        System.out.println(myPow(2.10000, 3));
    }
}
